package oracletutor.mvc.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.sakila.data.Actor;

import oracletutor.mvc.controller.ActorController;
/**
 * ActorView.java
 * Vista de la entidad actor
 * 
 * @author Juan José Jorge Rodríguez
 * @version 1.0
 *
 */
public class ActorView extends View 
{
	ActorController actor=new ActorController();
	/**
	 * Despliega la CLI del Actor View
	 * @return un object
	 */
	public Object Show() 
	{
		System.out.println(String.format("\n%-45s\n"," ************ Actor View ************"));
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
				clausulas.put("objectName", "Actor");
				clausulas.put("PKColumn", "Actor_ID");
				clausulas.put("OrderColumn",null);
				clausulas.put("FKColumn",null);
				
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
						clausulas.put("SearchColumn","Actor_ID,first_Name,last_Name,last_update");
						datos="";
						
						System.out.print("\n\tfirstName: ");
						datos+="'"+scan.nextLine()+"'";
					
						System.out.print("\tlastName: ");
						datos+=","+scan.nextLine();
						correct=true;
						clausulas.put("Values", datos);
						if(Savechanges())
						{
							result=actor.Post(clausulas);
							return result;
						}
						return null;
					case 2:
						//clausulas=new HashMap<String,String>();
						System.out.print("\n\tLastName: ");

						clausulas.put("SearchColumn","Actor_ID,first_Name,last_Name,last_update");
						clausulas.put("Values", "last_name='"+scan.nextLine()+"'");
					
						correct=true;
						if(Savechanges())
						{
							result=actor.Get(clausulas);
							Capture(result);
						}
						return null;
					case 3:
						//clausulas=new HashMap<String,String>();
						datos="";
						System.out.println("\n\tSET\n");
						
						System.out.print("\t\tFirstName: ");
						datos+="first_Name='"+scan.nextLine()+"'";
						
						System.out.print("\t\tLastName: ");
						datos+=", last_Name="+scan.nextLine();
						
						datos+=", last_update="+fecha;
						clausulas.put("Values", datos);
						System.out.println("\tWHERE\n");
						
						System.out.print("\t\tID: ");
						
						clausulas.put("SearchColumn", "Actor_ID="+scan.nextLine());
						correct=true;
						if(Savechanges())
						{
							result=actor.Put(clausulas);
							System.out.println();
							return result;
						}
						return null;
					case 4:
						//clausulas=new HashMap<String,String>();
						
						System.out.print("\t\tID: ");
						clausulas.put("SearchColumn", "Actor_ID="+scan.nextLine());
						correct=true;
						if(Savechanges())
						{
							result=actor.Delete(clausulas);
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
	 * @param actores
	 */
	public void Capture(Object actores)
	{
		ArrayList<Actor> actorList=(ArrayList<Actor>)actores;
		System.out.print("+");
		for(int i=0;i<91;i++)
		{
			System.out.print("-");
		}
		System.out.print("+");
		System.out.print(String.format("\n| %-5s | %-30s | %-15s | %-30s |\n","ID","FirstName","LastName","Last_Update"));
		System.out.print("+");
		for(int i=0;i<91;i++)
		{
			System.out.print("-");
		}
		System.out.print("+");
		for(Actor actor:actorList)
		{
			System.out.println(String.format("\n| %-5d | %-30s | %-15s | %-30s |", actor.ID,actor.firstName,actor.lastName,actor.lastUpdate));
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
