package expedicao.unittest;

import static org.junit.Assert.*;
import org.junit.Test;

import expedicao.comum.ComumConstrucaoValueObject;
import expedicao.dominio.valueobject.Coordenada;
import expedicao.exception.CoordenadaParseException;

public class TestCommon {

	@Test(expected=CoordenadaParseException.class)
	public void quandoGetCoordenadasAuxiliarReceberNulo_deveDispararExcecao() throws CoordenadaParseException {
		ComumConstrucaoValueObject.getCoordenadas(null);
	}
	
	@Test(expected=CoordenadaParseException.class)
	public void quandoGetCoordenadasAuxiliarReceberVazio_deveDispararExcecao() throws CoordenadaParseException {
		ComumConstrucaoValueObject.getCoordenadas("");
	}
	
	@Test(expected=CoordenadaParseException.class)
	public void quandoGetCoordenadasAuxiliarReceberStringEspaco_deveDispararExcecao() throws CoordenadaParseException {
		ComumConstrucaoValueObject.getCoordenadas(" ");
	}
	
	@Test(expected=CoordenadaParseException.class)
	public void quandoGetCoordenadasAuxiliarReceberStringSemEspaco_deveDispararExcecao() throws CoordenadaParseException {
		ComumConstrucaoValueObject.getCoordenadas("12345");
	}
	
	@Test(expected=CoordenadaParseException.class)
	public void quandoGetCoordenadasAuxiliarReceberStringComDoisEspacos_deveDispararExcecao() throws CoordenadaParseException {
		ComumConstrucaoValueObject.getCoordenadas("12 34 5");
	}
	
	@Test(expected=CoordenadaParseException.class)
	public void quandoGetCoordenadasAuxiliarReceberValorXNaoInteiro_deveDispararExcecao() throws CoordenadaParseException {
		ComumConstrucaoValueObject.getCoordenadas("a1 10");
	}
	
	@Test(expected=CoordenadaParseException.class)
	public void quandoGetCoordenadasAuxiliarReceberValorYNaoInteiro_deveDispararExcecao() throws CoordenadaParseException {
		ComumConstrucaoValueObject.getCoordenadas("45 a9");
	}
	
	@Test
	public void quandoGetCoordenadasAuxiliarReceberStringComEixosXYInteiros_deveConstruirCoordenadas() throws CoordenadaParseException {
		// Arrange
		Coordenada esperado = new Coordenada(9, 10);
		
		// Act
		Coordenada actual = ComumConstrucaoValueObject.getCoordenadas("9 10");
		
		// Assert
		assertEquals(esperado, actual);
	}

}
