package expedicao.unittest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import expedicao.dominio.valueobject.Avancador;
import expedicao.dominio.valueobject.movimentador.*;

public class TestMovimentadoresResponsabilidade {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void quandoComandoDireitaRMaiusculo_deveConseguirTratar() {
		// Arrange
		MovimentadorDireita movimentadorDireita = new MovimentadorDireita(null);
		
		// Act
		boolean consegueTratar = movimentadorDireita.consegueTratar('R');
		
		// Assert
		assertTrue(consegueTratar);
	}

	@Test
	public void quandoComandoDireitaRMinusculo_deveConseguirTratar() {
		// Arrange
		MovimentadorDireita movimentadorDireita = new MovimentadorDireita(null);
		
		// Act
		boolean consegueTratar = movimentadorDireita.consegueTratar('r');
		
		// Assert
		assertTrue(consegueTratar);
	}
	
	@Test
	public void quandoComandoDireitaNaoRQualquerCaso_naoDeveConseguirTratar() {
		// Arrange
		MovimentadorDireita movimentadorDireita = new MovimentadorDireita(null);
		
		// Act
		boolean consegueTratar = movimentadorDireita.consegueTratar('L');
		
		// Assert
		assertFalse(consegueTratar);
	}
	 
	@Test
	public void quandoComandoDireitaVazio_naoDeveConseguirTratar() {
		// Arrange
		MovimentadorDireita movimentadorDireita = new MovimentadorDireita(null);
		
		// Act
		boolean consegueTratar = movimentadorDireita.consegueTratar(' ');
		
		// Assert
		assertFalse(consegueTratar);
	}
	
	@Test
	public void quandoComandoEsquerdaLMaiusculo_deveConseguirTratar() {
		// Arrange
		MovimentadorEsquerda movimentadorEsquerda = new MovimentadorEsquerda(null);
		
		// Act
		boolean consegueTratar = movimentadorEsquerda.consegueTratar('L');
		
		// Assert
		assertTrue(consegueTratar);
	}

	@Test
	public void quandoComandoEsquerdaLMinusculo_deveConseguirTratar() {
		// Arrange
		MovimentadorEsquerda movimentadorEsquerda = new MovimentadorEsquerda(null);
		
		// Act
		boolean consegueTratar = movimentadorEsquerda.consegueTratar('l');
		
		// Assert
		assertTrue(consegueTratar);
	}
	
	@Test
	public void quandoComandoEsquerdaNaoLQualquerCaso_naoDeveConseguirTratar() {
		// Arrange
		MovimentadorEsquerda movimentadorEsquerda = new MovimentadorEsquerda(null);
		
		// Act
		boolean consegueTratar = movimentadorEsquerda.consegueTratar('R');
		
		// Assert
		assertFalse(consegueTratar);
	}
	 
	@Test
	public void quandoComandoEsquerdaVazio_naoDeveConseguirTratar() {
		// Arrange
		MovimentadorEsquerda movimentadorEsquerda = new MovimentadorEsquerda(null);
		
		// Act
		boolean consegueTratar = movimentadorEsquerda.consegueTratar(' ');
		
		// Assert
		assertFalse(consegueTratar);
	}
	
	@Test
	public void quandoComandoAvancadorMMaiusculo_deveConseguirTratar() {
		// Arrange
		Avancador avancador = new Avancador(null);
		
		// Act
		boolean consegueTratar = avancador.consegueTratar('M');
		
		// Assert
		assertTrue(consegueTratar);
	}

	@Test
	public void quandoComandoAvancadorMMinusculo_deveConseguirTratar() {
		// Arrange
		Avancador avancador = new Avancador(null);
		
		// Act
		boolean consegueTratar = avancador.consegueTratar('m');
		
		// Assert
		assertTrue(consegueTratar);
	}
	
	@Test
	public void quandoComandoAvancadorNaoMQualquerCaso_naoDeveConseguirTratar() {
		// Arrange
		Avancador avancador = new Avancador(null);
		
		// Act
		boolean consegueTratar = avancador.consegueTratar('Y');
		
		// Assert
		assertFalse(consegueTratar);
	}
	 
	@Test
	public void quandoComandoAvancadorVazio_naoDeveConseguirTratar() {
		// Arrange
		Avancador avancador = new Avancador(null);
		
		// Act
		boolean consegueTratar = avancador.consegueTratar(' ');
		
		// Assert
		assertFalse(consegueTratar);
	}
}
