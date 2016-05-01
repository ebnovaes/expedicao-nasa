package expedicao.dominio.valueobject;

public abstract class Movimento {
	
	public Movimento(Movimento proximoMovimento){
		this.proximoMovimento = proximoMovimento;
	}
	
	protected abstract boolean consegueTratar(char comando);
	
	protected abstract Posicao realizarMovimento(Posicao posicaoOrigem);
	
	public Posicao movimentar(char comando, Posicao posicaoOrigem){
		if (this.consegueTratar(comando)){
			return realizarMovimento(posicaoOrigem);
		}
		
		if (proximoMovimento != null){
			return proximoMovimento.movimentar(comando, posicaoOrigem);
		}
		
		return null;
	}
	
	public Movimento getProximoMovimento(){
		return this.proximoMovimento;
	}
	
	protected Movimento proximoMovimento;
}
