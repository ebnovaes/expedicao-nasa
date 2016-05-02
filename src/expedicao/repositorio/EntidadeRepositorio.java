package expedicao.repositorio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import expedicao.dominio.entidade.*;

public final class EntidadeRepositorio {
	
	private EntidadeRepositorio(){
		this.superficies = new ArrayList<Superficie>();
		this.sondas = new ArrayList<Sonda>();
	}
	
	public List<Superficie> getSuperficies() {
		return new ArrayList<Superficie>(this.superficies);
	}
	
	public List<Sonda> getSondas() {
		return new ArrayList<Sonda>(this.sondas);
	}
	
	public void adicionarSuperficie(Superficie superficie){
		this.superficies.add(superficie);
	}

	public void adicionarSonda(Sonda sonda){
		this.sondas.add(sonda);
	}

	public int getMaxSuperficieCodigo(){
		int ultimoCodigo = 0;
		
		List<Superficie> superficies = getSuperficies();
		Optional<Superficie> max = superficies
							      .stream()
								  .max(Comparator.comparing(s -> s.getCodigo()));
		
		if (max.isPresent()){
			ultimoCodigo = max.get().getCodigo();
		}
		
		return ultimoCodigo;
	}
	
	public int getMaxSondaOrdem(Superficie superficie){
		int ultimoElemento = 0;
		
		Optional<Sonda> max = 
				   sondas
				  .stream()
				  .filter(f -> f.getSuperficie().equals(superficie))
				  .max(Comparator.comparing(s -> s.getOrdem()));

		if (max.isPresent()){
			ultimoElemento =  max.get().getOrdem();
		}
		
		return ultimoElemento;
	}
		
	private List<Superficie> superficies;
	
	private List<Sonda> sondas;
	
	public static EntidadeRepositorio getInstancia() {
		return instancia;
	}
	
	private static EntidadeRepositorio instancia = new EntidadeRepositorio();

	public void excluirSuperficie(Superficie superficie) {
		this.superficies.removeIf(s -> s.equals(superficie));
	}
}
