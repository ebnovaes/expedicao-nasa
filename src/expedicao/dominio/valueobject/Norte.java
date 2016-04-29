package expedicao.dominio.valueobject;

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

	public boolean isPermitidoAvancar(Coordenada coordenadaReferencia) {
		Coordenada coordenadaLimite = orientacaoFactory.getCoordenadaLimite();
		int coordenadaReferenciaY = coordenadaReferencia.getY();
		int coordenadaLimiteY = coordenadaLimite.getY();
		return (coordenadaReferenciaY + 1 <= coordenadaLimiteY);
	}

}
