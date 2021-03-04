package com.io.javaio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class EmployeePayrollService {

	/**
	 * @return returns the Employee Object after getting input from console
	 */
	public static Employee getEmployee() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the id of the employee");
		int employeeID = input.nextInt();
		System.out.println("Enter the name of the Employee");
		input.nextLine(); // reads the next line character
		String name = input.nextLine();
		System.out.println("Enter the salary of the employee");
		double salary = input.nextDouble();
		return new Employee(employeeID, name, salary);
	}

	public static void main(String[] args) throws Exception {
	
		Path path = Paths.get("E:/");
		if (Files.exists(path))
			System.out.println("The "+path+" file exists");
		else
			System.out.println("The  "+path+" file is not found");
}
}