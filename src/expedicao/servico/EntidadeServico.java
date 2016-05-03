package expedicao.servico;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import expedicao.comum.ComumConstrucaoValueObject;
import expedicao.dominio.entidade.Sonda;
import expedicao.dominio.entidade.Superficie;
import expedicao.dominio.valueobject.Coordenada;
import expedicao.dominio.valueobject.Posicao;
import expedicao.dominio.valueobject.orientacao.OrientacaoFactory;
import expedicao.exception.CoordenadaParseException;
import expedicao.exception.ExpedicaoNasaException;
import expedicao.repositorio.EntidadeRepositorio;
import expedicao.rest.modelo.SondaModel;
import expedicao.rest.modelo.SuperficieModel;

public class EntidadeServico {

	public EntidadeServico(EntidadeRepositorio entidadeRepositorio) {
		this.repositorio = entidadeRepositorio;
	}

	public List<Superficie> getSuperficies() {
		return new ArrayList<Superficie>(repositorio.getSuperficies());
	}
	
	public List<Sonda> getSondas(Superficie superficie) {
		List<Sonda> sondas = repositorio.getSondas();
		List<Sonda> retorno =
				sondas.stream()
					  .filter(so -> so.getSuperficie().equals(superficie))
					  .sorted(Comparator.comparing(st -> st.getOrdem()))
					  .collect(Collectors.toList());
		
		return retorno;
	}

	public Sonda getSonda(Superficie superficie, int ordem) {
		Optional<Sonda> opt =
			this.getSondas(superficie)
				.stream()
				.filter(s -> s.getOrdem() == ordem)
				.findFirst();
		
		if (opt.isPresent()){
			return opt.get();
		}
		
		return null;
	}
	
	public Superficie getSuperficie(int codigo) {
		List<Superficie> superficies = repositorio.getSuperficies();
		for (Superficie s : superficies) {
			if (s.getCodigo() == codigo) {
				return s;
			}
		}
    	return null;
	}
	
	public Superficie salvarSuperficie(SuperficieModel superficieModel) throws CoordenadaParseException{
		Coordenada coordenadaSuperficie = ComumConstrucaoValueObject.getCoordenadas(superficieModel.getCoordenadasLimite());
		int max = repositorio.getMaxSuperficieCodigo();
	
		Superficie superficie = new Superficie(++max, coordenadaSuperficie);
		repositorio.adicionarSuperficie(superficie);
		return superficie;
	}
	
	public void excluirSuperficie(Superficie superficie){
		repositorio.excluirSuperficie(superficie);
	}
	
	public List<Sonda> salvarSondas(List<SondaModel> sondas, OrientacaoFactory orientacaoFactory) throws ExpedicaoNasaException{
		Superficie superficie = orientacaoFactory.getSuperficie();
		int max = repositorio.getMaxSondaOrdem(superficie);
		 
		List<Sonda> retorno = new ArrayList<Sonda>();
		for (SondaModel s : sondas){
			Posicao posicao = ComumConstrucaoValueObject.getPosicao(s.getPosicao(), orientacaoFactory);
			Sonda sonda = new Sonda(posicao, orientacaoFactory.getSuperficie(), ++max, s.getMovimento());
			repositorio.adicionarSonda(sonda);	
			retorno.add(sonda);
		}
		
		return retorno;
	}
	
	private EntidadeRepositorio repositorio;

}
