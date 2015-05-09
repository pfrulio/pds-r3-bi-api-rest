package fr.esiag.isies.pds.model;

/**
 * Class which represents Patient
 * @author PFR
 *
 */
public class Patient extends Person {
	
	/**
	 * Organization which is attached to the patient
	 */
	private Organization organization;
	
	public Organization getOrganization() {
		return organization;
	}
	
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
}
