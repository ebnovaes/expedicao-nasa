package expedicao.dominio.valueobject.movimento;

import expedicao.dominio.valueobject.Coordenada;

public final class MovimentoSul implements MovimentoOrientacao {

	public Coordenada avancar(Coordenada coordenadaReferencia) {
		int yMenosUm = coordenadaReferencia.getY() - 1;
		if (yMenosUm >= 0){
			return new Coordenada(coordenadaReferencia.getX(), yMenosUm);
		}
		
		return coordenadaReferencia;
	}

}
