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
			for (int j = 0; j < 11; j++) {
				if (j == 0)
					JogoDaForca.temasEPalavras[i][j] = listaTemasPadrao[i];
				else
					JogoDaForca.temasEPalavras[i][j] = listaPalavrasPadrao[i][j-1];
			}
		}
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
					buscarTema();
					break;
			}
		}while (opcao != 4);
	}

	private static void menuTemas() {
		System.out.println();
		System.out.println("****** Gerenciador de Temas *****");
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
		
		if (temaExiste(novoTema, JogoDaForca.somenteTemas))
			System.out.println("Tema digitado já cadastrado!");
		else {
			inserirTema(novoTema, JogoDaForca.temasEPalavras);
			System.out.println("Tema cadastrado com sucesso!");
		}
	}

	// Verifica se o tema já existe na array temas.
	private static boolean temaExiste(String tema, String[] temas) {
		boolean temaRepetido = false;
		
		for (int i = 0; i < Utensilios.arrayLengthNotNull(temas); i++)
			if (temas[i].equals(tema)) {
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
			System.out.printf("%2d. %s%n", (counter+1), Utensilios.capitalize(temas[counter])); // exemplo de formato: 1. Tema
		}
		System.out.println();
	}

	// Semelhante a outra imprimeTemas, mas somente imprime os temasSelecionados.
	private static void imprimeTemas(String[] temas, String[] temasSelecionados) {
		int index = 0;
		for (String tema : temas) {
			if (Utensilios.arrayContem(temasSelecionados, tema) && tema != null) {
				System.out.printf("%2d. %s%n", (index+1), Utensilios.capitalize(tema));
				index++;
			}	
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
					
					// O uso do try and catch é para o caso do programa ter todos os temas possíveis, assim, para que o último tema não dê erro,
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

	private static void buscarTema() {
		System.out.print("Escreva o nome do tema que deseja pesquisar: ");
		String temaBuscado = Utensilios.ler.next().toLowerCase();
		
		if (temaExiste(temaBuscado, JogoDaForca.somenteTemas)) {
			System.out.println("Tema encontrado!");
			String[] palavrasTemas = JogoDaForca.temasEPalavras[posicaoTema(temaBuscado, JogoDaForca.temasEPalavras)];
			int quantPalavrasTema = Utensilios.arrayLengthNotNull(palavrasTemas) - 1;
			System.out.printf("O tema tem %d palavras cadastradas...%n", quantPalavrasTema);
			
		} else
			System.out.println("Tema não encontrado!");
		
	}
	
	// Retorna a posição que o tema está na array bidimensional
	private static int posicaoTema(String tema, String[][] temasEPalavras) {
			
		int posicaoTema = 0;

		for (int i = 0; i < temasEPalavras.length; i++) {
			// Só faremos a repetição enquanto houver valores nos temas.
			if (temasEPalavras[i][0] == null)
				break;
			
			else {
				if (temasEPalavras[i][0].equals(tema))
					posicaoTema = i;
			}
		}
		return posicaoTema;
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
					buscaPalavra(JogoDaForca.temasEPalavras);
					break;
				case 4:
					listarPalavras();
			}
		}while (opcao != 5);
	}

	private static void menuPalavras() {
		System.out.println();
		System.out.println("******* Gerenciar Palavras ******");
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
		String palavra = Utensilios.ler.next().toLowerCase();
		
		if (palavraEncontrada(palavra, temasEPalavras)) {
			String[] temasDaPalavra = temasPalavra(palavra, temasEPalavras);
			int quantTemas = Utensilios.arrayLengthNotNull(temasDaPalavra); // Quantos temas tem essa palavra.
			
			if(quantTemas == 1) {
				deletaPalavra(palavra, temasDaPalavra[0], temasEPalavras);
				System.out.printf("A palavra %S foi deletada do tema %S com sucesso!%n", palavra, temasDaPalavra[0]);
				
			} else {
				System.out.println("Selecione em que tema a palavra será excluída:");
				System.out.println(" 0. Todos");
				imprimeTemas(JogoDaForca.somenteTemas, temasDaPalavra);
				
				int opcao = 0;
				opcao = Utensilios.validarVariavel(opcao, 0, quantTemas, "Opção digitada inválida, tente novamente: ");
				switch(opcao) {
					case 0:
						for (String tema : temasDaPalavra)
							if (tema != null)
								deletaPalavra(palavra, tema, temasEPalavras);
						System.out.printf("A palavra %S foi deletada de todos os temas!%n", palavra);
						break;
					default:
						int indexTema = opcao - 1; // É o indíce do tema que o usuário escolheu na opção.
						deletaPalavra(palavra, temasDaPalavra[indexTema], temasEPalavras);
						System.out.printf("A palavra %S foi deletada do tema %S com sucesso!%n", palavra, temasDaPalavra[indexTema]);
				}
			}
		}else
			System.out.println("Palavra não encontrada!");
		
	}
	
	// Esse método desloca a coluna da array temasEPalavras em que está o temaDaPalavra, sobrescrevendo o valor de "palavra".
	// Para tal, copiamos o valor da próxima posição, na posição da palavra que queremos sobrescrever.
	private static void deletaPalavra (String palavra, String temaDaPalavra, String[][] temasEPalavras) {
		
		int posicaoTema = posicaoTema(temaDaPalavra, temasEPalavras);
		int posicaoPalavra = posicaoPalavra(palavra, temasEPalavras[posicaoTema]);
		
		for (int i = posicaoPalavra; i < temasEPalavras[posicaoTema].length; i++) {
			// Só percorre as colunas enquanto houver palavras com valores.
			if (temasEPalavras[posicaoTema][i] == null)
				break;
			else {
				// // O uso do try and catch é para o caso do tema ter todas as palavras possíveis, assim, para que a último palavra não dê erro,
				// fazemos isso, e colocamos null no último item.
				try {
					temasEPalavras[posicaoTema][i] = temasEPalavras[posicaoTema][i+1];	
				
				} catch (ArrayIndexOutOfBoundsException erro) {
					temasEPalavras[posicaoTema][i] = null;	
				}	
			}
		}
	}

	// Retorna a posição da palavra da lista de palavras dada.
	private static int posicaoPalavra (String palavra, String[] listaPalavras) {
		int quantPalavras = Utensilios.arrayLengthNotNull(listaPalavras); // Quantidade de palavras com valores.
		
		int posicaoPalavra = 0;
		for (int i = 0; i < quantPalavras; i++)
			if (listaPalavras[i].equals(palavra))
				posicaoPalavra = i;
		
		return posicaoPalavra;
	}
	
	private static void buscaPalavra(String[][] temasEPalavras) {
		System.out.print("Digite a palavra que deseja buscar: ");
		String palavraBuscada = Utensilios.ler.next().toLowerCase();		
		
		if (palavraEncontrada(palavraBuscada, temasEPalavras)) {
			String[] temasDaPalavra = temasPalavra(palavraBuscada, temasEPalavras); // guarda todos os temas que contiverem a palavra.
			
			int quantTemas = Utensilios.arrayLengthNotNull(temasDaPalavra); // quantidade de temas com a palavra.
			
			if (quantTemas == 1) {
				System.out.printf("Palavra encontrada no tema %S%n", temasDaPalavra[0]);
				
			}else {
				System.out.println("Palavra encontrada nos seguintes temas:");
				imprimeTemas(JogoDaForca.somenteTemas, temasDaPalavra);
			}
			
	
		}else
			System.out.println("Palavra não encontrada!");
	}

	private static boolean palavraEncontrada(String palavraBuscada, String[][] temasEPalavras) {
		boolean palavraEncontrada = false;
		
		for (int i = 0; i < temasEPalavras.length; i++) {
			// Irá percorrer a array até encontrar um valor null, a partir desse momento não haverá mais temas armazenados,
			// então interrompe a repetição.
			if (temasEPalavras[i][0] == null) {
				break;
			}else {
				// iniciamos a busca na coluna a partir do 1, pois o índice 0 é o nome do tema e percorremos somente os valores que não
				// forem null com o "arrayLengthNotNull".
				for (int j = 1; j < Utensilios.arrayLengthNotNull(temasEPalavras[i]); j++) {
					if (temasEPalavras[i][j].equals(palavraBuscada))
						palavraEncontrada = true;
				}
			}
		}
		return palavraEncontrada;
	}

	// Retorna os nomes dos temas que tiverem a palavraBuscada.
	private static String[] temasPalavra (String palavraBuscada, String[][] temasEPalavras) {
		int quantTemas = Utensilios.arrayLengthNotNull(JogoDaForca.somenteTemas); // Quantidade de temas armazenados no programa.
		String[] temasDaPalavra = new String[quantTemas];
		
		int indexTemasDaPalavra = 0;
		for (int i = 0; i < temasEPalavras.length; i++) {
			// Irá percorrer a array até encontrar um valor null, a partir desse momento não haverá mais temas armazenados,
			// então interrompe a repetição.
			if (temasEPalavras[i][0] == null) {
				break;
			}else {
				// iniciamos a busca na coluna a partir do 1, pois o índice 0 é o nome do tema e percorremos somente os valores que não
				// forem null com o "arrayLengthNotNull".
				for (int j = 1; j < Utensilios.arrayLengthNotNull(temasEPalavras[i]); j++) {
					if (temasEPalavras[i][j].equals(palavraBuscada)) {
						temasDaPalavra[indexTemasDaPalavra++] = temasEPalavras[i][0];
					}
				}
			}
		}
		
		return temasDaPalavra;
 	}
	
	private static void listarPalavras() {
		imprimeTemas(JogoDaForca.somenteTemas);
		System.out.print("Escolha o tema que deseja listar as palavras: ");
		int posicaoTema = escolhaTema();
		
		System.out.println();
		System.out.println("************ Palavras ***********");
		
		String [] listaPalavras = JogoDaForca.temasEPalavras[posicaoTema]; // Lista de palavras do tema selecionado
		int quantPalavras = Utensilios.arrayLengthNotNull(listaPalavras); // Quantidade de palavras não nulas na lista.
		
		// Imprime as palavras de 5 em 5 por linha.
		for (int i = 1; i < quantPalavras; i+=5) {
			for (int j = 0; j < 5; j++)
				if (listaPalavras[i+j] != null)
					System.out.printf("%S    ", listaPalavras[i+j]);
			
			System.out.println();
		}
	}

		
}
