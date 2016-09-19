package ie.errigal.samuel.main;


/*Coded by Samuel Costa on 18-09-2016
samuelddc9@gmail.com
*/

public class PhoneBookApp {
	
	
	
	public static void main(String[] args) {
		
		//Instantiates phonebook class, which populates itself in its  constructor with random contacts
		PhoneBook phoneBook = new PhoneBook();
		
		//shows main menu till the user exits the application
		while(true)	phoneBook.showMainMenu();
	}
}
