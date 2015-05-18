package fr.esiag.isies.pds.utils.mapping;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.esiag.isies.pds.model.production.course.HealthPath;
import fr.esiag.isies.pds.model.production.course.MedicalRecords;
import fr.esiag.isies.pds.model.production.course.Organization;
import fr.esiag.isies.pds.model.production.course.OrganizationType;
import fr.esiag.isies.pds.model.production.course.Patient;

public class CourseMappingTest {

	CourseMapping courseMapping = new CourseMapping();

	@Test
	public void mappingTest() {
		// production Object
		OrganizationType ot = new OrganizationType();
		ot.setCode("toto");
		ot.setDescription("unit test");

		Organization o = new Organization();
		o.setOrganizationType(ot);
		o.setName("titi");

		Patient p = new Patient();
		p.setOrganization(o);
		p.setFirstName("tutu");
		p.setLastName("tata");

		MedicalRecords mr = new MedicalRecords();
		mr.setPatient(p);

		HealthPath hp = new HealthPath();
		hp.setMedicalRecords(mr);

		// staging Object
		fr.esiag.isies.pds.model.staging.course.OrganizationType ot2 = new fr.esiag.isies.pds.model.staging.course.OrganizationType();
		ot2.setCode("toto");
		ot2.setDescription("unit test");

		fr.esiag.isies.pds.model.staging.course.Organization o2 = new fr.esiag.isies.pds.model.staging.course.Organization();
		o2.setOrganizationType(ot2);
		o2.setName("titi");

		fr.esiag.isies.pds.model.staging.course.Patient p2 = new fr.esiag.isies.pds.model.staging.course.Patient();
		p2.setOrganization(o2);
		p2.setFirstName("tutu");
		p2.setLastName("tata");

		fr.esiag.isies.pds.model.staging.course.MedicalRecords mr2 = new fr.esiag.isies.pds.model.staging.course.MedicalRecords();
		mr2.setPatient(p2);

		fr.esiag.isies.pds.model.staging.course.HealthPath hp2 = new fr.esiag.isies.pds.model.staging.course.HealthPath();
		hp2.setMedicalRecords(mr2);

		fr.esiag.isies.pds.model.staging.course.HealthPath hp3 = courseMapping
				.mapping(hp);

		assertEquals(hp2.getMedicalRecords().getPatient().getOrganization()
				.getOrganizationType().getCode(), hp3.getMedicalRecords()
				.getPatient().getOrganization().getOrganizationType().getCode());

		assertEquals(hp2.getMedicalRecords().getPatient().getOrganization()
				.getOrganizationType().getDescription(), hp3
				.getMedicalRecords().getPatient().getOrganization()
				.getOrganizationType().getDescription());

		assertEquals(hp2.getMedicalRecords().getPatient().getOrganization()
				.getName(), hp3.getMedicalRecords().getPatient()
				.getOrganization().getName());

		assertEquals(hp2.getMedicalRecords().getPatient().getFirstName(), hp3
				.getMedicalRecords().getPatient().getFirstName());

		assertEquals(hp2.getMedicalRecords().getPatient().getLastName(), hp3
				.getMedicalRecords().getPatient().getLastName());
	}
}
