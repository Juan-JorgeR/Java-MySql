package oracletutor.mvc.controller;

import java.sql.SQLException;
import java.util.HashMap;

import com.sakila.models.CountryModel;
/**
 * Country.java
 * Controlador que sirve como interface entre el view de la app y el modelo de la entidad Country
 * 
 * @author Juan José Jorge Rodríguez
 * @version 1.0
 *
 */
public class CountryController extends Controller
{
	CountryModel country=new CountryModel("Country","Country_ID",null);
	/**
	 * Busca los datos en la base de datos
	 * @param clausulas
	 * @return Object
	 */
	public Object Get(HashMap<String,String> clausulas) throws SQLException
	{
		return country.Get(clausulas);
	}
	/**
	 * Crea un nuevo registro en la base de datos
	 * @param clausulas
	 * @return boolean
	 */
	public boolean Post(HashMap<String,String> clausulas) 
	{
		return country.Post(clausulas);
	}
	/**
	 * Actualiza un registro en la base de datos
	 * @param clausulas
	 * @return boolean
	 */
	public boolean Put(HashMap<String,String> clausulas) 
	{
		return country.Put(clausulas);
	}
	/**
	 * Elimina un registro
	 * @param clausulas
	 * @return boolean
	 */
	public boolean Delete(HashMap<String,String> clausulas) 
	{
		return country.Delete(clausulas);
	}
	/**
	 * Hace una serializacion(no implementado por ahora)
	 */
	public void Serializer() {}
}
