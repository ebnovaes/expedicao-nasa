package expedicao.dominio.entidade;

import expedicao.dominio.valueobject.Coordenada;
import expedicao.dominio.valueobject.Posicao;
import expedicao.dominio.valueobject.movimentador.Movimento;
import expedicao.dominio.valueobject.movimentador.MovimentoChainFactory;
import expedicao.dominio.valueobject.orientacao.Orientacao;
import expedicao.dominio.valueobject.orientacao.OrientacaoFactory;

public final class Sonda {

	public Sonda(OrientacaoFactory orientacaoFactory, int ordem, String cadeiaComadosInicial){
		Coordenada coordenada = new Coordenada(0, 0);
		Orientacao norte = orientacaoFactory.getNorte();
		this.posicao = new Posicao(coordenada, norte);
		this.superficie = orientacaoFactory.getSuperficie();
		this.ordem = ordem;
		this.cadeiaComadosInicial = cadeiaComadosInicial;
	}

	public Sonda(Posicao posicao, Superficie superficie, int ordem, String cadeiaComadosInicial){
		this.posicao = posicao;
		this.superficie = superficie;
		this.ordem = ordem;
		this.cadeiaComadosInicial = cadeiaComadosInicial;
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
	
	public Posicao movimentar(){
		return movimentar(this.cadeiaComadosInicial);
	}
	public Superficie getSuperficie() {
		return superficie;
	}

	public int getOrdem(){
		return ordem;
	}
	
	private Posicao posicao;
	
	private Superficie superficie;
	
	private int ordem;
	
	private String cadeiaComadosInicial;
}
