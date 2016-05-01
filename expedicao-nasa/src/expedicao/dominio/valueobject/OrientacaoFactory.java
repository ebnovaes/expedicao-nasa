package expedicao.dominio.valueobject;

import expedicao.dominio.entidade.Superficie;

public class OrientacaoFactory {

	public OrientacaoFactory(Superficie superficie) {
		this.superficie = superficie;
	}

	public Orientacao get(char sigla){
		switch (Character.toLowerCase(sigla)){
		case 'n':
			return getNorte();
		case 'e':
			return getLeste();
		case 's':
			return getSul();
		case 'w':
			return getOeste();
		}
		
		return null;
	}
	
	public Orientacao getNorte() {
		return new Norte(this);
	}

	public Orientacao getSul() {
		return new Sul(this);
	}

	public Orientacao getOeste() {
		return new Oeste(this);
	}

	public Orientacao getLeste() {
		return new Leste(this);
	}

	public Superficie getSuperficie() {
		return superficie;
	}

	private Superficie superficie;
}
