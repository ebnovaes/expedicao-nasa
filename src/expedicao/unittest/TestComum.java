package expedicao.unittest;

import expedicao.dominio.entidade.*;
import expedicao.dominio.valueobject.Coordenada;
import expedicao.dominio.valueobject.Posicao;
import expedicao.dominio.valueobject.orientacao.*;
import expedicao.exception.SondaInvalidaException;

public class TestComum {

	public static OrientacaoFactory getOrientacaoFactory(){
		return getOrientacaoFactory(0, 0);
	}
	
	public static OrientacaoFactory getOrientacaoFactory(int x, int y){
		Superficie superficie = new Superficie(0, new Coordenada(x, y));
		return new OrientacaoFactory(superficie);
	}
	
	public static Sonda criarSonda(int xSonda, int ySonda, int ordem, Superficie superficie, String movimento, Orientacao orientacao) throws SondaInvalidaException{
		Coordenada coordSonda = new Coordenada(xSonda, ySonda);
		Posicao posicao = new Posicao(coordSonda, orientacao);
		return new Sonda(posicao, superficie, ordem, movimento);
	}
	
	public static Sonda criarSonda(int xSonda, int ySonda, int xSuperficie, int ySuperficie, String movimento) throws SondaInvalidaException{
		return criarSonda(xSonda, ySonda, xSuperficie, ySuperficie, movimento, new Norte(null));
	}
	
	public static Sonda criarSonda(int xSonda, int ySonda, int xSuperficie, int ySuperficie, String movimento, Orientacao orientacao) throws SondaInvalidaException{
		Coordenada coordSuperficie = new Coordenada(xSuperficie, ySuperficie);
		Coordenada coordSonda = new Coordenada(xSonda, ySonda);
		Superficie superficie = new Superficie(0, coordSuperficie);
		Posicao posicao = new Posicao(coordSonda, orientacao);
		return new Sonda(posicao, superficie, 0, movimento);
	}
}
