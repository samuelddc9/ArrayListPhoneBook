package ie.errigal.samuel.comparators;
import java.util.Comparator;

import ie.errigal.samuel.main.Contact;

/*Coded by Samuel Costa on 18-09-2016
samuelddc9@gmail.com
 */

//comparator to sort the Contacts arraylist by last Name
public class LastNameComparator implements Comparator<Contact>{

	@Override
	public int compare(Contact p1, Contact p2) {

		return (p1.getLastName().compareTo(p2.getLastName()));
	}

}
