package Unit4;

public class CallLink {

	private String nameFirst;
	
	private String nameLast;
	
	private String telephoneNumber;
	
	private String emailAddress;
	
	private String reason;
	
	private String priority;

	public CallLink next;

	public CallLink(String nf, String nl, String t, String e, String r, String p) {

		this.nameFirst = nf;
		
		this.nameLast = nl;
		
		this.telephoneNumber = t;
		
		this.emailAddress = e;
		
		this.reason = r;
		
		this.priority = p;

	}
	
	public String getFirstName() {
		
		return nameFirst;
		
	}
	
	public String getLastName() {
		
		return nameLast;
		
	}
	
	public String getPhoneNumber() {
		
		return telephoneNumber;
		
	}
	
	public String getEmailAddress() {
		
		return emailAddress;
		
	}
	
	public String getReason() {
		
		return reason;
		
	}

	public String getPriority() {

		return priority;

	}

	public String toCallString() {

		return nameFirst + " " + nameLast + ", " + telephoneNumber + ", " + emailAddress + ", " + reason + ", " + priority;

	}

}
