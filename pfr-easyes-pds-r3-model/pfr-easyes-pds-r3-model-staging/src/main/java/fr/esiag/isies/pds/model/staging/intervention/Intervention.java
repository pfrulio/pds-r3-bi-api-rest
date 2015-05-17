package fr.esiag.isies.pds.model.staging.intervention;

import java.util.List;

import fr.esiag.isies.pds.model.staging.AbstractModel;

/**
 * 
 * @author PFR
 *
 */
public class Intervention extends AbstractModel {

	private IncidentTicket incidentTicket;

	private Operator operator;

	private Vehicle vehicle;

	private List<HistoricalAssigment> historicalAssigments;

	public IncidentTicket getIncidentTicket() {
		return incidentTicket;
	}

	public void setIncidentTicket(IncidentTicket incidentTicket) {
		this.incidentTicket = incidentTicket;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public List<HistoricalAssigment> getHistoricalAssigments() {
		return historicalAssigments;
	}

	public void setHisricalAssigments(
			List<HistoricalAssigment> historicalAssigments) {
		this.historicalAssigments = historicalAssigments;
	}

}
