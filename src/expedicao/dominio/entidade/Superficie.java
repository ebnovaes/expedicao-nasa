package expedicao.dominio.entidade;

import expedicao.dominio.valueobject.Coordenada;

public final class Superficie {


	public Superficie(int codigo, Coordenada tamanhoMaximoSuperficie) {
		this.codigo = codigo;
		this.coordenada = tamanhoMaximoSuperficie;
	}

	public Coordenada getTamanhoMaximoSuperficie() {
		return new Coordenada(coordenada.getX(), coordenada.getY());
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		
		Superficie that = (Superficie) obj;
		return codigo == that.codigo;
	}

	
	private Coordenada coordenada;

	private int codigo;
}
