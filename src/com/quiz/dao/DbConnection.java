package com.quiz.dao;

//package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;



public class DbConnection {
	static Connection con;

	//to create object of class which implements Connection interface
	public static Connection createC() {
		try {

// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

// create the connection...

			String user = "root";

			String password = "root";

			String url = "jdbc:mysql://localhost:3306/quiz";

//DriverManager is a class and getConnection method returns object of class that implements Connection interface
			con = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return con; 
	}

}