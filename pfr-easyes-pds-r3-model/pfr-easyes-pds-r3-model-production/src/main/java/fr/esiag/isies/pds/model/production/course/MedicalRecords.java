package fr.esiag.isies.pds.model.production.course;

import fr.esiag.isies.pds.model.production.AbstractModel;

/**
 * 
 * @author PFR
 *
 */
public class MedicalRecords extends AbstractModel {
	
	private Patient patient;
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
