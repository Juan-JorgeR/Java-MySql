package com.sakila.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.sakila.data.Actor;

/**
 * ActorModel.java
 * 
 * Representa la implementación de la interface IORMObject en una entidad actor
 * @author Juan Josó Jorge Rodríguez
 * @version 1.0
 *
 */
public class ActorModel extends EntiryModel implements iORMObject
{
	ArrayList<Actor> actores;
	/**
	 * Método que permite saber a la entidad actor cual es la tabla que le corresponde en 
	 * la base de datos, la columna que contiene la clave primaria y las que poseen las clave foranes.
	 * 
	 * @param objectName
	 * @param PKColumn
	 * @param FKColumn
	 */
	public ActorModel(String objectName,String PKColumn,String FKColumn)
	{
		super(objectName,PKColumn,FKColumn);
	}
	/**
	 * Método que llama a la clase padre y hace una busqueda en la base de datos 
	 */
	protected ResultSet Find(HashMap<String,String> clausulas) 
	{
		return super.Find(clausulas);
	}
	/**
	 * Obtiene los datos devueltos en la busqueda
	 * @param clausulas
	 * @return Object
	 * @throws SQLException
	 */
	public Object Get(HashMap<String,String> clausulas) throws SQLException
	{
		actores=new ArrayList<Actor>();
		ResultSet rs;
		rs=Find(clausulas);
		Actor actor;
		while(rs.next())
		{
			actor=new Actor();
			actor.ID=Short.parseShort(rs.getString(1));
			actor.firstName=rs.getString(2);
			actor.lastName=rs.getString(3);
			actor.lastUpdate=rs.getString(4);
			actores.add(actor);
		}
		return actores;
	}
	/**
	 * Crea un nuevo registro
	 * @param clausulas
	 * @return boolean
	 */
	public boolean Post(HashMap<String,String> clausulas) 
	{
		return super.Post(clausulas);
	}
	/**
	 * Actualiza un registro
	 * @param clausulas
	 * @return boolean
	 */
	public boolean Put(HashMap<String,String> clausulas) 
	{
		return super.Put(clausulas);
	}
	/**
	 * Elimina un registro
	 * @param clausulas
	 * @return boolean
	 */
	public boolean Delete(HashMap<String,String> clausulas)
	{		
		return super.Delete(clausulas);
	}
	/**
	 * Hace un mapeo (no implementado por ahora)
	 */
	public void Mapping() {}
}
