package ie.errigal.samuel.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import ie.errigal.samuel.comparators.FirstNameComparator;
import ie.errigal.samuel.comparators.LastNameComparator;
import ie.errigal.samuel.main.Contact;


/*Coded by Samuel Costa on 18-09-2016
samuelddc9@gmail.com
 */


public class PhoneBook {  

	public PhoneBook() {
		super();
		insertDefaultContacts();
		//		listContacts(SortingAttribute.FIRSTNAME);
	}


	//As it is just an sample application, I decided to just use a temporary arraylist as  storage
	private ArrayList<Contact> contactList = new ArrayList<Contact>();
	//Number of random users generated when the application starts
	private int noOfDefaultUsers = 10;
	// enum for choosing sorting attribute
	public enum SortingAttribute{FIRSTNAME, LASTNAME};
	//scanners for user input
	Scanner scanner = new Scanner(System.in);

	//shows main menu and call methods based on user input
	public void showMainMenu() {
		int userChoice;

		System.out.println("\n Welcome! What do you want to do?"
				+ "\n 1 - List all contacts by first name"
				+ "\n 2 - List all contacts by last name"
				+ "\n 3 - Search contact by ID"
				+ "\n 4 - Add new contact"
				+ "\n 5 - Remove contact by ID"
				+ "\n 6 - Edit contact by ID"
				+ "\n 0 - Exit");
		while (!scanner.hasNextInt()) scanner.next();
		userChoice = scanner.nextInt();
		scanner.nextLine();

		switch (userChoice) {

		case 1: 	//		1 - List all contacts by first name
			listContacts(SortingAttribute.FIRSTNAME);
			break;


		case 2: //		2 - List all contacts by last name	
			listContacts(SortingAttribute.LASTNAME);
			break;

		case 3: //		3 - Search contact by index
			showContactInfo();
			break;

		case 4: //		4 - Add new contact
			addContact();
			break;

		case 5:  //		5 - Remove contact by index
			deleteContact();
			break;

		case 6: //		6 - Edit contact by index
			editContact();
			break;

		case 0: 	//		0 - Exit
			scanner.close();
			System.exit(0);
			break;
		default:
			System.out.println("Invalid choice, type a number between 0 and 6");
			break;
		}


	}

	public void editContact() {

		String userInput;
		int userChoice;

		System.out.println("Type the index of contact that you want to edit");
		userChoice = scanner.nextInt();
		scanner.nextLine();

		System.out.println("editing " + contactList.get(userChoice));

		System.out.println("Type the contact's new first Name");
		userInput = scanner.nextLine();
		contactList.get(userChoice).setFirstName(userInput);

		System.out.println("Type the  contact's new  last Name");
		userInput = scanner.nextLine();
		contactList.get(userChoice).setLastName(userInput);

		System.out.println("Type the contact's new  phone number");
		userInput = scanner.nextLine();
		contactList.get(userChoice).setPhoneNumber(userInput);

		System.out.println("Type the  contact's new  Address");
		userInput = scanner.nextLine();
		contactList.get(userChoice).setAdress(userInput);


		System.out.println("updated to: " +  contactList.get(userChoice));


	}

	//Creates a new instance of Contact, sets its attribute according to user input and then adds it to the arrayList
	public void addContact(){

		Contact newContact = new Contact();
		String userInput;		


		System.out.println("Type the new contact's first Name");
		userInput = scanner.nextLine();	
		newContact.setFirstName(userInput);

		System.out.println("Type the new contact's last Name");
		userInput = scanner.nextLine();
		newContact.setLastName(userInput);

		System.out.println("Type the new contact's phone number");
		userInput = scanner.nextLine();
		newContact.setPhoneNumber(userInput);

		System.out.println("Type the new contact's Address");
		userInput = scanner.nextLine();
		newContact.setAdress(userInput);


		System.out.println("adding  " +  newContact);

		contactList.add(newContact);


	}


	public void showContactInfo(){


		//try/catch in case user inserts an out of bounds index
		try {
			System.out.println("Type the Index of the user you want to see");
			int index = scanner.nextInt();
			scanner.nextLine();

			System.out.println(contactList.get(index));
		} catch (Exception e) {
			System.out.println("Invalid Index. Please Type an index between 0 and " + (contactList.size()-1));

		}

	}



	//asks for contact's index and remove it, 
	public void deleteContact(){
		System.out.println("Type the Index of the user you want to delete ( 0 - " + (contactList.size()-1));

		//try/catch in case user inserts an out of bounds index
		try {
			int index = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Are you sure that you want to delete: " + contactList.get(index) + "\n Type 'Y' to delete");

			String yesOrNo = scanner.nextLine();
			switch (yesOrNo) {
			case "Y":
				contactList.remove(index);
				System.out.println("contact deleted");
				break;

			default:
				System.out.println("contact not deleted");
				break;
			}


		} catch (Exception e) {
			System.out.println("Invalid Index. Please Type an index between 0 and " + (contactList.size()-1));
		}



	}

	//Sorts the contacts array using the attributes firstName or LastName depending on the ENUM passed as parameter and prints their first and last name 
	public void listContacts(SortingAttribute sortingAttribute){


		//calls Collections.sort using FirsName comparator
		if (sortingAttribute == SortingAttribute.FIRSTNAME){
			Comparator<Contact> firstNameComp = new FirstNameComparator();
			Collections.sort(contactList, firstNameComp);
		}
		//calls Collections.sort using LastName comparator
		else if (sortingAttribute == SortingAttribute.LASTNAME){
			Comparator<Contact> lastNameComp = new LastNameComparator();
			Collections.sort(contactList, lastNameComp);
		}

		//prints the sorted array
		for (Contact currentContact : contactList) {
			System.out.println( currentContact.getFirstName() + " " + currentContact.getLastName());

		}
	}

	//Calls generateRandomContact a number of times equal the  value of noOfDefaultUsers variable and adds them to the contactlist array
	public void insertDefaultContacts(){

		for(int i = 1; i <= noOfDefaultUsers; i++){	

			contactList.add(generateRandomContact());

		}

	}

	// returns a random contact created using the strings in the vectors
	public Contact generateRandomContact(){

		int randomIndex;
		String[] firstNames = {"John", "Peter", "Luke", "Jhoseph", "Mary", "Anny", "Aoife", "Marina", "Andrew"};
		String[] lastNames = {"Connor", "O'neal", "Powers", "Mayer", "Hopkins", "Costa", "Jackson", "Monroe"};
		String[] phoneNumbers = {"333 2332", "222 2323", "555 2762", "877 3232", "332 7677", "999 2124", "121 1221", "089 2122"};
		String[] addresses = {" Waterford - Ireland", "Dublin - Ireland", "Wexford - Ireland", "New Ross - Ireland" };

		Contact randomContact = new Contact();			

		randomIndex = (int) (Math.random()*firstNames.length);
		randomContact.setFirstName(firstNames[randomIndex]);

		randomIndex = (int) (Math.random()*lastNames.length);
		randomContact.setLastName(lastNames[randomIndex]);

		randomIndex = (int) (Math.random()*phoneNumbers.length);
		randomContact.setPhoneNumber(phoneNumbers[randomIndex]);

		randomIndex = (int) (Math.random()*addresses.length);
		randomContact.setAdress(addresses[randomIndex]);

		return (randomContact);
	}
	
	
	//gets and setters

	public int getNoOfDefaultUsers() {
		return noOfDefaultUsers;
	}

	public void setNoOfDefaultUsers(int noOfDefaultUsers) {
		this.noOfDefaultUsers = noOfDefaultUsers;
	}


	public ArrayList<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(ArrayList<Contact> contactList) {
		this.contactList = contactList;
	}




}
