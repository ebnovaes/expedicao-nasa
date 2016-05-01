package expedicao.rest;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;

import expedicao.rest.modelo.SuperficieModel;

@RequestScoped
@Path("superficies")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class RestSuperficie {

	@POST
	public void movimentar(SuperficieModel superficie){  
		
	}
}