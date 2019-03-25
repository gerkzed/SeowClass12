/*
The Friend class represents a Friend using their first name, last name, email
address and phone number.
*/
public class Friend{

	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	//Default constructor
	public Friend(){
		firstName = "";
		lastName = "";
		email = "";
		phone = "";
	}
	
	public Friend(String f, String l, String e, String p){
		firstName = f;
		lastName = l;
		email = e;
		phone = p;
	}
	
	//Mutator methods
	public void setName(int n, String name){
		if (n ==1 ) firstName = name;
		else lastName = name;
	}
	
	public void setEmail(String e){
		email = e;
	}
	
	public void setPhone(String p){
		phone = p;
	}
	
	//Accessor methods
	public String getName(int n){
		if (n ==1 ) return firstName;
		else return lastName;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getPhone(){
		return phone;
	}
	
	
	public String toString(){
		String s = firstName + " " + lastName +"\n"+phone+ "\n"+email;
		return s;
	}
	
	//implement compareTo method(s) below
		
}