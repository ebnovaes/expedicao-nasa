package expedicao.dominio.valueobject;

public final class Sul extends Orientacao {
	
	public Sul(OrientacaoFactory orientacaoFactory) {
		super(orientacaoFactory);
	}

	public char sigla() {
		return 'S';
	}

	public Orientacao aDireita() {
		return orientacaoFactory.getOeste();
	}

	public Orientacao aEsquerda() {
		return orientacaoFactory.getLeste();
	}

	public MovimentoOrientacao getMovimentoOrientacao() {
		return new MovimentoSul();
	}
	
}