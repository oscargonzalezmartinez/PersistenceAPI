package com.ogm.persistance.test.model;

import com.ogm.persistance.model.annotation.DBColumn;
import com.ogm.persistance.model.annotation.DBTable;
 /**
 * <p>Tabla de base de datos TX_TIPOS_BLOQUE</p>
 * @author OGOMAR01 (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1 $LastChangedRevision: 25402 $ $LastChangedDate: 2009-01-27 13:19:20 +0100 (mar, 27 ene 2009) $
 * Clase autogenerada: 03/12/2008
 * version generador 0.4
 */
@DBTable(table="TX_TIPOS_BLOQUE", pk="NU_TBL_NUMERO_BLOQUE") 
public class TipoBloque implements java.io.Serializable{
		/** Serial Version UID */
		private static final long serialVersionUID = -1974198180L;
		/**
		 * Atributo mapeado a la columna base datos <b>NU_TBL_NUMERO_BLOQUE</b>. 
		 */ 
		 @DBColumn(column ="NU_TBL_NUMERO_BLOQUE") 
		 private java.lang.Integer numeroBloque = null;
		/**
		 * Atributo mapeado a la columna base datos <b>TX_TBL_DESCRIPCION</b>. 
		 */ 
		 @DBColumn(column ="TX_TBL_DESCRIPCION") 
		 private java.lang.String descripcion = null;
		/**
		 * Atributo mapeado a la columna base datos <b>TX_TBL_TEXTO_GUI</b>. 
		 */ 
		 @DBColumn(column ="TX_TBL_TEXTO_GUI") 
		 private java.lang.String textoGui = null;
		/**
		 * Devuelve el valor del atributo <b>numeroBloque</b>. 
		 * @return valor del atributo <b>numeroBloque</b>. 
		 */ 
		 public java.lang.Integer getNumeroBloque() { return numeroBloque; }
		/**
		 * Fija el valor del atributo <b>numeroBloque</b>. 
		 * @param newNumeroBloque nuevo valor para numeroBloque.
		 */ 
		 public void setNumeroBloque(java.lang.Integer newNumeroBloque) { numeroBloque = newNumeroBloque; }
		/**
		 * Devuelve el valor del atributo <b>descripcion</b>. 
		 * @return valor del atributo <b>descripcion</b>. 
		 */ 
		 public java.lang.String getDescripcion() { return descripcion; }
		/**
		 * Fija el valor del atributo <b>descripcion</b>. 
		 * @param newDescripcion nuevo valor para descripcion.
		 */ 
		 public void setDescripcion(java.lang.String newDescripcion) { descripcion = newDescripcion; }
		/**
		 * Devuelve el valor del atributo <b>textoGui</b>. 
		 * @return valor del atributo <b>textoGui</b>. 
		 */ 
		 public java.lang.String getTextoGui() { return textoGui; }
		/**
		 * Fija el valor del atributo <b>textoGui</b>. 
		 * @param newTextoGui nuevo valor para textoGui.
		 */ 
		 public void setTextoGui(java.lang.String newTextoGui) { textoGui = newTextoGui; }

		 /**
		  * <p>Devuelve la representación en String del objeto.</p>
		  * @return representación en String del objeto.
		  **/
		 public String toString(){
				 StringBuilder out = new StringBuilder();

				 out.append("Class: TipoBloque:\n");

				 out.append("numeroBloque").append("=[").append(numeroBloque).append("];\n" );
 
				 out.append("descripcion").append("=[").append(descripcion).append("];\n" );
 
				 out.append("textoGui").append("=[").append(textoGui).append("];\n" );
 
				 return out.toString();
		}

}