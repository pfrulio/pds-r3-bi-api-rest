package fr.esiag.isies.pds.model.production.intervention;

import fr.esiag.isies.pds.model.production.AbstractModel;

/**
 * 
 * @author PFR
 *
 */
public class Intervention extends AbstractModel {
	private IncidentTicket incidentTicket;

	private Vehicle vehicle;

	public IncidentTicket getIncidentTicket() {
		return incidentTicket;
	}

	public void setIncidentTicket(IncidentTicket incidentTicket) {
		this.incidentTicket = incidentTicket;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}
