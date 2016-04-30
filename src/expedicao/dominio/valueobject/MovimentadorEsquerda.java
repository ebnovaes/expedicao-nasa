package expedicao.dominio.valueobject;

public class MovimentadorEsquerda extends Movimento {

	public MovimentadorEsquerda(Movimento proximoMovimento, char comando, Posicao posicaoOrigem) {
		super(proximoMovimento, comando, posicaoOrigem);
	}

	protected boolean consegueTratar() {
		return Character.toLowerCase(this.comando) == 'l';
	}

	@Override
	protected Posicao realizarMovimento() {
		Orientacao novaOrientacao = posicaoOrigem.getOrientacao().aEsquerda();
		Posicao retorno = new Posicao(posicaoOrigem.getCoordenada(), novaOrientacao);
		return retorno;
	}
	
}
