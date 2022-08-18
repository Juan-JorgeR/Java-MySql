package oracletutor.mvc.controller;

import java.sql.SQLException;
import java.util.HashMap;

import com.sakila.data.iDataRoute;
import com.sakila.models.RentalModel;
/**
 * RentalController.java
 * Controlador que sirve como interface entre el view de la app y el modelo de la entidad Rental
 * 
 * @author Juan José Jorge Rodríguez
 * @version 1.0
 *
 */
public class RentalController extends Controller
{
	RentalModel rental=new RentalModel("Rental","rental_id","customer_id inventory_id staff_id");
	/**
	 * Busca los datos en la base de datos
	 * @param clausulas
	 * @return Object
	 */
	@Override
	public Object Get(HashMap<String, String> clausulas) throws SQLException {
		// TODO Auto-generated method stub
		return rental.Get(clausulas);
	}
	/**
	 * Crea un nuevo registro en la base de datos
	 * @param clausulas
	 * @return boolean
	 */
	@Override
	public boolean Post(HashMap<String, String> clausulas) {
		// TODO Auto-generated method stub
		return rental.Post(clausulas);
	}
	/**
	 * Actualiza un registro en la base de datos
	 * @param clausulas
	 * @return boolean
	 */
	@Override
	public boolean Put(HashMap<String, String> clausulas) {
		// TODO Auto-generated method stub
		return rental.Put(clausulas);
	}
	/**
	 * Elimina un registro
	 * @param clausulas
	 * @return boolean
	 */
	@Override
	public boolean Delete(HashMap<String, String> clausulas) {
		// TODO Auto-generated method stub
		return rental.Delete(clausulas);
	}
	/**
	 * Hace una serializacion(no implementado por ahora)
	 */
	@Override
	public void Serializer() {
		// TODO Auto-generated method stub

	}

}
