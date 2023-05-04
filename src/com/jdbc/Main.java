package com.jdbc;

import java.sql.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		String url="jdbc:mysql://localhost:3306/rahul";
		String username="root";
		String password="root";
		try {
			
			Connection conn=DriverManager.getConnection(url,username,password);
			CallableStatement cs=conn.prepareCall("{CALL GetAllStudents() }");
			ResultSet rs=cs.executeQuery();
		while (rs.next()) {
			int id=rs.getInt("id");
			String name=rs.getString("name");
			int age=rs.getInt("age");
			String email=rs.getString("email");
			System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Email: " + email);
			   
		}
			
		} catch (SQLException  e) {
			e.printStackTrace();
		}
	}

}
