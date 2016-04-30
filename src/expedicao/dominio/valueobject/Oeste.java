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

	public Coordenada avancar(Coordenada coordenadaReferencia) {
		int xMenosUm = coordenadaReferencia.getX() - 1;
		if (xMenosUm - 1 >= 0){
			return new Coordenada(xMenosUm, coordenadaReferencia.getY());
		}
		
		return coordenadaReferencia;

	}

}
