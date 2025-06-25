// This program holds vehicles' informations.
public class Vehicle {

	private String plateNumber;
	private int size;

	public Vehicle(String plateNumber, int size) {
		this.plateNumber = plateNumber;
		this.size = size;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public int getSize() {
		return size;
	}

	public String getVehicleInfo() {
		String str = "Vehicle Info\nPlate Number: " + getPlateNumber() + "\nSize: " + getSize();
		return str;
	}

}
