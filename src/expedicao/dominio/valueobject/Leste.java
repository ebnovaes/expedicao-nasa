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

	@Override
	public Coordenada avancar(Coordenada coordenadaReferencia) {
		Coordenada coordenadaLimite = orientacaoFactory.getSuperficie().getTamanhoMaximoSupeficie();
		int coordenadaReferenciaX = coordenadaReferencia.getX();
		int coordenadaLimiteX = coordenadaLimite.getX();
		int xMaisUm = coordenadaReferenciaX + 1;
		
		if (xMaisUm <= coordenadaLimiteX){
			return new Coordenada(xMaisUm, coordenadaReferencia.getY());
		}
		
		return coordenadaReferencia;
	}

}
