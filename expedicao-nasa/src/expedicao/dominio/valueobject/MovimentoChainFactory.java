package expedicao.dominio.valueobject;

public final class MovimentoChainFactory {

	public Movimento construir(){
		MovimentadorEsquerda movimentadorEsquerda = new MovimentadorEsquerda(null);
		MovimentadorDireita movimentadorDireita = new MovimentadorDireita(movimentadorEsquerda);
		Avancador avancador = new Avancador(movimentadorDireita);
		return avancador;
	}
}
