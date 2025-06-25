// In this program, parkPlace object's informations keeping safe with private modifier.
public class ParkPlace {

	private int size;
	private Vehicle vehicle;

	public ParkPlace(Vehicle vehicle) {
		this.vehicle = vehicle;
		this.size = vehicle.getSize();
	}

	public int getSize() {
		return size;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

}
