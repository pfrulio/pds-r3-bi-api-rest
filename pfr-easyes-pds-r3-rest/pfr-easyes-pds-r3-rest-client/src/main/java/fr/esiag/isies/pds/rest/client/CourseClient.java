package fr.esiag.isies.pds.rest.client;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import fr.esiag.isies.pds.model.production.course.HealthPath;

/**
 * rest client for course ws
 * 
 * @author PFR
 *
 */
public class CourseClient {

	/**
	 * Base URI
	 */
	private static final String BASE_URI = "http://localhost:8080/pfr-easyes-pds-r3-rest-server/rest/";

	/**
	 * path of Course WS
	 */
	private static final String COURSE_WS = "course-ws";

	/**
	 * Request Course WS to get lst of courses which are closed between begin
	 * date and end date
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return list of courses
	 */
	public List<HealthPath> getRequest(String beginDate, String endDate) {
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(BASE_URI + COURSE_WS + "/"
				+ beginDate + "/" + endDate);
		webResource.accept(MediaType.APPLICATION_JSON);

		ClientResponse response = webResource.get(ClientResponse.class);
		List<HealthPath> lst = response
				.getEntity(new GenericType<List<HealthPath>>() {
				});

		return lst;

	}
}
