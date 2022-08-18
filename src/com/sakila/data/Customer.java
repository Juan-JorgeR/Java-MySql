package com.sakila.data;
/**
 * Customer.java
 * 
 * Representa la entidad cliente 
 * 
 * @author Juan José Jorge Rodríguez
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
	 * Correo electrónico
	 */
	public String email;
	/**
	 * Id de la direccion del cliente
	 */
	public short addressID;
	/**
	 * Nombre de la dirección
	 */
	public String addressName;
	/**
	 * Especifica si el cliente retorno o no la película rentada 
	 */
	public boolean active;
	/**
	 * Fecha de consumo del cliente
	 */
	public String createDate;
	/**
	 * Fecha de última actualización
	 */
	public String lastUpdate;
	/**
	 * Constructor
	 */
	public Customer() {}
}
