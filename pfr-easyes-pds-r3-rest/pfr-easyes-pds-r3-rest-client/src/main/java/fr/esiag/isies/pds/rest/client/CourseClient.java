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

import fr.esiag.isies.pds.model.HealthPath;

public class CourseClient {

	private static final String BASE_URI = "http://localhost:8080/pfr-easyes-pds-r3-rest-server/rest/";

	private static final String COURSE_WS = "course-ws";

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

	public static void main(String[] args) {
		CourseClient client = new CourseClient();
		client.getRequest("12122012", "12122012");
	}
}
