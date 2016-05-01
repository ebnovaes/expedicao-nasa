package expedicao.dominio.valueobject.orientacao;

import expedicao.dominio.valueobject.movimento.MovimentoOeste;
import expedicao.dominio.valueobject.movimento.MovimentoOrientacao;

public final class Oeste extends Orientacao {

	public Oeste(OrientacaoFactory orientacaoFactory) {
		super(orientacaoFactory);
	}

	public char sigla() {
		return 'O';
	}

	public Orientacao aDireita() {
		return orientacaoFactory.getNorte();
	}

	public Orientacao aEsquerda() {
		return orientacaoFactory.getSul();
	}

	public MovimentoOrientacao getMovimentoOrientacao() {
		return new MovimentoOeste();
	}
}
