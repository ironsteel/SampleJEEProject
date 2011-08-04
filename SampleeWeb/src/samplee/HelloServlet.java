package samplee;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.samplee.*;




// The Java class will be hosted at the URI path "/helloworld"
@Path("/API")
public class HelloServlet {

	private SampleeFacade facade;
	
	public HelloServlet() { facade = new SampleeFacade(); }
	// The Java method will process HTTP GET requests
	@Path("/helloworld")
	@GET
	// The Java method will produce content identified by the MIME Media
	// type "text/plain"
	@Produces("text/plain")
	public String getSimpleString() {
		return facade.createSimpleString("Hello from sevlet");
	}
	
	@Path("/samplemodel")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SampleModel getSampleModel() {
		return facade.createSampleModel();
	}
}