package Unit3_2;

public class Truck extends Vehicle {

	private double truckbedSize;
	private boolean containerAttached;

	public Truck() {

		super();
		this.truckbedSize = 10;
		this.containerAttached = false;

	}

	public Truck(String own, String ins, int reg, int wheel, double carry, boolean container) {

		super(own, ins, reg, wheel);
		this.truckbedSize = carry;
		this.containerAttached = container;

	}

	public double getTruckbedSize() {

		return truckbedSize;

	}

	public void setTruckbedSize(double carry) {

		this.truckbedSize = carry;

	}

	public boolean isAttached() {

		return containerAttached;

	}

	@Override
	public void startEngine() {
		
		System.out.println("Starting Truck Engine!");
		
	}

}
