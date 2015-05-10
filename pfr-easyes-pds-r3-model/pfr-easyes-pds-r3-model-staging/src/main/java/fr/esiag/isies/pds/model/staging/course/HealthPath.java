package fr.esiag.isies.pds.model.staging.course;

import java.util.Date;

import fr.esiag.isies.pds.model.staging.AbstractModel;

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

	private HealthPathBill healthPathBill;

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

	public HealthPathBill getHealthPathBill() {
		return healthPathBill;
	}

	public void setHealthPathBill(HealthPathBill healthPathBill) {
		this.healthPathBill = healthPathBill;
	}
}
