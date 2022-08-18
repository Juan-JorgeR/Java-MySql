package com.sakila.data;
/**
 * Rental.java
 * Representa la entidad renta
 * @author Usuario
 * @version 1.0
 */
public class Rental extends Entity 
{
	/**
	 * PKColumn
	 */
	public int ID;
	/**
	 * Fecha de rentada la pel�cula
	 */
	public String rentalDate;
	/**
	 * Id del inventario
	 */
	public int inventoryID;
	/**
	 * Id cliente
	 */
	public int customerID;
	/**
	 * Nombre del cliente
	 */
	public String customerName;
	/**
	 * Fecha de devoluci�n de la pel�cula
	 */
	public String returnDate;
	/**
	 * Id del empleado que atendi� al cliente
	 */
	public short staffID;
	/**
	 * Nombre del empleado
	 */
	public String staffName;
	/**
	 * Fecha de la �ltima actualizaci�n
	 */
	public String lastUpdate;
	
	/**
	 * Constructor
	 */
	public Rental() {}
}
