package principal;

public class Localizacao {
	private String cep;
	private String logradouro;
	
	
	// Getters e Setters - inicio
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	// Getters e Setters - fim
	public Localizacao(String cep, String logradouro) {
		this.logradouro = logradouro;
		this.cep = cep;
	}
	
	public Localizacao() {
		System.out.print("CEP: ");
		setCep(Validador.lerEntrada(8));
		System.out.print("Logradouro: ");
		setLogradouro(Validador.lerString());
		
	}
	
	

	public void editar() {
	}

}
