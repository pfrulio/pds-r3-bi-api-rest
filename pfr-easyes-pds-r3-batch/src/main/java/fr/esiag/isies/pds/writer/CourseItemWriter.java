package fr.esiag.isies.pds.writer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import fr.esiag.isies.pds.model.HealthPath;

public class CourseItemWriter implements ItemWriter<HealthPath> {
	
	/**
	 * Logger.
	 */
	protected static final Logger LOGGER = LoggerFactory
			.getLogger(CourseItemWriter.class);
	
	@Override
	public void write(List<? extends HealthPath> healthPaths) throws Exception {
		LOGGER.info("PDS-R3-PFR : writer");
		LOGGER.info("PDS-R3-PFR : " + healthPaths.get(0).getMedicalRecords().getPatient().getFirstName());
	}
	
}
