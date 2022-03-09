package principal;

public class Beneficio {
	
	private String nome;
	// Sao as categorias que um beneficio pode ter.
	private enum TipoBeneficio {
		COMODIDADE, REFEICAO, INSTALACAO, ACESSIBILIDADE, REGRA;
		
		public static void imprimeTipoBeneficio() {
			int i = 1;
			for(TipoBeneficio tipo : TipoBeneficio.values()) {
				// Imprime: i. nome do tipoCasa
				System.out.printf("%d. %s%n", i, tipo.toString().toLowerCase());
				i++;
			}
		}
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
	private void escolheTipoBeneficio(int escolha) {
		switch(escolha){
		case 1:
			this.tipo = TipoBeneficio.COMODIDADE;
			break;
		case 2:
			this.tipo = TipoBeneficio.REFEICAO;
			break;
		case 3:
			this.tipo = TipoBeneficio.INSTALACAO;
			break;
		case 4:
			this.tipo = TipoBeneficio.ACESSIBILIDADE;
			break;
		case 5:
			this.tipo = TipoBeneficio.REGRA;
			break;
			
		}	
	}
	//Getters e Setters - fim
	
	public Beneficio(String nome, String tipo) {
		this.nome = nome;
		this.tipo = TipoBeneficio.valueOf(tipo);
	}
	
	public Beneficio() {
		System.out.print("nome: ");
		setNome(Validador.lerNome(3));
		
		System.out.println("Escolha o tipo de beneficio:");
		TipoBeneficio.imprimeTipoBeneficio();
		int tipoEscolhido = Validador.lerEntrada(1,5);
		escolheTipoBeneficio(tipoEscolhido);
	}
	
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
