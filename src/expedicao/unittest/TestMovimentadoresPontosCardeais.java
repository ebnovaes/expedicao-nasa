package expedicao.unittest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import expedicao.dominio.entidade.Superficie;
import expedicao.dominio.valueobject.*;
import expedicao.dominio.valueobject.movimento.*;

public class TestMovimentadoresPontosCardeais {

	@Before
	public void setUp() {
	}

	@Test
	public void quandoNorteRecebeCoordenadaX1Y5ELimiteEX1Y7_DeveRetornarCoordenadaX1Y6() {
		
		// Arrange
		Coordenada expected = new Coordenada(1, 6);
		Superficie superficie = getSuperficie(1, 7);
		MovimentoNorte norte = new MovimentoNorte(superficie);

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
		Superficie superficie = getSuperficie(1, 5);
		MovimentoNorte norte = new MovimentoNorte(superficie);

		// Act
		Coordenada coordenadaReferencia = new Coordenada(1, 5);
		Coordenada actual = norte.avancar(coordenadaReferencia);
		
		// Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void quandoNorteRecebeCoordenadaX1Y5ELimiteEX1Y4_DeveRetornarCoordenadaX1Y4() {

		// Arrange
		Coordenada expected = new Coordenada(1, 4);
		Superficie superficie = getSuperficie(1, 4);
		MovimentoNorte norte = new MovimentoNorte(superficie);

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
		MovimentoSul sul = new MovimentoSul();

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
		MovimentoSul sul = new MovimentoSul();

		// Act
		Coordenada coordenadaReferencia = new Coordenada(2, 3);
		Coordenada actual = sul.avancar(coordenadaReferencia);
		
		// Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void quandoSulRecebeCoordenadaX3Y1_DeveRetornarCoordenadaX3Y0() {
		// Arrange
		Coordenada expected = new Coordenada(3, 0);
		MovimentoSul sul = new MovimentoSul();

		// Act
		Coordenada coordenadaReferencia = new Coordenada(3, 1);
		Coordenada actual =  sul.avancar(coordenadaReferencia);
		
		// Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void quandoSulRecebeCoordenadaX5Y0_DeveRetornarCoordenadaX5Y0() {
		// Arrange
		Coordenada expected = new Coordenada(5, 0);
		MovimentoSul sul = new MovimentoSul();

		// Act
		Coordenada coordenadaReferencia = new Coordenada(5, 0);
		Coordenada actual =  sul.avancar(coordenadaReferencia);
		
		// Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void quandoOesteRecebeCoordenadaX2Y1_DeveRetornarCoordenadaX1Y1() {
		
		// Arrange
		Coordenada expected = new Coordenada(1, 1);
		MovimentoOeste oeste = new MovimentoOeste();

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
		MovimentoOeste oeste = new MovimentoOeste();

		// Act
		Coordenada coordenadaReferencia = new Coordenada(3, 2);
		Coordenada actual = oeste.avancar(coordenadaReferencia);
		
		// Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void quandoOesteRecebeCoordenadaX1Y3_DeveRetornarCoordenadaX0Y3() {
		// Arrange
		Coordenada expected = new Coordenada(0, 3);
		MovimentoOeste oeste = new MovimentoOeste();

		// Act
		Coordenada coordenadaReferencia = new Coordenada(1, 3);
		Coordenada actual =  oeste.avancar(coordenadaReferencia);
		
		// Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void quandoOesteRecebeCoordenadaX0Y5_DeveRetornarCoordenadaX0Y5() {
		// Arrange
		Coordenada expected = new Coordenada(0, 5);
		MovimentoOeste oeste = new MovimentoOeste();

		// Act
		Coordenada coordenadaReferencia = new Coordenada(0, 5);
		Coordenada actual =  oeste.avancar(coordenadaReferencia);
		
		// Assert
		assertEquals(expected, actual);
	}

	@Test
	public void quandoLesteRecebeCoordenadaX5Y1ELimiteEX7Y1_DeveRetornarCoordenadaX6Y1() {
		
		// Arrange
		Coordenada expected = new Coordenada(6, 1);
		Superficie superficie = getSuperficie(7, 1);
		MovimentoLeste leste = new MovimentoLeste(superficie);

		// Act
		Coordenada coordenadaReferencia = new Coordenada(5, 1);
		Coordenada actual = leste.avancar(coordenadaReferencia);
		
		// Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void quandoLesteRecebeCoordenadaX5Y1ELimiteX5Y1_DeveRetornarCoordenadaX5Y1() {

		// Arrange
		Coordenada expected = new Coordenada(5, 1);
		Superficie superficie = getSuperficie(5, 1);
		MovimentoLeste leste = new MovimentoLeste(superficie);

		// Act
		Coordenada coordenadaReferencia = new Coordenada(5, 1);
		Coordenada actual = leste.avancar(coordenadaReferencia);
		
		// Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void quandoLesteRecebeCoordenadaX5Y1ELimiteEX4Y1_DeveRetornarCoordenadaX4Y1() {

		// Arrange
		Coordenada expected = new Coordenada(4, 1);
		Superficie superficie = getSuperficie(4, 1);
		MovimentoLeste leste = new MovimentoLeste(superficie);

		// Act
		Coordenada coordenadaReferencia = new Coordenada(5, 1);
		Coordenada actual = leste.avancar(coordenadaReferencia);
		
		// Assert
		assertEquals(expected, actual);
	}
	
	private Superficie getSuperficie(int x, int y){
		Coordenada coordenada = new Coordenada(x, y);
		return new Superficie(0, coordenada);
	}

}