package expedicao.unittest;

import java.util.*;

import expedicao.dominio.entidade.*;
import expedicao.dominio.valueobject.Coordenada;
import expedicao.dominio.valueobject.orientacao.Norte;
import expedicao.exception.SondaInvalidaException;

public class TestRepositorioFake {

	public static List<Sonda> buildCincoSondasSendoDuasPassadasETresAleatorias(List<Sonda> sondasSuperficie) throws SondaInvalidaException{
		List<Sonda> retorno = new ArrayList<Sonda>();
		retorno.addAll(sondasSuperficie);
		
		Superficie superficie = new Superficie(2, new Coordenada(10, 10));
		retorno.add(TestComum.criarSonda(10, 10, 1, superficie, "MMM", new Norte(null)));
		retorno.add(TestComum.criarSonda(9, 9, 2, superficie, "MMM", new Norte(null)));
		retorno.add(TestComum.criarSonda(8, 8, 3, superficie, "MMM", new Norte(null)));
		
		return retorno;
	}
}
