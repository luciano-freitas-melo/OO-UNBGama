package principal;

public class Gerenciador {
	
	public static void temasPadrao() {
		String[] listaTemasPadrao = {"animais", "frutas", "profissões", "paises", "friends"};
		String[][] listaPalavrasPadrao = {{"cachorro", "macaco", "gato", "elefante", "baleia", "tartaruga", "tigre", "panda", "cobra", "cavalo"},
										  {"abacate", "pera", "banana", "abacaxi", "goiaba", "melancia", "tomate", "figo", "ameixa", "caju"},
										  {"engenheiro", "arquiteto", "advogado", "dentista", "escritor", "motorista", "entregador", "enfermeiro", "contador", "policial"},
										  {"brasil", "alemanha", "estados unidos", "reino unido", "chile", "venezuela", "equador", "argentina", "irlanda", "china"},
										  {"janice", "ross", "rachel", "mike","ursula","phoebe", "gunther", "chandler", "joey", "monica"}};
		
		// Coloca os temas dentro da array temas do nosso jogo da forca
		for(int i = 0; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0)
					JogoDaForca.temasEPalavras[i][j] = listaTemasPadrao[i];
				else
					JogoDaForca.temasEPalavras[i][j] = listaPalavrasPadrao[i][j-1];
			}
		}
	}
	
	public static void gerenciarPalavras() {
		int opcao = 0;
		do{
			menuPalavras();
			System.out.print("Escolha uma das opções acima: ");
			opcao = Utensilios.validarVariavel(opcao, 1, 5, "Opção inválida, digite novamente: ");
			System.out.println();
			
			switch (opcao) {
				case 1:
					cadastrarPalavra();
					break;
				case 2:
					excluirPalavra(JogoDaForca.temasEPalavras);
					break;
				case 3:
					imprimeTemas(JogoDaForca.somenteTemas);
					break;
			}
		}while (opcao != 5);
	}
	
	
	private static void menuPalavras() {
		System.out.println();
		System.out.println("*** Gerenciador de Palavras ***");
		System.out.println();
		System.out.println("1. Cadastrar");
		System.out.println("2. Excluir");
		System.out.println("3. Buscar");
		System.out.println("4. Listar");
		System.out.println("5. Voltar");
		System.out.println();
		
	}

	private static void cadastrarPalavra() {
		imprimeTemas(JogoDaForca.somenteTemas);
		System.out.print("Escolha um dos temas acima para cadastrar a palavra: ");
		int indexTemaEscolhido = escolhaTema();
		
		System.out.print("Digite a palavra: ");
		String novaPalavra = Utensilios.ler.next().toLowerCase();
		
		if (palavraRepetida(novaPalavra, JogoDaForca.temasEPalavras[indexTemaEscolhido]))
			System.out.println("A palavra já está cadastrada para esse tema!");
		else {
			inserirPalavra(novaPalavra, JogoDaForca.temasEPalavras[indexTemaEscolhido]);
			System.out.println("Palavra cadastrada com sucesso!");
		}
	}
	
	private static boolean palavraRepetida (String novaPalavra, String[] listaPalavras) {
		boolean palavraRepetida = false;
		
		// Iniciamos a partir do 1, pois o primeiro valor da listaPalavras é o nome do tema.
		for (int i = 1; i < Utensilios.arrayLengthNotNull(listaPalavras); i++)
			if (listaPalavras[i].equals(novaPalavra)) {
				palavraRepetida = true;
				break;
			}
		return palavraRepetida;
	}
	
	private static void inserirPalavra(String palavra, String[] listaPalavras) {

		for (int i = 0; i < listaPalavras.length; i++) {
			if (listaPalavras[i] == null) {
				listaPalavras[i] = palavra;
				break;
			}		
		}
	}
	
	private static void excluirPalavra(String[][] temasEPalavras) {
		System.out.print("Digite o nome da palavra que deseja excluir: ");
		
	}
	
	public static void gerenciarTemas() {
		
		int opcao = 0;
		do{
			JogoDaForca.filtraTemas();
			menuTemas();
			System.out.print("Escolha uma das opções acima: ");
			opcao = Utensilios.validarVariavel(opcao, 1, 4, "Opção inválida, digite novamente: ");
			System.out.println();
			
			switch (opcao) {
				case 1:
					cadastrarTema();
					break;
				case 2:
					excluirTema(JogoDaForca.somenteTemas);
					break;
				case 3:
					imprimeTemas(JogoDaForca.somenteTemas);
					break;
			}
		}while (opcao != 4);
	}

	private static void menuTemas() {
		System.out.println();
		System.out.println("*** Gerenciador de Temas ***");
		System.out.println();
		System.out.println("1. Cadastrar");
		System.out.println("2. Excluir");
		System.out.println("3. Buscar");
		System.out.println("4. Voltar");
		System.out.println();
		
	}
	
	private static void cadastrarTema() {
		System.out.print("Digite o nome do tema que deseja cadastrar: ");
		String novoTema = Utensilios.ler.next().toLowerCase();
		
		if (temaRepetido(novoTema, JogoDaForca.somenteTemas))
			System.out.println("Tema digitado já cadastrado!");
		else {
			inserirTema(novoTema, JogoDaForca.temasEPalavras);
			System.out.println("Tema cadastrado com sucesso!");
		}
	}

	private static boolean temaRepetido(String novoTema, String[] temas) {
		boolean temaRepetido = false;
		
		for (int i = 0; i < Utensilios.arrayLengthNotNull(temas); i++)
			if (temas[i].equals(novoTema)) {
				temaRepetido = true;
				break;
			}
		return temaRepetido;
	}

	private static void inserirTema(String novoTema, String[][] temas) {
		
		for (int i = 0; i < temas.length; i++) {
			if (temas[i][0] == null) {
				temas[i][0] = novoTema;
				break;
			}		
		}
	}

	private static void excluirTema(String[] temas) {
		imprimeTemas(temas);
		
		System.out.printf("%nDigite o número do tema que deseja excluir: ");
		
		int indexTema = 0;
		
		indexTema = escolhaTema();
							
		if(!temaSemPalavras(JogoDaForca.temasEPalavras, indexTema))
			System.out.println("Não foi possível excluir o tema. Verifique se existem palavras cadastradas nesse tema.");
		
		else {
			deletarTema(indexTema);
			System.out.println("Tema deletado com sucesso!");
		}
		
		
	}

	// Vasculha a array temas, apresentando os temas disponíveis ao usuário
	public static void imprimeTemas(String[] temas) {
		System.out.println("************* TEMAS *************");
		
		for(int counter = 0; counter < Utensilios.arrayLengthNotNull(temas); counter++) {
			System.out.printf("%-1d. %s%n", (counter+1), Utensilios.capitalize(temas[counter])); // exemplo de formato: 1. Tema
		}
		
	}

	// Pede ao usuário que escolha o tema e avalia se o valor digitado é válido ou não.
	public static int escolhaTema() {
		int quantTemas = Utensilios.arrayLengthNotNull(JogoDaForca.somenteTemas); // Quantidade de temas armazenados no programa
		int indexTemaEscolhido = 0;
		indexTemaEscolhido = Utensilios.validarVariavel(indexTemaEscolhido, 1, quantTemas,
				"Tema escolhido inválido, digite novamente: ");
		
		indexTemaEscolhido --; // Removemos 1 do index pois arrays iniciam com 0 e não com 1, diferente de como apresenta o nosso menu.
		
		return indexTemaEscolhido;
	}
	
	// Esse método desloca as linhas da array temasEPalavras, sobrescrevendo o tema indicado por indexTema.
	// Para tal, copiamos os valores da próxima linha na linha que será sobrescrita.
	private static void deletarTema(int indexTema) {
		String[][] temas = JogoDaForca.temasEPalavras;
		
		// Serão deslocadas as linhas a partir da linha que queremos sobrescrever.
		for (int i = indexTema; i < temas.length; i++) {
			
			// Somente serão deslocadas as linhas que tiverem valores.
			if (temas[i][0] != null) {
				for (int j = 0; j < temas[i].length; j++) {
					
					// O uso do try and catch é para o caso do programa ter todos os 50 temas, assim, para que o último tema não dê erro,
					// fazemos isso, e colocamos null nessa última linha.
					try {
						temas[i][j] = temas[i+1][j];	
					} catch (ArrayIndexOutOfBoundsException erro){
						temas[i][j] = null;
					}
				}
			}	
		}
		
	}

	public static boolean temaSemPalavras(String[][] temas, int indexTema) {
		boolean temaSemPalavras = false;
		int primeiraPalavra = 1; // É o índice da primeira palavra de cada tema na array bidimensional
		
		if (temas[indexTema][primeiraPalavra] == null) {
			temaSemPalavras = true;
		}
			
		return temaSemPalavras;
	}

	
	
}
