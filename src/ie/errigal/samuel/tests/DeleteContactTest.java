package ie.errigal.samuel.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ie.errigal.samuel.main.PhoneBook;

/*Coded by Samuel Costa on 18-09-2016
samuelddc9@gmail.com
 */

public class DeleteContactTest {

	//calls deleteContact() method, compares if the list of contacts has one less element after executing it
	@Test
	public void test() {



		PhoneBook testPhoneBook = new PhoneBook();

		//saves initial array size
		int initialArraySize, currentArraySize;
		initialArraySize = testPhoneBook.getContactList().size();

		testPhoneBook.deleteContact();
		
		//checks if the contact list's new size is equals the initial size + 1
		currentArraySize = testPhoneBook.getContactList().size();
		assertEquals(initialArraySize - 1, currentArraySize);
	}

}
