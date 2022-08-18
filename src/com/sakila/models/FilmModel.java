package com.sakila.models;
/**
 * CustomerModel.java
 * 
 * Representa la implementación de la interface IORMObject para Customer
 * @author Juan Josó Jorge Rodríguez
 * @version 1.0
 *
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.sakila.data.Film;

public class FilmModel extends EntiryModel implements iORMObject
{
	ArrayList<Film> films;
	
	/**
	 * Método que permite saber a la entidad film cual es la tabla que le corresponde en 
	 * la base de datos, la columna que contiene la clave primaria y las que poseen las clave foranes.
	 * 
	 * @param objectName
	 * @param PKColumn
	 * @param FKColumn
	 */
	public FilmModel(String objectName,String PKColumn,String FKColumn)
	{
		super(objectName,PKColumn,FKColumn);
	}
	/**
	 * Método que llama a la clase padre y hace una busqueda en la base de datos 
	 * @param clausulas
	 * @return ResultSet de la base de datos
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
		films=new ArrayList<Film>();
		ResultSet rs;
		rs=Find(clausulas);
		Film film;
		while(rs.next())
		{
			film=new Film();
			film.ID=rs.getShort(1);
			film.title=rs.getString(2);
			film.description=rs.getString(3);
			film.release_year=rs.getInt(4);
			film.language_id=rs.getShort(5);
			film.lenguajeName=rs.getString(6);
			film.original_language_id=rs.getShort(7);
			film.originallanguageName=rs.getString(8);
			film.rental_duration=rs.getInt(9);
			film.rental_rate=rs.getShort(10);
			film.length=rs.getInt(11);
			film.replacement_cost=rs.getDouble(12);
			film.rating=rs.getString(13);
			film.special_features=rs.getString(14);
			film.lastUpdate=rs.getString(15);
			
			films.add(film);
			
		}
		return films;
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
