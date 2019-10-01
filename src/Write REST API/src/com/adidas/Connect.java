package com.adidas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	public Connection dbConnection;
	/*
	 * Creates connection to the MYsql database*/
	Connect(String driverClassName, String connectionURL, String userName, String passWord){
		try{  
			if(dbConnection==null){
				Class.forName(driverClassName);  
				dbConnection=DriverManager.getConnection(  
						connectionURL,userName,passWord);  
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

