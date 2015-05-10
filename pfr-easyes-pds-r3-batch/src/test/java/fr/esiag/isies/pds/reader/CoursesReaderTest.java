package fr.esiag.isies.pds.reader;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

public class CoursesReaderTest {
	
	CoursesReader cr = new CoursesReader();
	
	@Test
	public void testGetBeginDate() throws ParseException {
		
		DateFormat df = new SimpleDateFormat("ddMMyyyy");
		
		assertEquals("15121990", cr.getBeginDate(df.parse("22011991")));
		
		assertEquals("15011991", cr.getBeginDate(df.parse("22021991")));
		
		assertEquals("24021991", cr.getBeginDate(df.parse("31031991")));
		
	}
}
