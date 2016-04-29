package expedicao.dominio.valueobject;

public final class Posicao {

	public Posicao(Coordenada coordenada, Orientacao orientacao){
		this.coordenada = coordenada;
		this.orientacao = orientacao;
	}
	
	public Coordenada getCoordenada() {
		return coordenada;
	}

	public Orientacao getOrientacao() {
		return orientacao;
	}

	private Coordenada coordenada;
	
	private Orientacao orientacao;
}
