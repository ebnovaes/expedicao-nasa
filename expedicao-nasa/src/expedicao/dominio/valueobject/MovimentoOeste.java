package expedicao.dominio.valueobject;

public final class MovimentoOeste implements MovimentoOrientacao {

	public Coordenada avancar(Coordenada coordenadaReferencia) {
		int xMenosUm = coordenadaReferencia.getX() - 1;
		if (xMenosUm >= 0){
			return new Coordenada(xMenosUm, coordenadaReferencia.getY());
		}
		
		return coordenadaReferencia;
	}
	
}
