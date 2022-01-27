package principal;

public class JogoDaForca {
	
	public static String[][] temasEPalavras = new String[50][51];
	public static String[] somenteTemas = new String[50];
	

	public static void main(String[] args) {
		
		System.out.println("Ol�, esse programa � destinado a uso e administra��o do jogo da Forca! Aproveite!");
		System.out.println("PLUS ULTRA!");
		System.out.println();
		
		Gerenciador.temasPadrao();
		int escolhaMenu = 0;
		do {
			filtraTemas();
			imprimeMenu();
			System.out.print("Digite a op��o desejada: ");
			escolhaMenu = Utensilios.validarVariavel(escolhaMenu, 1, 4, "Essa n�o � uma escolha v�lida, tente novamente: ");
			
			switch (escolhaMenu) {
				case 1:
					Gerenciador.gerenciarTemas();
					break;
				case 2:
					Gerenciador.gerenciarPalavras();
					break;
				case 3:
					JogarForca.jogar();
					break;
			}
			
		} while(escolhaMenu != 4);
		
		System.out.println("Obrigado por usar o nosso programa, at� mais!");
	
	}
	// Insere na vari�vel somenteTemas, os temas que estiverem armazenados em temasEPalavra.
	public static void filtraTemas() {
		
		for (int i = 0; i < temasEPalavras.length; i++) {
			somenteTemas[i] = temasEPalavras[i][0];
		}
	}
	
	private static void imprimeMenu() {
		System.out.println();
		System.out.println("*********** MENU ***********");
		System.out.println();
		System.out.println("1. Gerenciar Temas");
		System.out.println("2. Gerenciar Palavras");
		System.out.println("3. Jogar");
		System.out.println("4. Sair");
		System.out.println();
	}

	
}
