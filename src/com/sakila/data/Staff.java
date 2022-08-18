package com.sakila.data;

import java.nio.file.Path;
import java.sql.Blob;
/**
 * Staff.java
 * Representa la entidad empleado
 * @author Juan José Jorge Rodríguez
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
	 * Id de la dirección
	 */
	public short addressID;
	/**
	 * Nombre de la dirección
	 */
	public String addressName;
	/**
	 * Foto del empleado
	 */
	public Blob picture;
	/**
	 * COrreo electónico del empleado
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
	 * Contraseña
	 */
	public String password;
	/**
	 * Fecha de ultima actualización
	 */
	public String lastUpdate;
	/**
	 * Constructor
	 */
	public Staff() {}
}
