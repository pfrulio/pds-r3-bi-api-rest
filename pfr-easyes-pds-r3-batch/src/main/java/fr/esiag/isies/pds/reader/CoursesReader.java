package fr.esiag.isies.pds.reader;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import fr.esiag.isies.pds.model.production.course.HealthPath;
import fr.esiag.isies.pds.rest.client.CourseClient;

/**
 * Call CourseWS to read courses from production database
 * 
 * @author Peter
 *
 */
public class CoursesReader implements ItemReader<HealthPath> {

	/**
	 * Logger.
	 */
	protected static final Logger LOGGER = LoggerFactory
			.getLogger(CoursesReader.class);

	private int counter;

	private CourseClient courseClient;

	private List<HealthPath> courses;

	/**
	 * create course client and get all courses which are in the database
	 */
	public CoursesReader() {
		courseClient = new CourseClient();
		counter = 0;
		Date today = new Date();
		courses = courseClient.getRequest(getBeginDate(today),
				getEndDate(today));
	}

	/**
	 * read the courses list while exist another element to read
	 */
	@Override
	public HealthPath read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		LOGGER.info("Nb of HealthPath : " + courses.size());
		if (counter < courses.size()) {
			LOGGER.info("PDS-R3-PFR : Read list of Path");
			HealthPath temp = courses.get(counter);
			counter++;
			return temp;
		} else {
			return null;
		}
	}

	public String getBeginDate(Date date) {
		DateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) - 7);
		return sdf.format(cal.getTime());
	}

	public String getEndDate(Date date) {
		DateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
		return sdf.format(cal.getTime());

	}
}
