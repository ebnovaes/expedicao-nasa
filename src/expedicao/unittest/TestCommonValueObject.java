package expedicao.unittest;

import static org.junit.Assert.*;
import org.junit.Test;

import expedicao.comum.ComumConstrucaoValueObject;
import expedicao.dominio.valueobject.Coordenada;
import expedicao.dominio.valueobject.Posicao;
import expedicao.dominio.valueobject.orientacao.*;
import expedicao.dominio.valueobject.orientacao.OrientacaoFactory;
import expedicao.exception.CoordenadaParseException;
import expedicao.exception.PosicaoParseException;

public class TestCommonValueObject {

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

	@Test(expected=PosicaoParseException.class)
	public void quandoGetPosicaoAuxiliarReceberNulo_deveDispararExcecao() throws PosicaoParseException {
		OrientacaoFactory factory = TestComum.getOrientacaoFactory();
		ComumConstrucaoValueObject.getPosicao(null, factory);
	}
	
	@Test(expected=PosicaoParseException.class)
	public void quandoGetPosicaoAuxiliarReceberVazio_deveDispararExcecao() throws PosicaoParseException {
		OrientacaoFactory factory = TestComum.getOrientacaoFactory();
		ComumConstrucaoValueObject.getPosicao("", factory);
	}
	
	@Test(expected=PosicaoParseException.class)
	public void quandoGetPosicaoAuxiliarReceberStringSemEspaco_deveDispararExcecao() throws PosicaoParseException {
		OrientacaoFactory factory = TestComum.getOrientacaoFactory();
		ComumConstrucaoValueObject.getPosicao("12345", factory);
	}
	
	@Test(expected=PosicaoParseException.class)
	public void quandoGetPosicaoAuxiliarReceberStringComUmEspaco_deveDispararExcecao() throws PosicaoParseException {
		OrientacaoFactory factory = TestComum.getOrientacaoFactory();
		ComumConstrucaoValueObject.getPosicao("123 45", factory);
	}
	
	@Test(expected=PosicaoParseException.class)
	public void quandoGetPosicaoAuxiliarReceberPosicaoNaoNSEW_deveDispararExcecao() throws PosicaoParseException {
		OrientacaoFactory factory = TestComum.getOrientacaoFactory();
		ComumConstrucaoValueObject.getPosicao("1 2 X", factory);
	}
	
	@Test(expected=PosicaoParseException.class)
	public void quandoGetPosicaoAuxiliarReceberPosicaoNSEWCoordenadaIncorreta_deveDispararExcecao() throws PosicaoParseException {
		OrientacaoFactory factory = TestComum.getOrientacaoFactory();
		ComumConstrucaoValueObject.getPosicao("q 1 W", factory);
	}
	
	@Test
	public void quandoGetPosicaoAuxiliarReceberPosicaoN_deveConstruirPosicao() throws PosicaoParseException {
		// Arrange
		OrientacaoFactory factory = TestComum.getOrientacaoFactory();
		Posicao expected = new Posicao(new Coordenada(1, 1), new Norte(factory));
		
		// Act
		Posicao actual = ComumConstrucaoValueObject.getPosicao("1 1 N", factory);

		// Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void quandoGetPosicaoAuxiliarReceberPosicaoW_deveConstruirPosicao() throws PosicaoParseException {
		// Arrange
		OrientacaoFactory factory = TestComum.getOrientacaoFactory();
		Posicao expected = new Posicao(new Coordenada(10, 5), new Oeste(factory));
		
		// Act
		Posicao actual = ComumConstrucaoValueObject.getPosicao("10 5 W", factory);

		// Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void quandoGetPosicaoAuxiliarReceberPosicaoS_deveConstruirPosicao() throws PosicaoParseException {
		// Arrange
		OrientacaoFactory factory = TestComum.getOrientacaoFactory();
		Posicao expected = new Posicao(new Coordenada(7, 2), new Sul(factory));
		
		// Act
		Posicao actual = ComumConstrucaoValueObject.getPosicao("7 2 S", factory);

		// Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void quandoGetPosicaoAuxiliarReceberPosicaoL_deveConstruirPosicao() throws PosicaoParseException {
		// Arrange
		OrientacaoFactory factory = TestComum.getOrientacaoFactory();
		Posicao expected = new Posicao(new Coordenada(4, 5), new Leste(factory));
		
		// Act
		Posicao actual = ComumConstrucaoValueObject.getPosicao("4 5 E", factory);

		// Assert
		assertEquals(expected, actual);
	}
}
