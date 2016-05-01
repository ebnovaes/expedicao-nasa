package expedicao.dominio.valueobject;

public final class Leste extends Orientacao {

	public Leste(OrientacaoFactory orientacaoFactory) {
		super(orientacaoFactory);
	}

	public char sigla() {
		return 'E';
	}

	public Orientacao aDireita() {
		return orientacaoFactory.getSul();
	}

	public Orientacao aEsquerda() {
		return orientacaoFactory.getNorte();
	}
	
	public MovimentoOrientacao getMovimentoOrientacao() {
		return new MovimentoLeste(orientacaoFactory.getSuperficie());
	}
}