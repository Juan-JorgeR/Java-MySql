package oracletutor.mvc.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.sakila.data.Staff;

import oracletutor.mvc.controller.StaffController;
/**
 * StaffView.java
 * Vista de la entidad Staff
 * 
 * @author Juan José Jorge Rodríguez
 * @version 1.0
 *
 */
public class StaffView extends View
{
	StaffController staff=new StaffController();
	/**
	 * Despliega la CLI del Actor View
	 * @return un object
	 */
	public Object Show() 
	{
		System.out.println(String.format("\n%-45s\n"," ************ Staff View ************"));
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
				clausulas.put("objectName", "Staff");
				clausulas.put("PKColumn", "Staff_ID");
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
				clausulas.put("DateColumn","'"+fecha+"'");
				
				switch(opcion)
				{
					
					case 1:
						//clausulas=new HashMap<String,String>();
						clausulas.put("SearchColumn","Staff_ID,firtsName,LastName,Address_ID,email,store_ID,active,username,password,last_update");
						datos="";
						
						System.out.print("\n\tfirtsName: ");
						datos+="'"+scan.nextLine()+"'";
						
						System.out.print("\n\tlastName: ");
						datos+=", '"+scan.nextLine()+"'";
						
						System.out.print("\n\tAddress_ID: ");
						datos+=", "+scan.nextLine();
						
						System.out.print("\n\temail: ");
						datos+=", '"+scan.nextLine()+"'";
						
						System.out.print("\n\tstore_ID: ");
						datos+=", "+scan.nextLine();
						
						System.out.print("\n\tactive: ");
						datos+=", '"+scan.nextLine()+"'";
						
						System.out.print("\n\tusername: ");
						datos+=", '"+scan.nextLine()+"'";
						
						System.out.print("\n\tpassword: ");
						datos+=", '"+scan.nextLine()+"'";
						
						correct=true;
						clausulas.put("Values", datos);
						if(Savechanges())
						{
							result=staff.Post(clausulas);
							return result;
						}
						return null;
					case 2:
						//clausulas=new HashMap<String,String>();
						System.out.print("\n\tLast Name: ");

						clausulas.put("SearchColumn","Staff_ID,first_Name,Last_Name,staff.Address_ID,address,picture,email,store_ID,active,username,password,staff.last_update");
						clausulas.put("Values", "last_Name='"+scan.nextLine()+"'");
						clausulas.put("TableJoin","address");
						clausulas.put("Condicion de Relacion", "address.address_ID=staff.address_ID");
						
						correct=true;
						if(Savechanges())
						{
							result=staff.Get(clausulas);
							Capture(result);
						}
						return null;
					case 3:
						//clausulas=new HashMap<String,String>();
						datos="";
						System.out.println("\n\tSET\n");
						
						System.out.print("\t\tfirstName: ");
						datos+="first_Name='"+scan.nextLine()+"'";					
						
						System.out.print("\t\tlastName: ");
						datos+=",last_Name='"+scan.nextLine()+"'";	
						
						System.out.print("\t\tAddress_ID: ");
						datos+=",address_id="+scan.nextLine();
						
						System.out.print("\t\tStaff_ID: ");
						datos+=",staff_id="+scan.nextLine();		
						
						System.out.print("\t\tEmail: ");
						datos+=",email='"+scan.nextLine()+"'";
						
						System.out.print("\t\tStore_ID: ");
						datos+=",store_ID="+scan.nextLine();
						
						System.out.print("\t\tActive: ");
						datos+=",active="+scan.nextLine();
						
						System.out.print("\t\tUserName: ");
						datos+=",username='"+scan.nextLine()+"'";
						
						System.out.print("\t\tPassword: ");
						datos+=",password='"+scan.nextLine()+"'";

						datos+=", last_update="+fecha;

						clausulas.put("Values", datos);
						System.out.println("\tWHERE\n");
						
						System.out.print("\t\tID: ");
						
						clausulas.put("SearchColumn", "Staff_ID="+scan.nextLine());
						correct=true;
						if(Savechanges())
						{
							result=staff.Put(clausulas);
							System.out.println();
							return result;
						}
						return null;
					case 4:
						//clausulas=new HashMap<String,String>();
						
						System.out.print("\t\tID: ");
						clausulas.put("SearchColumn", "Staff_ID="+scan.nextLine());
						correct=true;
						if(Savechanges())
						{
							result=staff.Delete(clausulas);
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
	 * @param staff
	 */
	public void Capture(Object staff)
	{
		ArrayList<Staff> staffList=(ArrayList<Staff>)staff;
		System.out.print("+");
		for(int i=0;i<318;i++)
		{
			System.out.print("-");
		}
		System.out.print("+");
		System.out.print(String.format("\n| %-5s | %-30s | %-30s | %-50s | %-50s | %-15s| %-10s | %-30s | %-40s | %-30s |\n",
				"ID","firtsName","LastName",
				"Address","email","store_ID",
				"active","username","password","last_update"));
		System.out.print("+");
		for(int i=0;i<318;i++)
		{
			System.out.print("-");
		}
		System.out.print("+");
		for(Staff stf:staffList)
		{
			System.out.println(String.format("\n| %-5s | %-30s | %-30s | %-50s | %-50s | %-15s| %-10s | %-30s | %-40s | %-30s |", 
					stf.ID,stf.firtsName,stf.lastName,
					stf.addressName,stf.email,
					stf.storeID,stf.active,stf.username,
					stf.password,stf.lastUpdate));
			System.out.print("+");
			for(int i=0;i<318;i++)
			{
				System.out.print("-");
			}
			System.out.print("+");
		}
		System.out.println("\n");
	}
}
