package fr.esiag.isies.pds.model.production.course;

import fr.esiag.isies.pds.model.production.AbstractModel;

/**
 * Class which represents a type of an organization the description can be
 * "Hôpital Publique" ou "Hôpital Privée"
 * 
 * @author PFR
 *
 */
public class OrganizationType extends AbstractModel {

	/**
	 * Label of the type
	 */
	private String description;

	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
