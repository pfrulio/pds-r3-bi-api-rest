package fr.esiag.isies.pds.dao.staging;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.esiag.isies.pds.dao.staging.utils.HibernateUtils;
import fr.esiag.isies.pds.model.staging.course.HealthPath;

public class CourseDao implements IDao<HealthPath> {

	@Override
	public Boolean insert(HealthPath item) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
//		session.merge(item.getMedicalRecords().getPatient().getOrganization()
//				.getOrganizationType());
//		session.merge(item.getMedicalRecords().getPatient().getOrganization());
//		session.merge(item.getMedicalRecords().getPatient());
//		session.merge(item.getMedicalRecords());
		session.save(item.getMedicalRecords().getPatient().getOrganization().getOrganizationType());
		session.save(item.getMedicalRecords().getPatient().getOrganization());
		session.save(item.getMedicalRecords().getPatient());
		session.save(item.getMedicalRecords());
		System.out.println(item.getHealthPathBill().getAmount());
		session.save(item.getHealthPathBill());
		session.save(item);
		tr.commit();
		return true;
	}

}
