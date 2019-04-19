package Unit3_2;

public class Vehicle {

	private String owner;
	private String insurance;

	private int registration;
	private int wheels;
	private int axels;

	public Vehicle() {

		this.owner = "";
		this.insurance = "";
		this.registration = 0;
		this.wheels = 4;
		this.axels = 2;

	}

	public Vehicle(String own, String ins, int reg, int wheel, int axel) {

		this.owner = own;
		this.insurance = ins;
		this.registration = reg;
		this.wheels = wheel;
		this.axels = axel;

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

	public int getAxels() {

		return axels;

	}

	public void setAxels(int axel) {

		this.axels = axel;

	}

}
