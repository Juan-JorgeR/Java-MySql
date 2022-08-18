package oracletutor.mvc.controller;

import java.sql.SQLException;
import java.util.HashMap;

import com.sakila.data.iDataRoute;
import com.sakila.models.StoreModel;
/**
 * StoreController.java
 * Controlador que sirve como interface entre el view de la app y el modelo de la entidad Store
 * 
 * @author Juan José Jorge Rodríguez
 * @version 1.0
 *
 */
public class StoreController extends Controller
{
	StoreModel store=new StoreModel("store","store_id","address_id manager_staff_id");
	/**
	 * Busca los datos en la base de datos
	 * @param clausulas
	 * @return Object
	 */
	@Override
	public Object Get(HashMap<String, String> clausulas) throws SQLException {
		// TODO Auto-generated method stub
		return store.Get(clausulas);
	}
	/**
	 * Crea un nuevo registro en la base de datos
	 * @param clausulas
	 * @return boolean
	 */
	@Override
	public boolean Post(HashMap<String, String> clausulas) {
		// TODO Auto-generated method stub
		return store.Post(clausulas);
	}
	/**
	 * Actualiza un registro en la base de datos
	 * @param clausulas
	 * @return boolean
	 */
	@Override
	public boolean Put(HashMap<String, String> clausulas) {
		// TODO Auto-generated method stub
		return store.Put(clausulas);
	}
	/**
	 * Elimina un registro
	 * @param clausulas
	 * @return boolean
	 */
	@Override
	public boolean Delete(HashMap<String, String> clausulas) {
		// TODO Auto-generated method stub
		return store.Delete(clausulas);
	}
	/**
	 * Hace una serializacion(no implementado por ahora)
	 */
	@Override
	public void Serializer() {
		// TODO Auto-generated method stub

	}

}
