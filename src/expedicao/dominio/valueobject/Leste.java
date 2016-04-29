package expedicao.dominio.valueobject;

public final class Leste extends Orientacao {

	public Leste(OrientacaoFactory orientacaoFactory) {
		super(orientacaoFactory);
	}

	public char sigla() {
		return 'L';
	}

	public Orientacao aDireita() {
		return orientacaoFactory.getSul();
	}

	public Orientacao aEsquerda() {
		return orientacaoFactory.getNorte();
	}

	public boolean isPermitidoAvancar(Coordenada coordenadaReferencia) {
		int x = coordenadaReferencia.getX();
		return (x - 1 >= 0);
	}

}
