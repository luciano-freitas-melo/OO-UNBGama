package modelo;

public class Beneficio {
	
	private String nome;
	// Sao as categorias que um beneficio pode ter.
	private enum TipoBeneficio {
		COMODIDADE, REFEICAO, INSTALACAO, ACESSIBILIDADE, REGRA;
	};
	// Reservamos uma variavel para guardar o Enum escolhido pelo usuario
	private TipoBeneficio tipo;
	
	//Getters e Setters - inicio
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo.toString().toLowerCase();
	}
	public void setTipo(TipoBeneficio tipo) {
		this.tipo = tipo;
	}
	//Getters e Setters - fim
	
	
	public Beneficio(String nome, TipoBeneficio tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}
	
}
