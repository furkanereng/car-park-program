// This program displays information about vehicles parked in a car park for 6 hours.

import java.util.Date;

public class Test {

	public static void main(String[] args) {

		// Objects created and holding vehicle objects on array to make things easier.
		CarPark carPark = new CarPark(10, 5);
		Vehicle vehicle0 = new Vehicle("34ZS1245", 4);
		Vehicle vehicle1 = new Vehicle("50PS2654", 2);
		Vehicle vehicle2 = new Vehicle("37SK1115", 1);
		Vehicle vehicle3 = new Vehicle("06AP1507", 2);
		Vehicle vehicle4 = new Vehicle("35HA1240", 4);
		Vehicle[] vehicles = { vehicle0, vehicle1, vehicle2, vehicle3, vehicle4 };

		// Created entryDate object which holds information of that moment, turned into
		// milliseconds.
		java.util.Date entryDate = new java.util.Date();
		long time = entryDate.getTime();

		// I supposed that all vehicles will stay for 6 hours at car park, so I get
		// times as milliseconds into an array.
		// Also, supposed that after a vehicle is parked, other one will park 1 hour
		// later (3600000ms later).
		long[][] times = new long[vehicles.length][2];
		for (int i = 0; i < times.length; i++) {
			times[i][0] = time + i * 3600000;
			times[i][1] = times[i][0] + 6 * 3600000; // Exit information (6h later).
		}

		// Getting entry dates and displaying is vehicle parked or not (if park is
		// full).
		for (int i = 0; i < vehicles.length; i++) {
			entryDate.setTime(times[i][0]);
			carPark.parkVehicle(vehicles[i], entryDate);
		}
		System.out.println();

		// Supposed that, only first 4 vehicles could parked. Displays only parked
		// vehicles.
		carPark.printVehicleList();

		// Many hours later, first two vehicles exit from car park. Displays plate
		// numbers and prices.
		for (int i = 0; i < 2; i++)
			carPark.exitVehicle(carPark.ticketArray[i], new Date(times[i][1]));
		System.out.println();

		// Displays vehicles left in car park.
		carPark.printVehicleList();

		// Many hours later, the left cars exit too. Displays plate numbers and prices.
		for (int i = 2; i < 4; i++)
			carPark.exitVehicle(carPark.ticketArray[i], new Date(times[i][1]));
		System.out.println();

		// Displays total income and number of tickets.
		System.out.println("Total Income: " + carPark.getTotalIncome());
		System.out.println("Total Number of Vehicles: " + Ticket.numberOfTickets);
		System.out.println();

		// Prints ticket informations for all vehicles.
		carPark.printTickets();

	}

}
