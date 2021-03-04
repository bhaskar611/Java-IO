package com.io.javaio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperations {
	
	public static boolean createDirectory(String containingDirectory, String toBeCreated) {
		boolean flag = false;
		Path path = Paths.get(containingDirectory);
		if (Files.exists(path)) {
			path = Paths.get(toBeCreated);
			if (Files.exists(path))
				return true;
			try {
				Files.createDirectory(path);
				flag = true;
			} catch (IOException e) {
				System.out.println("The path specified does not exist");
			}
		} else
			System.out.println("The directory was not found");
		return flag;
	}

	
	public static boolean createFile(String containingDirectory, String toBeCreated) {
		boolean flag = false;
		Path path = Paths.get(containingDirectory);
		if (Files.exists(path)) {
			path = Paths.get(toBeCreated);
			if (Files.exists(path))
				return true;
			try {
				Files.createFile(path);
				flag = true;
			} catch (IOException e) {
				System.out.println("The path specified does not exist");
			}
		} else
			System.out.println("The containing directory was not found");
		return flag;
	}

	
	public static boolean deleteFile(String containingDirectory, String toBeDeleted) {
		boolean flag = false;
		Path path = Paths.get(containingDirectory);
		if (Files.exists(path)) {
			path = Paths.get(toBeDeleted);
			try {
				Files.delete(path);
				flag = true;
			} catch (IOException e) {
				System.out.println("The path specified does not exist");
			}
		} else
			System.out.println("The containing directory was not found");
		return flag;
	}

	
	public static boolean listDirectoryContents() {
		Path path = Paths.get("E:/");
		try {
			Files.newDirectoryStream(path).forEach(System.out::println);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
