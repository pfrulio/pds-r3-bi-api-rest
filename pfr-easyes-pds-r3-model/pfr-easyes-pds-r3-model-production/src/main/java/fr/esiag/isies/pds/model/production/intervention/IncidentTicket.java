package fr.esiag.isies.pds.model.production.intervention;

import java.util.Date;

import fr.esiag.isies.pds.model.production.AbstractModel;

/**
 * 
 * @author PFR
 *
 */
public class IncidentTicket extends AbstractModel {
	
	private Date openDate;

	private Date closeDate;

	private IncidentAdress incidentadress;
	
	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	
	public IncidentAdress getIncidentadress() {
		return incidentadress;
	}
	
	public void setIncidentadress(IncidentAdress incidentadress) {
		this.incidentadress = incidentadress;
	}
}
