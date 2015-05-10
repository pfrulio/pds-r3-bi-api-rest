package fr.esiag.isies.pds.utils.mapping;

import fr.esiag.isies.pds.model.staging.course.HealthPath;
import fr.esiag.isies.pds.model.staging.course.HealthPathBill;
import fr.esiag.isies.pds.model.staging.course.MedicalRecords;
import fr.esiag.isies.pds.model.staging.course.Organization;
import fr.esiag.isies.pds.model.staging.course.OrganizationType;
import fr.esiag.isies.pds.model.staging.course.Patient;

/**
 * Map HealthPath production into HealthPath Staging
 * @author PFR
 *
 */
public class CourseMapping implements
		IMapping<fr.esiag.isies.pds.model.production.course.HealthPath, HealthPath> {

	@Override
	public HealthPath mapping(
			fr.esiag.isies.pds.model.production.course.HealthPath item) {
		HealthPath mapObject = new HealthPath();

		mapObject.setCreateDate(item.getCreateDate());
		mapObject.setEndDate(item.getEndDate());
		mapObject.setId(item.getId());
		mapObject.setUpdateDate(item.getUpdateDate());
		mapObject.setUpdateUser(item.getUpdateUser());

		mapObject.setMedicalRecords(new MedicalRecords());
		mapObject.getMedicalRecords().setCreateDate(
				item.getMedicalRecords().getCreateDate());
		mapObject.getMedicalRecords().setId(item.getMedicalRecords().getId());
		mapObject.getMedicalRecords().setUpdateDate(
				item.getMedicalRecords().getUpdateDate());
		mapObject.getMedicalRecords().setUpdateUser(
				item.getMedicalRecords().getUpdateUser());

		mapObject.getMedicalRecords().setPatient(new Patient());
		mapObject
				.getMedicalRecords()
				.getPatient()
				.setCreateDate(
						item.getMedicalRecords().getPatient().getCreateDate());
		mapObject
				.getMedicalRecords()
				.getPatient()
				.setFirstName(
						item.getMedicalRecords().getPatient().getFirstName());
		mapObject
				.getMedicalRecords()
				.getPatient()
				.setLastName(
						item.getMedicalRecords().getPatient().getLastName());
		mapObject.getMedicalRecords().getPatient()
				.setId(item.getMedicalRecords().getPatient().getId());
		mapObject
				.getMedicalRecords()
				.getPatient()
				.setUpdateDate(
						item.getMedicalRecords().getPatient().getUpdateDate());
		mapObject
				.getMedicalRecords()
				.getPatient()
				.setUpdateUser(
						item.getMedicalRecords().getPatient().getUpdateUser());

		mapObject.getMedicalRecords().getPatient()
				.setOrganization(new Organization());
		mapObject
				.getMedicalRecords()
				.getPatient()
				.getOrganization()
				.setCreateDate(
						item.getMedicalRecords().getPatient().getOrganization()
								.getCreateDate());
		mapObject
				.getMedicalRecords()
				.getPatient()
				.getOrganization()
				.setId(item.getMedicalRecords().getPatient().getOrganization()
						.getId());
		mapObject
				.getMedicalRecords()
				.getPatient()
				.getOrganization()
				.setLatitude(
						item.getMedicalRecords().getPatient().getOrganization()
								.getLatitude());
		mapObject
				.getMedicalRecords()
				.getPatient()
				.getOrganization()
				.setLongitude(
						item.getMedicalRecords().getPatient().getOrganization()
								.getLongitude());
		mapObject
				.getMedicalRecords()
				.getPatient()
				.getOrganization()
				.setName(
						item.getMedicalRecords().getPatient().getOrganization()
								.getName());
		mapObject
				.getMedicalRecords()
				.getPatient()
				.getOrganization()
				.setUpdateDate(
						item.getMedicalRecords().getPatient().getOrganization()
								.getUpdateDate());
		mapObject
				.getMedicalRecords()
				.getPatient()
				.getOrganization()
				.setUpdateUser(
						item.getMedicalRecords().getPatient().getOrganization()
								.getUpdateUser());

		mapObject.getMedicalRecords().getPatient().getOrganization()
				.setOrganizationType(new OrganizationType());
		mapObject
				.getMedicalRecords()
				.getPatient()
				.getOrganization()
				.getOrganizationType()
				.setCode(
						item.getMedicalRecords().getPatient().getOrganization()
								.getOrganizationType().getCode());
		mapObject
				.getMedicalRecords()
				.getPatient()
				.getOrganization()
				.getOrganizationType()
				.setCreateDate(
						item.getMedicalRecords().getPatient().getOrganization()
								.getOrganizationType().getCreateDate());
		mapObject
				.getMedicalRecords()
				.getPatient()
				.getOrganization()
				.getOrganizationType()
				.setDescription(
						item.getMedicalRecords().getPatient().getOrganization()
								.getOrganizationType().getDescription());
		mapObject
				.getMedicalRecords()
				.getPatient()
				.getOrganization()
				.getOrganizationType()
				.setId(item.getMedicalRecords().getPatient().getOrganization()
						.getOrganizationType().getId());
		mapObject
				.getMedicalRecords()
				.getPatient()
				.getOrganization()
				.getOrganizationType()
				.setUpdateDate(
						item.getMedicalRecords().getPatient().getOrganization()
								.getOrganizationType().getUpdateDate());
		mapObject
				.getMedicalRecords()
				.getPatient()
				.getOrganization()
				.getOrganizationType()
				.setUpdateUser(
						item.getMedicalRecords().getPatient().getOrganization()
								.getOrganizationType().getUpdateUser());

		mapObject.setHealthPathBill(createBill());

		return mapObject;
	}

	/**
	 * HealthPathBill mock for add bill information to heatlhpath object
	 * @return HealthPathBill with random information
	 */
	private HealthPathBill createBill() {
		HealthPathBill tmp = new HealthPathBill();
		// random to simulate if the bill is paid
		int testPaid = (int) (Math.random() * 100);
		if (testPaid < 10) {
			tmp.setPaid(false);
		} else if (testPaid < 15) {
			int testPaid2 = (int) (Math.random() * 10);
			if (testPaid2 < 8) {
				tmp.setPaid(false);
			} else {
				tmp.setPaid(true);
			}
		} else {
			tmp.setPaid(true);
		}
		
		//Random to simulate amount of the bill
		int testAmount = (int)(Math.random() * 100);
		// 60% < 50
		if (testAmount <= 60) {
			tmp.setAmount((float) (1 + Math.random() * 50));
		} else {
			int testAmount2 = (int)(Math.random() * 100);
			// 50 < 24% < 100
			if (testAmount2 <= 60) {
				tmp.setAmount((float)(50 + Math.random() * 50));
			} else {
				//16% > 100
				tmp.setAmount((float)(100 + Math.random() * 200));
			}
		}

		return tmp;
	}
}
