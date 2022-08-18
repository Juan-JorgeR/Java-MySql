package com.sakila.data;
/**
 * 
 * Category.java
 * 
 * Representa la entidad categoria
 * 
 * @author Juan Jos� Jorge Rodr�guez
 * @version 1.0
 *
 */
public class Category extends Entity 
{
	/**
	 * PKColumn
	 */
	public short ID;
	/**
	 * Nombre de la categoria
	 */
	public String name;
	/**
	 * Fecha de �ltima actualizaci�n
	 */
	public String lastUpdate;
	/**
	 * Constructor
	 */
	public Category() {}
}
