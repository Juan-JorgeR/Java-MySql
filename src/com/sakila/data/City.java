package com.sakila.data;
/**
 * City.java
 * 
 * Representa la entidad ciudad
 * 
 * @author Juan Jos� Jorge Rodr�guez
 * @version 1.0
 *
 */
public class City extends Entity
{
	/** 
	 * PKColumn
	 */
	public short ID;
	/**
	 * Nombre de la ciudad
	 */
	public String Name;
	/**
	 * Id del pais al que pertenece la ciudad
	 */
	public short CountryID;
	/**
	 * Nombre del pa�s
	 */
	public String CountryName;
	/**
	 * Constructor
	 */
	public City() {}
}
