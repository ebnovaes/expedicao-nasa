package expedicao.rest.modelo;

public class ErroModel {

	public ErroModel(String erro){
		this.erro = erro;
	}
	
	public String getErro(){
		return this.erro;
	}
	
	private String erro;
}
