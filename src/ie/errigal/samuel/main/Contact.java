package ie.errigal.samuel.main;

/*Coded by Samuel Costa on 18-09-2016
samuelddc9@gmail.com
 */

public class Contact {

	//Basic contact attributes 
	private String firstName;
	private String lastName;
	private String adress;
	private String phoneNumber;


	

	//Overrided toString to easily print it 
	@Override
	public String toString() {
		return "Contact: [\n First Name= " + firstName + "\n  Last Name= " + lastName + "\n  Adress= " + adress + "\n  phone Number= "
				+ phoneNumber + "]";
	}

	//Overrided equals to compare custom Objects
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!Contact.class.isAssignableFrom(obj.getClass())) {
			return false;
		}
		final Contact other = (Contact) obj;
		if (!this.getFirstName().equals(other.getFirstName())) {
			return false;
		}
		if (!this.getLastName().equals(other.getLastName())) {
			return false;
		}
		if (!this.getAdress().equals(other.getAdress())) {
			return false;
		}
		if (!this.getPhoneNumber().equals(other.getPhoneNumber())) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}


	//gets and setters
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
		public String getAdress() {
			return adress;
		}
		public void setAdress(String adress) {
			this.adress = adress;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}





}
