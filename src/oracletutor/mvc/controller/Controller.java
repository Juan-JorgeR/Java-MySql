package oracletutor.mvc.controller;

import java.util.HashMap;
import java.sql.SQLException;

import com.sakila.data.iDataRoute;
/**
 * Controller.java
 * Representa un controlador para todas las vistas
 * @author Juan José Jorge Rodríguez 
 * @version 1.0
 *
 */
public abstract class Controller implements iDataRoute
{
	/**
	 * Busca los datos en la base de datos
	 * @param clausulas
	 */
	public abstract Object Get(HashMap<String,String> clausulas) throws SQLException;
	/**
	 * Crea un nuevo registro en la base de datos
	 * @param clausulas
	 * @return boolean
	 */
	public abstract boolean Post(HashMap<String,String> clausulas);
	/**
	 * Actualiza un registro en la base de datos
	 * @param clausulas
	 * @return boolean
	 */
	public abstract boolean Put(HashMap<String,String> clausulas);
	/**
	 * Elimina un registro
	 * @param clausulas
	 * @return boolean
	 */
	public abstract boolean Delete(HashMap<String,String> clausulas);
	/**
	 * Hace una serializacion(no implementado por ahora)
	 */
	public abstract void Serializer();
}
