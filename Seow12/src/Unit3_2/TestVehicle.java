package Unit3_2;

public class TestVehicle {
	public static void main(String[] args) {

		Car car = new Car();
		Truck truck = new Truck();
		Motorcycle motorcycle = new Motorcycle();

		car.setDoors(4);
		car.setInsurance("Manulife");
		car.setOwner("John Doe");
		car.setRegistration(101010);
		car.setSunroof(true);
		car.setWheels(4);

		truck.setTruckbedSize(20);
		truck.setInsurance("Sunlife Financial");
		truck.setOwner("Jane Smith");
		truck.setRegistration(202020);
		truck.setWheels(18);

		motorcycle.setWheelSize(15);
		motorcycle.setInsurance("Bel-Air");
		motorcycle.setOwner("Eric Erikson");
		motorcycle.setRegistration(303030);
		motorcycle.setBrand("Harley");
		motorcycle.setWheels(2);

		System.out.println("Doors: " + car.getDoors() + "\nInsurance: " + car.getInsurance() + "\nOwner: "
				+ car.getOwner() + "\nRegistration: " + car.getRegistration() + "\nSunroof: " + car.isSunroof()
				+ "\nWheels: " + car.getWheels());

		System.out.println();

		System.out.println("Truckbed Size: " + truck.getTruckbedSize() + "\nInsurance: " + truck.getInsurance()
				+ "\nOwner: " + truck.getOwner() + "\nRegistration: " + truck.getRegistration() + "\nWheels: "
				+ truck.getWheels());

		System.out.println();

		System.out.println("Wheel Size: " + motorcycle.getWheelSize() + "\nInsurance: " + motorcycle.getInsurance()
				+ "\nOwner: " + motorcycle.getOwner() + "\nRegistration: " + motorcycle.getRegistration() + "\nBrand: "
				+ motorcycle.getBrand() + "\nWheels: " + motorcycle.getWheels());

		System.out.println();

		car.startEngine();
		truck.startEngine();
		motorcycle.startEngine();

	}

}
