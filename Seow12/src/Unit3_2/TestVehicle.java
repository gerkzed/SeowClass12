package Unit3_2;

public class TestVehicle {
	public static void main(String[] args) {

		Vehicle test = new Car();

		test.setAxels(2);
		test.setInsurance("Sunlife Financial");
		test.setOwner("William S");
		test.setRegistration(372816);
		test.setWheels(4);
		((Car) test).setDoors(4);
		((Car) test).isElectric();

		System.out.println(test.getAxels());
		System.out.println(test.getInsurance());
		System.out.println(test.getOwner());
		System.out.println(test.getRegistration());
		System.out.println(test.getWheels());
		System.out.println(((Car) test).getDoors());
		System.out.println(((Car) test).isElectric());

	}

}
