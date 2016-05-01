import expedicao.dominio.entidade.Sonda;
import expedicao.dominio.entidade.Superficie;
import expedicao.dominio.valueobject.Coordenada;
import expedicao.dominio.valueobject.Posicao;
import expedicao.dominio.valueobject.orientacao.Orientacao;
import expedicao.dominio.valueobject.orientacao.OrientacaoFactory;

public class program {

	public static void main(String[] args){
		
//		Coordenada coordenada = new Coordenada(2, 4);
//		Coordenada coordenadaSuperficie = new Coordenada(5, 5);
//		Superficie superficie = new Superficie(0, coordenadaSuperficie);
//		OrientacaoFactory orientacaoFactory = new OrientacaoFactory(superficie);
//		Orientacao orientacao = orientacaoFactory.getOeste();
//		Posicao posicao = new Posicao(coordenada, orientacao);
//		String movimento = "RMLMLMMMLMRMMMMMMM";
//		System.out.println(coordenadaSuperficie);
//		System.out.println(posicao);
//		System.out.println(movimento);
//		
//		Sonda robo = new Sonda(posicao, superficie, 0, "MMMMMMM");
//		posicao = robo.movimentar(movimento);
//		System.out.println(posicao);
		
		
		Coordenada coordenada = new Coordenada(1, 2);
		Coordenada coordenadaSuperficie = new Coordenada(5, 5);
		Superficie superficie = new Superficie(0, coordenadaSuperficie);
		OrientacaoFactory orientacaoFactory = new OrientacaoFactory(superficie);
		Orientacao orientacao = orientacaoFactory.getNorte();
		Posicao posicao = new Posicao(coordenada, orientacao);
		String movimento = "LMLMLMLMM";
		System.out.println(coordenadaSuperficie);
		System.out.println(posicao);
		System.out.println(movimento);
		
		Sonda sonda = new Sonda(posicao, superficie, 0, "A");
		posicao = sonda.movimentar(movimento);
		System.out.println(posicao);
		
		coordenada = new Coordenada(3, 3);
		orientacao = orientacaoFactory.getLeste();
		posicao = new Posicao(coordenada, orientacao);
		sonda = new Sonda(posicao, superficie, 0, "A");
		movimento = "MMRMMRMRRM";
		System.out.println(posicao);
		System.out.println(movimento);
		
		posicao = sonda.movimentar(movimento);
		System.out.println(posicao);
		
	}
}
