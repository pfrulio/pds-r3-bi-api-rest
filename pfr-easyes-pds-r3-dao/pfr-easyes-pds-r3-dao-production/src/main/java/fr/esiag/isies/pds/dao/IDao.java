package fr.esiag.isies.pds.dao;

import java.util.Date;
import java.util.List;

/**
 * This interface must implement by all DAO and show the method which must be
 * overriden by all DAO
 * 
 * @author PFR
 *
 * @param <T>
 *            represents object which is persist in database
 */
public interface IDao<T> {

	/**
	 * This method select in database all data which are insert or update after
	 * the start date
	 * 
	 * @param startDate
	 * @return all object which is create or insert after the start date
	 */
	List<T> getAllByDate(Date startDate, Date endDate);

}
