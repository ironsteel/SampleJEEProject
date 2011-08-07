package samplee;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
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
	private SampleeFacade facade;

	public HelloServlet() throws NamingException {
		Context context = new InitialContext();
		facade = (SampleeFacade) context
				.lookup("java:comp/env/ejb/SampleeFacade");
	}

	@Path("/samplemodel/new")
	@POST
	public void insertSampleModel(SampleModel model) {
		facade.insertSampleModel(model);
	}

	/*@Path("/samplemodel/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SampleModel getSampleModel(@PathParam("id") Integer id)
			throws NotFoundException {
		return facade.getSampleModel(id);
	}*/

	@Path("/samplemodel/{name}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SampleModel getSampleModelByName(@PathParam("name") String name) {
		return facade.getSampleModelByName(name);
	}

	@Path("samplemodel/update")
	@PUT
	public void updateSampleModel(SampleModel model) {
		facade.updateSampleModel(model);
	}

	@Path("samplemodel/delete/{name}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteSampleModel(@PathParam("name")String name) {
		facade.deleteSampleModelByName(name);
	}

	@Path("samplemodel/all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<SampleModel> getAll() {
		return facade.getAll();
	}
	
	@Path("samplemodel/deleteall")
	@DELETE
	public void deleteAll() {
		facade.deleteAll();
	}

}