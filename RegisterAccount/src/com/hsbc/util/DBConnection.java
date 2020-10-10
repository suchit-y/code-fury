package com.hsbc.util;


	 
	import java.sql.Connection;
	import java.sql.DriverManager;
	 
	public class DBConnection {
	 public static Connection createConnection()
	 {
	     Connection con = null;
	     String url = "jdbc:derby://localhost:1527/bankdata"; 
	     //String username = "root"; //MySQL username
	     //String password = "root123"; //MySQL password
	     
	      
	     try
	     {
	         try
	         {
	            Class.forName("org.apache.derby.jdbc.ClientDriver"); 
	         } 
	         catch (ClassNotFoundException e)
	         {
	            e.printStackTrace();
	         }       
	         con = DriverManager.getConnection(url); //attempting to connect to database
	         System.out.println("Printing connection object "+con);
	     } 
	     catch (Exception e) 
	     {
	        e.printStackTrace();
	     }   
	     return con; 
	 }
	}


