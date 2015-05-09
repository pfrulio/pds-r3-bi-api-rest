package fr.esiag.isies.pds.reader;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import fr.esiag.isies.pds.model.HealthPath;
import fr.esiag.isies.pds.rest.client.CourseClient;

/**
 * Call CourseWS to read courses from production database
 * 
 * @author Peter
 *
 */
public class CoursesReader implements ItemReader<List<HealthPath>> {

	/**
	 * Logger.
	 */
	protected static final Logger LOGGER = LoggerFactory
			.getLogger(CoursesReader.class);

	private int counter;

	private CourseClient courseClient;

	public CoursesReader() {
		courseClient = new CourseClient();
		counter = 0;
	}

	@Override
	public List<HealthPath> read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		
		if (counter == 0) {
			LOGGER.info("PDS-R3-PFR : Read list of Path");
			counter++;
			return courseClient.getRequest("12122012", "13122012");
		} else {
			return null;
		}
	}
	
	public String getBeginDate() {
		Date date = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		if (cal.get(Calendar.MONTH) == 0) {
			
		}
		return null;
	}
	
	public String getEndDate() {
		return null;
		
	}
}
