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
import com.sakila.data.Country;
import java.util.HashMap; 
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryModel extends EntiryModel implements iORMObject
{
	ArrayList<Country> paises;
	/**
	 * Método que permite saber a la entidad country cual es la tabla que le corresponde en 
	 * la base de datos, la columna que contiene la clave primaria y las que poseen las clave foranes.
	 * 
	 * @param objectName
	 * @param PKColumn
	 * @param FKColumn
	 */
	public CountryModel(String objectName,String PKColumn,String FKColumn)
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
		paises=new ArrayList<Country>();
		ResultSet rs;
		rs=Find(clausulas);
		Country country;
		while(rs.next())
		{
			country=new Country();
			country.ID=Short.parseShort(rs.getString(1));
			country.Name=rs.getString(2);
			paises.add(country);
		}
		
		return paises;
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
