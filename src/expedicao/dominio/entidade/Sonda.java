package expedicao.dominio.entidade;

import expedicao.dominio.valueobject.Coordenada;
import expedicao.dominio.valueobject.Posicao;
import expedicao.dominio.valueobject.movimentador.Movimento;
import expedicao.dominio.valueobject.movimentador.MovimentoChainFactory;
import expedicao.exception.SondaInvalidaException;

public final class Sonda {

	@Override
	public int hashCode() {
		final int prime = 27;
		int result = 1;
		result = prime * result + ordem;
		result = prime * result + ((superficie == null) ? 0 : superficie.hashCode());
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
			
		Sonda that = (Sonda) obj;
		if (ordem != that.ordem){
			return false;
		}
			
		if ((superficie == null && that.superficie != null) || (!superficie.equals(that.superficie))){
			return false;
		} 
			
		return true;
	}

	public Sonda(Posicao posicao, Superficie superficie, int ordem, String cadeiaComadosInicial) throws SondaInvalidaException{
		Coordenada maxima = superficie.getTamanhoMaximoSuperficie();
		if (posicao.getCoordenada().extrapolaSuperiorDireita(maxima)){
			String erro = String.format("Coordenadas iniciais %s são maiores que tamanho da superfície (%s)", 
										 posicao.getCoordenada(), 
										 maxima);
			throw new SondaInvalidaException(erro);
		}
		
		this.posicao = posicao;
		this.superficie = superficie;
		this.ordem = ordem;
		this.cadeiaComados = cadeiaComadosInicial;
	}
	
	public Posicao getPosicao(){
		return posicao;
	}
	
	public Posicao movimentar(String cadeiaComandos){

		this.cadeiaComados = cadeiaComandos;
		MovimentoChainFactory movimentoChainFactory = new MovimentoChainFactory();
		Movimento movimento = movimentoChainFactory.construir();

		Posicao posicaoFinal = posicao;
		char[] comandosChar = cadeiaComandos.toCharArray();
		for (int i = 0; i < comandosChar.length; i++){
			posicaoFinal = movimento.movimentar(comandosChar[i], posicaoFinal);
		}

		this.posicao = posicaoFinal;
		return posicaoFinal;		
	}
	
	public Posicao movimentar(){
		return movimentar(this.cadeiaComados);
	}
	public Superficie getSuperficie() {
		return superficie;
	}

	public int getOrdem(){
		return ordem;
	}
	
	public String getCadeiaComados() {
		return cadeiaComados;
	}

	public void setCadeiaComados(String cadeiaComados) {
		this.cadeiaComados = cadeiaComados;
	}

	private Posicao posicao;
	
	private Superficie superficie;
	
	private int ordem;
	
	private String cadeiaComados;
}
