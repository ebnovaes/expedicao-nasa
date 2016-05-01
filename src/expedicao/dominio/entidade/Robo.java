package expedicao.dominio.entidade;

import expedicao.dominio.valueobject.Coordenada;
import expedicao.dominio.valueobject.Posicao;
import expedicao.dominio.valueobject.movimentador.Movimento;
import expedicao.dominio.valueobject.movimentador.MovimentoChainFactory;
import expedicao.dominio.valueobject.orientacao.Orientacao;
import expedicao.dominio.valueobject.orientacao.OrientacaoFactory;

public final class Robo {

	public Robo(OrientacaoFactory orientacaoFactory){
		Coordenada coordenada = new Coordenada(0, 0);
		Orientacao norte = orientacaoFactory.getNorte();
		this.posicao = new Posicao(coordenada, norte);
		this.superficie = orientacaoFactory.getSuperficie();
	}

	public Robo(Posicao posicao, Superficie superficie){
		this.posicao = posicao;
		this.superficie = superficie;
	}
	
	public Posicao getPosicao(){
		return posicao;
	}
	
	public Posicao movimentar(String cadeiaComandos){

		MovimentoChainFactory movimentoChainFactory = new MovimentoChainFactory();
		Movimento movimento = movimentoChainFactory.construir();

		Posicao posicaoFinal = posicao;
		char[] comandosChar = cadeiaComandos.toCharArray();
		for (int i = 0; i < comandosChar.length; i++){
			posicaoFinal = movimento.movimentar(comandosChar[i], posicaoFinal);
		}

		return posicaoFinal;		
	}
	
	private Posicao posicao;
	
	private Superficie superficie;
}
