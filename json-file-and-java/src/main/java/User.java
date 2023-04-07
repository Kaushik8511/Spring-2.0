
public class User {
	
	private String firstName;
	
	private String lastName;
	
	private int age;
	
	private Address address;

	public User() {
		
	}
	
	public User(String firstName, String lastName, int age, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", address=" + address
				+ "]";
	}

	
	
}
