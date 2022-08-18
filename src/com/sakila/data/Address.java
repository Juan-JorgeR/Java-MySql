package com.sakila.data;
/**
 * Address.java
 *
 * Representa la entidad direcci�n
 * 
 * @author Juan Jos� Jorge Rodr�guez
 * @version 1.0
 *
 */
public class Address extends Entity
{
	/**
	 * PKColumn de address
	 */
	public short ID;
	/**
	 * Direccion
	 */
	public String address;
	/**
	 * Segunda direccion
	 */
	public String address2;
	/**
	 * Distrito
	 */
	public String district;
	/**
	 * Id de la ciudad a la que pertenece
	 */
	public short cityID;
	/**
	 * Nombre de la ciudad
	 */
	public String cityName;
	/**
	 * Codigo postal de la direccion
	 */
	public String postalCode;
	/**
	 * Numero de telefono
	 */
	public String phone;
	/**
	 * Fecha de la �ltima actualizaci�n
	 */
	public String lastUpdate;
	/**
	 * Constructor
	 */
	public Address() {}
}
