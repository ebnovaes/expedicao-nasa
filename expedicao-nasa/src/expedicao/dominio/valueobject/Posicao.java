package expedicao.dominio.valueobject;

public final class Posicao {

	public Posicao(Coordenada coordenada, Orientacao orientacao){
		if (coordenada == null || orientacao == null){
			throw new IllegalArgumentException();
		}

		this.coordenada = coordenada;
		this.orientacao = orientacao;
	}
	
	public Coordenada getCoordenada() {
		return coordenada;
	}

	public Orientacao getOrientacao() {
		return orientacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordenada == null) ? 0 : coordenada.hashCode());
		result = prime * result + ((orientacao == null) ? 0 : orientacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
			
		if (obj == null || getClass() != obj.getClass()){
			return false;
		}
			
		Posicao that = (Posicao) obj;
		return that.getCoordenada().equals(this.coordenada) && that.getOrientacao().equals(this.orientacao);
	}

	@Override
	public String toString() {
		return String.format("%s %s", coordenada.toString(), orientacao.toString());
	}
	
	private Coordenada coordenada;
	
	private Orientacao orientacao;

}
