package expedicao.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import expedicao.comum.ComumHttpResponse;
import expedicao.dominio.entidade.*;
import expedicao.dominio.valueobject.orientacao.OrientacaoFactory;
import expedicao.exception.*;
import expedicao.rest.modelo.*;
import expedicao.servico.EntidadeServico;

@RequestScoped
@Path("superficies")
@Produces({ "application/json; charset=UTF-8" })
@Consumes({ "application/json" })
public class RestSuperficie {

	@POST
	public Response movimentar(SuperficieModel superficieModel){
		
		Superficie superficie = null;
		try {
			superficie = servico.salvarSuperficie(superficieModel);
		} catch (CoordenadaParseException ce){
			return ComumHttpResponse.construirComErrorModel(ce.getMessage(), Response.Status.BAD_REQUEST);
		}
		
		OrientacaoFactory factory = new OrientacaoFactory(superficie);
		List<Sonda> sondas = null;
		try {
			sondas = servico.salvarSondas(superficieModel.getSondas(), factory);
			sondas.forEach(s -> s.movimentar());
		} catch (ExpedicaoNasaException ee){
			servico.excluirSuperficie(superficie);
			return ComumHttpResponse.construirComErrorModel(ee.getMessage(), Response.Status.BAD_REQUEST);
		}
		
		SuperficieModel retorno = SuperficieModel.transformarBaseadoEm(superficie, sondas);
		return Response.status(Response.Status.CREATED).entity(retorno).build();
	}
	
	
	@GET
	@Path("{codigo}")
	public Response getSuperficie(@PathParam("codigo")int codigo){
		Superficie superficie = servico.getSuperficie(codigo);
		if (superficie == null){
			String mensagem = String.format("Superfície com código %s não encontrada", codigo);
			return ComumHttpResponse.construirComErrorModel(mensagem, Response.Status.NOT_FOUND);
		}
		
		List<Sonda> sondas = servico.getSondas(superficie);
		
		SuperficieModel retorno = SuperficieModel.transformarBaseadoEm(superficie, sondas);
		return Response.status(Response.Status.OK).entity(retorno).build();
	}
	
	@GET
	@Path("{codigo}/sondas/{sonda}")
	public Response getSonda(@PathParam("codigo")int codigo,
							 @PathParam("sonda")int ordem)
	{
		Superficie superficie = servico.getSuperficie(codigo);
		if (superficie == null){
			String mensagem = String.format("Superfície com código %s não encontrada", codigo);
			ComumHttpResponse.construirComErrorModel(mensagem, Response.Status.NOT_FOUND);
		}
		
		Sonda sonda = servico.getSonda(superficie, ordem);
		if (sonda == null){
			String mensagem = String.format("Sonda de ordem %s não encontrada", ordem);
			return ComumHttpResponse.construirComErrorModel(mensagem, Response.Status.NOT_FOUND);
		}
		
		SondaModel sondaModel = SondaModel.transformarBaseadoEm(sonda);
		return Response.status(Response.Status.OK).entity(sondaModel).build();
	}
	private EntidadeServico servico = new EntidadeServico();
}