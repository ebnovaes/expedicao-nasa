package expedicao.rest.modelo;

import java.util.ArrayList;
import java.util.List;

import expedicao.dominio.entidade.Sonda;
import expedicao.dominio.entidade.Superficie;

public final class SondaModel {

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public String getMovimento() {
		return movimento;
	}

	public void setMovimento(String movimento) {
		this.movimento = movimento;
	}

	public static List<SondaModel> transformarBaseadoEm(Superficie superficie, List<Sonda> sondas) {
		List<SondaModel> retorno = new ArrayList<>();
		for (Sonda s : sondas) {
			if (s.getSuperficie().equals(superficie)) {
				SondaModel sondaModel = new SondaModel();
				sondaModel.setOrdem(s.getOrdem());
				sondaModel.setPosicao(s.getPosicao().toString());
				sondaModel.setMovimento(s.getCadeiaComados());
				retorno.add(sondaModel);
			}
		}

		return retorno;
	}

	public static SondaModel transformarBaseadoEm(Sonda sonda) {
		SondaModel sondaModel = new SondaModel();
		sondaModel.setOrdem(sonda.getOrdem());
		sondaModel.setPosicao(sonda.getPosicao().toString());
		sondaModel.setMovimento(sonda.getCadeiaComados());
		return sondaModel;
	}

	private int ordem;
	
	private String posicao;

	private String movimento;
}
