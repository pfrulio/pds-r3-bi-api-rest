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

import fr.esiag.isies.pds.model.production.intervention.Intervention;
import fr.esiag.isies.pds.rest.client.InterventionClient;

/**
 * Call InterventionWS to read courses from production database
 * 
 * @author PFR
 *
 */
public class InterventionReader implements ItemReader<Intervention> {

	/**
	 * Logger.
	 */
	protected static final Logger LOGGER = LoggerFactory
			.getLogger(InterventionReader.class);

	private int counter;

	private InterventionClient interventionClient;

	private List<Intervention> interventions;

	/**
	 * create intervention client and get all courses which are in the database
	 */
	public InterventionReader() {
		interventionClient = new InterventionClient();
		counter = 0;
		Date today = new Date();
		interventions = interventionClient.getRequest(getBeginDate(today),
				getEndDate(today));
	}

	/**
	 * read the interventions list while exist another element to read
	 */
	@Override
	public Intervention read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		LOGGER.info("Nb of Interventions : " + interventions.size());
		if (counter < interventions.size()) {
			LOGGER.info("PDS-R3-PFR : Read list of intervention");
			Intervention temp = interventions.get(counter);
			counter++;
			return temp;
		} else {
			return null;
		}
	}

	/**
	 * get one month + one week before today date
	 * @param date
	 * @return
	 */
	public String getBeginDate(Date date) {
		DateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) - 7);
		return sdf.format(cal.getTime());
	}

	/**
	 * get one month before today date
	 * @param date
	 * @return
	 */
	public String getEndDate(Date date) {
		DateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
		return sdf.format(cal.getTime());

	}
}
