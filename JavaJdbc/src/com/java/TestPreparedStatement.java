package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestPreparedStatement {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/java";
		String user="root";
		String pwd="Nikshith@2723";
		String sql="insert into sample values(?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println("Error:"+e.getMessage());
		}
		try (
			Connection con=DriverManager.getConnection(url, user, pwd);
			PreparedStatement pst=con.prepareStatement(sql);
				Scanner scan=new Scanner(System.in);){
			for(int i=101;i<=105;i++) {
				System.out.println("Enter Id ");
				int id=scan.nextInt();
				pst.setInt(1, id);
				System.out.println("Enter name ");
				String name=scan.next();
				pst.setString(2, name);
				pst.addBatch();
			}
			int[] status=pst.executeBatch();
			System.out.println(status.length+" inserted successfully");

	

		}catch(SQLException e) {
			System.out.println("Error "+e.getMessage());
		}

	}

}
