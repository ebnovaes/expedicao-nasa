package expedicao.dominio.valueobject;

public class Avancador extends Movimento {

	public Avancador(Movimento proximoMovimento) {
		super(proximoMovimento);
	}

	public boolean consegueTratar(char comando) {
		return Character.toLowerCase(comando) == 'm';
	}

	protected Posicao realizarMovimento(Posicao posicaoOrigem) {
		Orientacao orientacao = posicaoOrigem.getOrientacao();
		MovimentoOrientacao movimento = orientacao.getMovimentoOrientacao();
		Coordenada coordenada = movimento.avancar(posicaoOrigem.getCoordenada());
		return new Posicao(coordenada, orientacao);
	}
	
}