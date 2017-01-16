
public class Car extends Vehicle{
	
	private int noOfDoors;
	private String color;
	
	public Car(String vehiID, int noOfDoors, String color) {
		super(vehiID);
		
		this.noOfDoors = noOfDoors;
		this.color = color;
	}

	public int getNoOfDoors() {
		return noOfDoors;
	}

	public String getColor() {
		return color;
	}

	public void setNoOfDoors(int noOfDoors) {
		this.noOfDoors = noOfDoors;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
//	public void addCar() {
//		
//	}
	
}
