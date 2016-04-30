package expedicao.dominio.valueobject;

import expedicao.dominio.entidade.Superficie;

public final class MovimentoNorte implements MovimentoOrientacao {

	public MovimentoNorte(Superficie superficie){
		this.superficie = superficie;
	}
	
	public Coordenada avancar(Coordenada coordenadaReferencia) {
		Coordenada coordenadaLimite =  superficie.getTamanhoMaximoSupeficie();
		int coordenadaReferenciaY = coordenadaReferencia.getY();
		int coordenadaLimiteY = coordenadaLimite.getY();
		int yMaisUm = coordenadaReferenciaY + 1;
		
		if (yMaisUm <= coordenadaLimiteY){
			return new Coordenada(coordenadaReferencia.getX(), yMaisUm);
		}
		
		return coordenadaLimite;
	}

	private Superficie superficie;
}
