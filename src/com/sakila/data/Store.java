package com.sakila.data;
/**
 * Store.java
 * Representa la entidad Tienda
 * @author Juan José Jorge Rodríguez
 * @version 1.0
 *
 */
public class Store extends Entity 
{
	/**
	 * PKColumn
	 */
	public short ID;
	/**
	 * Id del encargado de la tienda 
	 */
	public short managerStaffID;
	/**
	 * Nombre del encargado
	 */
	public String managerStaffName;
	/**
	 * Id de la dirección
	 */
	public short addressID;
	/**
	 * Nombre de la dirección
	 */
	public String addressName;
	/**
	 * Fecha de última actualización
	 */
	public String lastUpdate;
	/**
	 * Constructor
	 */
	public Store() {}
}
