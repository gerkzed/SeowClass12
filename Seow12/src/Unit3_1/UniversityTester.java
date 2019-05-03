package Unit3_1;

public class UniversityTester {
	public static void main(String[] args) {
		
		UEmployee employee = new UEmployee();
		Staff staff = new Staff();
		Faculty faculty = new Faculty();
		
		employee.setFirstName("John");
		employee.setLastName("Doe");
		employee.setSalary(12000);
		
		staff.setFirstName("Mary");
		staff.setLastName("Sue");
		staff.setSalary(14500);
		staff.setTitle("Janitor");
		
		faculty.setFirstName("Jane");
		faculty.setLastName("Smith");
		faculty.setSalary(12300);
		faculty.setDept("Comp Sci");
		
		System.out.println("Name: " + employee.getFirstName() + " " + employee.getLastName() + "\nSalary: " + employee.getSalary());
		
		System.out.println();
		
		System.out.println("Name: " + staff.getFirstName() + " " + staff.getLastName() + "\nSalary: " + employee.getSalary() + "\nTitle: " + staff.getTitle());
		
		System.out.println();
		
		System.out.println("Name: " + faculty.getFirstName() + " " + faculty.getLastName() + "\nSalary: " + employee.getSalary() + "\nTitle: " + faculty.getDept());
		
	}
}