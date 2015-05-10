package fr.esiag.isies.pds.model.staging.course;

import fr.esiag.isies.pds.model.staging.AbstractModel;

/**
 * Class which represents an orgnization in GIE
 * @author PFR
 *
 */
public class Organization extends AbstractModel {

	/**
	 * Name of the orgnization
	 */
	private String name;

	/**
	 * Latitude of the organization
	 */
	private float latitude;

	/**
	 * Longitude of the organization
	 */
	private float longitude;

	private OrganizationType organizationType;

	public OrganizationType getOrganizationType() {
		return organizationType;
	}

	public void setOrganizationType(OrganizationType organizationType) {
		this.organizationType = organizationType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
}
