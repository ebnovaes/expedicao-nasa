package expedicao.comum;

import expedicao.dominio.valueobject.Coordenada;
import expedicao.dominio.valueobject.Posicao;
import expedicao.dominio.valueobject.orientacao.Orientacao;
import expedicao.dominio.valueobject.orientacao.OrientacaoFactory;
import expedicao.exception.CoordenadaParseException;
import expedicao.exception.PosicaoParseException;

public final class ComumConstrucaoValueObject {

	public static Coordenada getCoordenadas(String de) throws CoordenadaParseException {
		
		if (de == null){
			throw new CoordenadaParseException("Coordenadas não informadas");
		}
		
		String[] dividido = de.split(" ");
		
		String erro = "";
		if (dividido.length != 2){
			erro = String.format("Valor de coordenadas '%s' incorreta. Valor permitido: <inteiro><espaço><inteiro>. Exemplo: 5 8", de);
			throw new CoordenadaParseException(erro);
		}
		
		Integer x = TratamentoComum.tryParse(dividido[0]);
		if (x == null){
			erro = "Valor '%s' para abscissa (eixo x) incorreto; número inteiro era esperado";
			throw new CoordenadaParseException(String.format(erro, dividido[0]));
		}
		
		Integer y = TratamentoComum.tryParse(dividido[1]);
		if (y == null){
			erro = "Valor '%s' para ordenada (eixo y) incorreto; número inteiro era esperado";
			throw new CoordenadaParseException(String.format(erro, dividido[1]));
		}
		
		return new Coordenada(x, y);
	}
	
	public static Posicao getPosicao(String de, OrientacaoFactory factory) throws PosicaoParseException {
		if (de == null){
			throw new PosicaoParseException("Posição não informada");
		}

		int split = de.split(" ").length;
		String erro = "";
		if (split != 3){
			erro = String.format("Valor de posicao '%s' incorreta. Valor permitido: <inteiro><espaço><inteiro><espaco><[N,S,E,W]>. Exemplo: 4 6 W", de);
			throw new PosicaoParseException(erro);
		}
		
		String posicao = de.substring(de.lastIndexOf(" "), de.length() - 1);
		if (posicao.length() != 1){
			erro = String.format("Valor de orientação '%s' incorreta. Valor permitido: N, S, E ou W", posicao);
			throw new PosicaoParseException(erro);
		}

		Orientacao orientacao = factory.get(posicao.charAt(0));
		if (orientacao == null){
			erro = String.format("Valor de orientação '%s' incorreta. Valor permitido: N, S, E ou W", posicao);
			throw new PosicaoParseException(erro);
		}
		
		String coordenadaStr = de.substring(0, de.lastIndexOf(" ") - 1);
		Coordenada coordenada = null;
		try{
			coordenada = getCoordenadas(coordenadaStr);
		} catch (CoordenadaParseException ce){
			throw new PosicaoParseException(ce.getMessage());
		}
		
		return new Posicao(coordenada, orientacao);	
	}
	
}
