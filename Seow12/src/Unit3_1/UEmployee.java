package Unit3_1;

public class UEmployee {

	private String firstName;
	private String lastName;
	private double salary;

	public UEmployee() {

		this.firstName = "";
		this.lastName = "";
		this.salary = 0;

	}

	public UEmployee(String first, String last, double money) {

		this.firstName = first;
		this.lastName = last;
		this.salary = money;

	}

	public String getFirstName() {

		return firstName;

	}

	public String getLastName() {

		return lastName;

	}

	public double getSalary() {

		return salary;

	}
}