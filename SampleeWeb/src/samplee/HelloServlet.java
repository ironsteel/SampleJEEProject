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




// The Java class will be hosted at the URI path "/helloworld"
@Path("/API")
public class HelloServlet {
	private static SampleeFacade facade = new SampleeFacade() ;
	
	@Path("helloworld")
	@GET
	public String getHelloWorld() {
		return "Hello from servlet";
	}
	
	
	@Path("/insert/{name}")
	@POST
	public void insertSampleModel(@PathParam("name")String name) {
		facade.insertSampleModel(name);
	}
	
	@Path("/getmodel/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SampleModel getSampleModel(@PathParam("id")Integer id) throws NotFoundException {
		return facade.getSampleModel(id);
	}
	
	@Path("update/{id}/{name}")
	@PUT
	public void updateSampleModel(@PathParam("id")Integer id, @PathParam("name")String name) {
		facade.updateSampleModel(id, name);		
	}
	
	@Path("delete/{id}")
	@DELETE
	public void deleteSampleModel(@PathParam("id")Integer id) {
		facade.deleteSampleModel(id);
	}
		
	
}