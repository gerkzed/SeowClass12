package Unit3_2;

public class Truck extends Vehicle {

	private double carryingCapacity;
	private boolean containerAttached;

	public Truck() {

		super();
		this.carryingCapacity = 10;
		this.containerAttached = false;

	}

	public Truck(String own, String ins, int reg, int wheel, int axel, double carry, boolean container) {

		super(own, ins, reg, wheel, axel);
		this.carryingCapacity = carry;
		this.containerAttached = container;

	}

	public double getCarryCapacity() {

		return carryingCapacity;

	}

	public void setCarryCapacity(double carry) {

		this.carryingCapacity = carry;

	}

	public boolean isAttached() {

		return containerAttached;

	}

}
