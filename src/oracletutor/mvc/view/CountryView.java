package oracletutor.mvc.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

import com.sakila.data.City;
import com.sakila.data.Country;
import com.sakila.data.Entity;

import oracletutor.mvc.controller.CountryController;
/**
 * CountryView.java
 * Vista de la entidad Country
 * 
 * @author Juan José Jorge Rodríguez
 * @version 1.0
 *
 */
public class CountryView extends View
{
	CountryController country=new CountryController();
	/**
	 * Despliega la CLI del Actor View
	 * @return un object
	 */
	public Object Show() 
	{
		System.out.println(String.format("\n%-45s\n"," ************ Country View ************"));
		Scanner scan=new Scanner(System.in);
		
		super.Show();
		boolean correct=false;
		while(!correct)
		{
			System.out.print("\n into opcion: ");
			
			try
			{
				HashMap<String,String> clausulas=new HashMap<String,String>();
				int opcion=GetOption();
				Object result;
				String datos;
				clausulas.put("objectName", "country");
				clausulas.put("PKColumn", "Country_ID");
				clausulas.put("OrderColumn","");
				
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
						clausulas.put("SearchColumn","Country_ID,Country,last_update");
						datos="";
						
						System.out.print("\n\tCountry: ");
						datos+="'"+scan.nextLine()+"'";
						correct=true;
						clausulas.put("Values", datos);
						if(Savechanges())
						{
							result=country.Post(clausulas);
							return result;
						}
						return null;
					case 2:
						System.out.print("\n\tCountry: ");

						clausulas.put("SearchColumn","Country_ID,Country");
						clausulas.put("Values", "Country='"+scan.nextLine()+"'");
					
						correct=true;
						if(Savechanges())
						{
							result=country.Get(clausulas);
							Capture(result);
						}	
						return null;
					case 3:
						datos="";
						System.out.println("\n\tSET\n");
						
						System.out.print("\t\tCountry: ");
						datos+="City='"+scan.nextLine()+"'";
						
						System.out.print("\t\tCountry_ID: ");
						datos+=", Country_ID="+scan.nextLine();
						
						datos+=", last_update="+fecha;
						
						clausulas.put("Values", datos);
						System.out.println("\tWHERE\n");
						
						System.out.print("\t\tID: ");
						
						clausulas.put("SearchColumn", "Country_ID="+scan.nextLine());
						correct=true;
						if(Savechanges())
						{
							result=country.Put(clausulas);
							System.out.println();
							return result;
						}
						return null;
					case 4:
						System.out.print("\t\tID: ");
						clausulas.put("SearchColumn", "Country_ID="+scan.nextLine());
						correct=true;
						if(Savechanges())
						{
							result=country.Delete(clausulas);
							return result;
						}
						return null;
					default:
						System.out.println("opcion invalida");
				}
			}
			catch(Exception e)
			{
				System.out.println("opcion invalida");
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * Captura la respuesta de la consulta a la base de datos
	 * @param paises
	 */
	public void Capture(Object paises)
	{
		ArrayList<Country> countryList=(ArrayList<Country>)paises;
		System.out.print("+");
		for(int i=0;i<40;i++)
		{
			System.out.print("-");
		}
		System.out.print("+");
		System.out.print(String.format("\n| %-5s | %-30s |\n","ID","Country"));
		System.out.print("+");
		for(int i=0;i<40;i++)
		{
			System.out.print("-");
		}
		System.out.print("+");
		for(Country country:countryList)
		{
			System.out.println(String.format("\n| %-5d | %-30s |", country.ID,country.Name));
			System.out.print("+");
			for(int i=0;i<40;i++)
			{
				System.out.print("-");
			}
			System.out.print("+");
		}
		System.out.println("\n");	}
}
