package oracletutor.mvc.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.sakila.data.Customer;

import oracletutor.mvc.controller.CustomerController;
/**
 * CustomerView.java
 * Vista de la entidad Customer
 * @author Juan José Jorge Rodríguez
 * @version 1.0
 *
 */
public class CustomerView extends View 
{
	CustomerController customer=new CustomerController();
	/**
	 * Despliega la CLI del Actor View
	 * @return un object
	 */
	public Object Show() 
	{
		System.out.println(String.format("\n%-45s\n"," ************ Customer View ************"));
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
				clausulas.put("objectName", "Customer");
				clausulas.put("PKColumn", "Customer_ID");
				clausulas.put("OrderColumn",null);
				clausulas.put("FKCOlumn","Address_ID Store_ID");
				
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
						clausulas.put("SearchColumn","Customer_ID,Store_ID,first_Name,last_Name,email,customer.address_ID,active,create_Date,customer.last_update");
						datos="";
						
						System.out.print("\n\tStoreId: ");
						datos+=", "+scan.nextLine();
						
						System.out.print("\n\tfirstName: ");
						datos+="'"+scan.nextLine()+"'";
						
						System.out.print("\n\tlastName: ");
						datos+=", '"+scan.nextLine()+"'";
											
						System.out.print("\n\temail: ");
						datos+=", '"+scan.nextLine()+"'";
						
						System.out.print("\n\taddressID: ");
						datos+=", "+scan.nextLine();
						
						System.out.print("\n\tactive: ");
						datos+=", '"+scan.nextLine()+"'";
						
						datos+=", "+fecha;
						
						correct=true;
						clausulas.put("Values", datos);
						if(Savechanges())
						{
							result=customer.Post(clausulas);
							return result;
						}
						return null;
					case 2:
						//clausulas=new HashMap<String,String>();
						System.out.print("\n\tLastName: ");

						clausulas.put("SearchColumn","Customer_ID,Store_ID,first_Name,last_Name,email,customer.address_ID,address,active,create_Date,customer.last_update");
						clausulas.put("Values", "last_Name='"+scan.nextLine()+"'");
						clausulas.put("TableJoin","Address");
						clausulas.put("Condicion de Relacion", "Address.Address_ID=Customer.Address_ID");

						correct=true;
						if(Savechanges())
						{
							result=customer.Get(clausulas);
							Capture(result);
						}
						return null;
					case 3:
						//clausulas=new HashMap<String,String>();
						datos="";
						System.out.println("\n\tSET\n");
						
						System.out.print("\n\tStoreId: ");
						datos+=", store_id="+scan.nextLine();
						
						System.out.print("\t\tFirtsName: ");
						datos+="first_name='"+scan.nextLine()+"'";					
						
						System.out.print("\t\tLastName: ");
						datos+="last_name='"+scan.nextLine()+"'";
						
						System.out.print("\t\temail: ");
						datos+="email='"+scan.nextLine()+"'";
						
						System.out.print("\t\tAddressID: ");
						datos+="address_id="+scan.nextLine();
						
						System.out.print("\t\tActive: ");
						datos+="active='"+scan.nextLine()+"'";
						
						datos+=", last_update="+fecha;
						
						clausulas.put("Values", datos);
						System.out.println("\tWHERE\n");
						
						System.out.print("\t\tID: ");
						
						clausulas.put("SearchColumn", "Customer_ID="+scan.nextLine());
						correct=true;
						if(Savechanges())
						{
							result=customer.Put(clausulas);
							System.out.println();
							return result;
						}
						return null;
					case 4:
						//clausulas=new HashMap<String,String>();
						
						System.out.print("\t\tID: ");
						clausulas.put("SearchColumn", "Customer_ID="+scan.nextLine());
						correct=true;
						if(Savechanges())
						{
							result=customer.Delete(clausulas);
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
	 * @param customeres
	 */
	public void Capture(Object customeres)
	{
		ArrayList<Customer> customerList=(ArrayList<Customer>)customeres;
		System.out.print("+");
		for(int i=0;i<236;i++)
		{
			System.out.print("-");
		}
		System.out.print("+");
		System.out.print(String.format("\n| %-5s | %-30s | %-15s | %-30s | %-30s | %-30s | %-10s | %-30s | %-30s |\n","ID","Store_ID","firstName","lastName","email","addressID","active","createData","Last_Update"));
		System.out.print("+");
		for(int i=0;i<236;i++)
		{
			System.out.print("-");
		}
		System.out.print("+");
		for(Customer customer:customerList)
		{
			System.out.println(String.format("\n| %-5s | %-30s | %-15s | %-30s | %-30s | %-30s | %-10s | %-30s | %-30s |", customer.ID,customer.storeID,customer.firtsName,customer.lastName,customer.email,customer.addressID,customer.active,customer.createDate,customer.lastUpdate));
			System.out.print("+");
			for(int i=0;i<236;i++)
			{
				System.out.print("-");
			}
			System.out.print("+");
		}
		System.out.println("\n");
	}
}
