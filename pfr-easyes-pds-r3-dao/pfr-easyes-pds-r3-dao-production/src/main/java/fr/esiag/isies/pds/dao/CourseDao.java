package fr.esiag.isies.pds.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.esiag.isies.pds.model.HealthPath;
import fr.esiag.isies.pds.model.MedicalRecords;
import fr.esiag.isies.pds.model.Organization;
import fr.esiag.isies.pds.model.OrganizationType;
import fr.esiag.isies.pds.model.Patient;

public class CourseDao implements IDao<HealthPath> {

	@Override
	public List<HealthPath> getAllByDate(Date startDate, Date endDate) {
		// Session session = HibernateUtils.getSessionFactory().openSession();
		// session.beginTransaction();
		// @SuppressWarnings("unchecked")
		// List<HealthPath> lst = (List<HealthPath>) session
		// .createCriteria(HealthPath.class)
		// .add(Restrictions.between("date", startDate, new Date())).list();
		// session.close();
		// return lst;
		OrganizationType organizationType = new OrganizationType();
		organizationType.setDescription("Hôpital Public");
		Organization organization = new Organization();
		organization.setOrganizationType(organizationType);
		organization.setLatitude(new Float(11.11));
		organization.setLongitude(new Float(11.11));
		organization.setName("Groupe Hospitalier Pitiée Salpétrière");
		Patient patient = new Patient();
		patient.setFirstname("Toto");
		patient.setLastname("titi");
		patient.setOrganization(organization);
		MedicalRecords mr = new MedicalRecords();
		mr.setPatient(patient);
		HealthPath hp = new HealthPath();
		hp.setMedicalRecords(mr);

		List<HealthPath> hps = new ArrayList<HealthPath>();
		hps.add(hp);
		return hps;
	}

}
