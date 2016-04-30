package expedicao.dominio.entidade;

import expedicao.dominio.valueobject.Coordenada;

public final class Superficie {

	public Superficie(Coordenada tamanhoMaximoSuperficie){
		this.coordenada = tamanhoMaximoSuperficie;
	}
	
	public Coordenada getTamanhoMaximoSupeficie(){
		return this.coordenada;
	}
	
	private Coordenada coordenada;
}
