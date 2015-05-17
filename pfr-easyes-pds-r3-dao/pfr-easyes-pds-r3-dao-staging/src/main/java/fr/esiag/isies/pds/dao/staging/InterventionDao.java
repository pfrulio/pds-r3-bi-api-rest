package fr.esiag.isies.pds.dao.staging;

import fr.esiag.isies.pds.model.staging.intervention.Intervention;

/**
 * Intervention DAO for staging database
 * 
 * @author PFR
 *
 */
public class InterventionDao implements IDao<Intervention> {

	@Override
	public Boolean insert(Intervention item) {
//		Session session = HibernateUtils.getSessionFactory().openSession();
//		Transaction tr = session.beginTransaction();
//		session.saveOrUpdate(item.getMedicalRecords().getPatient()
//				.getOrganization().getOrganizationType());
//		session.saveOrUpdate(item.getMedicalRecords().getPatient()
//				.getOrganization());
//		session.save(item.getMedicalRecords().getPatient());
//		session.save(item.getMedicalRecords());
//		session.save(item.getHealthPathBill());
//		session.save(item);
//		tr.commit();
//		session.close();
		return true;
	}

}
