package fr.esiag.isies.pds.rest.server;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mockit.Mocked;
import mockit.NonStrictExpectations;

import org.junit.Before;
import org.junit.Test;

import fr.esiag.isies.pds.dao.production.InterventionDao;
import fr.esiag.isies.pds.model.production.intervention.Intervention;

/**
 * Unit Test for intervention WS
 * 
 * @author PFR
 *
 */
public class InterventionWSTest {

	private static final int BAD_REQUEST_CODE_SERVER = 400;

	private static final int OK_CODE_SERVER = 200;

	@Mocked
	private InterventionDao interventionDao;

	@Mocked
	private Intervention intervention;

	@Mocked
	Date startDate;

	@Mocked
	Date endDate;

	private InterventionWS interventionWS = new InterventionWS();

	List<Intervention> interventionList = new ArrayList<Intervention>();

	@Before
	public void init() {
		interventionList.add(intervention);
	}

	@Test
	public void testGetCourseByBeginAndEndDate() {
		new NonStrictExpectations() {
			{
				interventionDao.getAllByDate(startDate, endDate);
				result = interventionList;
			}
		};

		/*
		 * assert to verify when you have wrong format arguments, WS return code
		 * error 400
		 */
		assertEquals(BAD_REQUEST_CODE_SERVER, interventionWS
				.getInterventionsByBeginAndEndDate("", "").getStatus());

		/*
		 * assert to verify when you have valid arguments, WS return code 200
		 * (ok)
		 */
		assertEquals(OK_CODE_SERVER,
				interventionWS.getInterventionsByBeginAndEndDate("22012010", "30042015")
						.getStatus());
	}
}
