package lab16countries;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CountriesTextFile {
	
	// readFromFile to an arraylist. use String.split(","); method *****this was for code challenge
		/**
		 * This is a void method to read from a file 
		 */
		public static ArrayList<String> readFromFile(String dirString, String fileName) {

			ArrayList<String> arrList = new ArrayList<String>();
			
			Path readFile = Paths.get(dirString, fileName);
			File file = readFile.toFile();
			
			try {
				FileReader fr = new FileReader(file);
				BufferedReader reader = new BufferedReader(fr);
				
				String line = reader.readLine();
				while(line != null) {
					arrList.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (FileNotFoundException e) {
				System.out.println("Something went wrong. ");
			} catch (IOException e) {
				System.out.println("Sssomething else went wrongg . ");
			}
			return arrList;
		}
		
		public static void writeToFile(String dir,String fileName, String input) {//take country input from main
			
			Path writeFile = Paths.get(dir, fileName);
			
			File file = writeFile.toFile();
			
			try {
				// creating object
				PrintWriter outW = new PrintWriter(new FileOutputStream(file, true));
				
				// using object
				outW.println(input);
				System.out.println("This country has been saved!");
				outW.close();
			} catch (FileNotFoundException e) {
				System.out.println("The file was not found. ");
			}
			
		}

		public static void createFile(String dirString, String fileName) {//hard code fileName in main

			
			Path filePath = Paths.get(dirString, fileName);
			
			if(Files.notExists(filePath)) {
				try {
					Files.createFile(filePath);
					System.out.println("File was created successfully. ");
				} catch (IOException e) {
					System.out.println("Something went wrong! ");
				}
			System.out.println("File Name: " + filePath.getFileName());
			System.out.println("Absolute Path: " + filePath.toAbsolutePath());
			}
		}
		public static void createDirectory(String path) {
			
			Path dirPath = Paths.get(path);
			
			if (Files.notExists(dirPath)) {
				try {
					Files.createDirectories(dirPath);
					System.out.println("Folder was created successfully! ");
				} catch (IOException e) {
					System.out.println("Something went wrong!");
				}
				
			}
			
		}
		
}
