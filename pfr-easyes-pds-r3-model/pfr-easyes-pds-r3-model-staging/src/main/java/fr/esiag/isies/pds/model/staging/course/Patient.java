package fr.esiag.isies.pds.model.staging.course;

/**
 * Class which represents Patient
 * @author PFR
 *
 */
public class Patient extends Person {
	
	/**
	 * Organization which is attached to the patient
	 */
	private Organization organization;
	
	private MedicalRecords medicalRecords;
	
	public MedicalRecords getMedicalRecords() {
		return medicalRecords;
	}
	
	public void setMedicalRecords(MedicalRecords medicalRecords) {
		this.medicalRecords = medicalRecords;
	}
	
	public Organization getOrganization() {
		return organization;
	}
	
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
}
