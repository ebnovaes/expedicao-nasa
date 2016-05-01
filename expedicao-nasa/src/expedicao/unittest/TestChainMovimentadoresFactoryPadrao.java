package expedicao.unittest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import expedicao.dominio.valueobject.*;

public class TestChainMovimentadoresFactoryPadrao {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void criacaoFabrica_DeveHaverUmObjetoAvancador() {
		MovimentoChainFactory factory = new MovimentoChainFactory();
		Movimento movimentoChain = factory.construir();
		
		boolean encontrou = acharClasse(movimentoChain, Avancador.class.getName());
		
		assertTrue(encontrou);
	}
	
	@Test
	public void criacaoFabrica_DeveHaverUmObjetoMovimentoDireita() {
		MovimentoChainFactory factory = new MovimentoChainFactory();
		Movimento movimentoChain = factory.construir();
		
		boolean encontrou = acharClasse(movimentoChain, MovimentadorDireita.class.getName());
		
		assertTrue(encontrou);
	}
	
	@Test
	public void criacaoFabrica_DeveHaverUmObjetoMovimentoEsquerda() {
		MovimentoChainFactory factory = new MovimentoChainFactory();
		Movimento movimentoChain = factory.construir();
		
		boolean encontrou = acharClasse(movimentoChain, MovimentadorEsquerda.class.getName());
		
		assertTrue(encontrou);
	}

	private boolean acharClasse(Movimento movimentoChain, String nomeClasse) {
		boolean encontrou = false;
		
		Movimento movimento = movimentoChain;
		while (!encontrou && movimento != null){
			encontrou = movimento.getClass().getName() == nomeClasse;
			movimento = movimento.getProximoMovimento();
		}
		return encontrou;
	}

}
