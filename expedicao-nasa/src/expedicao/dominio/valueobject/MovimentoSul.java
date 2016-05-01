package expedicao.dominio.valueobject;

public final class MovimentoSul implements MovimentoOrientacao {

	public Coordenada avancar(Coordenada coordenadaReferencia) {
		int yMenosUm = coordenadaReferencia.getY() - 1;
		if (yMenosUm >= 0){
			return new Coordenada(coordenadaReferencia.getX(), yMenosUm);
		}
		
		return coordenadaReferencia;
	}

}
