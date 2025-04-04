package com.java;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ProcedureTestUsingTable {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/java";
		String user="root";
		String pwd="Nikshith@2723";
		try {Class.forName("com.mysql.cj.jdbc.Driver");
		
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try (Connection conn=DriverManager.getConnection(url,user,pwd);
		CallableStatement cst=conn.prepareCall("{call get_sum_avg(?,?,?)}");
		Scanner scan=new Scanner(System.in);){
			System.out.println("Enter Id");
			int id=scan.nextInt();
			cst.setInt(1,id);
			cst.execute();
			int total=cst.getInt(2);
			double average=cst.getDouble(3);
			System.out.println("total is"+total+" Average is "+average);
			
			
		}
		catch(SQLException e) {
			System.out.println("Error "+e.getMessage());
		}
		}

	/*CREATE DEFINER=`root`@`localhost` PROCEDURE `get_sum_avg`(stud_id int,OUT total integer,OUT avg decimal)
			BEGIN
			select sub1+sub2+sub3+sub4+sub5 into total from student where id=stud_id;
			set avg=total/5;
			END*/

}
