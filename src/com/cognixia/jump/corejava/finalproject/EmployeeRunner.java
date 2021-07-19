package com.cognixia.jump.corejava.finalproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeRunner {

	private static ArrayList<Employee> employees = new ArrayList<Employee>();
	static File file = new File("resources/Employee.txt");
	static File csv = new File("resources/employees.csv");
	
	public static void main(String[] args) {
		readEmployee();
		
		System.out.println("List of Employees = 1");
		System.out.println("List of Departments = 2");
		System.out.println("Employees in Departments = 3");
		System.out.println("Add Employee = 4");
		System.out.println("Remove Employee = 5");
			
		Scanner sc = new Scanner(System.in);
		int userInput = 0;
		
		try {
			userInput = sc.nextInt();
		} catch(InputMismatchException e) {
		System.out.println("Please enter one of the numbers above!");
		}
		
		if(userInput == 1) {
			listEmployee();
		}
		if(userInput == 2) {
			listDepartment();
		}
		if(userInput == 3) {
			listEmployeeDepartment();
		}
		if(userInput == 4) {
			addEmployee();
		}
		if(userInput == 4) {
			removeEmployee();
		}
		sc.close();
		writeEmployee();
	}

	
	public static void readEmployee() {
		try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))) {
			while (true) {
				employees.add((Employee) reader.readObject());
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("*** FILE NOT FOUND EXCEPTION ***");
			e.printStackTrace();
		} catch(IOException e) {
			System.out.println("*** IO EXCEPTION ***");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("*** GENERAL EXCEPTION ***");
			e.printStackTrace();
		}
	}
	
	public static void writeEmployee() {
		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file, false))) {
			employees.forEach(ee -> {
				try {
					writer.writeObject(ee);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (BufferedWriter csvWriter = new BufferedWriter(new FileWriter(csv, false))) {
			employees.forEach(ee -> {
				try {
					csvWriter.write(ee.toString() + ('\n'));;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
//		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))) {
//			
//			Employee person1 = new Employee("Andy Apple", 10, Departments.CEO);
//			Employee person2 = new Employee("Billy Banana", 7, Departments.HR);
//			Employee person3 = new Employee("Charlie Cherry", 5, Departments.IT);
//			Employee person4 = new Employee("Danny Dragonfruit", 5, Departments.ACCOUNTING);
//			Employee person5 = new Employee("Eric Eggplant", 4, Departments.FINANCE);
//			Employee person6 = new Employee("Frank Fig", 6, Departments.MARKETING);
//			Employee person7 = new Employee("Greg Guava", 3, Departments.RANDD);
//			Employee person8 = new Employee("Henry Honeydew", 1, Departments.INTERN);
//			
//			writer.writeObject(person1);
//			writer.writeObject(person2);
//			writer.writeObject(person3);
//			writer.writeObject(person4);
//			writer.writeObject(person5);
//			writer.writeObject(person6);
//			writer.writeObject(person7);
//			writer.writeObject(person8);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}
	
	public static void listEmployee() {
		for (Employee e : employees) {
			System.out.println(e);
		}
	}
	
	public static void listDepartment() {
		Departments[] dpList = Departments.values();
		
		System.out.println("List of Departments:");
		for (int i = 0; i < dpList.length; i++) {
			System.out.println(dpList[i]);
		}
	}
	
	public static void listEmployeeDepartment() {
		Departments[] dpList = Departments.values();
		Scanner sc = new Scanner(System.in);
		int userInput = 0;
		System.out.println("Select Department Number:");
		
		for (int i = 0; i < dpList.length; i++) {
			System.out.println(i + ":" + dpList[i]);
		}
		
		try {
			userInput = sc.nextInt();
		} catch(InputMismatchException e) {
			e.printStackTrace();
		}
		
		Departments dp = dpList[userInput];
		
		employees.stream()
			.filter(ee -> ee.getDepartment() == dp)
			.forEach(System.out::println);
		
		sc.close();
	}
	
	public static void addEmployee() {
	
	}	
	
	public static void removeEmployee() {
	
	}
}
