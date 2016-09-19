package ie.errigal.samuel.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ie.errigal.samuel.main.Contact;
import ie.errigal.samuel.main.PhoneBook;
/*Coded by Samuel Costa on 18-09-2016
samuelddc9@gmail.com
*/
public class EditContactTest {

	//gets one contact from the contacts arraylist and compares the content before and after calling the edit method
	@Test
	public void testEditContact() {
		
		
		PhoneBook testPhoneBook = new PhoneBook();
		
		//indexToCompare's value defines which contact will be used for the test. Value 1 was chosen arbitrarily
		int indexToCompare = 1;
		
		// saves the information from an contact in the list to a temporary object
		Contact contactToEdit = testPhoneBook.getContactList().get(indexToCompare);
		Contact temporaryContact = new Contact();
		
		temporaryContact.setFirstName(contactToEdit.getFirstName());
		temporaryContact.setLastName(contactToEdit.getLastName());
		temporaryContact.setAdress(contactToEdit.getAdress());
		temporaryContact.setPhoneNumber(contactToEdit.getPhoneNumber());

		
		System.out.println("in order for the test to work, edit the contact at index " + indexToCompare + "\n");
		//calls the edit method 
		testPhoneBook.editContact();
	
		
		//returns success if the actual contact info is different from the old information saved in the temporary object
		assertNotEquals(temporaryContact, testPhoneBook.getContactList().get(indexToCompare));

		
	}

}
