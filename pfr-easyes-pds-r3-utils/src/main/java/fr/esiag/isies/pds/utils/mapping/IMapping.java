package fr.esiag.isies.pds.utils.mapping;

/**
 * mapping X object into Y object
 * 
 * @author PFR
 *
 * @param <X>
 * @param <Y>
 */
public interface IMapping<X, Y> {

	/**
	 * Map item (X) into Y object
	 * 
	 * @param item
	 *            X
	 * @return Y object which mapped by an item X
	 */
	Y mapping(X item);
}
