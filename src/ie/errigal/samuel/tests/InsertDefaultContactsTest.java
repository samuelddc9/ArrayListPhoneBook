package ie.errigal.samuel.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ie.errigal.samuel.main.PhoneBook;
/*Coded by Samuel Costa on 18-09-2016
samuelddc9@gmail.com
*/
public class InsertDefaultContactsTest {

	//the insertDefaultcontact is called when the class is instantiated,  so it just checks if the current list size is the same as the value set
	//for getNoOfDefaultUsers
	@Test
	public void test() {
		
		PhoneBook testPhoneBook = new PhoneBook();
		
		assertTrue( testPhoneBook.getNoOfDefaultUsers()  == testPhoneBook.getContactList().size());
	}

}
 