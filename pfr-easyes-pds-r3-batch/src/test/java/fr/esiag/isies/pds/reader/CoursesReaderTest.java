package fr.esiag.isies.pds.reader;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import mockit.Mocked;
import mockit.NonStrictExpectations;

import org.junit.Before;
import org.junit.Test;

import fr.esiag.isies.pds.rest.client.CourseClient;

public class CoursesReaderTest {

	@Mocked
	CourseClient courseClient;

	CoursesReader cr;

	@Before
	public void init() {
		new NonStrictExpectations() {
			{
				courseClient.getRequest("", "");
				result = null;
			}
		};

		cr = new CoursesReader();
	}

	@Test
	public void testGetBeginDate() throws ParseException {

		DateFormat df = new SimpleDateFormat("ddMMyyyy");

		assertEquals("15121990", cr.getBeginDate(df.parse("22011991")));

		assertEquals("15011991", cr.getBeginDate(df.parse("22021991")));

		assertEquals("24021991", cr.getBeginDate(df.parse("31031991")));

	}

	@Test
	public void testGetEndDate() throws ParseException {

		DateFormat df = new SimpleDateFormat("ddMMyyyy");

		assertEquals("22121990", cr.getEndDate(df.parse("22011991")));

		assertEquals("22011991", cr.getEndDate(df.parse("22021991")));

		assertEquals("03031991", cr.getEndDate(df.parse("31031991")));

	}
}
