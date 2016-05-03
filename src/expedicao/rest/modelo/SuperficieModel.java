package expedicao.rest.modelo;

import java.util.*;

import expedicao.dominio.entidade.Sonda;
import expedicao.dominio.entidade.Superficie;
import expedicao.dominio.valueobject.Coordenada;

public final class SuperficieModel {

	public String getCoordenadasLimite() {
		return coordenadasLimite;
	}

	public void setCoordenadasLimite(String coordenadasLimite) {
		this.coordenadasLimite = coordenadasLimite;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public List<SondaModel> getSondas() {
		return new ArrayList<>(sondas);
	}

	public void setSondas(List<SondaModel> sondas) {
		if (sondas == null){
			this.sondas = new ArrayList<>();
		}
		this.sondas = sondas;
	}
	
	public static SuperficieModel transformarBaseadoEm(Superficie superficie, List<Sonda> sondas){
		if (superficie == null){
			return null;
		}
		
		SuperficieModel superficieModel = new SuperficieModel();
		Coordenada coordenada = superficie.getTamanhoMaximoSuperficie();
		superficieModel.codigo = superficie.getCodigo();
		superficieModel.coordenadasLimite = coordenada.toString();
		
		List<SondaModel> sondasModel = SondaModel.transformarBaseadoEm(superficie, sondas);
		superficieModel.sondas = new ArrayList<>(sondasModel);
		
		return superficieModel;
	}

	private String coordenadasLimite;
	
	private int codigo;
	
	private List<SondaModel> sondas;
	
}
