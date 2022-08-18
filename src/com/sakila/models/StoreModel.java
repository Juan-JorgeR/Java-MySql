package com.sakila.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.sakila.data.Store;

/**
 * StoreModel.java
 * 
 * Representa la implementaci�n de la interface IORMObject para Store
 * @author Juan Jos� Jorge Rodr�guez
 * @version 1.0
 *
 */
public class StoreModel extends EntiryModel implements iORMObject 
{
	ArrayList<Store> stores;
	
	/**
	 * M�todo que permite saber a la entidad store cual es la tabla que le corresponde en 
	 * la base de datos, la columna que contiene la clave primaria y las que poseen las clave foranes.
	 * 
	 * @param objectName
	 * @param PKColumn
	 * @param FKColumn
	 */
	public StoreModel(String objectName,String PKColumn,String FKColumn)
	{
		super(objectName,PKColumn,FKColumn);
	}
	/**
	 * M�todo que llama a la clase padre y hace una busqueda en la base de datos 
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
		stores=new ArrayList<Store>();
		ResultSet rs;
		rs=Find(clausulas);
		Store store;
		while(rs.next())
		{
			store=new Store();
			store.ID=rs.getShort(1);
			store.managerStaffID=rs.getShort(2);
			store.managerStaffName=rs.getString(3)+" "+rs.getString(4);
			store.addressID=rs.getShort(5);
			store.addressName=rs.getString(6);
			store.lastUpdate=rs.getString(7);
			stores.add(store);
		}
		return stores;
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
