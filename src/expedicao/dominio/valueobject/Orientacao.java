package expedicao.dominio.valueobject;

public abstract class Orientacao {

	public Orientacao(OrientacaoFactory orientacaoFactory){
		this.orientacaoFactory = orientacaoFactory;
	}

	public abstract char sigla();
	
	public abstract Orientacao aDireita();
	
	public abstract Orientacao aEsquerda();
	
	public abstract MovimentoOrientacao getMovimentoOrientacao();
	
	protected OrientacaoFactory orientacaoFactory;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (sigla());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
			
		if (obj == null || getClass() != obj.getClass()){
			return false;
	    }
		
		Orientacao that = (Orientacao) obj;
		return (that.sigla() == this.sigla());
	}
	
	
}
