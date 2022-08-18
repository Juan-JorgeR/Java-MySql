package oracletutor.mvc.controller;

import com.sakila.models.CityModel;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * Controlador que sirve como interface entre el view de la app y el modelo de la entidad City
 * 
 * @author Juan José Jorge Rodríguez
 * @version 1.0
 *
 */
public class CityController extends Controller
{
	CityModel city=new CityModel("city","city_id","country_id");
	/**
	 * Busca los datos en la base de datos
	 * @param clausulas
	 * @return Object
	 */
	public Object Get(HashMap<String,String> clausulas) throws SQLException
	{
		return city.Get(clausulas);
	}
	/**
	 * Crea un nuevo registro en la base de datos
	 * @param clausulas
	 * @return boolean
	 */
	public boolean Post(HashMap<String,String> clausulas) 
	{

		return city.Post(clausulas);
	}
	/**
	 * Actualiza un registro en la base de datos
	 * @param clausulas
	 * @return boolean
	 */
	public boolean Put(HashMap<String,String> clausulas) 
	{
		return city.Put(clausulas);
	}
	/**
	 * Elimina un registro
	 * @param clausulas
	 * @return boolean
	 */
	public boolean Delete(HashMap<String,String> clausulas) 
	{
		return city.Delete(clausulas);
	}
	/**
	 * Hace una serializacion(no implementado por ahora)
	 */
	public void Serializer() {}
}
