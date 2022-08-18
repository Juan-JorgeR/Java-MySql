package com.sakila.models;
/**
 * CityModel.java
 * 
 * Representa la implementación de la interface IORMObject para Category
 * @author Juan Josó Jorge Rodríguez
 * @version 1.0
 *
 */
import com.sakila.data.City;
import java.util.HashMap;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class CityModel extends EntiryModel implements iORMObject 
{
	ArrayList<City> ciudades;
	/**
	 * Método que permite saber a la entidad city cual es la tabla que le corresponde en 
	 * la base de datos, la columna que contiene la clave primaria y las que poseen las clave foranes.
	 * 
	 * @param objectName
	 * @param PKColumn
	 * @param FKColumn
	 */
	public CityModel(String objectName,String PKColumn,String FKColumn)
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
		ciudades=new ArrayList<City>();
		ResultSet rs;
		rs=Find(clausulas);
		City city;
		while(rs.next())
		{
			city=new City();
			city.ID=Short.parseShort(rs.getString(1));
			city.Name=rs.getString(2);
			city.CountryID=Short.parseShort(rs.getString(3));
			city.CountryName=rs.getString(4);
			ciudades.add(city);
		}
		return ciudades;
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
