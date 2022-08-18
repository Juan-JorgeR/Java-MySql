package oracletutor.mvc.view;

import java.util.Scanner;
import oracletutor.mvc.controller.Controller;
import com.sakila.data.Entity;
/**
 * View.java
 * Vista
 * 
 * @author Juan José Jorge Rodríguez
 * @version 1.0
 *
 */
public class View 
{
	/**
	 * Despliega la CLI del Actor View
	 * @return un object
	 */
	public Object Show() 
	{
		System.out.println("\t 1 - Create ");
		System.out.println("\t 2 - Read ");
		System.out.println("\t 3 - Update ");
		System.out.println("\t 4 - Delete ");
		
		
		return null;
	}
	/**
	 * Guarda los cambios efectuados 
	 * @return boolean
	 */
	public boolean Savechanges() 
	{
		System.out.print("\tDesea guardar los cambios[y|n]: ");
		Scanner scan=new Scanner(System.in);
		if(scan.next().equals("y"))
			return true;
		else
			return false;
	}
	/**
	 * Captura desde el teclado la opcion seleccionada
	 * @return int
	 */
	public int GetOption() 
	{
		Scanner scan=new Scanner(System.in);
		int option=scan.nextInt();
		
		return option;
	}
	/**
	 * Captura la respuesta de la consulta hecha a la base de datos
	 * @param entidad
	 */
	public void Capture(Object entidad) {} 
}
