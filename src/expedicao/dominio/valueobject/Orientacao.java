package expedicao.dominio.valueobject;

public abstract class Orientacao {

	public Orientacao(OrientacaoFactory orientacaoFactory){
		this.orientacaoFactory = orientacaoFactory;
	}

	public abstract char sigla();
	
	public abstract Orientacao aDireita();
	
	public abstract Orientacao aEsquerda();
	
	public abstract Coordenada avancar(Coordenada coordenadaReferencia);

	protected OrientacaoFactory orientacaoFactory;
}
