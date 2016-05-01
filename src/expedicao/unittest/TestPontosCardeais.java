package expedicao.unittest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import expedicao.dominio.entidade.Superficie;
import expedicao.dominio.valueobject.*;
import expedicao.dominio.valueobject.orientacao.*;

public class TestPontosCardeais {

	@Before
	public void setUp(){
		Superficie superficie = new Superficie(0, new Coordenada(0, 0));
		this.orientacaoFactory = new OrientacaoFactory(superficie);
	}
	
	@Test
	public void leste_deveRetornarSiglaCharL() {
		Leste leste = new Leste(orientacaoFactory);
		
		assertEquals('E', leste.sigla());
	}
	
	@Test
	public void oeste_deveRetornarSiglaCharO() {
		Oeste oeste = new Oeste(orientacaoFactory);
		
		assertEquals('W', oeste.sigla());
	}
	
	@Test
	public void norte_deveRetornarSiglaCharN() {
		Norte norte = new Norte(orientacaoFactory);
		
		assertEquals('N', norte.sigla());
	}

	@Test
	public void sul_deveRetornarSiglaCharS() {
		Sul sul = new Sul(orientacaoFactory);
		
		assertEquals('S', sul.sigla());
	}
	
	@Test
	public void leste_deveRetornarSulADireita(){
		Leste leste = new Leste(orientacaoFactory);
		
		assertEquals('S', leste.aDireita().sigla());
	}
	
	@Test
	public void leste_deveRetornarNorteAEsquerda(){
		Leste leste = new Leste(orientacaoFactory);
		
		assertEquals('N', leste.aEsquerda().sigla());
	}
	
	@Test
	public void sul_deveRetornarOesteADireita(){
		Sul sul = new Sul(orientacaoFactory);
		
		assertEquals('W', sul.aDireita().sigla());
	}
	
	@Test
	public void sul_deveRetornarLesteAEsquerda(){
		Sul sul = new Sul(orientacaoFactory);
		
		assertEquals('E', sul.aEsquerda().sigla());
	}
	
	@Test
	public void oeste_deveRetornarNorteADireita(){
		Oeste oeste = new Oeste(orientacaoFactory);
		
		assertEquals('N', oeste.aDireita().sigla());
	}
	
	@Test
	public void oeste_deveRetornarSulAEsquerda(){
		Oeste oeste = new Oeste(orientacaoFactory);
		
		assertEquals('S', oeste.aEsquerda().sigla());
	}
	
	@Test
	public void norte_deveRetornarLesteADireita(){
		Norte norte = new Norte(orientacaoFactory);
		
		assertEquals('E', norte.aDireita().sigla());
	}
	
	@Test
	public void norte_deveRetornarOesteAEsquerda(){
		Norte norte = new Norte(orientacaoFactory);
		
		assertEquals('W', norte.aEsquerda().sigla());
	}
	
	private OrientacaoFactory orientacaoFactory;
}
