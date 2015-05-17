package fr.esiag.isies.pds.model.staging.intervention;

import fr.esiag.isies.pds.model.staging.AbstractModel;

/**
 * 
 * @author PFR
 *
 */
public class Operator extends AbstractModel {

	private String name;
	
	private GeographicArea geographicArea;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GeographicArea getGeographicArea() {
		return geographicArea;
	}

	public void setGeographicArea(GeographicArea geographicArea) {
		this.geographicArea = geographicArea;
	}
	
	
}
