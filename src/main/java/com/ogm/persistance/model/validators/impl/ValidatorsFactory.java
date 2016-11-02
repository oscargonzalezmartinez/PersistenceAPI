package com.ogm.persistance.model.validators.impl;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.ogm.persistance.model.ValidationEnum;
import com.ogm.persistance.model.validators.Validator;
import com.ogm.persistance.util.ClassUtil;

/**
 * <p>Factor�a para los diferentes validadores.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 */
public final class ValidatorsFactory {

	/**
	 * Factoría de beans.
	 */
	private static XmlBeanFactory bf = new XmlBeanFactory(new ClassPathResource("/"+ClassUtil.getPackageName(ValidatorsFactory.class) + "/validators.xml", ValidatorsFactory.class));

	/**
	 * Constructor privado.
	 */
	private ValidatorsFactory(){
		
	}

	/**
	 * <p>Devuelve una instacia del validador.</p>
	 * @param validator Tipo de validador.
	 * @return instacia del validador.
	 */
	public static Validator getValidator(ValidationEnum validator){
		return (Validator) bf.getBean(validator.name());
	}

}
