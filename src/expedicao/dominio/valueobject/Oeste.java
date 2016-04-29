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

	public boolean isPermitidoAvancar(Coordenada coordenadaReferencia) {
		Coordenada coordenadaLimite = orientacaoFactory.getCoordenadaLimite();
		int coordenadaReferenciaX = coordenadaReferencia.getX();
		int coordenadaLimiteX = coordenadaLimite.getX();
		return (coordenadaReferenciaX + 1 <= coordenadaLimiteX);
	}

}
