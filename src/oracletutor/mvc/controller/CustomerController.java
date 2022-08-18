package oracletutor.mvc.controller;

import java.sql.SQLException;
import java.util.HashMap;

import com.sakila.data.iDataRoute;
import com.sakila.models.CustomerModel;
/**
 * Customer.java
 * Controlador que sirve como interface entre el view de la app y el modelo de la entidad Customer
 * 
 * @author Juan José Jorge Rodríguez
 * @version 1.0
 *
 */
public class CustomerController extends Controller 
{
	CustomerModel customer=new CustomerModel("customer","customer_id","address_id store_id");
	/**
	 * Busca los datos en la base de datos
	 * @param clausulas
	 * @return Object
	 */
	@Override
	public Object Get(HashMap<String, String> clausulas) throws SQLException 
	{
		return customer.Get(clausulas);
	}
	/**
	 * Crea un nuevo registro en la base de datos
	 * @param clausulas
	 * @return boolean
	 */
	@Override
	public boolean Post(HashMap<String, String> clausulas) 
	{
		return customer.Post(clausulas);
	}
	/**
	 * Actualiza un registro en la base de datos
	 * @param clausulas
	 * @return boolean
	 */
	@Override
	public boolean Put(HashMap<String, String> clausulas) {
		// TODO Auto-generated method stub
		return customer.Put(clausulas);
	}
	/**
	 * Elimina un registro
	 * @param clausulas
	 * @return boolean
	 */
	@Override
	public boolean Delete(HashMap<String, String> clausulas) {
		// TODO Auto-generated method stub
		return customer.Delete(clausulas);
	}
	/**
	 * Hace una serializacion(no implementado por ahora)
	 */
	@Override
	public void Serializer() {
		// TODO Auto-generated method stub

	}

}
