package expedicao.comum;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import expedicao.rest.modelo.ErroModel;

public class ComumHttpResponse {

	public static Response construirComErrorModel(String mensagem, Status responseStatus){
		ErroModel erroModel = new ErroModel(mensagem);
		return Response.status(responseStatus).entity(erroModel).build();
	}
	
}
