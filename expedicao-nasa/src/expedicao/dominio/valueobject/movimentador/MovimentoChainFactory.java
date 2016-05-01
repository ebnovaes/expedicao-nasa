package expedicao.dominio.valueobject.movimentador;

import expedicao.dominio.valueobject.Avancador;

public final class MovimentoChainFactory {

	public Movimento construir(){
		MovimentadorEsquerda movimentadorEsquerda = new MovimentadorEsquerda(null);
		MovimentadorDireita movimentadorDireita = new MovimentadorDireita(movimentadorEsquerda);
		Avancador avancador = new Avancador(movimentadorDireita);
		return avancador;
	}
}
