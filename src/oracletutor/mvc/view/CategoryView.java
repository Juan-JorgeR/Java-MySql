package oracletutor.mvc.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.sakila.data.Category;

import oracletutor.mvc.controller.CategoryController;
/**
 * CategoryView.java
 * Vista de la entidad Category
 * 
 * @author Juan José Jorge Rodríguez
 * @version 1.0
 *
 */
public class CategoryView extends View 
{
	CategoryController category=new CategoryController();
	/**
	 * Despliega la CLI del Actor View
	 * @return un object
	 */
	public Object Show() 
	{
		System.out.println(String.format("\n%-45s\n"," ************ Category View ************"));
		Scanner scan=new Scanner(System.in);
		
		super.Show();
		boolean correct=false;
		while(!correct)
		{
			System.out.print("\n into opcion: ");
			
			try
			{
				HashMap<String,String> clausulas=new HashMap<String,String>();
				Object result;
				String datos;
				int opcion=GetOption();
				clausulas.put("objectName", "Category");
				clausulas.put("PKColumn", "Category_ID");
				clausulas.put("OrderColumn",null);
				clausulas.put("FKCOlumn",null);
				
				GregorianCalendar g=new GregorianCalendar();
				int year,month,day,hour,min,sec;
				year=g.get(Calendar.YEAR);
				month=g.get(Calendar.MONTH);
				day=g.get(Calendar.DAY_OF_MONTH);
				hour=g.get(Calendar.HOUR);
				min=g.get(Calendar.MINUTE);
				sec=g.get(Calendar.SECOND);
				String fecha="'"+String.format("%d-%d-%d %d:%d:%d", year,month,day,hour,min,sec)+"'";
				clausulas.put("DateColumn",fecha);
				
				switch(opcion)
				{
					
					case 1:
						//clausulas=new HashMap<String,String>();
						clausulas.put("SearchColumn","Category_ID,Name,last_update");
						datos="";
						
						System.out.print("\n\tName: ");
						datos+="'"+scan.nextLine()+"'";
						
						correct=true;
						clausulas.put("Values", datos);
						if(Savechanges())
						{
							result=category.Post(clausulas);
							return result;
						}
						return null;
					case 2:
						//clausulas=new HashMap<String,String>();
						System.out.print("\n\tName: ");

						clausulas.put("SearchColumn","category_id,name,last_update");
						clausulas.put("Values", "name='"+scan.nextLine()+"'");
					
						correct=true;
						if(Savechanges())
						{
							result=category.Get(clausulas);
							Capture(result);
						}
						return null;
					case 3:
						//clausulas=new HashMap<String,String>();
						datos="";
						System.out.println("\n\tSET\n");
						
						System.out.print("\t\tName: ");
						datos+="name='"+scan.nextLine()+"'";					
						
						datos+=", last_update="+fecha;
						
						clausulas.put("Values", datos);
						System.out.println("\tWHERE\n");
						
						System.out.print("\t\tID: ");
						
						clausulas.put("SearchColumn", "Category_ID="+scan.nextLine());
						correct=true;
						if(Savechanges())
						{
							result=category.Put(clausulas);
							System.out.println();
							return result;
						}
						return null;
					case 4:
						//clausulas=new HashMap<String,String>();
						
						System.out.print("\t\tID: ");
						clausulas.put("SearchColumn", "Category_ID="+scan.nextLine());
						correct=true;
						if(Savechanges())
						{
							result=category.Delete(clausulas);
							return result;
						}
						return null;
					default:
						System.out.println("opcion invalida");
				}
				
			}
			catch(InputMismatchException | SQLException e)
			{
				if(e.equals(InputMismatchException.class))
					System.out.println("opcion invalida");
				System.out.println(e);
			}
		}
		return null;
	}
	/**
	 * Captura la respuesta de la consulta a la base de datos
	 * @param categorias
	 */
	public void Capture(Object categorias)
	{
		ArrayList<Category> categoryList=(ArrayList<Category>)categorias;
		System.out.print("+");
		for(int i=0;i<73;i++)
		{
			System.out.print("-");
		}
		System.out.print("+");
		System.out.print(String.format("\n| %-5s | %-30s | %-30s |\n","ID","Name","Last_Update"));
		System.out.print("+");
		for(int i=0;i<73;i++)
		{
			System.out.print("-");
		}
		System.out.print("+");
		for(Category category:categoryList)
		{
			System.out.println(String.format("\n| %-5d | %-30s | %-30s |", category.ID,category.name,category.lastUpdate));
			System.out.print("+");
			for(int i=0;i<73;i++)
			{
				System.out.print("-");
			}
			System.out.print("+");
		}
		System.out.println("\n");
	}
}
