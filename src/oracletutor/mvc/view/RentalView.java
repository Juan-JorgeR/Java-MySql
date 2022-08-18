package oracletutor.mvc.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.sakila.data.Rental;

import oracletutor.mvc.controller.RentalController;
/**
 * RentalView.java
 * Vista de la entidad Rental
 * 
 * @author Juan José Jorge Rodríguez
 * @version 1.0
 *
 */
public class RentalView extends View 
{
	RentalController rental=new RentalController();
	/**
	 * Despliega la CLI del Actor View
	 * @return un object
	 */
	public Object Show() 
	{
		System.out.println(String.format("\n%-45s\n"," ************ Rental View ************"));
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
				clausulas.put("objectName", "Rental");
				clausulas.put("PKColumn", "Rental_ID");
				clausulas.put("OrderColumn",null);
				clausulas.put("FKCOlumn","inventory_ID customer_ID staff_ID");
				
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
						clausulas.put("SearchColumn","Rantal_ID,Rental_Date,Inventory_ID,Customer_ID,Staff_ID,Return_Date,last_update");
						datos="";
						
						datos+=fecha;
						System.out.print("\n\tInventory_ID: ");
						datos+=", "+scan.nextLine();
						
						System.out.print("\n\tCustomer_ID: ");
						datos+=", "+scan.nextLine();
						
						System.out.print("\n\tStaff_ID: ");
						datos+=", "+scan.nextLine();
						
						System.out.print("\n\tReturn_Date: ");
						datos+=", '"+scan.nextLine()+"'";
						
						correct=true;
						clausulas.put("Values", datos);
						if(Savechanges())
						{
							result=rental.Post(clausulas);
							return result;
						}
						return null;
					case 2:
						//clausulas=new HashMap<String,String>();
						System.out.print("\n\tRental Date: ");

						clausulas.put("SearchColumn","Rental_ID,Rental_Date,Inventory_ID,Customer_ID,rental.staff_id,first_name,last_name,Return_Date,rental.last_update");
						clausulas.put("Values", "Rental_Date='"+scan.nextLine()+"'");
						clausulas.put("TableJoin","Staff");
						clausulas.put("Condicion de Relacion", "Staff.Staff_ID=rental.staff_ID");
						
						correct=true;
						if(Savechanges())
						{
							result=rental.Get(clausulas);
							Capture(result);
						}
						return null;
					case 3:
						//clausulas=new HashMap<String,String>();
						datos="";
						System.out.println("\n\tSET\n");
						
						System.out.print("\t\tRental_Date: ");
						datos+="rental_date='"+scan.nextLine()+"'";					
						
						System.out.print("\t\tInventory_ID: ");
						datos+=",inventory_id="+scan.nextLine();	
						
						System.out.print("\t\tCustomer_ID: ");
						datos+=",customer_id="+scan.nextLine();
						
						System.out.print("\t\tStaff_ID: ");
						datos+=",staff_id="+scan.nextLine();	
						
						System.out.print("\t\tReturn_Date: ");
						datos+=",return_date='"+scan.nextLine()+"'";	
						
						datos+=", last_update="+fecha;
						
						clausulas.put("Values", datos);
						System.out.println("\tWHERE\n");
						
						System.out.print("\t\tID: ");
						
						clausulas.put("SearchColumn", "Rental_ID="+scan.nextLine());
						correct=true;
						if(Savechanges())
						{
							result=rental.Put(clausulas);
							System.out.println();
							return result;
						}
						return null;
					case 4:
						//clausulas=new HashMap<String,String>();
						
						System.out.print("\t\tID: ");
						clausulas.put("SearchColumn", "Rental_ID="+scan.nextLine());
						correct=true;
						if(Savechanges())
						{
							result=rental.Delete(clausulas);
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
	 * @param rentas
	 */
	public void Capture(Object rentas)
	{
		ArrayList<Rental> rentalList=(ArrayList<Rental>)rentas;
		System.out.print("+");
		for(int i=0;i<185;i++)
		{
			System.out.print("-");
		}
		System.out.print("+");
		System.out.print(String.format("\n| %-5s | %-30s | %-20s | %-30s | %-20s | %-30s | %-30s |\n","ID","Rental_Date","Inventory_ID","Customer_ID","Name","Return_Date","Last_Update"));
		System.out.print("+");
		for(int i=0;i<185;i++)
		{
			System.out.print("-");
		}
		System.out.print("+");
		for(Rental rental:rentalList)
		{
			System.out.println(String.format("\n| %-5s | %-30s | %-20s | %-30s | %-20s | %-30s | %-30s |", 
					rental.ID,rental.rentalDate,rental.inventoryID,
					rental.customerID,rental.staffName,rental.returnDate,rental.lastUpdate));
			System.out.print("+");
			for(int i=0;i<185;i++)
			{
				System.out.print("-");
			}
			System.out.print("+");
		}
		System.out.println("\n");
	}
}
