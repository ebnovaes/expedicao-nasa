package expedicao.dominio.valueobject;

public class MovimentadorDireita {

	public Posicao movimentar(Posicao posicaoOrigem) {
		Orientacao orientacao = posicaoOrigem.getOrientacao().aDireita();
		
		return new Posicao(posicaoOrigem.getCoordenada(), orientacao);
	}

}
