package com.sakila.models;
/**
 * EntiryModel.java
 * 
 * Representa la implementación de la interface IORMObject para Entiry
 * @author Juan Josó Jorge Rodríguez
 * @version 1.0
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class EntiryModel 
{
	private String objectName;
	private String PKColumn;
	private String SearchColumn;
	private String OrderColumn;
	private String FKColumn;
	private String DateColumn;
	
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/sakila?&serverTimezone=UTC";
	String user = "root";
	String password = "";
	
	ArrayList<Object> rows;
	/**
	 * Método que permite saber a la entidades sepa cual es la tabla que le corresponde en 
	 * la base de datos, la columna que contiene la clave primaria y las que poseen las clave foranes.
	 * 
	 * @param objectName
	 * @param PKColumn
	 * @param FKColumn
	 */
	public EntiryModel(String objectName,String PKColumn,String FKColumn) 
	{
		this.objectName=objectName;
		this.PKColumn=PKColumn;
		this.FKColumn=FKColumn;
		try 
		{
			 Class.forName(driver);
		}
		catch (ClassNotFoundException e) 
		{
			System.out.println("Driver no encontrado");
		}
	}
	/**
	 * Busca en la base de datos
	 * @param clausulas
	 * @return ResultSet de la base de datos
	 */
	protected ResultSet Find(HashMap<String,String> clausulas) 
	{ 
		String query="select {<campos>} from {<table>} {<join>} where {<filter>}";
		return PrepareStm(query,clausulas);
	}
	/**
	 * crea un registro nuevo
	 * @param clausulas
	 * @return boolean
	 */
	protected boolean Post(HashMap<String,String> clausulas)
	{
		String query="insert into {<table>}( {<campos>} ) value( {<values>} )";
		InitClass();
		return PrepInsertSQL(query,clausulas);
	}
	/**
	 * Crea un nuevo registro
	 * @param clausulas
	 * @return boolean
	 */
	protected boolean Put(HashMap<String,String> clausulas) 
	{
		String query="update {<table>} set {<campos=valor>} where {<filter>}";
		return PrepUpdateSQL(query,clausulas);
	}
	/**
	 * Elimina un registro
	 * @param clausulas
	 * @return boolean
	 */
	protected boolean Delete(HashMap<String,String> clausulas) 
	{
		String query="delete from {<table>} where {<filter>}";
		InitClass();
		return PrepDeleteSQL(query,clausulas);
	}
	
	private void InitClass() {}
	private ResultSet PrepareStm(String query,HashMap<String,String> clausulas)
	{
		this.SearchColumn=clausulas.get("SearchColumn");
		this.DateColumn=clausulas.get("DateColumn");
		String table_join=clausulas.get("TableJoin");
		String cr=clausulas.get("Condicion de Relacion");
		
		String[] tablejoin; 
		String values=clausulas.get("Values");
		String[] condiciones_de_relacion;
		
		if(table_join!=null && cr!=null)
		{
			tablejoin=table_join.split(" ");
			condiciones_de_relacion=cr.split(" ");
			
			String join="";
			int i=0;
			for(String table:tablejoin)
			{
				join+=" join "+table;
				join+=" on "+condiciones_de_relacion[i++];
			}
			query=query.replace("{<join>}",join);
				
		}	
		else
			query=query.replace("{<join>}", "");
		
		query=query.replace("{<campos>}", SearchColumn);
		query=query.replace("{<table>}",  objectName);
		query=query.replace("{<filter>}", values);

		try
		{
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			return rs;
		}
		catch (SQLException e) 
		{
			System.out.println(e);
		}
		return null;
	}
	private boolean PrepUpdateSQL(String query,HashMap<String,String> clausulas)  
	{
		this.SearchColumn=clausulas.get("SearchColumn");
		this.DateColumn=clausulas.get("DateColumn");
		query=query.replace("{<filter>}", SearchColumn);
		query=query.replace("{<table>}",  objectName);
		query=query.replace("{<campos=valor>}", clausulas.get("Values"));
		
		try
		{
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			if(st.execute(query))
				return true;
		}
		catch (SQLException e) 
		{
			System.out.println(e);
		}
		return false;
	}
	private boolean PrepInsertSQL(String query,HashMap<String,String> clausulas)  
	{
		this.SearchColumn=clausulas.get("SearchColumn");
		this.DateColumn=clausulas.get("DateColumn");
		query=query.replace("{<table>}", objectName);
		query=query.replace("{<campos>}", SearchColumn);
		
		try
		{
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			ResultSet result=st.executeQuery("select count(*) from "+objectName);
			result.next();
			query=query.replace("{<values>}", getMaxID()+1 +","+ clausulas.get("Values")+","+DateColumn);
			if(st.execute(query))
				return true;
		}
		catch (SQLException e) 
		{
			System.out.println(e);
		}
		return false;
	}
	private boolean PrepDeleteSQL(String query,HashMap<String,String> clausulas)  
	{
		this.SearchColumn=clausulas.get("SearchColumn");
		query=query.replace("{<table>}",  objectName);
		query=query.replace("{<filter>}", SearchColumn);
		
		try
		{
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			ResultSet rs=st.executeQuery("select * from "+objectName+" where "+SearchColumn);;

			if(st.execute(query))
				return true;
		}
		catch (SQLException e) 
		{
			System.out.println(e);
		}
		return false;
	}
	/**
	 * Retorna el mensaje de la exception
	 * @param e
	 * @return un string
	 */
	public String getMensaje(Exception e) {return null;}
	private int getMaxID()
	{
		try
		{
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			ResultSet rs=st.executeQuery("select "+PKColumn+" from "+objectName);;

			rs.next();
			int maxID=Integer.parseInt(rs.getString(1));
			int id;
			
			while(rs.next())
			{
				id=Integer.parseInt(rs.getString(1));
				if(id>maxID)
					maxID=id;
			}
			return maxID;
		}
		catch (SQLException e) 
		{
			System.out.println(e);
		}
		return 0;
	}

}
