package expedicao.dominio.valueobject.orientacao;

import expedicao.dominio.valueobject.movimento.MovimentoNorte;
import expedicao.dominio.valueobject.movimento.MovimentoOrientacao;

public class Norte extends Orientacao {

	public Norte(OrientacaoFactory orientacaoFactory) {
		super(orientacaoFactory);
	}

	public char sigla() {
		return 'N';
	}

	public Orientacao aDireita() {
		return orientacaoFactory.getLeste();
	}

	public Orientacao aEsquerda() {
		return orientacaoFactory.getOeste();
	}

	public MovimentoOrientacao getMovimentoOrientacao() {
		return new MovimentoNorte(orientacaoFactory.getSuperficie());
	}

}