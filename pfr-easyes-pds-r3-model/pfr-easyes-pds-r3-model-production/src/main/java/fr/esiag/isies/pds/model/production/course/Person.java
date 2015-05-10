package fr.esiag.isies.pds.model.production.course;

import fr.esiag.isies.pds.model.production.AbstractModel;

/**
 * Class which represents a person
 * 
 * @author PFR
 *
 */
public class Person extends AbstractModel {

	private String firstName;

	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

}
