package com.sakila.data;
/**
 * Store.java
 * Representa la entidad Tienda
 * @author Juan Jos� Jorge Rodr�guez
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
	 * Id de la direcci�n
	 */
	public short addressID;
	/**
	 * Nombre de la direcci�n
	 */
	public String addressName;
	/**
	 * Fecha de �ltima actualizaci�n
	 */
	public String lastUpdate;
	/**
	 * Constructor
	 */
	public Store() {}
}
