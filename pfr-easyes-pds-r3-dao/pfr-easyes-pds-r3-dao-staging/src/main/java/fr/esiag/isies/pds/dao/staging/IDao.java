package fr.esiag.isies.pds.dao.staging;


/**
 * This interface must implement by all DAO and show the method which must be
 * overriden by all DAO for staging database
 * 
 * @author PFR
 *
 * @param <T>
 *            represents object which is persist in database
 */
public interface IDao<T> {

	/**
	 * This method insert in the staging database an item
	 * 
	 * @param item
	 * @return true if insert was ok
	 */
	Boolean insert(T item);

}
