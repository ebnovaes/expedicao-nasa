package expedicao.unittest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import expedicao.dominio.valueobject.*;


public class TestAvancoPontosCardeais {

	@Before
	public void setUp() {
	}

	@Test
	public void quandoNorteRecebeCoordenadaX1Y5ELimiteEX1Y7_DevePermitirAvanco() {
		// Arrange
		OrientacaoFactory factory = getOrientacaoFactory(1, 7);
		Norte norte = new Norte(factory);

		// Act
		Coordenada coordenadaReferencia = new Coordenada(1, 5);
		boolean actual = norte.isPermitidoAvancar(coordenadaReferencia);
		
		// Assert
		assertTrue(actual);
	}
	
	@Test
	public void quandoNorteRecebeCoordenadaX1Y5ELimiteEX1Y5_DeveBloquearAvanco() {
		// Arrange
		OrientacaoFactory factory = getOrientacaoFactory(1, 5);
		Norte norte = new Norte(factory);

		// Act
		Coordenada coordenadaReferencia = new Coordenada(1, 5);
		boolean actual = norte.isPermitidoAvancar(coordenadaReferencia);
		
		// Assert
		assertFalse(actual);
	}
	
	@Test
	public void quandoNorteRecebeCoordenadaX1Y5ELimiteEX1Y4_DeveBloquearAvanco() {
		// Arrange
		OrientacaoFactory factory = getOrientacaoFactory(1, 4);
		Norte norte = new Norte(factory);

		// Act
		Coordenada coordenadaReferencia = new Coordenada(1, 5);
		boolean actual = norte.isPermitidoAvancar(coordenadaReferencia);
		
		// Assert
		assertFalse(actual);
	}
	
	@Test
	public void quandoSulRecebeCoordenadaX1Y2_DevePermitirAvanco() {
		// Arrange
		OrientacaoFactory factory = getOrientacaoFactory(1, 1);
		Sul sul = new Sul(factory);

		// Act
		Coordenada coordenadaReferencia = new Coordenada(1, 2);
		boolean actual = sul.isPermitidoAvancar(coordenadaReferencia);
		
		// Assert
		assertTrue(actual);
	}
	
	@Test
	public void quandoSulRecebeCoordenadaX1Y3_DevePermitirAvanco() {
		// Arrange
		OrientacaoFactory factory = getOrientacaoFactory(1, 1);
		Sul sul = new Sul(factory);

		// Act
		Coordenada coordenadaReferencia = new Coordenada(1, 3);
		boolean actual = sul.isPermitidoAvancar(coordenadaReferencia);
		
		// Assert
		assertTrue(actual);
	}
	
	@Test
	public void quandoSulRecebeCoordenadaX1Y1_DevePermitirAvanco() {
		// Arrange
		OrientacaoFactory factory = getOrientacaoFactory(1, 1);
		Sul sul = new Sul(factory);

		// Act
		Coordenada coordenadaReferencia = new Coordenada(1, 1);
		boolean actual = sul.isPermitidoAvancar(coordenadaReferencia);
		
		// Assert
		assertFalse(actual);
	}

	private OrientacaoFactory getOrientacaoFactory(int x, int y){
		Coordenada coordenada = new Coordenada(x, y);
		return new OrientacaoFactory(coordenada);
	}
}
