package fr.esiag.isies.pds.writer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import fr.esiag.isies.pds.dao.staging.CourseDao;
import fr.esiag.isies.pds.model.production.course.HealthPath;
import fr.esiag.isies.pds.utils.mapping.CourseMapping;

/**
 * Write Health Pah into staging Database by production database
 * 
 * @author PFR
 *
 */
public class CourseItemWriter implements ItemWriter<HealthPath> {

	/**
	 * Logger.
	 */
	protected static final Logger LOGGER = LoggerFactory
			.getLogger(CourseItemWriter.class);

	/**
	 * map production object into staging object
	 */
	private CourseMapping courseMapping;

	/**
	 * Staging Dao of Course item
	 */
	private CourseDao courseDao;
	
	public CourseItemWriter() {
		courseMapping = new CourseMapping();
		courseDao = new CourseDao();
	}

	@Override
	public void write(List<? extends HealthPath> healthPaths) throws Exception {
		LOGGER.info("PDS-R3-PFR : writer");
		for (HealthPath healthPath : healthPaths) {
			courseDao.insert(courseMapping.mapping(healthPath));
		}
	}

}
