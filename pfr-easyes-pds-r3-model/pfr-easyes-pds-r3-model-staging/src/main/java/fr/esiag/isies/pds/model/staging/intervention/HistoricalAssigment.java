package fr.esiag.isies.pds.model.staging.intervention;

import fr.esiag.isies.pds.model.staging.AbstractModel;

/**
 * 
 * @author PFR
 *
 */
public class HistoricalAssigment extends AbstractModel {

	private Vehicle vehicle;
	
	private Intervention intervention;

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Intervention getIntervention() {
		return intervention;
	}

	public void setIntervention(Intervention intervention) {
		this.intervention = intervention;
	}
	
	
}
