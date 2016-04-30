package expedicao.dominio.valueobject;

public class MovimentadorDireita extends Movimento {

	public MovimentadorDireita(Movimento proximoMovimento, char comando, Posicao posicaoOrigem) {
		super(proximoMovimento, comando, posicaoOrigem);
	}
	
	protected boolean consegueTratar() {
		return Character.toLowerCase(this.comando) == 'r';
	}

	protected Posicao realizarMovimento() {
		Orientacao novaOrientacao = posicaoOrigem.getOrientacao().aDireita();
		Posicao retorno = new Posicao(posicaoOrigem.getCoordenada(), novaOrientacao);
		
		return retorno;
	}

}
