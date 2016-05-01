package expedicao.unittest;

import static org.junit.Assert.*;

import org.junit.Test;

import expedicao.dominio.valueobject.Coordenada;

public class TestEquals {

	@Test
	public void quandoCoordenadasComXDiferentes_DeveRetornarFalso() {
		Coordenada coordenadaReferencia = new Coordenada(1, 2);
		Coordenada coordenadaComparar = new Coordenada(2, 2);
		
		assertNotEquals(coordenadaComparar, coordenadaReferencia);
	}
	
	@Test
	public void quandoCoordenadasComYDiferentes_DeveRetornarFalso() {
		Coordenada coordenadaReferencia = new Coordenada(2, 2);
		Coordenada coordenadaComparar = new Coordenada(2, 1);
		
		assertNotEquals(coordenadaComparar, coordenadaReferencia);
	}
	
	@Test
	public void quandoCoordenadasComXYDiferentes_DeveRetornarFalso() {
		Coordenada coordenadaReferencia = new Coordenada(2, 2);
		Coordenada coordenadaComparar = new Coordenada(1, 1);
		
		assertNotEquals(coordenadaComparar, coordenadaReferencia);
	}

	@Test
	public void quandoCoordenadasComXYIguais_DeveRetornarTrue() {
		Coordenada coordenadaReferencia = new Coordenada(2, 2);
		Coordenada coordenadaComparar = new Coordenada(2, 2);
		
		assertEquals(coordenadaComparar, coordenadaReferencia);
	}
	
	@Test
	public void quandoClasseComparacaoDiferenteDeCoordenada_DeveRetornarFalse() {
		Coordenada coordenadaReferencia = new Coordenada(2, 2);
		String outroObjeto = "";
		
		assertNotEquals(outroObjeto, coordenadaReferencia);
	}
		
}