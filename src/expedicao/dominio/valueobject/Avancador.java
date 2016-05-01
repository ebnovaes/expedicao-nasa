package expedicao.dominio.valueobject;

import expedicao.dominio.valueobject.movimentador.Movimento;
import expedicao.dominio.valueobject.movimento.MovimentoOrientacao;
import expedicao.dominio.valueobject.orientacao.Orientacao;

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