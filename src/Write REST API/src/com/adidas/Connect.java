package com.adidas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	public Connection dbConnection;
	/*
	 * Creates connection to the MYSql database*/
	Connect(String driverClassName, String connectionURL, String userName, String passWord){
		connectionURL=connectionURL.concat("?useUnicode=true&useJDBCCompliantTimezoneShift"
				+ "=true&useLegacyDatetimeCode=false&serverTimezone=UTC");		
		try{  
			if(dbConnection==null){
				Class.forName(driverClassName);  
				dbConnection=DriverManager.getConnection(  
						connectionURL,userName,passWord);  
			}
		}
		catch(SQLException e){
			e.printStackTrace();
			System.exit(1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

