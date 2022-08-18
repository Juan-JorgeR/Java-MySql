package oracletutor.mvc.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.sakila.data.Store;

import oracletutor.mvc.controller.StoreController;
/**
 * StoreView.java
 * Vista de la entidad Store
 * 
 * @author Juan José Jorge Rodríguez
 * @version 1.0
 *
 */
public class StoreView extends View 
{
	StoreController store=new StoreController();
	/**
	 * Despliega la CLI del Actor View
	 * @return un object
	 */
	public Object Show() 
	{
		System.out.println(String.format("\n%-45s\n"," ************ Store View ************"));
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
				clausulas.put("DateColumn","'"+fecha+"'");
				
				switch(opcion)
				{
					
					case 1:
						//clausulas=new HashMap<String,String>();
						clausulas.put("SearchColumn","Store_ID,manager_Staff_ID,address_ID,last_update");
						datos="";
						
						System.out.print("\n\tmanager_Staff_ID: ");
						datos+=scan.nextLine();
					
						System.out.print("\taddress_ID: ");
						datos+=","+scan.nextLine();
						
						correct=true;
						clausulas.put("Values", datos);
						if(Savechanges())
						{
							result=store.Post(clausulas);
							return result;
						}
						return null;
					case 2:
						//clausulas=new HashMap<String,String>();
						System.out.print("\n\tStore ID: ");

						clausulas.put("SearchColumn","store.Store_ID,manager_Staff_ID,staff.first_name,staff.last_name,store.address_ID,address,store.last_update");
						clausulas.put("Values", "store.Store_id='"+scan.nextLine()+"'");
						clausulas.put("TableJoin","address staff");
						clausulas.put("Condicion de Relacion", "address.address_ID=store.address_ID staff.staff_id=store.manager_staff_id");
						
						correct=true;
						if(Savechanges())
						{
							result=store.Get(clausulas);
							Capture(result);
						}
						return null;
					case 3:
						//clausulas=new HashMap<String,String>();
						datos="";
						System.out.println("\n\tSET\n");
						
						System.out.print("\t\tmanager_Staff_ID: ");
						datos+="manager_staff_id="+scan.nextLine();
						
						System.out.print("\t\taddress_ID: ");
						datos+=", address_id="+scan.nextLine();
						
						datos+=", last_update="+fecha;
						
						clausulas.put("Values", datos);
						System.out.println("\tWHERE\n");
						
						System.out.print("\t\tID: ");
						
						clausulas.put("SearchColumn", "Store_ID="+scan.nextLine());
						correct=true;
						if(Savechanges())
						{
							result=store.Put(clausulas);
							System.out.println();
							return result;
						}
						return null;
					case 4:
						//clausulas=new HashMap<String,String>();
						
						System.out.print("\t\tID: ");
						clausulas.put("SearchColumn", "Store_ID="+scan.nextLine());
						correct=true;
						if(Savechanges())
						{
							result=store.Delete(clausulas);
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
	 * @param stores
	 */
	public void Capture(Object stores)
	{
		ArrayList<Store> storeList=(ArrayList<Store>)stores;
		System.out.print("+");
		for(int i=0;i<106;i++)
		{
			System.out.print("-");
		}
		System.out.print("+");
		System.out.print(String.format("\n| %-5s | %-30s | %-30s | %-30s |\n","ID","Name","Address","Last_Update"));
		System.out.print("+");
		for(int i=0;i<106;i++)
		{
			System.out.print("-");
		}
		System.out.print("+");
		for(Store store:storeList)
		{
			System.out.println(String.format("\n| %-5s | %-30s | %-30s | %-30s |", store.ID,store.managerStaffName,store.addressName,store.lastUpdate));
			System.out.print("+");
			for(int i=0;i<106;i++)
			{
				System.out.print("-");
			}
			System.out.print("+");
		}
		System.out.println("\n");
	}
}
