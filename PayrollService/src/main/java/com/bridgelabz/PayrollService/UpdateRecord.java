package com.bridgelabz.PayrollService;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

	public class UpdateRecord
	{
		static Scanner sc = new Scanner(System.in);
	    public static void main( String[] args ) throws SQLException, ClassNotFoundException 
	    {
	    	updateQuery();
	    	checkResult();
	    }
	    
	    public static void updateQuery() throws SQLException, ClassNotFoundException
	    {
	    	String url = "jdbc:mysql://localhost:3306/payroll_service";
	    	String name = "root";
	    	String pass = "";
	    	String query = "update employee_payroll set name=?,salary=? where id=?";
	    	
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	java.sql.Connection con = DriverManager.getConnection(url,name,pass);
	    	PreparedStatement ps = con.prepareStatement(query);
	    	
	    	ps.setString(1, "Gold D Rogger");
	    	ps.setDouble(2, 3000000);
	    	ps.setInt(3, 7);
	    	
	    	int result = ps.executeUpdate();
	    	System.out.println("Number of affected rows:" + result);
	    	
	    	ps.close();
	    	con.close();
	    }
	    
	    public static void checkResult() throws ClassNotFoundException, SQLException
	    {
	    	String url = "jdbc:mysql://localhost:3306/payroll_service";
	    	String name = "root";
	    	String pass = "A$ha@9100";
	    	String query = "select *from employee_payroll;";
	    	
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	java.sql.Connection con = DriverManager.getConnection(url,name,pass);
	    	java.sql.Statement st = con.createStatement();
	    	ResultSet rs = st.executeQuery(query);
	    	
	    	rs.next();
	    	
	    	int emp_id = rs.getInt(1);
	    	String emp_name = rs.getString(2);
	    	String emp_gender = rs.getString(3);
	    	double emp_salary = rs.getDouble(4);
	    	String emp_date = rs.getString(5);
	    	
	    	System.out.println();
	    	System.out.println(emp_id);
	    	System.out.println(emp_name);
	    	System.out.println(emp_gender);
	    	System.out.println(emp_salary);
	    	System.out.println(emp_date);
	    	
	    	rs.close();
	    	con.close();
	    }
	}
