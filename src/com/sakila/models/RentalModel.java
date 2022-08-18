package com.sakila.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.sakila.data.Rental;
/**
 * RentalModel.java
 * 
 * Representa la implementación de la interface IORMObject para Renta
 * @author Juan Josó Jorge Rodríguez
 * @version 1.0
 *
 */
public class RentalModel extends EntiryModel implements iORMObject
{
	ArrayList<Rental> rentas;
	/**
	 * Método que permite saber a la entidad Renta cual es la tabla que le corresponde en 
	 * la base de datos, la columna que contiene la clave primaria y las que poseen las clave foranes.
	 * 
	 * @param objectName
	 * @param PKColumn
	 * @param FKColumn
	 */
	public RentalModel(String objectName,String PKColumn,String FKColumn)
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
		rentas=new ArrayList<Rental>();
		ResultSet rs;
		rs=Find(clausulas);
		Rental renta;
		while(rs.next())
		{
			renta=new Rental();
			renta.ID=rs.getShort(1);
			renta.rentalDate=rs.getString(2);
			renta.inventoryID=rs.getInt(3);
			renta.customerID=rs.getInt(4);
			renta.staffID=rs.getShort(5);
			renta.staffName=rs.getString(6)+" "+rs.getString(7);
			renta.returnDate=rs.getString(8);
			renta.lastUpdate=rs.getString(9);
			
			rentas.add(renta);
		}
		return rentas;
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
