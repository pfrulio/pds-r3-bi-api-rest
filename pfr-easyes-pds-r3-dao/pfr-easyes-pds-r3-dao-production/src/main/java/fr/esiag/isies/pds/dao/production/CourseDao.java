package fr.esiag.isies.pds.dao.production;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import fr.esiag.isies.pds.dao.production.utils.HibernateUtils;
import fr.esiag.isies.pds.model.production.course.HealthPath;

public class CourseDao implements IDao<HealthPath> {

	@Override
	public List<HealthPath> getAllByDate(Date startDate, Date endDate) {
		 Session session = HibernateUtils.getSessionFactory().openSession();
		 session.beginTransaction();
		 @SuppressWarnings("unchecked")
		 List<HealthPath> lst = (List<HealthPath>) session
		 .createCriteria(HealthPath.class)
		 .add(Restrictions.between("endDate", startDate, endDate)).list();
		 session.close();
		 return lst;
	}

}
