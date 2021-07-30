package com.bridgelabz.PayrollService;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class Connection {

	public static void main(String[] args) {
		String URL = "jdbc:mysql://localhost:3306/payroll_service";
		String userName = "root";
		String password = "A$ha@9100";
		java.sql.Connection con;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded!");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Cannot find driver in classpath!", e);
		}
		listDrivers();
		try {
			System.out.println("Connecting to database: " + URL);
			con = DriverManager.getConnection(URL, userName, password);
			System.out.println("Connection successful!!" + con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void listDrivers() {
		Enumeration<Driver> driverList = DriverManager.getDrivers();
		while (driverList.hasMoreElements()) {
			Driver driverClass = (Driver) driverList.nextElement();
			System.out.println("   " + driverClass.getClass().getName());
		}
	}
	}
