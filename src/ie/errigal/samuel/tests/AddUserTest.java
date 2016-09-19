package ie.errigal.samuel.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ie.errigal.samuel.main.PhoneBook;
/*Coded by Samuel Costa on 18-09-2016
samuelddc9@gmail.com
*/
public class AddUserTest {

	
	//calls addContact method and compares if the list of contacts has one more element after executing it.
	@Test
	public void testAddContact() {
	PhoneBook testPhoneBook = new PhoneBook();
		
		//saves initial array size
		int initialArraySize, currentArraySize;
		initialArraySize = testPhoneBook.getContactList().size();
		
		testPhoneBook.addContact();
		
		//checks if the contact list's new size is equals the initial size + 1
		currentArraySize = testPhoneBook.getContactList().size();
		assertEquals(initialArraySize + 1 , currentArraySize);
	}

}
