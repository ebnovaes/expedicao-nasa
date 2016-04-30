import expedicao.dominio.entidade.Robo;
import expedicao.dominio.entidade.Superficie;
import expedicao.dominio.valueobject.Coordenada;
import expedicao.dominio.valueobject.Orientacao;
import expedicao.dominio.valueobject.OrientacaoFactory;
import expedicao.dominio.valueobject.Posicao;

public class program {

	public static void main(String[] args){
		Coordenada coordenada = new Coordenada(0, 0);
		Superficie superficie = new Superficie(coordenada);
		OrientacaoFactory orientacaoFactory = new OrientacaoFactory(superficie);
		Orientacao orientacao = orientacaoFactory.getNorte();
		Posicao posicao = new Posicao(coordenada, orientacao);
		Robo robo = new Robo(orientacaoFactory);
	}
}
