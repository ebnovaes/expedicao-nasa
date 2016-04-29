package expedicao.dominio.valueobject;

public abstract class Orientacao {

	public Orientacao(OrientacaoFactory orientacaoFactory){
		this.orientacaoFactory = orientacaoFactory;
	}

	public abstract char sigla();
	
	public abstract Orientacao aDireita();
	
	public abstract Orientacao aEsquerda();
	
	public abstract boolean isPermitidoAvancar(Coordenada coordenadaReferencia);

	protected OrientacaoFactory orientacaoFactory;
}
