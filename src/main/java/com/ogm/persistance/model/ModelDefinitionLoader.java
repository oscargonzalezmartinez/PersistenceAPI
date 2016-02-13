package com.ogm.persistance.model;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ogm.persistance.exceptions.ModelPersistanceException;
import com.ogm.persistance.model.annotation.DBColumn;
import com.ogm.persistance.model.annotation.DBRelacion;
import com.ogm.persistance.model.annotation.DBSequence;
import com.ogm.persistance.model.annotation.DBTable;
import com.ogm.persistance.model.annotation.DBValidation;
import com.ogm.persistance.model.mapping.xml.Mapping;
import com.ogm.persistance.util.ErrorMessageID;

/**
 * <p>Clase encargada de generar un modelo para una clase anotada.</p>
 * 
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 *
 */
public class ModelDefinitionLoader {
	private static Log log = LogFactory.getLog(ModelDefinitionLoader.class);
	/**
	 * <p>Carga un modelo a partir de una clase anotada.</p>
	 * @param configurationFileName Nombre de la clase con formato foo/mypackage/MyClass.
	 * @return Una instancia de ModelDefinition que representa el mapeo
	 */
	public ModelDefinition loadFromAnnotatedClass(String configurationFileName) {
		String className = configurationFileName.replace('/','.');
		log.info("Cargando mapeo de clase anotada " + className);
		try {
			Class clazz = Class.forName(className);
			DBTable dbTable = (DBTable) clazz.getAnnotation(DBTable.class);
			//Esto es un error MUY GRAVE que solo se dan en primeras fases de desarrollo
			if (dbTable == null){
				//El fichero de configuración [{0}] indica el uso de clases anotadas, pero el modelo definido en [{1}] 
				// no es una clase anotada.
				//throw new ModelPersistanceException(ErrorMessageID.PE_00010, "", configurationFileName);
				log.warn("La clase " + className+ " no tiene definida la anotación DBTable. No podrá ser persistida.");
			}
			return loadFromAnnotatedClass(clazz);

		
		} catch (ClassNotFoundException e) {
			throw new ModelPersistanceException(e);
		}
	}
	
	/**
	 * <p>.</p>
	 * @param clazz
	 * @param dbTable
	 * @return Una instancia de ModelDefinition que representa el mapeo
	 */
	public  ModelDefinition loadFromAnnotatedClass(Class clazz) {

		String table = null;
		String pk = null;
		KeyGeneratorEnum keyGenerator = null;
		DBTable dbTable = (DBTable) clazz.getAnnotation(DBTable.class);
		if (dbTable!=null){
			table = dbTable.table();
			pk = dbTable.pk();
			keyGenerator = dbTable.keyGenerator();
			if ("".equals(pk) || "null".equals(pk)){
				pk = null;
			}

		}
		ModelDefinition md = new ModelDefinition(clazz.getName(),
												table,
												pk);
		if (keyGenerator!=null){
			md.setKeyGenerator(keyGenerator.name());
			if (KeyGeneratorEnum.SEQUENCE.equals(keyGenerator)){
				DBSequence sequence = (DBSequence) clazz.getAnnotation(DBSequence.class);
				//Esto sólo debería pasar en desarrollo
				if (sequence == null){
					throw new ModelPersistanceException(ErrorMessageID.PE_00011,
							md.getClassName(),
							"Se ha indicado generador de claves una secuencia pero no hay @DBSequence definida");
				}
				md.setSequence(sequence.name());		
			}
		}
		

		Field[] fields = clazz.getDeclaredFields();
		Map<String,Relationship> relations = null;
		for (Field field:fields) {
			DBColumn dbColumn = field.getAnnotation(DBColumn.class);
			String attribute = field.getName();
			if (dbColumn != null){
				boolean isPKField = false;
				String column = dbColumn.column();
			//	String type = field.getType().getName();
				if (pk!=null && pk.equals(column)){
					md.setPrimaryKeyField(attribute);
					md.addPrimaryKeyField(attribute);
					isPKField = true;
				}
				else if (dbColumn.pk()){
					//en la propia columna pueden aparecer como primary key, normalmente para claves compuestas
					md.addPrimaryKeyField(attribute);
					isPKField = true;
				}
				
				com.ogm.persistance.model.Field modelField = new com.ogm.persistance.model.Field(attribute, column, dbColumn.isTransient(),isPKField);
				DBValidation dbValidation = field.getAnnotation(DBValidation.class);
				if (dbValidation!=null){
					modelField.setValidation(dbValidation.validation());
					modelField.setValidationData(dbValidation.value());
				}
				md.addField( modelField );
				

			}
			
			DBRelacion relacion = field.getAnnotation(DBRelacion.class);
			if (relacion!=null){
				
				if (relations == null){
					relations = new HashMap<String, Relationship>();
				}

				relations.put(attribute,new Relationship(relacion.field(),
														relacion.targetClass(), 
														relacion.targetField(),
														relacion.readOnly(),
														relacion.lazy()));
			}
			
		}
		
		//leemos las relaciones
		md.setRelations(relations);

		return md;
	
	}
	
	public ModelDefinition loadFromMappingFile(String configurationFileName) {
		String fileName = "/"+configurationFileName + ".xml";
		log.info("Cargando mapeo de " + fileName);
		try {
			JAXBContext jc = JAXBContext.newInstance( Mapping.class);
			Unmarshaller um = jc.createUnmarshaller();
			InputStream is = getClass().getResourceAsStream(fileName);
			if (is == null){
				throw new ModelPersistanceException(ErrorMessageID.MO_00006, fileName);
			}
			Mapping mapping = (Mapping) um.unmarshal(is);

			//Esto es un error MUY GRAVE que solo se dan en primeras fases de desarrollo
			if (mapping.getTable() == null){
				//El fichero de configuración [{0}] indica el uso de clases anotadas, pero el modelo definido en [{1}] 
				// no es una clase anotada.
				//throw new ModelPersistanceException(ErrorMessageID.PE_00010, "", configurationFileName);
				log.warn("El mapeo " + fileName + " no tiene definida la tabla. No podrá ser persistida.");
			}
			return loadFromMappingFile(mapping);
		
		} catch (JAXBException e) {
			throw new ModelPersistanceException(e);
		}
	}
	
	private ModelDefinition loadFromMappingFile(Mapping mapping) {
		String table = null;
		String pk = null;
		KeyGeneratorEnum keyGenerator = null;
		Mapping.Pk.KeyGenerator keyGeneratorXml = null;
		if (mapping.getPk()!=null){
			pk = mapping.getPk().getColumn();
			keyGeneratorXml = mapping.getPk().getKeyGenerator();
		}
		
		ModelDefinition md = new ModelDefinition(mapping.getClazz(),
												mapping.getTable(),
												pk);
		if (keyGeneratorXml!=null){
			md.setKeyGenerator(keyGeneratorXml.getType().toString().toUpperCase());
			if (KeyGeneratorEnum.SEQUENCE.name().equals(md.getKeyGenerator())){
				String sequence = keyGeneratorXml.getName().toString();
				//Esto sólo debería pasar en desarrollo
				if (sequence == null){
					throw new ModelPersistanceException(ErrorMessageID.PE_00011,
							md.getClassName(),
							"Se ha indicado generador de claves una secuencia pero no hay nombre definido");
				}
				md.setSequence(sequence);		
			}
		}
		

		for (Mapping.Attribute attribute:mapping.getAttribute()) {

			String property = attribute.getName();
			boolean isPKField = false;
			String column = attribute.getColumn();
			//	String type = field.getType().getName();
				if (pk!=null && pk.equals(column)){
					md.setPrimaryKeyField(property);
					md.addPrimaryKeyField(property);
					isPKField = true;
				}
				else if (attribute.isPk()){
					//en la propia columna pueden aparecer como primary key, normalmente para claves compuestas
					md.addPrimaryKeyField(property);
					isPKField = true;
				}
				
				com.ogm.persistance.model.Field modelField = new com.ogm.persistance.model.Field(property, column, attribute.isTransient(),isPKField);
				md.addField( modelField );
			}
			
//			DBRelacion relacion = field.getAnnotation(DBRelacion.class);
//			if (relacion!=null){
//				
//				if (relations == null){
//					relations = new HashMap<String, Relationship>();
//				}
//
//				relations.put(attribute,new Relationship(relacion.field(),
//														relacion.targetClass(), 
//														relacion.targetField(),
//														relacion.readOnly(),
//														relacion.lazy()));
//			}
//			
		//}
		
		//leemos las relaciones
		//md.setRelations(relations);

		return md;
		
	}
}
