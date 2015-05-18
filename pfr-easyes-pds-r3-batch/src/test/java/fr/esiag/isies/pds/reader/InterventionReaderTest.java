package fr.esiag.isies.pds.reader;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import mockit.Mocked;
import mockit.NonStrictExpectations;

import org.junit.Before;
import org.junit.Test;

import fr.esiag.isies.pds.rest.client.InterventionClient;

public class InterventionReaderTest {

	@Mocked
	InterventionClient interventionClient;

	InterventionReader ir;

	@Before
	public void init() {
		new NonStrictExpectations() {
			{
				interventionClient.getRequest("", "");
				result = null;
			}
		};

		ir = new InterventionReader();
	}

	@Test
	public void testGetBeginDate() throws ParseException {

		DateFormat df = new SimpleDateFormat("ddMMyyyy");

		assertEquals("15121990", ir.getBeginDate(df.parse("22011991")));

		assertEquals("15011991", ir.getBeginDate(df.parse("22021991")));

		assertEquals("24021991", ir.getBeginDate(df.parse("31031991")));

	}

	@Test
	public void testGetEndDate() throws ParseException {

		DateFormat df = new SimpleDateFormat("ddMMyyyy");

		assertEquals("22121990", ir.getEndDate(df.parse("22011991")));

		assertEquals("22011991", ir.getEndDate(df.parse("22021991")));

		assertEquals("03031991", ir.getEndDate(df.parse("31031991")));

	}
}
