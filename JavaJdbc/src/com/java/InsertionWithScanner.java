package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertionWithScanner {

	public static void main(String[] args) {
		try { Class.forName("com.mysql.cj.jdbc.Driver");}
		catch(ClassNotFoundException ex) {
			System.out.println("Error: "+ex.getMessage());
		}
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "Nikshith@2723");
			Scanner scan=new Scanner(System.in);
			Statement stmt=con.createStatement();
		
		for(int i=1;i<=3;i++) {
			System.out.println("Enter Id ");
			int id=scan.nextInt();
			System.out.println("Enter name ");
			String name=scan.next();
			String sql="insert into sample values("+id+",'"+name+"')";
			stmt.executeUpdate(sql);
			stmt.executeUpdate("Delete from sample where id=4");
			System.out.println(sql);
		}
		
		System.out.println("Insertion is completed");}
		
		catch(SQLException ex) {
			System.out.println("Error :"+ex.getMessage());
		}
		

	}

}
