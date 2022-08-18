package com.sakila.data;
/**
 * Customer.java
 * 
 * Representa la entidad cliente 
 * 
 * @author Juan Jos� Jorge Rodr�guez
 * @version 1.0
 *
 */
public class Customer extends Entity 
{
	/**
	 * PKColumn
	 */
	public short ID;
	/**
	 * Id de la tienda en la alquilo la pelicula
	 */
	public short storeID;
	/**
	 * Nombre del cliente
	 */
	public String firtsName;
	/**
	 * Apellido del cliente
	 */
	public String lastName;
	/**
	 * Correo electr�nico
	 */
	public String email;
	/**
	 * Id de la direccion del cliente
	 */
	public short addressID;
	/**
	 * Nombre de la direcci�n
	 */
	public String addressName;
	/**
	 * Especifica si el cliente retorno o no la pel�cula rentada 
	 */
	public boolean active;
	/**
	 * Fecha de consumo del cliente
	 */
	public String createDate;
	/**
	 * Fecha de �ltima actualizaci�n
	 */
	public String lastUpdate;
	/**
	 * Constructor
	 */
	public Customer() {}
}
