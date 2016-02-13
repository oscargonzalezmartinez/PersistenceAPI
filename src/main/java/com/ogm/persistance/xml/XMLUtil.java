package com.ogm.persistance.xml;

import java.io.InputStream;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.ogm.persistance.util.ErrorMessageID;



/**
 * <p>Clase de utilidades de XML.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 2.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 * @see <a href="http://java.sun.com/developer/technicalArticles/WebServices/jaxb/">Java Architecture for XML Binding (JAXB)</a>
 * @see <a href="https://jaxb.dev.java.net/">JAXB Reference Implementation</a>
 */
public final class XMLUtil {

	/**
	 * Evitamos la instanciación.
	 */
	private XMLUtil(){}

	
	/**
	 * <p>Genera un objeto a partir de su representación XML</p>.
	 * @param pkg paquete al que pertenece el objeto.
	 * @param xml xml con los datos.
	 * @return Instancia del objeto representado en el xml.
	 * @throws UnmarshalException Si se produce un error en el proceso.
	 */
	public static Object unmarshall(Package pkg,String xml) throws UnmarshalException{

		try {
			JAXBContext jc = JAXBContext.newInstance(pkg.getName());
			Unmarshaller um = jc.createUnmarshaller();
			return um.unmarshal(new StringReader(xml));

		} catch (JAXBException e) {
			throw new UnmarshalException(ErrorMessageID.XML000002,e,xml);
		}
	}	
	
	/**
	 * <p>Genera un objeto a partir de su representación XML</p>.
	 * @param pkg paquete al que pertenece el objeto.
	 * @param is Inputstream con los datos.
	 * @return Instancia del objeto representado en el xml.
	 * @throws UnmarshalException Si se produce un error en el proceso.
	 */
	public static Object unmarshall(Package pkg,InputStream is) throws UnmarshalException{

		try {
			JAXBContext jc = JAXBContext.newInstance(pkg.getName());
			Unmarshaller um = jc.createUnmarshaller();
			return um.unmarshal(is);

		} catch (JAXBException e) {
			throw new UnmarshalException(ErrorMessageID.XML000002,e,e.getMessage());
		}
	}

}
