// In this program, informations about carPark object is stored and its methods displays informations.
public class CarPark {

	private int capacity;
	public ParkPlace[] parkPlaceArray = new ParkPlace[4];
	public Ticket[] ticketArray = new Ticket[5];
	private double hourlyPrice;

	public CarPark(int capacity, double hourlyPrice) {
		this.capacity = capacity;
		this.hourlyPrice = hourlyPrice;
	}

	public Ticket parkVehicle(Vehicle vehicle, java.util.Date entryDate) {

		Ticket ticket = new Ticket(vehicle, entryDate);
		ParkPlace parkPlace = new ParkPlace(vehicle);
		capacity -= vehicle.getSize();
		if (capacity <= 0) {
			System.out.println("Car park is full!");
			ticket = null;
		} else {
			int i = 0;
			for (; this.parkPlaceArray[i] != null; i++)
				;
			this.parkPlaceArray[i] = parkPlace;
			this.ticketArray[i] = ticket;
			System.out.println("The vehicle with " + vehicle.getPlateNumber() + " plate number is parked.");
		}
		return ticket;

	}

	public Vehicle exitVehicle(Ticket ticket, java.util.Date exitDate) {

		ParkPlace parkPlaceArray[] = new ParkPlace[this.parkPlaceArray.length - 1]; // Every time when this method
																					// called, only one vehicle exits.
		System.out.println("The price for vehicle with "
				+ (this.ticketArray[Ticket.numberOfTickets].getVehicle()).getPlateNumber() + " plate number is: "
				+ this.ticketArray[Ticket.numberOfTickets].calculatePrice(hourlyPrice, exitDate) + " TLs");

		this.parkPlaceArray[0] = null; // The left vehicle's place set as null.
		for (int i = 0, j = 0; i < this.parkPlaceArray.length; i++) {
			if (this.parkPlaceArray[i] != null)
				parkPlaceArray[j++] = this.parkPlaceArray[i]; // Creating new array without null value.
		}

		/**
		 * Car Park object's parkPlaceArray refers to the last created parkPlaceArray
		 * right now, which doesn't contain null value.
		 */
		this.parkPlaceArray = parkPlaceArray;

		return ticket.getVehicle();

	}

	public double getTotalIncome() {

		int income = 0;
		for (int i = 0; i < this.ticketArray.length - 1; i++)
			income += this.ticketArray[i].getPrice();
		return income;

	}

	public void printVehicleList() {

		for (int i = 0; i < parkPlaceArray.length; i++)
			System.out.println((parkPlaceArray[i].getVehicle()).getVehicleInfo());

	}

	public void printTickets() {

		// We supposed only 4 vehicles parked, so the last null ticket won't be
		// displayed.
		for (int i = 0; i < ticketArray.length - 1; i++)
			System.out.println(ticketArray[i].getTicketInfo());

	}

}
