package lab16countries;

import java.util.ArrayList;
import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> arrList = new ArrayList<String>();
		int userNum;
		String userInput;
		System.out.println("Welcome to the Countries Maintenance Application! ");
		
		do {
		printMenu();
		userNum = Validator.getInt(scan, "Enter a menu number: ", 1, 3);
		System.out.println();
		
		if(userNum == 1) {
		
			CountriesTextFile.createFile("CountriesTextFileLab","countries.txt");
			arrList = CountriesTextFile.readFromFile("CountriesTextFileLab","countries.txt");
			printCountries(arrList);
			System.out.println();
			
		} else if (userNum == 2) {
			
			userInput = Validator.getString(scan, "Enter country: ");
			CountriesTextFile.writeToFile("CountriesTextFileLab", "countries.txt", userInput);
			System.out.println();
		}
		
		}while(userNum != 3);
		
		System.out.println("Goodbye. ");
	}
	
	public static void printMenu() {
		
		System.out.println("1. See the list of countries");
		System.out.println("2. Add a country");
		System.out.println("3. Exit");
		System.out.println();
		
	}
	public static void printCountries (ArrayList<String> arrList) {
		for(String str: arrList) {
			System.out.println(str);
		}
	}

}
