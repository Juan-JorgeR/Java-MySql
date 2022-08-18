package com.sakila.data;
/**
 * Film.java
 * 
 * Representa la entidad pel�cula
 * 
 * @author Juan Jos� Jorge Rodr�guez
 * @version 1.0
 *
 */
public class Film extends Entity 
{
	/**
	 * PKColumn
	 */
	public short ID;
	/**
	 * T�tulo de la pel�cula
	 */
	public String title;
	/**
	 * Descricci�n
	 */
	public String description;
	/**
	 * release year
	 */
	public int release_year;
	/**
	 * Id del lenguaje en que esta la pelicula
	 */
	public short language_id;
	/**
	 * Lenguaje de la pelicula
	 */
	public String lenguajeName;
	/**
	 * Id del lenguaje original de la pel�cula
	 */
	public short original_language_id;
	/**
	 * Lenguaje original de la pel�cula
	 */
	public String originallanguageName;
	/**
	 * Periodo de tiempo por el cual se rentar� la pel�cula
	 */
	public int rental_duration;
	/**
	 * rental rate
	 */
	public double rental_rate;
	/**
	 * length
	 */
	public int length;
	/**
	 * costo de renta
	 */
	public double replacement_cost;
	/**
	 * rating
	 */
	public String rating;
	/**
	 * special feactures
	 */
	public String special_features;
	/**
	 * Fecha de �ltima actualizaci�n
	 */
	public String lastUpdate;
	/**
	 * Constructor
	 */
	public Film() {}
}
