package expedicao.unittest;

import static org.junit.Assert.*;

import org.junit.Test;

import expedicao.dominio.entidade.Superficie;
import expedicao.dominio.valueobject.*;
import expedicao.dominio.valueobject.movimento.MovimentoLeste;
import expedicao.dominio.valueobject.movimento.MovimentoNorte;
import expedicao.dominio.valueobject.movimento.MovimentoOeste;
import expedicao.dominio.valueobject.movimento.MovimentoSul;
import expedicao.dominio.valueobject.orientacao.Leste;
import expedicao.dominio.valueobject.orientacao.Norte;
import expedicao.dominio.valueobject.orientacao.Oeste;
import expedicao.dominio.valueobject.orientacao.OrientacaoFactory;
import expedicao.dominio.valueobject.orientacao.Sul;

public class TestFactoryMethodPontosCardeais {

	@Test
	public void norte_deveConstruirMovimentadorNorte(){
		Coordenada coordenada = new Coordenada(0, 0);
		Superficie superficie = new Superficie(coordenada);
		OrientacaoFactory orientacaoFactory = new OrientacaoFactory(superficie);
		Norte norte = new Norte(orientacaoFactory);
		
		assertEquals(MovimentoNorte.class, norte.getMovimentoOrientacao().getClass());
	}
	
	@Test
	public void sul_deveConstruirMovimentadorSul(){
		Coordenada coordenada = new Coordenada(0, 0);
		Superficie superficie = new Superficie(coordenada);
		OrientacaoFactory orientacaoFactory = new OrientacaoFactory(superficie);
		Sul sul = new Sul(orientacaoFactory);
		
		assertEquals(MovimentoSul.class, sul.getMovimentoOrientacao().getClass());
	}
	
	@Test
	public void leste_deveConstruirMovimentadorLeste(){
		Coordenada coordenada = new Coordenada(0, 0);
		Superficie superficie = new Superficie(coordenada);
		OrientacaoFactory orientacaoFactory = new OrientacaoFactory(superficie);
		Leste leste = new Leste(orientacaoFactory);
		
		assertEquals(MovimentoLeste.class, leste.getMovimentoOrientacao().getClass());
	}
	
	@Test
	public void oeste_deveConstruirMovimentadorOeste(){
		Coordenada coordenada = new Coordenada(0, 0);
		Superficie superficie = new Superficie(coordenada);
		OrientacaoFactory orientacaoFactory = new OrientacaoFactory(superficie);
		Oeste oeste = new Oeste(orientacaoFactory);
		
		assertEquals(MovimentoOeste.class, oeste.getMovimentoOrientacao().getClass());
	}
}