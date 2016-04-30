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

	public Coordenada avancar(Coordenada coordenadaReferencia) {
		
		Coordenada coordenadaLimite = orientacaoFactory.getSuperficie().getTamanhoMaximoSupeficie();
		int coordenadaReferenciaY = coordenadaReferencia.getY();
		int coordenadaLimiteY = coordenadaLimite.getY();
		int yMaisUm = coordenadaReferenciaY + 1;
		
		if (yMaisUm <= coordenadaLimiteY){
			return new Coordenada(coordenadaReferencia.getX(), yMaisUm);
		}
		
		return coordenadaReferencia;
	}

}
