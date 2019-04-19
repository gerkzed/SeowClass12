package Unit3_1;

public class Staff extends UEmployee {

	private String title;

	public Staff() {

		super();
		this.title = "";

	}

	public Staff(String first, String last, double money, String job) {

		super(first, last, money);
		this.title = job;

	}

	public void setTitle(String job) {

		this.title = job;

	}

	public String getTitle() {

		return title;

	}

}