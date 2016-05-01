package expedicao.rest.modelo;

import java.util.*;

import expedicao.dominio.entidade.*;

public final class SuperficieModel {

	public String getCoordenadasLimite() {
		return coordenadasLimite;
	}

	public void setCoordenadasLimite(String coordenadasLimite) {
		this.coordenadasLimite = coordenadasLimite;
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

	public Superficie getSuperficie() {
		return superficie;
	}

	private String coordenadasLimite;
	
	private List<SondaModel> sondas;
	
	private Superficie superficie;
}
