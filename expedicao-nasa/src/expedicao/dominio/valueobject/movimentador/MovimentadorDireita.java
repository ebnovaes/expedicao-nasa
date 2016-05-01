package expedicao.dominio.valueobject.movimentador;

import expedicao.dominio.valueobject.Posicao;
import expedicao.dominio.valueobject.orientacao.Orientacao;

public class MovimentadorDireita extends Movimento {

	public MovimentadorDireita(Movimento proximoMovimento) {
		super(proximoMovimento);
	}
	
	public boolean consegueTratar(char comando) {
		return Character.toLowerCase(comando) == 'r';
	}

	protected Posicao realizarMovimento(Posicao posicaoOrigem) {
		Orientacao novaOrientacao = posicaoOrigem.getOrientacao().aDireita();
		Posicao retorno = new Posicao(posicaoOrigem.getCoordenada(), novaOrientacao);
		
		return retorno;
	}

}
