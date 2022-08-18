package oracletutor.mvc.view;

import oracletutor.mvc.controller.CityController;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.sql.SQLException;
import com.sakila.data.City;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * CityView.java
 * Vista de la entidad City
 * 
 * @author Juan José Jorge Rodríguez
 * @version 1.0
 *
 */
public class CityView extends View
{
	CityController city=new CityController();
	/**
	 * Despliega la CLI del Actor View
	 * @return un object
	 */
	public Object Show() 
	{
		System.out.println(String.format("\n%-45s\n"," ************ City View ************"));
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
				clausulas.put("objectName", "city");
				clausulas.put("PKColumn", "City_ID");
				clausulas.put("OrderColumn","");
				clausulas.put("FKCOlumn","city.Country_ID");
				
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
						clausulas.put("SearchColumn","City_ID,City,city.Country_ID,last_update");
						datos="";
						
						System.out.print("\n\tCity: ");
						datos+="'"+scan.nextLine()+"'";
					
						System.out.print("\tCountry_ID: ");
						datos+=","+scan.nextLine();
						correct=true;
						clausulas.put("Values", datos);
						if(Savechanges())
						{
							result=city.Post(clausulas);
							return result;
						}
						return null;
					case 2:
						//clausulas=new HashMap<String,String>();
						System.out.print("\n\tCity: ");

						clausulas.put("SearchColumn","City_ID,City,city.Country_ID,Country");
						clausulas.put("Values", "City='"+scan.nextLine()+"'");
						clausulas.put("TableJoin","Country");
						clausulas.put("Condicion de Relacion", "City.Country_ID=Country.Country_ID");
						
						correct=true;
						if(Savechanges())
						{
							result=city.Get(clausulas);
							Capture(result);
						}
						return null;
					case 3:
						//clausulas=new HashMap<String,String>();
						datos="";
						System.out.println("\n\tSET\n");
						
						System.out.print("\t\tCity: ");
						datos+="City='"+scan.nextLine()+"'";
						
						System.out.print("\t\tCountry_ID: ");
						datos+=", Country_ID="+scan.nextLine();
						
						datos+=", last_update="+fecha;
						
						clausulas.put("Values", datos);
						System.out.println("\tWHERE\n");
						
						System.out.print("\t\tID: ");
						
						clausulas.put("SearchColumn", "City_ID="+scan.nextLine());
						correct=true;
						if(Savechanges())
						{
							result=city.Put(clausulas);
							System.out.println();
							return result;
						}
						return null;
					case 4:
						//clausulas=new HashMap<String,String>();
						
						System.out.print("\t\tID: ");
						clausulas.put("SearchColumn", "City_ID="+scan.nextLine());
						correct=true;
						if(Savechanges())
						{
							result=city.Delete(clausulas);
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
	 * @param ciudades
	 */
	public void Capture(Object ciudades)
	{
		ArrayList<City> cityList=(ArrayList<City>)ciudades;
		System.out.print("+");
		for(int i=0;i<91;i++)
		{
			System.out.print("-");
		}
		System.out.print("+");
		System.out.print(String.format("\n| %-5s | %-30s | %-15s | %-30s |\n","ID","City","CountryID","CountryName"));
		System.out.print("+");
		for(int i=0;i<91;i++)
		{
			System.out.print("-");
		}
		System.out.print("+");
		for(City city:cityList)
		{
			System.out.println(String.format("\n| %-5d | %-30s | %-15d | %-30s |", city.ID,city.Name,city.CountryID,city.CountryName));
			System.out.print("+");
			for(int i=0;i<91;i++)
			{
				System.out.print("-");
			}
			System.out.print("+");
		}
		System.out.println("\n");
	}
}
