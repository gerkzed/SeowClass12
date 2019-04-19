package Unit3_2;

public class Car extends Vehicle {

	private int numberOfDoors;
	private boolean electric;
	
	public Car() {
		
		super();
		this.numberOfDoors = 4;
		this.electric = false;
		
	}
	
	public Car(String own, String ins, int reg, int wheel, int axel, int doors, boolean elec) {
		
		super(own, ins, reg, wheel, axel);
		this.numberOfDoors = doors;
		this.electric = elec;
		
	}
	
	public int getDoors() {
		
		return numberOfDoors;
		
	}
	
	public void setDoors(int doors) {
		
		this.numberOfDoors = doors;
		
	}
	
	public boolean isElectric() {
		
		return electric;
		
	}
}
