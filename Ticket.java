// This program holds informations about when vehicle entered and exited to car park, what is price etc.
public class Ticket {

	private Vehicle vehicle;
	private java.util.Date entryDate = new java.util.Date();
	private java.util.Date exitDate = new java.util.Date();
	private double totalPrice;
	public static int numberOfTickets;

	public Ticket(Vehicle vehicle, java.util.Date entryDate) {
		this.vehicle = vehicle;
		this.entryDate = entryDate;
	}

	public double calculatePrice(double hourlyPrice, java.util.Date exitDate) {
		int numberOfHours = 6; // Supposed that all vehicles stays for 6h.
		double parkingCost = vehicle.getSize() * hourlyPrice * numberOfHours;
		this.exitDate = exitDate; // Updating exit date.
		this.entryDate = new java.util.Date(this.exitDate.getTime() - 3600000 * numberOfHours); // Updating entry date.
		totalPrice += parkingCost;
		numberOfTickets++;
		return parkingCost;
	}

	public String getTicketInfo() {

		String str = "Ticket Info\nPlate Number: " + vehicle.getPlateNumber() + "\nEntry: " + entryDate;
		boolean checker = false;
		if (exitDate != null)
			checker = true;

		// If vehicle left car park, below informations will be displayed too.
		if (checker) {
			str += "\nExit : " + exitDate + "\nHour : 6" + "\nFee  : " + calculatePrice(5, exitDate) + "\n";
		}
		return str;

	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public double getPrice() {
		return totalPrice;
	}

}
