package oracletutor.mvc.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.sakila.data.Address;

import oracletutor.mvc.controller.AddressController;
/**
 * AddressView.java
 * Vista de la entidad address
 * 
 * @author Juan José Jorge Rodríguez
 * @version 1.0
 *
 */
public class AddressView extends View 
{
	AddressController address=new AddressController();
	/**
	 * Despliega la CLI del Actor View
	 * @return un object
	 */
	public Object Show() 
	{
		System.out.println(String.format("\n%-45s\n"," ************ Address View ************"));
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
				clausulas.put("objectName", "Address");
				clausulas.put("PKColumn", "Address_ID");
				clausulas.put("OrderColumn",null);
				clausulas.put("FKCOlumn","City_ID");
				
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
						clausulas.put("SearchColumn","Address_ID,Address,Address2,District,City,Postal_Code,Phone,address.last_update");
						datos="";
						
						System.out.print("\n\tAddress: ");
						datos+="'"+scan.nextLine()+"'";
					
						System.out.print("\tAddress2: ");
						datos+=",'"+scan.nextLine()+"'";
						
						System.out.print("\tDistrict: ");
						datos+=",'"+scan.nextLine()+"'";
						
						System.out.print("\tCity_ID: ");
						datos+=","+scan.nextLine();
						
						System.out.print("\tPostal Code: ");
						datos+=","+scan.nextLine();
						
						System.out.print("\tPhone: ");
						datos+=",'"+scan.nextLine()+"'";
						
						correct=true;
						clausulas.put("Values", datos);
						if(Savechanges())
						{
							result=address.Post(clausulas);
							return result;
						}
						return null;
					case 2:
						//clausulas=new HashMap<String,String>();
						System.out.print("\n\tAddress: ");

						clausulas.put("SearchColumn","Address_ID,Address,Address2,District,address.City_ID,City,Postal_Code,Phone,address.last_update");
						clausulas.put("Values", "Address='"+scan.nextLine()+"'");
						clausulas.put("TableJoin","City");
						clausulas.put("Condicion de Relacion", "City.City_ID=Address.City_ID");
						
						correct=true;
						if(Savechanges())
						{
							result=address.Get(clausulas);
							Capture(result);
						}
						return null;
					case 3:
						//clausulas=new HashMap<String,String>();
						datos="";
						System.out.println("\n\tSET\n");
						
						System.out.print("\t\tAddress: ");
						datos+="address='"+scan.nextLine()+"'";
						
						System.out.print("\t\tAddress2: ");
						datos+=", address2='"+scan.nextLine()+"'";
						
						System.out.print("\t\tDistrict: ");
						datos+=", district='"+scan.nextLine()+"'";
						
						System.out.print("\t\tCityID: ");
						datos+=", city_id="+scan.nextLine();
						
						System.out.print("\t\tPostal Code: ");
						datos+=", postal_Code="+scan.nextLine();
						
						System.out.print("\t\tPhone: ");
						datos+=", phone='"+scan.nextLine()+"'";
						
						datos+=", last_update="+fecha;
						
						clausulas.put("Values", datos);
						System.out.println("\tWHERE\n");
						
						System.out.print("\t\tID: ");
						
						clausulas.put("SearchColumn", "Address_ID="+scan.nextLine());
						correct=true;
						if(Savechanges())
						{
							result=address.Put(clausulas);
							System.out.println();
							return result;
						}
						return null;
					case 4:
						//clausulas=new HashMap<String,String>();
						
						System.out.print("\t\tID: ");
						clausulas.put("SearchColumn", "Address_ID="+scan.nextLine());
						correct=true;
						if(Savechanges())
						{
							result=address.Delete(clausulas);
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
	 * @param addresses
	 */
	public void Capture(Object addresses)
	{
		ArrayList<Address> addressList=(ArrayList<Address>)addresses;
		System.out.print("+");
		for(int i=0;i<186;i++)
		{
			System.out.print("-");
		}
		System.out.print("+");
		System.out.print(String.format("\n| %-5s | %-30s | %-30s | %-30s | %-10s | %-15s | %-15s | %-30s |\n",
				"ID","Address","Address2","District","City_ID","Postal_Code","Phone","Last_Update"));
		System.out.print("+");
		for(int i=0;i<186;i++)
		{
			System.out.print("-");
		}
		System.out.print("+");
		for(Address address:addressList)
		{
			System.out.println(String.format("\n| %-5s | %-30s | %-30s | %-30s | %-10s | %-15s | %-15s | %-30s |", 
					address.ID,address.address,address.address2,address.district,address.cityID,address.postalCode,address.phone,address.lastUpdate));
			System.out.print("+");
			for(int i=0;i<186;i++)
			{
				System.out.print("-");
			}
			System.out.print("+");
		}
		System.out.println("\n");
	}
}
