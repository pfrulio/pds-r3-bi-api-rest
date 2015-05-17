package fr.esiag.isies.pds.dao.production;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.esiag.isies.pds.model.production.intervention.Intervention;

/**
 * 
 * @author PFR
 *
 */
public class InterventionDao implements IDao<Intervention> {

	@Override
	public List<Intervention> getAllByDate(Date startDate, Date endDate) {
		// Session session = HibernateUtils.getSessionFactory().openSession();
		// session.beginTransaction();
		// @SuppressWarnings("unchecked")
		// List<Intervention> lst = (List<Intervention>) session
		// .createCriteria(Intervention.class)
		// .add(Restrictions.between("updateDate", startDate, endDate))
		// .list();
		// session.close();
		List<Intervention> lst = new ArrayList<Intervention>();
		return lst;
	}

}
