package expedicao.unittest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import expedicao.dominio.entidade.Superficie;
import expedicao.dominio.valueobject.*;
import expedicao.dominio.valueobject.orientacao.Leste;
import expedicao.dominio.valueobject.orientacao.Norte;
import expedicao.dominio.valueobject.orientacao.Oeste;
import expedicao.dominio.valueobject.orientacao.OrientacaoFactory;
import expedicao.dominio.valueobject.orientacao.Sul;

public class TestPontosCardeais {

	@Before
	public void setUp(){
		Superficie superficie = new Superficie(new Coordenada(0, 0));
		this.orientacaoFactory = new OrientacaoFactory(superficie);
	}
	
	@Test
	public void leste_deveRetornarSiglaCharL() {
		Leste leste = new Leste(orientacaoFactory);
		
		assertEquals('L', leste.sigla());
	}
	
	@Test
	public void oeste_deveRetornarSiglaCharO() {
		Oeste oeste = new Oeste(orientacaoFactory);
		
		assertEquals('O', oeste.sigla());
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
		
		assertEquals('O', sul.aDireita().sigla());
	}
	
	@Test
	public void sul_deveRetornarLesteAEsquerda(){
		Sul sul = new Sul(orientacaoFactory);
		
		assertEquals('L', sul.aEsquerda().sigla());
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
		
		assertEquals('L', norte.aDireita().sigla());
	}
	
	@Test
	public void norte_deveRetornarOesteAEsquerda(){
		Norte norte = new Norte(orientacaoFactory);
		
		assertEquals('O', norte.aEsquerda().sigla());
	}
	
	private OrientacaoFactory orientacaoFactory;
}
