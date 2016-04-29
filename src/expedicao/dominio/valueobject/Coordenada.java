package expedicao.dominio.valueobject;

public class Coordenada {

	public Coordenada(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	private int x;
	
	private int y;
}
