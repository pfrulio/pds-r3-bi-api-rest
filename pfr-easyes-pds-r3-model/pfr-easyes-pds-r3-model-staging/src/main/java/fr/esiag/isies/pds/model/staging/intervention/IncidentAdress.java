package fr.esiag.isies.pds.model.staging.intervention;

import fr.esiag.isies.pds.model.staging.AbstractModel;

/**
 * 
 * @author PFR
 *
 */
public class IncidentAdress extends AbstractModel {

	private float latitude;

	private float longitude;

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
