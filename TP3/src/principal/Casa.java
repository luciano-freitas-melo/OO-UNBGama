package principal;

public class Casa extends Imovel{
	
	// Enum para todos os tipos de lugares que uma casa pode ser
	private enum TipoLugar {INTEIRO("Lugar Inteiro"), QUARTO_INTEIRO("Quarto Inteiro"), QUARTO_COMPARTILHADO("Quarto Compartilhado");
		private String nome;
		TipoLugar(String string) {
			this.nome = string;
		}
		public String getNome() {
			return nome;
		}
		// Imprime para o usuario as constantes e pede que escolha uma, retornando a constante escolhida
		public static TipoLugar escolherEnum(){
			
			TipoLugar tipoEscolhido = null;
			// Sera a variavel que indetificara cada constante do Enum
			int index = 1;
			// Quantidade de constantes no Enum
			int quant = TipoLugar.values().length;
			
			for(TipoLugar tipo : TipoLugar.values()) {
				System.out.printf("%d. %s%n", index, tipo.getNome());
				index++;
			}
			
			int opcao = Validador.lerEntrada(1, quant);
			
			index = 1;
			for(TipoLugar tipo : TipoLugar.values()) {
				tipoEscolhido = opcao == index ? tipo : null;
				index++;
			}
			
			return tipoEscolhido;
		}		
	};
	
	// Declaramos uma variavel para guardar nosso Enum
	private TipoLugar tipoLugar;
	
	// A categoria da casa que o imovel pode ser é de 4 tipos diferentes
	private enum TipoCasa {PADRAO("Casa Residencial"), CHALE("Chale"), CABANA("Cabana"), CAMPO("Casa de Campo");
		
		private String nome;
		
		public String getNome() {
			return nome;
		}
		
		TipoCasa(String string) {
			this.nome = string;
		}
		// Imprime para o usuario as constantes e pede que escolha uma, retornando a constante escolhida
		public static TipoCasa escolherEnum(){
			
			TipoCasa tipoEscolhido = null;
			// Sera a variavel que indetificara cada constante do Enum
			int index = 1;
			// Quantidade de constantes no Enum
			int quant = TipoCasa.values().length;
			
			for(TipoCasa tipo : TipoCasa.values()) {
				System.out.printf("%d. %s%n", index, tipo.getNome());
				index++;
			}
			
			int opcao = Validador.lerEntrada(1, quant);
			
			index = 1;
			for(TipoCasa tipo : TipoCasa.values()) {
				tipoEscolhido = opcao == index ? tipo : null;
				index++;
			}
			
			return tipoEscolhido;
		}		
	};
	
	// Declaramos uma variavel para guardar nosso Enum
	private TipoCasa tipo;
	
	// Getters e Setters - inicio
	public TipoLugar getTipoLugar() {
		return tipoLugar;
	}
	public void setTipoLugar(TipoLugar tipoLugar) {
		this.tipoLugar = tipoLugar;
	}
	public TipoCasa getTipo() {
		return tipo;
	}
	public void setTipo(TipoCasa tipo) {
		this.tipo = tipo;
	}
	// Getters e Setters - fim
	
	public Casa() {
		System.out.println("Escolha o tipo de lugar que deseja alugar:");
		setTipoLugar(TipoLugar.escolherEnum());
		System.out.println("Escolha o tipo de casa:");
		setTipo(TipoCasa.escolherEnum());
		
		super.cadastrarInfoImovel();
	}
}
