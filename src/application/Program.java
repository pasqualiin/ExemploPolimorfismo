package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Employee> employeeList = new ArrayList<>();

		System.out.print("Enter the number of employees: ");
		int employeeNumber = sc.nextInt();

		for (int i = 1; i <= employeeNumber; i++) {
			System.out.print("Employee #" + i + " data: ");
			System.out.print("Outsourced (y/n)? ");
			char outsourced = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();

			if (outsourced == 'n') {
				employeeList.add(new Employee(name, hours, valuePerHour));

			} else {
				System.out.print("Aditional charge: ");
				double aditionalCharge = sc.nextDouble();

				employeeList.add(new OutsourcedEmployee(name, hours, valuePerHour, aditionalCharge));
			}

			System.out.println();
		}

		System.out.println("PAYMENTS: ");
		for (Employee obj : employeeList) {
			System.out.println(String.format("%s - $%.2f", obj.getName(), obj.payment()));
		}

		sc.close();

	}

}
