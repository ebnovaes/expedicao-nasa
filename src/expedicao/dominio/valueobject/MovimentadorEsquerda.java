package expedicao.dominio.valueobject;

public class MovimentadorEsquerda extends Movimento {

	public MovimentadorEsquerda(Movimento proximoMovimento) {
		super(proximoMovimento);
	}

	public boolean consegueTratar(char comando) {
		return Character.toLowerCase(comando) == 'l';
	}

	@Override
	protected Posicao realizarMovimento(Posicao posicaoOrigem) {
		Orientacao novaOrientacao = posicaoOrigem.getOrientacao().aEsquerda();
		Posicao retorno = new Posicao(posicaoOrigem.getCoordenada(), novaOrientacao);
		return retorno;
	}
	
}
