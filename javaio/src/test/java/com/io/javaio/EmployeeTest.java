package com.io.javaio;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class EmployeeTest {
	/**
	 * Checks that the method returns an Employee Object
	 */
	@Test
	public void getEmployeeDetailsTest() {
		Employee employee1 = EmployeePayrollService.employee();
		assertNotNull("\nMethod does not return Employee OBject\n", employee1);
	}
}
