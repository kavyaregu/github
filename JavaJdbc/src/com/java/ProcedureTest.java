package com.java;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class ProcedureTest {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/java";
		String user="root";
		String pwd="Nikshith@2723";
		//String sql="insert into sample values(?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println("Error:"+e.getMessage());
		}
		try (
			Connection con=DriverManager.getConnection(url, user, pwd);
			//CallableStatement cst=con.prepareCall("{?=call sqrt(?)}");
				CallableStatement cst=con.prepareCall("{call Student(?,?,?,?,?,?,?,?)}");
				Scanner scan=new Scanner(System.in);){
			
				System.out.println("Enter sub1 ");
				int sub1=scan.nextInt();
				System.out.println("Enter sub2 ");
				int sub2=scan.nextInt();
				System.out.println("Enter sub3 ");
				int sub3=scan.nextInt();
				System.out.println("Enter sub4 ");
				int sub4=scan.nextInt();
				System.out.println("Enter sub5 ");
				int sub5=scan.nextInt();
				System.out.println("Enter sub6 ");
				int sub6=scan.nextInt();
				cst.registerOutParameter(7, Types.INTEGER);
				cst.registerOutParameter(8, Types.DECIMAL);
				cst.setInt(1, sub1);
				cst.setInt(2, sub2);
				cst.setInt(3, sub3);
				cst.setInt(4, sub4);
				cst.setInt(5, sub5);
				cst.setInt(6, sub6);
				cst.execute();
				int total=cst.getInt(7);
				double average=cst.getDouble(8);
			
			
			System.out.println("  The total is "+total+" average is "+average);

	

		}catch(SQLException e) {
			System.out.println("Error "+e.getMessage());
		}
		/*CREATE DEFINER=`root`@`localhost` PROCEDURE `Student`(IN sub1 integer,IN sub2 integer,
				IN sub3 integer,IN sub4 integer,IN sub5 integer,IN sub6 integer,
				OUT Total integer,OUT Average Double)
				BEGIN
				set Total=sub1+sub2+sub3+sub4+sub5+sub6;
				set average=total/6;

				END */

	}
}
