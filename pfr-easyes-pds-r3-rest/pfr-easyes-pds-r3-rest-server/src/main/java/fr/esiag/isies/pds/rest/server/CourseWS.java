package fr.esiag.isies.pds.rest.server;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.esiag.isies.pds.dao.production.CourseDao;
import fr.esiag.isies.pds.model.production.course.HealthPath;

/**
 * Webservice which exposed one method (get http request)
 * 
 * @author PFR
 *
 */
@Path("course-ws")
public class CourseWS {

	/**
	 * Logger
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CourseWS.class);

	@Context
	private UriInfo context;

	/**
	 * Dao for retrieve list of course
	 */
	private CourseDao courseDao = new CourseDao();

	/**
	 * this method is a restfull webservice which call production dao for
	 * retrieve all of courses by begin date and end date
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return response which contains all courses between begin and end date
	 *         and status 200 if everything is ok if it's not ok this method
	 *         return http code 400 (bad request)
	 * @throws Exception
	 */
	@Path("{beginDate}/{endDate}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCoursesByBeginAndEndDate(
			@PathParam("beginDate") String beginDateTxt,
			@PathParam("endDate") String endDateTxt) {
		DateFormat sdf = new SimpleDateFormat("ddMMyyyy", Locale.FRANCE);
		try {
			LOGGER.debug(beginDateTxt);
			Date beginDate = sdf.parse(beginDateTxt);
			Date endDate = sdf.parse(endDateTxt);
			LOGGER.debug("PDS-R3-PFR : begin date : " + sdf.format(beginDate));
			LOGGER.debug("PDS-R3-PFR : end date : " + sdf.format(endDate));
			// begin date must be before end date
			if (beginDate.after(endDate)) {
				LOGGER.info("PDS-R3-PFR : begin date must be before end date");
				return Response.status(400).build();
			} else {
				List<HealthPath> lst = courseDao.getAllByDate(beginDate,
						endDate);
				return Response.status(200).entity(lst).build();
			}
		} catch (ParseException e) {
			LOGGER.info("PDS-R3-PFR : date format error... (ddmmYYYY)");
			return Response.status(400).build();
		}
	}
}
