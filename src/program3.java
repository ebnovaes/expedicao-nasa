import expedicao.dominio.entidade.Sonda;
import expedicao.dominio.entidade.Superficie;
import expedicao.dominio.valueobject.Coordenada;
import expedicao.dominio.valueobject.Posicao;
import expedicao.dominio.valueobject.orientacao.Orientacao;
import expedicao.dominio.valueobject.orientacao.OrientacaoFactory;
import expedicao.repositorio.EntidadeRepositorioImpl;

public class program3 {

	public static void main(String[] args) throws Exception{
		Coordenada coordenada = new Coordenada(1, 2);
		Coordenada coordenadaSuperficie = new Coordenada(5, 5);
		Superficie superficie = new Superficie(0, coordenadaSuperficie);
		OrientacaoFactory orientacaoFactory = new OrientacaoFactory(superficie);
		Orientacao orientacao = orientacaoFactory.getNorte();
		Posicao posicao = new Posicao(coordenada, orientacao);
		String movimento = "LMLMLMLMM";
		EntidadeRepositorioImpl.getInstancia().adicionarSuperficie(superficie);
		
		Sonda sonda = new Sonda(posicao, superficie, 0, "LMLMLMLMM");
		posicao = sonda.movimentar(movimento);
		EntidadeRepositorioImpl.getInstancia().adicionarSonda(sonda);
		coordenada = new Coordenada(3, 3);
		orientacao = orientacaoFactory.getLeste();
		posicao = new Posicao(coordenada, orientacao);
		sonda = new Sonda(posicao, superficie, 0, "A");
		movimento = "MMRMMRMRRM";
		EntidadeRepositorioImpl.getInstancia().adicionarSonda(sonda);
		posicao = sonda.movimentar(movimento);
		
	}
}
