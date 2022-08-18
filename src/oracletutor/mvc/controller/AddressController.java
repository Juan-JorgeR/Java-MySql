package oracletutor.mvc.controller;

import java.sql.SQLException;
import java.util.HashMap;

import com.sakila.data.iDataRoute;
import com.sakila.models.AddressModel;
/**
 * AddressController.java
 * Controlador que sirve como interface entre el view de la app y el modelo de la entidad address
 * 
 * @author Juan José Jorge Rodríguez
 * @version 1.0
 *
 */
public class AddressController extends Controller 
{
	AddressModel address=new AddressModel("address","address_id","city_id");
	/**
	 * Busca los datos en la base de datos
	 * @param clausulas
	 * @return Object
	 */
	@Override
	public Object Get(HashMap<String, String> clausulas) throws SQLException 
	{
		return address.Get(clausulas);
	}
	/**
	 * Crea un nuevo registro
	 * @param clausulas
	 * @return boolean
	 */
	@Override
	public boolean Post(HashMap<String, String> clausulas) 
	{
		return address.Post(clausulas);
	}
	/**
	 * Actualiza un registro
	 * @param clausulas
	 * @return boolean
	 */
	@Override
	public boolean Put(HashMap<String, String> clausulas) 
	{
		return address.Put(clausulas);
	}
	/**
	 * Elimina un registro
	 * @param clausulas
	 * @return boolean
	 */
	@Override
	public boolean Delete(HashMap<String, String> clausulas) 
	{
		return address.Delete(clausulas);
	}
	/**
	 * Hace una serializacion(no implementado por ahora)
	 */
	@Override
	public void Serializer() {}

}
