package lab12cars;

import java.util.ArrayList;
import java.util.Scanner;

public class CarApp {
	public static ArrayList<Car> carList = new ArrayList<>();
	static Scanner scnr = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int selection;
		String make;
		String model;
		int year;
		double price;
		String clear;
		String cont = null;
		
		System.out.println("Welcome to the Grand Circus Motors admin console!");
		populateList();
		displayMenu();
		
		do {
			System.out.print("Select car to view: ");
			try {
				selection = scnr.nextInt();
				clear = scnr.nextLine();
			} catch (Exception e) {
				System.out.println("Invalid input! Please try again.");
				clear = scnr.nextLine();
				continue;
			}
			
			retrieveCar(selection);
			
			System.out.print("Continue? (y/n): ");
			cont = scnr.nextLine();
		} while(!cont.equalsIgnoreCase("n"));
		System.out.println("Goodbye!");
	}
	
	public static void populateList() {
		carList.add(new Car("Ford", "F150", 2019, 19999.99));
		carList.add(new Car("Chevy", "Silverado", 2018, 24999.99));
		carList.add(new Car("Chevrolet", "Equinox LT", 2017, 1998.99));
		carList.add(new UsedCar("Chevrolet", "Tahoe LT", 2010, 16995.99, 100496));
		carList.add(new UsedCar("GMC", "Acadia SLE-2", 2018, 2695.99, 18846));
		carList.add(new UsedCar("Kia", "Sportage LX", 2018, 1945.99, 13606));
	}
	
	public static void displayMenu() {
		int i = 0;
		String[] items = new String[6];
		String make;
		String model;
		String year;
		String price;
		String mileage;
		String[] s;
		
		for(Car car: carList) {
			items[i] = car.toString();
			i++;
		}
		
		i = 1;
		for(String item: items) {
			s = item.split(", ");
			make = s[0];
			model = s[1];
			year = s[2];
			price = s[3];
			
			try {
				mileage = s[4];
				System.out.printf("%d. %-10s %-15s %-6s %-10s %-8s\n", i, make, model, year, price, mileage);
			} catch (Exception e) {
				System.out.printf("%d. %-10s %-15s %-6s %-10s\n", i, make, model, year, price);
			}
			s = null;
			i++;
		}
	}
	
	public static void retrieveCar(int selection) {
		int i = 1;

		String make;
		String model;
		String year;
		String price;
		String mileage;
		String[] s;
		String items = "";
		
		for(Car car: carList) {
			if(i == selection) {
				items = car.toString();
			}
			i++;
		}
		
		s = items.split(", ");
		make = s[0];
		model = s[1];
		year = s[2];
		price = s[3];
			
		try {
			mileage = s[4];
			System.out.printf("%-10s %-8s\n\n", "Price", "Mileage");
			System.out.printf("%-10s %-8s\n", price, mileage);
		} catch (Exception e) {
			System.out.printf("%-10s\n\n", "Price");
			System.out.printf("%-10s\n", price);
		}
		s = null;
		i++;
	}
}
