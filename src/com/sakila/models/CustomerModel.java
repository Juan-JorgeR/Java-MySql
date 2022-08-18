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

import com.sakila.data.Customer;
import com.sakila.models.EntiryModel;

public class CustomerModel extends EntiryModel implements iORMObject
{
	ArrayList<Customer> customeres;
	/**
	 * Método que permite saber a la entidad customer cual es la tabla que le corresponde en 
	 * la base de datos, la columna que contiene la clave primaria y las que poseen las clave foranes.
	 * 
	 * @param objectName
	 * @param PKColumn
	 * @param FKColumn
	 */
	public CustomerModel(String objectName,String PKColumn,String FKColumn)
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
		customeres=new ArrayList<Customer>();
		ResultSet rs;
		rs=Find(clausulas);
		Customer customer;
		while(rs.next())
		{
			customer=new Customer();
			customer.ID=Short.parseShort(rs.getString(1));
			customer.storeID=Short.parseShort(rs.getString(2));
			customer.firtsName=rs.getString(3);
			customer.lastName=rs.getString(4);
			customer.email=rs.getString(5);
			customer.addressID=Short.parseShort(rs.getString(6));
			customer.addressName=rs.getString(7);
			customer.active=rs.getBoolean(8);
			customer.createDate=rs.getString(9);
			customer.lastUpdate=rs.getString(10);
			
			customeres.add(customer);
		}
		return customeres;
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
