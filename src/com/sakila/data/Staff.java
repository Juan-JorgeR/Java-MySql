package com.sakila.data;

import java.nio.file.Path;
import java.sql.Blob;
/**
 * Staff.java
 * Representa la entidad empleado
 * @author Juan Jos� Jorge Rodr�guez
 * @version 1.0
 *
 */
public class Staff extends Entity 
{
	/**
	 * PKColumn
	 */
	public short ID;
	/**
	 * Nombre del empleado
	 */
	public String firtsName;
	/**
	 * Apellido del empleado
	 */
	public String lastName;
	/**
	 * Id de la direcci�n
	 */
	public short addressID;
	/**
	 * Nombre de la direcci�n
	 */
	public String addressName;
	/**
	 * Foto del empleado
	 */
	public Blob picture;
	/**
	 * COrreo elect�nico del empleado
	 */
	public String email;
	/**
	 * Id de la tienda donde el empleado trabaja
	 */
	public short storeID;
	/**
	 * Especifica si el empleado esta trabajando
	 */
	public boolean active;
	/**
	 * Nombre de usuario del empleado
	 */
	public String username;
	/**
	 * Contrase�a
	 */
	public String password;
	/**
	 * Fecha de ultima actualizaci�n
	 */
	public String lastUpdate;
	/**
	 * Constructor
	 */
	public Staff() {}
}
