package com.sakila.data;

import java.sql.SQLException;
import java.util.HashMap;
/**
 * IDataRoute.java
 * 
 * Representa la interface CRUD implementada por los controladores
 * 
 * @author Juan José Jorge Rodríguez
 * @version 1.0
 *
 */
public interface iDataRoute 
{
	/**
	 * Realiza una consulta a la base de datos
	 * @param clausulas
	 * @return Object
	 * @throws SQLException
	 */
	public Object Get(HashMap<String,String> clausulas) throws SQLException;
	/**
	 * Crea un nuevo registro
	 * @param clausulas
	 * @return boolean
	 */
	public boolean Post(HashMap<String,String> clausulas);
	/**
	 * Actualiza un registro
	 * @param clausulas
	 * @return
	 */
	public boolean Put(HashMap<String,String> clausulas);
	/**
	 * Elimina un registro
	 * @param clausulas
	 * @return
	 */
	public boolean Delete(HashMap<String,String> clausulas);
	/**
	 * Serializa
	 */
	public void Serializer();
}
