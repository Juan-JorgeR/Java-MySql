package com.sakila.models;
/**
 * CategoryModel.java
 * 
 * Representa la implementación de la interface IORMObject para Category
 * @author Juan Josó Jorge Rodríguez
 * @version 1.0
 *
 */
import com.sakila.models.EntiryModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.sakila.data.Category;

public class CategoryModel extends EntiryModel implements iORMObject
{
	/**
	 * lista de direcciones
	 */
	ArrayList<Category> categorias;
	/**
	 * Método que permite saber a la entidad category cual es la tabla que le corresponde en 
	 * la base de datos, la columna que contiene la clave primaria y las que poseen las clave foranes.
	 * 
	 * @param objectName
	 * @param PKColumn
	 * @param FKColumn
	 */
	public CategoryModel(String objectName,String PKColumn,String FKColumn)
	{
		super(objectName,PKColumn,FKColumn);
	}
	/**
	 * Método que llama a la clase padre y hace una busqueda en la base de datos 
	 * @param clausulas
	 * @return ResulSet de la base de datos
	 */
	protected ResultSet Find(HashMap<String,String> clausulas) 
	{
		return super.Find(clausulas);
	}
	/**
	 * Obtiene los datos devueltos en la busqueda
	 * @param clausulas
	 * @return Object
	 * @throws SQLException
	 */
	public Object Get(HashMap<String,String> clausulas) throws SQLException
	{
		categorias=new ArrayList<Category>();
		ResultSet rs;
		rs=Find(clausulas);
		Category category;
		while(rs.next())
		{
			category=new Category();
			category.ID=Short.parseShort(rs.getString(1));
			category.name=rs.getString(2);
			category.lastUpdate=rs.getString(3);
			categorias.add(category);
		}
		return categorias;
	}
	/**
	 * Crea un nuevo registro
	 * @param clausulas
	 * @return boolean
	 */
	public boolean Post(HashMap<String,String> clausulas) 
	{
		return super.Post(clausulas);
	}
	/**
	 * Actualiza un registro
	 * @param clausulas
	 * @return boolean
	 */
	public boolean Put(HashMap<String,String> clausulas) 
	{
		return super.Put(clausulas);
	}
	/**
	 * Elimina un registro
	 * @param clausulas
	 * @return boolean
	 */
	public boolean Delete(HashMap<String,String> clausulas)
	{		
		return super.Delete(clausulas);
	}
	/**
	 * Hace un mapeo (no implementado por ahora)
	 */
	public void Mapping() {}
}
