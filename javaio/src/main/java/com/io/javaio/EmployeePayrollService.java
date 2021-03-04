package com.io.javaio;

import java.util.Scanner;

public class EmployeePayrollService {
	
	public static Employee employee() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the id of the employee");
		int employeeID = input.nextInt();
		System.out.println("Enter the name of the Employee");
		input.nextLine(); 
		String name = input.nextLine();
		System.out.println("Enter the salary of the employee");
		double salary = input.nextDouble();
		return new Employee(employeeID, name, salary);
	}
	public static void main(String[] args) {
		Employee employee = employee();
		System.out.println(employee);
	}
	
}
