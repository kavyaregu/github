package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertionTest {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc1.Driver");
		}catch(ClassNotFoundException ex) {
			System.out.println("Error: "+ex.getMessage());
		}
		try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "Nikshith@2723"); 
				Statement stmt=con.createStatement();){
			stmt.executeUpdate("insert into sample values(5,'berg')");
			System.out.println("execution is completed");
			//System.out.println("SQL is :"+sql);
			
		}catch(SQLException ex) {
			System.out.println("Error: "+ex.getMessage());
		}
				
				

	}

}
