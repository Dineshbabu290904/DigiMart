package com.digimart.project;

import java.sql.*;

public class ConnectionProvider {
	public static Connection getCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12740378","sql12740378","IbihDtcLDb");
			return con;
		} catch(Exception e) {
			System.out.print(e);
			return null;
		}
	}
}
