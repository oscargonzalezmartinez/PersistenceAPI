package com.ogm.persistance.model;

import java.util.List;

/**
 * <p>Clase que representa la información de una NamedQuery.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 10 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 *
 */
public class NamedQuery {

	/**
	 * Atributos.
	 */
	private List<String> attributes = null;
	private String key = null;
	private String query = null;
	private String model = null;
	public List<String> getAttributes() {
		return attributes;
	}
	public void setAttributes(List<String> newAttributes) {
		this.attributes = newAttributes;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String newKey) {
		this.key = newKey;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String newQuery) {
		this.query = newQuery;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String newModel) {
		this.model = newModel;
	}
	/**
	 * Constructor.
	 */
	public NamedQuery(){}
	
	@Override
	public String toString(){
		return new StringBuilder("key [").append(key).append("]\n ")
		.append("model [").append(model).append("]\n ")
		.append("query [\n").append(query).append("\n] \n")
		.append("atributos ").append(attributes).toString();
		
	}
}
