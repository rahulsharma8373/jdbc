package com.jdbc;

import java.sql.*;
import java.util.Scanner;

public class StudentDatabase {
	private static Connection conn=null;
	private static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		
	StudentDatabase studentDatabase=new StudentDatabase();
	
	
		
		
		try {

			String url="jdbc:mysql://localhost:3306/jdbcdb";
			String username="root";
			String password="root";
			 conn=DriverManager.getConnection(url,username,password);
			 System.out.println("Enter choice");
			 System.out.println("1. Insert record");
			 int  choice=Integer.parseInt(scanner.nextLine());
			 
			 switch (choice) {
			case 1: {
				studentDatabase.insertRecord();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
			 
			 
			
		//	 System.out.println("database called successfully!");
			 
		} catch (Exception  e) {
			throw new RuntimeException("something went wrong");
		}
		
	}
	private void insertRecord()  throws SQLException{
	
		
		String sql="insert into student (name,percentage,address)values(?,?,?)";
		
		// prepared statement
		PreparedStatement ps=conn.prepareStatement(sql);
		System.out.println("Enter name");
		ps.setString(1, scanner.nextLine());
		System.out.println("Enter percentage");
		ps.setDouble(2,Double.parseDouble(scanner.nextLine()));
		System.out.println("Enter address");
		ps.setString(3,scanner.nextLine() );
	int rows=	ps.executeUpdate();
		if (rows>0) {
			System.out.println("Record inserted successfully");
		}
		
	}

}
