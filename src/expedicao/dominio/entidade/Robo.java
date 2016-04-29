package expedicao.dominio.entidade;

import expedicao.dominio.valueobject.Posicao;

public final class Robo {

	public Robo(Posicao posicao){
		this.posicao = posicao;
	}
	
	public Posicao getPosicao(){
		return posicao;
	}
	
	private Posicao posicao;
}
