package com.sakila.models;

import com.sakila.data.Entity;

import java.sql.SQLException;
import java.util.HashMap;
/**
 * Interface para hacer CRUD en la base de datos
 * @author Juan José Jorge Rodríguez
 * @version 1.0
 */
public interface iORMObject 
{
	/**
	 * Busca en la base de datos
	 * @param clausulas
	 * @return Object
	 * @throws SQLException
	 */
	public Object Get(HashMap<String,String> clausulas) throws SQLException; //read
	/**
	 * Crea un registro en la base de datos
	 * @param clausulas
	 * @return boolean
	 */
	public boolean Post(HashMap<String,String> clausulas); // create
	/**
	 * Actualiza un registro en la base de datos
	 * @param clausulas
	 * @return boolean
	 */
	public boolean Put(HashMap<String,String> clausulas); // upload
	/**
	 * Elimina un registro en la base de datos
	 * @param clausulas
	 * @return boolean
	 */
	public boolean Delete(HashMap<String,String> clausulas); // delete
	/**
	 * realiza un mapeo
	 */
	public void Mapping();
}
