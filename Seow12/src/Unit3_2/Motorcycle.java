package Unit3_2;

public class Motorcycle extends Vehicle {

	private int wheelSize;
	private String brand;

	public Motorcycle() {

		super();
		this.wheelSize = 5;
		this.brand = "";

	}

	public Motorcycle(String own, String ins, int reg, int wheel, int axel, int doors, int wheelS, String br) {

		super(own, ins, reg, wheel, axel);
		this.wheelSize = wheelS;
		this.brand = br;

	}

	public int getWheelSize() {

		return wheelSize;

	}

	public void setWheelSize(int wheel) {

		this.wheelSize = wheel;

	}

	public String getBrand() {

		return brand;

	}

	public void setBrand(String br) {

		this.brand = br;

	}

}
