package expedicao.dominio.valueobject;

import expedicao.dominio.entidade.Superficie;

public final class MovimentoLeste implements MovimentoOrientacao {

	public MovimentoLeste(Superficie superficie){
		this.superficie = superficie;
	}
	
	public Coordenada avancar(Coordenada coordenadaReferencia) {
		Coordenada coordenadaLimite = superficie.getTamanhoMaximoSupeficie();
		int coordenadaReferenciaX = coordenadaReferencia.getX();
		int coordenadaLimiteX = coordenadaLimite.getX();
		int xMaisUm = coordenadaReferenciaX + 1;
		
		if (xMaisUm <= coordenadaLimiteX){
			return new Coordenada(xMaisUm, coordenadaReferencia.getY());
		}
		
		return coordenadaLimite;
	}

	private Superficie superficie;
}
