package com.sakila.data;
/**
 * Film.java
 * 
 * Representa la entidad película
 * 
 * @author Juan José Jorge Rodríguez
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
	 * Título de la película
	 */
	public String title;
	/**
	 * Descricción
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
	 * Id del lenguaje original de la película
	 */
	public short original_language_id;
	/**
	 * Lenguaje original de la película
	 */
	public String originallanguageName;
	/**
	 * Periodo de tiempo por el cual se rentará la película
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
	 * Fecha de última actualización
	 */
	public String lastUpdate;
	/**
	 * Constructor
	 */
	public Film() {}
}
