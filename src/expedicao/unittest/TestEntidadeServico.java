package expedicao.unittest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import expedicao.dominio.entidade.*;
import expedicao.dominio.valueobject.Coordenada;
import expedicao.dominio.valueobject.Posicao;
import expedicao.dominio.valueobject.orientacao.Norte;
import expedicao.dominio.valueobject.orientacao.Sul;
import expedicao.exception.SondaInvalidaException;
import expedicao.repositorio.EntidadeRepositorio;
import expedicao.servico.EntidadeServico;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class TestEntidadeServico {

	@Before
	public void setUp() throws Exception {
		this.mockRepositorio = mock(EntidadeRepositorio.class);
		entidadeServico = new EntidadeServico(this.mockRepositorio); 
	}

	@Test
	public void quandoRepositorioPossuiMaisDeUmaSuperficie_DeveRecuperarSomenteSondasDaSuperficieInformada() throws SondaInvalidaException {
	
		// Arrange
		Superficie superficie = new Superficie(1, new Coordenada(10, 10));
		List<Sonda> listaExpected = new ArrayList<>();
		listaExpected.add(TestComum.criarSonda(10, 10, 2, superficie, "MMM", new Norte(null)));
		listaExpected.add(TestComum.criarSonda(9, 9, 1, superficie, "MMM", new Norte(null)));
		List<Sonda> listaFake = TestRepositorioFake.buildCincoSondasSendoDuasPassadasETresAleatorias(listaExpected);
		when(this.mockRepositorio.getSondas()).thenReturn(listaFake);
		
		// Act
		List<Sonda> listaActual = entidadeServico.getSondas(superficie);

		// Assert
		assertTrue(listasIguais(listaExpected, listaActual));
	}
	
	@Test
	public void deveRecuperarListaOrdenadaPeloAtributoOrdem() throws SondaInvalidaException {
	
		// Arrange
		Superficie superficie = new Superficie(1, new Coordenada(10, 10));
		List<Sonda> listaExpected = new ArrayList<>();
		listaExpected.add(TestComum.criarSonda(10, 10, 1, superficie, "MMM", new Norte(null)));
		listaExpected.add(TestComum.criarSonda(9, 9, 4, superficie, "MMM", new Norte(null)));
		listaExpected.add(TestComum.criarSonda(10, 10, 3, superficie, "MMM", new Norte(null)));
		listaExpected.add(TestComum.criarSonda(10, 10, 2, superficie, "MMM", new Norte(null)));
		when(this.mockRepositorio.getSondas()).thenReturn(listaExpected);
		
		// Act
		List<Sonda> listaActual = entidadeServico.getSondas(superficie);

		// Assert
		assertEquals(4, listaActual.get(3).getOrdem());
	}
	
	@Test
	public void quandoInformarSuperficieEOrdem_deveRecuperarSondaSegundoCriterios() throws SondaInvalidaException {
	
		// Arrange
		Superficie superficie = new Superficie(1, new Coordenada(10, 10));
		List<Sonda> lista = new ArrayList<>();
		int ordemExpected = 23;
		Sonda sondaExpected = TestComum.criarSonda(10, 10, ordemExpected, superficie, "MMM", new Norte(null));
		lista.add(sondaExpected);
		lista.add(TestComum.criarSonda(9, 9, 4, superficie, "MMM", new Norte(null)));
		lista.add(TestComum.criarSonda(10, 10, 10, 12, "MMM", new Norte(null)));
		when(this.mockRepositorio.getSondas()).thenReturn(lista);
		
		// Act
		Sonda sondaActual = entidadeServico.getSonda(superficie, 23);

		// Assert
		assertEquals(sondaExpected, sondaActual);
	}
	
	@Test
	public void quandoInformarSuperficieEOrdemNaoExistentes_deveRetornarNulo() throws SondaInvalidaException {
	
		// Arrange
		Superficie superficie = new Superficie(1, new Coordenada(10, 10));
		List<Sonda> lista = new ArrayList<>();
		lista.add(TestComum.criarSonda(9, 9, 4, superficie, "MMM", new Norte(null)));
		lista.add(TestComum.criarSonda(10, 10, 10, 12, "MMM", new Norte(null)));
		when(this.mockRepositorio.getSondas()).thenReturn(lista);
		
		// Act
		Sonda sondaActual = entidadeServico.getSonda(superficie, 10);

		// Assert
		assertNull(sondaActual);
	}
	
	private boolean listasIguais(List<Sonda> expected, List<Sonda> actual){
		if (expected.size() != actual.size()){
			return false;
		}
		
		for (Sonda s : expected){
			boolean achou = false;
			for (Sonda s2 : actual){
				if (s2.getOrdem() == s.getOrdem() && s2.getSuperficie() == s.getSuperficie()){
					achou = true;
				}
			}
			if (!achou){
				return false;
			}
		}
		
		return true;
	}
	
	private EntidadeRepositorio mockRepositorio;
	private EntidadeServico entidadeServico;
}
