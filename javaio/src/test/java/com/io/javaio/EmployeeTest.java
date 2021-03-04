package com.io.javaio;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class EmployeeTest {
	Path path;


	@Test
	public void getEmployeeDetailsTest() {
		Employee employee1 = EmployeePayrollService.getEmployee();
		assertNotNull("\nMethod does not return Employee OBject\n", employee1);
	}

	
	 // Test for checking successful file creation
	 
	@Test
	public void fileExistsTest_Correct() {
		path = Paths.get("C:/Users");
		assertTrue(Files.exists(path));
	}

	
	//  Fails as directory not present
	 
	@Test
	public void fileExistsTest_InCorrect() {
		path = Paths.get("C:/Users/desktop");
		assertFalse(Files.exists(path));
	}

	
	//  Deletes the file
	 
	@Test
	public void fileDeletionTest_Correct() {
		assertTrue(FileOperations.createDirectory("C:", "C:/temp"));
		assertTrue(FileOperations.createFile("C:/temp", "C:/temp/temp.txt"));
		assertTrue(FileOperations.deleteFile("C:/temp", "C:/temp/temp.txt"));
	}

	
	//  cannot delete the file as the directory specified not present
	
	@Test
	public void fileDeletionTest_InCorrect() {
		assertFalse(FileOperations.deleteFile("C:/temp", "C:/temp/temp.txt"));
	}

	
	//  creates the file
	 
	@Test
	public void fileCreationTest_Correct() {
		assertTrue(FileOperations.createDirectory("C:", "C:/temp"));
		assertTrue(FileOperations.createFile("C:/temp", "C:/temp/temp.txt"));
	}

	
	 //unable to create file because directory not present
	 
	@Test
	public void fileCreationTest_InCorrect() {
		assertFalse(FileOperations.createFile("C:/temp", "C:/temp/temp.txt"));
	}


	 // Successful directory creation
	 
	@Test
	public void directoryCreationTest_Correct() {
		assertTrue(FileOperations.createDirectory("C:", "C:/temp"));
	}

	
	//  unsuccessful directory creation as parent directory not found
	 
	@Test
	public void directoryCreationTest_InCorrect() {
		assertFalse(FileOperations.createFile("F:", "F:/temp"));
	}

	
	//  Lists the files of a particular directory
	 
	@Test
	public void listFilesTest_Correct() {
		assertTrue(FileOperations.listDirectoryContents());
	}

	@After
	public void remove() {
		path = Paths.get("C:/temp");
		if (Files.exists(path)) {
			path = Paths.get("C:/temp/temp.txt");
			if (Files.exists(path)) {
				try {
					Files.delete(path);
				} catch (IOException e) {
					System.out.println("The file does not exist");
					e.printStackTrace();
				}
			}
			path = Paths.get("C:/temp ");
			try {
				Files.delete(path);
			} catch (IOException e) {
				System.out.println("The directory does not exist");
				e.printStackTrace();
			}
		}
	}
}