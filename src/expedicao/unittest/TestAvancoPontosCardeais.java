package expedicao.unittest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import expedicao.dominio.entidade.Superficie;
import expedicao.dominio.valueobject.*;

public class TestAvancoPontosCardeais {

	@Before
	public void setUp() {
	}

	@Test
	public void quandoNorteRecebeCoordenadaX1Y5ELimiteEX1Y7_DeveRetornarCoordenadaX1Y6() {
		
		// Arrange
		Coordenada expected = new Coordenada(1, 6);
		OrientacaoFactory factory = getOrientacaoFactory(1, 7);
		Norte norte = new Norte(factory);

		// Act
		Coordenada coordenadaReferencia = new Coordenada(1, 5);
		Coordenada actual = norte.avancar(coordenadaReferencia);
		
		// Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void quandoNorteRecebeCoordenadaX1Y5ELimiteX1Y5_DeveRetornarCoordenadaX1Y5() {

		// Arrange
		Coordenada expected = new Coordenada(1, 5);
		OrientacaoFactory factory = getOrientacaoFactory(1, 5);
		Norte norte = new Norte(factory);

		// Act
		Coordenada coordenadaReferencia = new Coordenada(1, 5);
		Coordenada actual = norte.avancar(coordenadaReferencia);
		
		// Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void quandoNorteRecebeCoordenadaX1Y5ELimiteEX1Y4_DeveRetornarCoordenadaX1Y4() {

		// Arrange
		Coordenada expected = new Coordenada(1, 5);
		OrientacaoFactory factory = getOrientacaoFactory(1, 4);
		Norte norte = new Norte(factory);

		// Act
		Coordenada coordenadaReferencia = new Coordenada(1, 5);
		Coordenada actual = norte.avancar(coordenadaReferencia);
		
		// Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void quandoSulRecebeCoordenadaX1Y2_DeveRetornarCoordenadaX1Y1() {
		
		// Arrange
		Coordenada expected = new Coordenada(1, 1);
		OrientacaoFactory factory = getOrientacaoFactory(1, 2);
		Sul sul = new Sul(factory);

		// Act
		Coordenada coordenadaReferencia = new Coordenada(1, 2);
		Coordenada actual = sul.avancar(coordenadaReferencia);
		
		// Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void quandoSulRecebeCoordenadaX2Y3_DeveRetornarCoordenadaX2Y2() {
		
		// Arrange
		Coordenada expected = new Coordenada(2, 2);
		OrientacaoFactory factory = getOrientacaoFactory(2, 3);
		Sul sul = new Sul(factory);

		// Act
		Coordenada coordenadaReferencia = new Coordenada(2, 3);
		Coordenada actual = sul.avancar(coordenadaReferencia);
		
		// Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void quandoSulRecebeCoordenadaX3Y1_DeveRetornarCoordenadaX3Y1() {
		// Arrange
		Coordenada expected = new Coordenada(3, 1);
		OrientacaoFactory factory = getOrientacaoFactory(3, 1);
		Sul sul = new Sul(factory);

		// Act
		Coordenada coordenadaReferencia = new Coordenada(3, 1);
		Coordenada actual =  sul.avancar(coordenadaReferencia);
		
		// Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void quandoOesteRecebeCoordenadaX2Y1_DeveRetornarCoordenadaX1Y1() {
		
		// Arrange
		Coordenada expected = new Coordenada(1, 1);
		OrientacaoFactory factory = getOrientacaoFactory(2, 1);
		Oeste oeste = new Oeste(factory);

		// Act
		Coordenada coordenadaReferencia = new Coordenada(2, 1);
		Coordenada actual = oeste.avancar(coordenadaReferencia);
		
		// Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void quandoOesteRecebeCoordenadaX3Y2_DeveRetornarCoordenadaX2Y2() {
		
		// Arrange
		Coordenada expected = new Coordenada(2, 2);
		OrientacaoFactory factory = getOrientacaoFactory(3, 2);
		Oeste oeste = new Oeste(factory);

		// Act
		Coordenada coordenadaReferencia = new Coordenada(3, 2);
		Coordenada actual = oeste.avancar(coordenadaReferencia);
		
		// Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void quandoOesteRecebeCoordenadaX1Y3_DeveRetornarCoordenadaX1Y3() {
		// Arrange
		Coordenada expected = new Coordenada(1, 3);
		OrientacaoFactory factory = getOrientacaoFactory(1, 3);
		Oeste oeste = new Oeste(factory);

		// Act
		Coordenada coordenadaReferencia = new Coordenada(1, 3);
		Coordenada actual =  oeste.avancar(coordenadaReferencia);
		
		// Assert
		assertEquals(expected, actual);
	}

	private OrientacaoFactory getOrientacaoFactory(int x, int y){
		Coordenada coordenada = new Coordenada(x, y);
		Superficie superficie = new Superficie(coordenada);
		return new OrientacaoFactory(superficie);
	}
}
