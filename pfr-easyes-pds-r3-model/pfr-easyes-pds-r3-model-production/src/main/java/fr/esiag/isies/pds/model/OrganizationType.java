package fr.esiag.isies.pds.model;

/**
 * Class which represents a type of an organization
 * the description can be "Hôpital Publique" ou "Hôpital Privée"
 * @author PFR
 *
 */
public class OrganizationType {
	
	/**
	 * Label of the type
	 */
	private String description;
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
