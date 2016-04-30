package expedicao.dominio.valueobject;

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
