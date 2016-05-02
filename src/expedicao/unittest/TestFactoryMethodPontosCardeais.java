package expedicao.unittest;

import static org.junit.Assert.*;

import org.junit.Test;

import expedicao.dominio.valueobject.movimento.*;
import expedicao.dominio.valueobject.orientacao.*;

public class TestFactoryMethodPontosCardeais {

	@Test
	public void norte_deveConstruirMovimentadorNorte(){
		OrientacaoFactory orientacaoFactory = TestComum.getOrientacaoFactory();
		Norte norte = new Norte(orientacaoFactory);
		
		assertEquals(MovimentoNorte.class, norte.getMovimentoOrientacao().getClass());
	}
	
	@Test
	public void sul_deveConstruirMovimentadorSul(){
		OrientacaoFactory orientacaoFactory = TestComum.getOrientacaoFactory();
		Sul sul = new Sul(orientacaoFactory);
		
		assertEquals(MovimentoSul.class, sul.getMovimentoOrientacao().getClass());
	}
	
	@Test
	public void leste_deveConstruirMovimentadorLeste(){
		OrientacaoFactory orientacaoFactory = TestComum.getOrientacaoFactory();
		Leste leste = new Leste(orientacaoFactory);
		
		assertEquals(MovimentoLeste.class, leste.getMovimentoOrientacao().getClass());
	}
	
	@Test
	public void oeste_deveConstruirMovimentadorOeste(){
		OrientacaoFactory orientacaoFactory = TestComum.getOrientacaoFactory();
		Oeste oeste = new Oeste(orientacaoFactory);
		
		assertEquals(MovimentoOeste.class, oeste.getMovimentoOrientacao().getClass());
	}
}