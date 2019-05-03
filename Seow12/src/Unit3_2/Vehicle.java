package Unit3_2;

public abstract class Vehicle {

	private String owner;
	private String insurance;

	private int registration;
	private int wheels;

	public Vehicle() {

		this.owner = "";
		this.insurance = "";
		this.registration = 0;
		this.wheels = 4;

	}

	public Vehicle(String own, String ins, int reg, int wheel) {

		this.owner = own;
		this.insurance = ins;
		this.registration = reg;
		this.wheels = wheel;

	}

	public String getOwner() {

		return owner;

	}

	public void setOwner(String own) {

		this.owner = own;

	}

	public String getInsurance() {

		return insurance;

	}

	public void setInsurance(String ins) {

		this.insurance = ins;

	}

	public int getRegistration() {

		return registration;

	}

	public void setRegistration(int reg) {

		this.registration = reg;

	}

	public int getWheels() {

		return wheels;

	}

	public void setWheels(int wheel) {

		this.wheels = wheel;

	}

	abstract void startEngine();
	

}
