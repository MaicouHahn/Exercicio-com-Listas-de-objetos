package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class App {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		List<Employee> employee = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		Scanner scanName = new Scanner(System.in);

		System.out.println("How many employees will be registered?");
		int numEmployees = scan.nextInt();// variable that controls the max number of objects on the list

		for (int i = 0; i < numEmployees; i++) {

			System.out.println("Employee #" + (i + 1));
			System.out.println("Whats is the ID?:");
			int id = scan.nextInt();

			while (hasId(id, employee)) {// this while will use hasId to check if there is duplicated IDs, and finish
											// the loop only
											// when the user type a not registered ID
				System.out.println("ID already taken:");
				System.out.println("Whats is the ID?:");
				id = scan.nextInt();
			}

			System.out.println("Whats your name:");
			String name = scanName.nextLine();
			System.out.println("Whats your Salary:");
			double salary = scan.nextDouble();
			employee.add(new Employee(id, name, salary));// instantiated object receiving the parameters read by the
															// scanners
		}

		System.out.print("\nEnter the employee id that will have salary increase: ");
		int id = scan.nextInt();

		while (hasId(id, employee) != true) {// check if the object id is equal to the id read by the scanner

			System.out.print("\nThis ID does not exist, enter a valid ID");
			id = scan.nextInt();
		}

		System.out.print("\nEnter the percentage: ");
		double percentage = scan.nextDouble();

		for (int i = 0; i < employee.size(); i++) {
			if (employee.get(i).getId() == id) {// check if the object id is equal to the id read by the scanner

				employee.get(i).increaseSalary(percentage);
			}
		}

		System.out.println("List of employees: ");
		for (Employee e : employee) {
			
			System.out.println(e);
		}
		
		scan.close();
		scanName.close();
	}

	public static boolean hasId(int id, List<Employee> list) {// method to test if the ID is already taken by others
																// objects on the list

		boolean hasId = false;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {

				hasId = true;
			}
		}
		return hasId;
	}

}
