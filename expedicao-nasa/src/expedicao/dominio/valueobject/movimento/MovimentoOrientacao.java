package expedicao.dominio.valueobject.movimento;

import expedicao.dominio.valueobject.Coordenada;

public interface MovimentoOrientacao {

	public Coordenada avancar(Coordenada coordenadaReferencia);
}
