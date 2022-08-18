package com.sakila.data;

/**
 * Actor.java
 * 
 * Representa la entidad actor 
 * 
 * @author Juan José Jorge Rodríguez
 * @version 1.0
 */
public class Actor extends Entity
{
	/**
	 * PKColumn de la entidad
	 */
	public short ID;
	/**
	 * Nombre del actor
	 */
	public String firstName;
	/**
	 * Apellido del actor
	 */
	public String lastName;
	/**
	 * Fecha de la última actualización
	 */
	public String lastUpdate;
	/**
	 * Constructor 
	 */
	public Actor() {}
}
