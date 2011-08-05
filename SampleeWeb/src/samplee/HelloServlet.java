package samplee;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import com.samplee.*;
import com.sun.jersey.api.NotFoundException;

@Path("/API")
public class HelloServlet {
	private static SampleeFacade facade = new SampleeFacade() ;
	
	@Path("helloworld")
	@GET
	public String getHelloWorld() {
		return "Hello from servlet";
	}
	
	
	@Path("/samplemodel/new")
	@POST
	public void insertSampleModel(SampleModel model) {
		facade.insertSampleModel(model);
	}
	
	@Path("/samplemodel/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SampleModel getSampleModel(@PathParam("id")Integer id) throws NotFoundException {
		return facade.getSampleModel(id);
	}
	
	@Path("samplemodel/update")
	@PUT
	public void updateSampleModel(SampleModel model) {
		facade.updateSampleModel(model);		
	}
	
	@Path("samplemodel/{id}")
	@DELETE
	public void deleteSampleModel(@PathParam("id")Integer id) {
		facade.deleteSampleModel(id);
	}
		
	
}