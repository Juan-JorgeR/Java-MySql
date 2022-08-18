package com.sakila.models;
/**
 * AddressModel.java
 * 
 * Representa la implementación de la interface IORMObject en la entidad address
 * @author Juan Josó Jorge Rodríguez
 * @version 1.0
 *
 */
import com.sakila.models.EntiryModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.sakila.data.Address;

public class AddressModel extends EntiryModel implements iORMObject
{

	ArrayList<Address> addresses;
	/**
	 * Método que permite saber a la entidad address cual es la tabla que le corresponde en 
	 * la base de datos, la columna que contiene la clave primaria y las que poseen las clave foranes.
	 * 
	 * @param objectName
	 * @param PKColumn
	 * @param FKColumn
	 */
	public AddressModel(String objectName,String PKColumn,String FKColumn)
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
		addresses=new ArrayList<Address>();
		ResultSet rs;
		rs=Find(clausulas);
		Address address;
		while(rs.next())
		{
			address=new Address();
			address.ID=Short.parseShort(rs.getString(1));
			address.address=rs.getString(2);
			address.address2=rs.getString(3);
			address.district=rs.getString(4);
			address.cityID=Short.parseShort(rs.getString(5));
			address.cityName=rs.getString(6);
			address.postalCode=rs.getString(7);
			address.phone=rs.getString(8);
			address.lastUpdate=rs.getString(9);
			
			addresses.add(address);
		}
		return addresses;
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
