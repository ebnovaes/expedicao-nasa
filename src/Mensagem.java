public class Mensagem{
		
		public Mensagem(){}
		
		public Mensagem(Mensagem mensagem){
			this.nome = mensagem.nome;
		}
		
		public String getMensagem(){
			return "hello, " + this.nome;
		}
		
		public void setMensagem(String mensagem){
			
		}
		
		public String getNome(){
			return nome;
		}
		
		public void setNome(String nome){
			this.nome = nome;
		}
		
		private String nome;
	}