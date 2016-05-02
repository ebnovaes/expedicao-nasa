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
	
	public boolean extrapolaSuperiorDireita(Coordenada coordenada){
		return this.x > coordenada.getX() || this.y > coordenada.getY();
	}
	
	public int hashCode() {
		final int primo = 31;
		int result = 1;
		result = primo * result + x;
		result = primo * result + y;
		return result;
	}

	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()){
			return false;
		}
			
		Coordenada that = (Coordenada) obj;
		return this.x == that.getX() && this.y == that.getY();
	}
	
	public String toString(){
		return String.format("%s %s", x, y);
	}
	
}
