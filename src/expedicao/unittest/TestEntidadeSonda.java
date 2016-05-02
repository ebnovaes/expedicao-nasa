package expedicao.unittest;

import static org.junit.Assert.*;

import javax.servlet.http.Cookie;

import org.junit.Before;
import org.junit.Test;

import expedicao.dominio.entidade.Sonda;
import expedicao.dominio.entidade.Superficie;
import expedicao.dominio.valueobject.Coordenada;
import expedicao.dominio.valueobject.Posicao;
import expedicao.dominio.valueobject.orientacao.Leste;
import expedicao.dominio.valueobject.orientacao.Norte;
import expedicao.dominio.valueobject.orientacao.OrientacaoFactory;
import expedicao.dominio.valueobject.orientacao.Sul;
import expedicao.exception.SondaInvalidaException;

public class TestEntidadeSonda {

	@Before
	public void setUp() throws Exception {
	}

	@Test(expected=SondaInvalidaException.class)
	public void quandoConstruirComXMaiorQueSuperficieX_DeveDispararExcecao() throws SondaInvalidaException{
		TestComum.criarSonda(11, 5, 10, 5, "MMM");
	}
	
	@Test(expected=SondaInvalidaException.class)
	public void quandoConstruirComYMaiorQueSuperficieY_DeveDispararExcecao() throws SondaInvalidaException{
		TestComum.criarSonda(10, 6, 10, 5, "MMM");
	}
	
	@Test
	public void quandoConstruirComXYNoLimiteDaSuperficie_DeveCriar() throws SondaInvalidaException{
		TestComum.criarSonda(10, 5, 10, 5, "MMM");
	}
	
	@Test
	public void quandoConstruir_DeveAssociarPosicao() throws SondaInvalidaException{
		// Arrange
		Posicao expected = new Posicao(new Coordenada(10, 10), new Sul(null));
		
		// Act
		Sonda sonda = TestComum.criarSonda(10, 10, 20, 20, "MMM", new Sul(null));
		
		// Assert
		assertEquals(expected, sonda.getPosicao());
	}
	
	@Test
	public void quandoConstruir_DeveAssociarSuperficie() throws SondaInvalidaException{
		// Arrange
		Superficie expected = new Superficie(0, new Coordenada(4, 4));
		
		// Act
		Sonda sonda = TestComum.criarSonda(4, 4, 20, 20, "MMM", new Sul(null));
		
		// Assert
		assertEquals(expected, sonda.getSuperficie());
	}
	
	@Test
	public void quandoSondaSeMovimentar_PosicaoSondaDeveRefletirAcao() throws SondaInvalidaException{
		// Arrange
		Posicao expected = new Posicao(new Coordenada(10, 8), new Sul(null));
		
		// Act
		Sonda sonda = TestComum.criarSonda(10, 10, 10, 10, "MM", new Sul(null));
		sonda.movimentar();
		
		// Assert
		assertEquals(expected, sonda.getPosicao());
	}
	
	@Test
	public void quandoSondaSeMovimentarComOverload_PosicaoSondaDeveRefletirAcao() throws SondaInvalidaException{
		// Arrange
		Posicao expected = new Posicao(new Coordenada(6, 5), new Leste(null));
		
		// Act
		Sonda sonda = TestComum.criarSonda(5, 5, 10, 10, "MM", new Sul(TestComum.getOrientacaoFactory(10, 10)));
		sonda.movimentar("LM");
		
		// Assert
		assertEquals(expected, sonda.getPosicao());
	}

}
