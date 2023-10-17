package bookstore;

public class Client {
	String name;
	int yearOfBirth;
	String residence;
	String phoneNumber;
	String email;
	
	public Client(String name, int yearOfBirth, String residence, String phoneNumber, String email) {
		this.name = name;
		this.yearOfBirth = yearOfBirth;
		this.residence = residence;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", yearOfBirth=" + yearOfBirth + ", residence=" + residence + ", phoneNumber="
				+ phoneNumber + ", email=" + email + "]";
	}
	
	
}
