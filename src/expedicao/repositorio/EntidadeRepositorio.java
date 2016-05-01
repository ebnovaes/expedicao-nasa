package expedicao.repositorio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import expedicao.comum.ComumConstrucaoValueObject;
import expedicao.dominio.entidade.Sonda;
import expedicao.dominio.entidade.Superficie;
import expedicao.dominio.valueobject.Coordenada;
import expedicao.dominio.valueobject.Posicao;
import expedicao.dominio.valueobject.orientacao.OrientacaoFactory;
import expedicao.exception.CoordenadaParseException;
import expedicao.exception.PosicaoParseException;
import expedicao.rest.modelo.SondaModel;
import expedicao.rest.modelo.SuperficieModel;

public class EntidadeRepositorio {

	private EntidadeRepositorio() {
		this.superficies = new ArrayList<Superficie>();
	}

	public List<Superficie> getSuperficies() {
		return new ArrayList<Superficie>(this.superficies);
	}
	
	public List<Sonda> getSondas(Superficie superficie) {
		ArrayList<Sonda> retorno = new ArrayList<>();
		sondas.stream()
			  .filter(so -> so.getSuperficie().equals(superficie))
			  .sorted(Comparator.comparing(st -> st.getOrdem()))
			  .collect(Collectors.toList());
		
		return retorno;
	}
	public Superficie getSuperficie(int codigo) {
		for (Superficie s : superficies) {
			if (s.getCodigo() == codigo) {
				return s;
			}
		}
    	return null;
	}
	
	public Superficie salvarSuperficie(SuperficieModel superficieModel) throws CoordenadaParseException{
		Coordenada coordenadaSuperficie = ComumConstrucaoValueObject.getCoordenadas(superficieModel.getCoordenadasLimite());
		int ultimoCodigo = 
				this.superficies.stream().max(Comparator.comparing(s -> s.getCodigo())).get().getCodigo();
		Superficie superficie = new Superficie(ultimoCodigo++, coordenadaSuperficie);
		this.superficies.add(superficie);
		return superficie;
	}
	
	public List<Sonda> salvarSondas(List<SondaModel> sondas, Superficie superficie, OrientacaoFactory orientacaoFactory) throws PosicaoParseException{
		int ultimoElemento = 
				this.sondas.stream().filter(f -> f.getSuperficie().equals(superficie))
				    .max(Comparator.comparing(s -> s.getOrdem()))
				    .get()
				    .getOrdem();
		
		List<Sonda> retorno = new ArrayList<Sonda>();
		for (SondaModel s : sondas){
			Posicao posicao = ComumConstrucaoValueObject.getPosicao(s.getPosicao(), orientacaoFactory);
			Sonda sonda = new Sonda(posicao, superficie, ultimoElemento++, s.getMovimento());
			this.sondas.add(sonda);	
			retorno.add(sonda);
		}
		
		return retorno;
	}

	public static EntidadeRepositorio getInstancia() {
		return instancia;
	}
	
	private static EntidadeRepositorio instancia = new EntidadeRepositorio();

	private List<Superficie> superficies;
	
	private List<Sonda> sondas;
}
