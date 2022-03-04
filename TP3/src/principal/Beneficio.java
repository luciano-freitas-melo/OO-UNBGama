package principal;

public class Beneficio {
	private String nome;
	// Sao as categorias que um beneficio pode ter.
	private enum TipoBeneficio {COMODIDADE, REFEICAO, INSTALACAO, ACESSIBILIDADE, REGRA};
	private TipoBeneficio tipo;
	// E o grau de importancia do beneficio
	private int relevancia;
	
	//Getters e Setters - inicio
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public TipoBeneficio getTipo() {
		return tipo;
	}
	public void setTipo(TipoBeneficio tipo) {
		this.tipo = tipo;
	}
	public int getRelevancia() {
		return relevancia;
	}
	public void setRelevancia(int relevancia) {
		this.relevancia = relevancia;
	}
	//Getters e Setters - fim
	
	public Boolean cadastrar() {
		return null;
	}
	
	public Boolean editar() {
		return null;
	}
	
	public Boolean excluir() {
		return null;
	}
}
