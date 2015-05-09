import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("test")
public class TestREST {
	@Context
	private UriInfo context;

	@GET
	@Produces("Application/json")
	public String getXml() {
		System.out.println("toto");
		return "toto";
	}
}