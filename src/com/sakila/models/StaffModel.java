package com.sakila.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.sakila.data.Staff;
/**
 * StaffModel.java
 * 
 * Representa la implementación de la interface IORMObject para Staff
 * @author Juan Josó Jorge Rodríguez
 * @version 1.0
 *
 */
public class StaffModel extends EntiryModel implements iORMObject
{
	ArrayList<Staff> staffs;
	
	/**
	 * Método que permite saber a la entidad staff cual es la tabla que le corresponde en 
	 * la base de datos, la columna que contiene la clave primaria y las que poseen las clave foranes.
	 * 
	 * @param objectName
	 * @param PKColumn
	 * @param FKColumn
	 */
	public StaffModel(String objectName,String PKColumn,String FKColumn)
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
		staffs=new ArrayList<Staff>();
		ResultSet rs;
		rs=Find(clausulas);
		Staff staff;
		while(rs.next())
		{
			staff=new Staff();
			staff.ID=rs.getShort(1);
			staff.firtsName=rs.getString(2);
			staff.lastName=rs.getString(3);
			staff.addressID=rs.getShort(4);
			staff.addressName=rs.getString(5);
			staff.picture=rs.getBlob(6);
			staff.email=rs.getString(7);
			staff.storeID=rs.getShort(8);
			staff.active=rs.getBoolean(9);
			staff.username=rs.getString(10);
			staff.password=rs.getString(11);
			staff.lastUpdate=rs.getString(12);
			
			staffs.add(staff);
		}
		return staffs;
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
