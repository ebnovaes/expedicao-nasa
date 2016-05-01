package expedicao.dominio.valueobject;

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
