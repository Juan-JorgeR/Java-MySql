package oracletutor.mvc.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.sakila.data.Film;

import oracletutor.mvc.controller.FilmController;
/**
 * FilmView.java
 * Vista de la entidad Film
 * 
 * @author Juan José Jorge Rodríguez
 * @version 1.0
 *
 */
public class FilmView extends View 
{
	FilmController film=new FilmController();
	/**
	 * Despliega la CLI del Actor View
	 * @return un object
	 */
	public Object Show() 
	{
		System.out.println(String.format("\n%-45s\n"," ************ Film View ************"));
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
				clausulas.put("objectName", "Film");
				clausulas.put("PKColumn", "Film_ID");
				clausulas.put("OrderColumn",null);
				clausulas.put("FKCOlumn","lenguaje_ID original_lenguaje_ID");
				
				GregorianCalendar g=new GregorianCalendar();
				int year,month,day,hour,min,sec;
				year=g.get(Calendar.YEAR);
				month=g.get(Calendar.MONTH);
				day=g.get(Calendar.DAY_OF_MONTH);
				hour=g.get(Calendar.HOUR);
				min=g.get(Calendar.MINUTE);
				sec=g.get(Calendar.SECOND);
				String fecha="'"+String.format("%d-%d-%d %d:%d:%d", year,month,day,hour,min,sec)+"'";
				clausulas.put("DateColumn","'"+fecha+"'");
				
				switch(opcion)
				{
					
					case 1:
						//clausulas=new HashMap<String,String>();
						clausulas.put("SearchColumn","Film_ID,title,description,release_year,language_id,original_language_id,rental_duration,rental_rate,length,replacement_cost,rating,special_features,last_update");
						datos="";
						
						System.out.print("\n\ttitle: ");
						datos+="'"+scan.nextLine()+"'";
						
						System.out.print("\n\tdescription: ");
						datos+=", '"+scan.nextLine()+"'";
						
						System.out.print("\n\trelease_year: ");
						datos+=", "+scan.nextLine();
						
						System.out.print("\n\tLanguageID: ");
						datos+=", "+scan.nextLine();
						
						System.out.print("\n\tOriginal Language ID: ");
						datos+=", "+scan.nextLine();
						
						System.out.print("\n\tRental_Duration: ");
						datos+=", "+scan.nextLine();
						
						System.out.print("\n\tRental_Rate: ");
						datos+=", "+scan.nextLine();
						
						System.out.print("\n\tLength: ");
						datos+=", "+scan.nextLine();
						
						System.out.print("\n\tReplacement Cost: ");
						datos+=", "+scan.nextLine();
						
						System.out.print("\n\tRating: ");
						datos+=", '"+scan.nextLine()+"'";
						
						System.out.print("\n\tSpecial Features: ");
						datos+=", '"+scan.nextLine()+"'";
						
						correct=true;
						clausulas.put("Values", datos);
						if(Savechanges())
						{
							result=film.Post(clausulas);
							return result;
						}
						return null;
					case 2:
						//clausulas=new HashMap<String,String>();
						System.out.print("\n\tTitle: ");

						clausulas.put("SearchColumn","Film_ID,title,description,release_year,film.language_id,name,original_language_id,name,rental_duration,rental_rate,length,replacement_cost,rating,special_features,film.last_update");
						clausulas.put("Values", "Title='"+scan.nextLine()+"'");
						clausulas.put("TableJoin","Language");
						clausulas.put("Condicion de Relacion", "language.language_ID=film.language_ID");
						
						correct=true;
						if(Savechanges())
						{
							result=film.Get(clausulas);
							Capture(result);
						}
						return null;
					case 3:
						//clausulas=new HashMap<String,String>();
						datos="";
						System.out.println("\n\tSET\n");
						
						System.out.print("\t\tTitle: ");
						datos+="title='"+scan.nextLine()+"'";
						
						System.out.print("\t\tDescription: ");
						datos+=", description='"+scan.nextLine()+"'";
						
						System.out.print("\t\tRelease_year: ");
						datos+=", release_year="+scan.nextLine();
						
						System.out.print("\t\tLenguaje_ID: ");
						datos+=", language_ID="+scan.nextLine();
						
						System.out.print("\t\tOriginal_lenguaje_ID: ");
						datos+=", original_language_ID="+scan.nextLine();
						
						System.out.print("\t\tRental_duration: ");
						datos+=", rental_duration="+scan.nextLine();
						
						System.out.print("\t\tRental_rate: ");
						datos+=", Rental_rate="+scan.nextLine();
						
						System.out.print("\t\tLength: ");
						datos+=", length="+scan.nextLine();
						
						System.out.print("\t\tReplacement_cost: ");
						datos+=", replacement_cost="+scan.nextLine();
						
						System.out.print("\t\tRating: ");
						datos+=", rating='"+scan.nextLine()+"'";
						
						System.out.print("\t\tspecial_features: ");
						datos+=", special_features='"+scan.nextLine()+"'";
						
						datos+=", last_update="+fecha;
						
						clausulas.put("Values", datos);
						System.out.println("\tWHERE\n");
						
						System.out.print("\t\tID: ");
						
						clausulas.put("SearchColumn", "Film_ID="+scan.nextLine());
						correct=true;
						if(Savechanges())
						{
							result=film.Put(clausulas);
							System.out.println();
							return result;
						}
						return null;
					case 4:
						//clausulas=new HashMap<String,String>();
						
						System.out.print("\t\tID: ");
						clausulas.put("SearchColumn", "Film_ID="+scan.nextLine());
						correct=true;
						if(Savechanges())
						{
							result=film.Delete(clausulas);
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
	 * @param films
	 */
	public void Capture(Object films)
	{
		ArrayList<Film> filmsList=(ArrayList<Film>)films;
		System.out.print("+");
		for(int i=0;i<408;i++)
		{
			System.out.print("-");
		}
		System.out.print("+");
		System.out.print(String.format("\n| %-10s | %-30s | %-120s | %-20s | %-15s | %-15s | %-15s | %-15s | %-30s | %-20s | %-20s | %-30s | %-30s |\n",
				"Film_ID","title","description","release_year",
				"language","origina_lan_ID","rental_duration",
				"rental_rate","length","replacement_cost",
				"rating","special_features","last_updat0e"));
		System.out.print("+");
		for(int i=0;i<408;i++)
		{
			System.out.print("-");
		}
		System.out.print("+");
		for(Film film:filmsList)
		{
			System.out.println(String.format("\n| %-10s | %-30s | %-120s | %-20s | %-15s | %-15s | %-15s | %-15s | %-30s | %-20s | %-20s | %-30s | %-30s |", 
					film.ID,film.title,film.description,
					film.release_year,film.lenguajeName,
					film.original_language_id,film.rental_duration,
					film.rental_rate,film.length,film.replacement_cost,
					film.rating,film.special_features,film.lastUpdate));
			System.out.print("+");
			for(int i=0;i<408;i++)
			{
				System.out.print("-");
			}
			System.out.print("+");
		}
		System.out.println("\n");
	}
}
