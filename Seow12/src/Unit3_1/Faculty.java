package Unit3_1;

public class Faculty extends UEmployee {

	private String department;

	public Faculty() {

		super();

		this.department = "";

	}

	public Faculty(String first, String last, double money, String dept) {

		super(first, last, money);

		this.department = dept;

	}

	public void setDept(String dept) {

		this.department = dept;

	}

	public String getDept() {

		return department;

	}

}