package fr.esiag.isies.pds.dao.staging;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.esiag.isies.pds.dao.staging.utils.HibernateUtils;
import fr.esiag.isies.pds.model.staging.course.HealthPath;

/**
 * Course DAO for staging database
 * 
 * @author PFR
 *
 */
public class CourseDao implements IDao<HealthPath> {

	@Override
	public Boolean insert(HealthPath item) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(item.getMedicalRecords().getPatient()
				.getOrganization().getOrganizationType());
		session.saveOrUpdate(item.getMedicalRecords().getPatient()
				.getOrganization());
		session.save(item.getMedicalRecords().getPatient());
		session.save(item.getMedicalRecords());
		session.save(item.getHealthPathBill());
		session.save(item);
		tr.commit();
		session.close();
		return true;
	}

}
