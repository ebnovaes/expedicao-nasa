package expedicao.dominio.valueobject;

public class MovimentadorEsquerda implements Movimento {

	public Posicao movimentar(Posicao posicaoOrigem) {
		Orientacao orientacao = posicaoOrigem.getOrientacao().aEsquerda();
		
		return new Posicao(posicaoOrigem.getCoordenada(), orientacao);
	}
	
}
