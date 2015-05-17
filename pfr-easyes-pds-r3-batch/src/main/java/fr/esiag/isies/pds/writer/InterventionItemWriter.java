package fr.esiag.isies.pds.writer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import fr.esiag.isies.pds.dao.staging.InterventionDao;
import fr.esiag.isies.pds.model.production.intervention.Intervention;
import fr.esiag.isies.pds.utils.mapping.InterventionMapping;

/**
 * Write intervention into staging Database by production database
 * 
 * @author PFR
 *
 */
public class InterventionItemWriter implements ItemWriter<Intervention> {

	/**
	 * Logger.
	 */
	protected static final Logger LOGGER = LoggerFactory
			.getLogger(InterventionItemWriter.class);

	/**
	 * map production object into staging object
	 */
	private InterventionMapping interventionMapping;

	/**
	 * Staging Dao of Intervention item
	 */
	private InterventionDao interventionDao;
	
	public InterventionItemWriter() {
		interventionMapping = new InterventionMapping();
		interventionDao = new InterventionDao();
	}

	@Override
	public void write(List<? extends Intervention> interventions) throws Exception {
		LOGGER.info("PDS-R3-PFR : writer");
		for (Intervention intervention : interventions) {
			interventionDao.insert(interventionMapping.mapping(intervention));
		}
	}

}
