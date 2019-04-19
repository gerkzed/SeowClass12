package Unit3_1;

public class UniversityTester {
	public static void main(String[] args) {
		
		Faculty seow = new Faculty("Gary", "Seow", 100000, "Business");
		
		System.out.println(seow.getFirstName());
		System.out.println(seow.getLastName());
		System.out.println(seow.getSalary());
		System.out.println(seow.getDept());
		
	}
}