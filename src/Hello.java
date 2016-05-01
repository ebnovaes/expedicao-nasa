import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Hello {

	@POST
	@Path("sayHello")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Mensagem sayHello(Mensagem mensagem){
		return //"hello, " + name;
				new Mensagem(mensagem);
	}

}
