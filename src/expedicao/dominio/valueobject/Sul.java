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

	@Override
	public Coordenada avancar(Coordenada coordenadaReferencia) {
		int yMenosUm = coordenadaReferencia.getY() - 1;
		if (yMenosUm > 0){
			return new Coordenada(coordenadaReferencia.getX(), yMenosUm);
		}
		
		return coordenadaReferencia;
	}

}
