package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "Nikshith@2723");
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from sample");
		while(rs.next()) {
			int id=rs.getInt("id");
			String name=rs.getString("name");
			System.out.println(id+"\t"+name+"\t");
		}
		System.out.println("execution is completed");

	}
		// TODO Auto-generated method stub

	}


