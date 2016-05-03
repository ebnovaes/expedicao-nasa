package expedicao.repositorio;

import java.util.List;

import expedicao.dominio.entidade.Sonda;
import expedicao.dominio.entidade.Superficie;

public interface EntidadeRepositorio {

	List<Superficie> getSuperficies();

	List<Sonda> getSondas();

	void adicionarSuperficie(Superficie superficie);

	void adicionarSonda(Sonda sonda);

	int getMaxSuperficieCodigo();

	int getMaxSondaOrdem(Superficie superficie);

	void excluirSuperficie(Superficie superficie);

}