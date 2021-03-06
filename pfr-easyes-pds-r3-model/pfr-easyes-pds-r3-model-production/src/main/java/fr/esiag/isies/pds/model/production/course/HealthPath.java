package fr.esiag.isies.pds.model.production.course;

import java.util.Date;

import fr.esiag.isies.pds.model.production.AbstractModel;

/**
 * Class which represents a medical course
 * 
 * @author PFR
 *
 */
public class HealthPath extends AbstractModel {

	/**
	 * 
	 */
	private MedicalRecords medicalRecords;

	private Date endDate;

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public MedicalRecords getMedicalRecords() {
		return medicalRecords;
	}

	public void setMedicalRecords(MedicalRecords medicalRecords) {
		this.medicalRecords = medicalRecords;
	}
}
