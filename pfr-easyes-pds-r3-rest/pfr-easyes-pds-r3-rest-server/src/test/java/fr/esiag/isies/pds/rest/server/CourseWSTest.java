package fr.esiag.isies.pds.rest.server;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mockit.Mocked;
import mockit.NonStrictExpectations;

import org.junit.Before;
import org.junit.Test;

import fr.esiag.isies.pds.dao.production.CourseDao;
import fr.esiag.isies.pds.model.production.course.HealthPath;

/**
 * Unit Test for course WS
 * 
 * @author PFR
 *
 */
public class CourseWSTest {

	private static final int BAD_REQUEST_CODE_SERVER = 400;

	private static final int OK_CODE_SERVER = 200;

	@Mocked
	private CourseDao courseDao;

	@Mocked
	private HealthPath hp;

	@Mocked
	Date startDate;

	@Mocked
	Date endDate;

	private CourseWS courseWS = new CourseWS();

	List<HealthPath> lstHp = new ArrayList<HealthPath>();

	@Before
	public void init() {
		lstHp.add(hp);
	}

	@Test
	public void testGetCourseByBeginAndEndDate() {
		new NonStrictExpectations() {
			{
				courseDao.getAllByDate(startDate, endDate);
				result = lstHp;
			}
		};

		/*
		 * assert to verify when you have wrong format arguments, WS return code error
		 * 400
		 */
		assertEquals(BAD_REQUEST_CODE_SERVER,
				courseWS.getCoursesByBeginAndEndDate("", "").getStatus());

		/*
		 * assert to verify when you have valid arguments, WS return code
		 * 200 (ok)
		 */
		assertEquals(OK_CODE_SERVER,
				courseWS.getCoursesByBeginAndEndDate("22012010", "30042015").getStatus());
	}
}
