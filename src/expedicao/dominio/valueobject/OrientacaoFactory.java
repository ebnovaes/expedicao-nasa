package expedicao.dominio.valueobject;

public class OrientacaoFactory {

	public OrientacaoFactory(Coordenada coordenadaLimite){
		this.coordenadaLimite = coordenadaLimite;
	}
	
	public Orientacao getNorte(){
		return new Norte(this);
	}
	
	public Orientacao getSul(){
		return new Sul(this);
	}
	
	public Orientacao getOeste(){
		return new Oeste(this);
	}
	
	public Orientacao getLeste(){
		return new Leste(this);
	}
	
	public Coordenada getCoordenadaLimite(){
		return coordenadaLimite;
	}
	
	private Coordenada coordenadaLimite;
}
