package oracletutor.mvc.view;

import oracletutor.mvc.view.View;
/**
 * MenuControl.java
 * 
 * Menu de inicio del programa
 * 
 * @author Juan José Jorge Rodríguez
 * @version 1.0
 *
 */
public class MenuControl 
{
	View view;
	CountryView countryView;
	CityView cityView;
	ActorView actorView;
	AddressView addressView;
	CategoryView categoryView;
	CustomerView customerView;
	FilmView filmView;
	RentalView rentalView;
	StaffView staffView;
	StoreView storeView;
	/**
	 * Constructor
	 */
	public MenuControl() 
	{
		view=new View();
		countryView=new CountryView();
		cityView=new CityView();
		actorView=new ActorView();
		addressView=new AddressView();
		categoryView=new CategoryView();
		customerView=new CustomerView();
		filmView=new FilmView();
		rentalView=new RentalView();
		staffView=new StaffView();
		storeView=new StoreView();
	}
	/**
	 * Despliega la CLI del menu
	 */
	public void Show() 
	{
		System.out.println(String.format("\n%-45s\n"," ************ Menu Control ************"));
		System.out.println("\t1 - City View");
		System.out.println("\t2 - Country View");
		System.out.println("\t3 - Actor View");
		System.out.println("\t4 - Address View");
		System.out.println("\t5 - Category View");
		System.out.println("\t6 - Customer View");
		System.out.println("\t7 - Film View");
		System.out.println("\t8 - Rental View");
		System.out.println("\t9 - Staff View");
		System.out.println("\t10 - Store View");
		EvaluarOpcion();
	}
	/**
	 * Captura y evalua las opciones introducidas
	 */
	public void EvaluarOpcion() 
	{
		System.out.print("\n into opcion: ");
		
		try
		{
			int opcion=view.GetOption();
			switch(opcion)
			{
				case 1:
					cityView.Show();
					break;
				case 2:
					countryView.Show();
					break;
				case 3:
					actorView.Show();
					break;
				case 4:
					addressView.Show();
					break;
				case 5:
					categoryView.Show();
					break;
				case 6:
					customerView.Show();
					break;
				case 7:
					filmView.Show();
					break;
				case 8:
					rentalView.Show();
					break;
				case 9:
					staffView.Show();
					break;
				case 10:
					storeView.Show();
					break;
				default:
					System.out.println("opcion invalida");
			}
		}
		catch(Exception e)
		{
			System.out.println("opcion invalida");
			e.printStackTrace();
			EvaluarOpcion();
		}
	}
}
