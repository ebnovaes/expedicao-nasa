package expedicao.dominio.valueobject;

public class Avancador extends Movimento {

	public Avancador(Movimento proximoMovimento, char comando, Posicao posicaoOrigem) {
		super(proximoMovimento, comando, posicaoOrigem);
	}

	protected boolean consegueTratar() {
		return Character.toLowerCase(this.comando) == 'm';
	}

	protected Posicao realizarMovimento() {
		Orientacao orientacao = posicaoOrigem.getOrientacao();
		Coordenada coordenada = orientacao.avancar(posicaoOrigem.getCoordenada());
		return new Posicao(coordenada, orientacao);
	}
	
}