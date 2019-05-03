package Unit3_2;

public class Car extends Vehicle {

	private int numberOfDoors;
	private boolean sunroof;
	
	public Car() {
		
		super();
		this.numberOfDoors = 4;
		this.sunroof = false;
		
	}
	
	public Car(String own, String ins, int reg, int wheel, int doors, boolean elec) {
		
		super(own, ins, reg, wheel);
		this.numberOfDoors = doors;
		this.sunroof = elec;
		
	}
	
	public int getDoors() {
		
		return numberOfDoors;
		
	}
	
	public void setDoors(int doors) {
		
		this.numberOfDoors = doors;
		
	}
	
	public boolean isSunroof() {
		
		return sunroof;
		
	}
	
	public void setSunroof(boolean b) {
		
		this.sunroof = b;
		
	}

	@Override
	public void startEngine() {
		
		System.out.println("Starting Car Engine!");
		
	}
	
	
}
