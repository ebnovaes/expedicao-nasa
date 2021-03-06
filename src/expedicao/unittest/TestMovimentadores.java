package expedicao.unittest;

import static org.junit.Assert.*;

import org.junit.Test;

import expedicao.dominio.entidade.Superficie;
import expedicao.dominio.valueobject.*;
import expedicao.dominio.valueobject.movimentador.*;
import expedicao.dominio.valueobject.orientacao.*;

public class TestMovimentadores {

	@Test
	public void quandoApontarParaSulMovimentadorDireitaAcionado_DeveRetornarNovaPosicaoApontandoParaOeste() {
		Coordenada coordenada = new Coordenada(0, 0);
		Superficie superficie = new Superficie(0, coordenada);
		OrientacaoFactory factory = new OrientacaoFactory(superficie);
		Orientacao orientacaoExpected = new Oeste(factory);
		Posicao expected = new Posicao(coordenada, orientacaoExpected);
		
		MovimentadorDireita movimentadorDireita = new MovimentadorDireita(null);
		Orientacao orientacao = new Sul(factory);
		Posicao posicao = new Posicao(coordenada, orientacao);
		Posicao actual = movimentadorDireita.movimentar('r', posicao);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void quandoApontarParaLesteMovimentadorEsquerdaAcionado_DeveRetornarNovaPosicaoApontandoParaNorte() {
		Coordenada coordenada = new Coordenada(0, 0);
		OrientacaoFactory factory = TestComum.getOrientacaoFactory();
		Orientacao orientacaoExpected = new Norte(factory);
		Posicao expected = new Posicao(coordenada, orientacaoExpected);
		
		MovimentadorEsquerda movimentadorEsquerda = new MovimentadorEsquerda(null);
		Orientacao orientacao = new Leste(factory);
		Posicao posicao = new Posicao(coordenada, orientacao);
		Posicao actual = movimentadorEsquerda.movimentar('l', posicao);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void quandoCoordenadaX2Y1MovimentadorAvancadorApontandoParaOeste_deveRetornarNovaCoordenadaX1Y1() {
		// Arrange
		Coordenada coordenadaExpected = new Coordenada(1, 1);
		OrientacaoFactory factory = TestComum.getOrientacaoFactory();
		Orientacao orientacao = new Oeste(factory);
		Posicao expected = new Posicao(coordenadaExpected, orientacao);
		Coordenada coordenadaActual = new Coordenada(2, 1);
		
		// Act
		Avancador avancador = new Avancador(null);
		Posicao posicao = new Posicao(coordenadaActual, orientacao);
		Posicao actual = avancador.movimentar('m', posicao);
		
		// Assert
		assertEquals(expected, actual);
	}

}