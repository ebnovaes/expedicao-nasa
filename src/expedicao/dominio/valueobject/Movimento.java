package expedicao.dominio.valueobject;

public abstract class Movimento {
	
	public Movimento(Movimento proximoMovimento, char comando, Posicao posicaoOrigem){
		this.proximoMovimento = proximoMovimento;
		this.comando = comando;
		this.posicaoOrigem = posicaoOrigem;
	}
	
	protected abstract boolean consegueTratar();
	
	protected abstract Posicao realizarMovimento();
	
	public Posicao movimentar(){
		if (this.consegueTratar()){
			return realizarMovimento();
		}
		
		if (proximoMovimento != null){
			return proximoMovimento.movimentar();
		}
		
		return null;
	}
	
	protected Movimento proximoMovimento;
	protected char comando;
	protected Posicao posicaoOrigem;
}
