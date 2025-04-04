package com.java;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CallableTest {

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
				CallableStatement cst=con.prepareCall("{?=call get_name(?)}");
				Scanner scan=new Scanner(System.in);){
			
				System.out.println("Enter id ");
				int id=scan.nextInt();
				cst.registerOutParameter(1, Types.VARCHAR);
				cst.setInt(2, id);
				cst.execute();
				String result=cst.getString(1);
			
			
			System.out.println("  The Result is "+result);

	

		}catch(SQLException e) {
			System.out.println("Error "+e.getMessage());
		}
		/*CREATE DEFINER=`root`@`localhost` FUNCTION `sqrt`(arg int) RETURNS int
			    DETERMINISTIC
			BEGIN

			RETURN arg * arg;

			END
			
			CREATE DEFINER=`root`@`localhost` FUNCTION `get_name`(arg integer) RETURNS varchar(20) CHARSET utf8mb4
		    DETERMINISTIC
		BEGIN
		declare first_name varchar(50);
		select name into first_name from sample where id=arg;
		RETURN first_name;
		END */

	}
}
