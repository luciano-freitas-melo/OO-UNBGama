package principal;

public class Gerenciador {
	public static String[][] temasEPalavras = new String[50][51];
	
	public static void temasPadrao() {
		String[] listaTemasPadrao = {"animais", "frutas", "profiss�es", "paises", "friends"};
		String[][] listaPalavrasPadrao = {{"cachorro", "macaco", "gato", "elefante", "baleia", "tartaruga", "tigre", "panda", "cobra", "cavalo"},
										  {"abacate", "pera", "banana", "abacaxi", "goiaba", "melancia", "tomate", "figo", "ameixa", "caju"},
										  {"engenheiro", "arquiteto", "advogado", "dentista", "escritor", "motorista", "entregador", "enfermeiro", "contador", "policial"},
										  {"brasil", "alemanha", "estados unidos", "reino unido", "chile", "venezuela", "equador", "argentina", "irlanda", "china"},
										  {"janice", "ross", "rachel", "mike","ursula","phoebe", "gunther", "chandler", "joey", "monica"}};
		
		// Coloca os temas dentro da array temas do nosso jogo da forca
		for(int i = 0; i < 5; i++) {
			for (int j = 0; j < 11; j++) {
				if (j == 0)
					temasEPalavras[i][j] = listaTemasPadrao[i];
				else
					temasEPalavras[i][j] = listaPalavrasPadrao[i][j-1];
			}
		}
	}
		
	public static void gerenciarTemas() {
		
 		int opcao;
		do{
			menuTemas();
			System.out.print("Escolha uma das op��es acima: ");
			opcao = Utensilios.validarVariavel(1, 4, "Op��o inv�lida, digite novamente: ");
			System.out.println();
			
			switch (opcao) {
				case 1:
					cadastrarTema();
					break;
				case 2:
					excluirTema();
					break;
				case 3:
					buscarTema();
					break;
			}
		}while (opcao != 4);
	}

	// Filtra a array bidimensional, retornando uma string com os temas do programa.
	private static String[] temas() {
		String[] somenteTemas = new String[temasEPalavras.length];
		
		for (int i = 0; i < temasEPalavras.length; i++)
			somenteTemas[i] = temasEPalavras[i][0];
		
		return somenteTemas;
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
		String novoTema = Utensilios.lerString();
		
		if (Utensilios.arrayContem(temas(), novoTema))
			System.out.println("Tema digitado j� cadastrado!");
		else {
			inserirTema(novoTema);
			System.out.println("Tema cadastrado com sucesso!");
		}
	}

	// Coloca o novoTema na array bidimensional.
	private static void inserirTema(String novoTema) {
	
		for (int i = 0; i < temasEPalavras.length; i++) {
			if (temasEPalavras[i][0] == null) {
				temasEPalavras[i][0] = novoTema;
				break;
			}		
		}
	}

	private static void excluirTema() {
		imprimeTemas();
		
		System.out.printf("%nDigite o n�mero do tema que deseja excluir: ");
		
		int indexTema = escolhaTema();
	
		if(temaSemPalavras(indexTema)) {
			deletarTema(indexTema);
			System.out.println("Tema deletado com sucesso!");
		
		}else 
			System.out.println("N�o foi poss�vel excluir o tema. Verifique se existem palavras cadastradas nesse tema.");
	}

	// Vasculha a array temas, apresentando os temas dispon�veis ao usu�rio
	public static void imprimeTemas() {
		String[] temas = temas();
		System.out.println("************* TEMAS *************");
		
		for(int counter = 0; counter < Utensilios.arrayLengthNotNull(temas); counter++) {
			System.out.printf("%2d. %s%n", (counter+1), Utensilios.capitalize(temas[counter])); // exemplo de formato: 1. Tema
		}
		System.out.println();
	}
	
	// Pede ao usu�rio que escolha o tema e avalia se o valor digitado � v�lido ou n�o.
	public static int escolhaTema() {
		int quantTemas = Utensilios.arrayLengthNotNull(temas()); // Quantidade de temas armazenados no programa
		
		int indexTemaEscolhido = Utensilios.validarVariavel(1, quantTemas, "Tema escolhido inv�lido, digite novamente: ");
		
		indexTemaEscolhido --; // Removemos 1 do index pois arrays iniciam com 0 e n�o com 1, diferente de como apresenta o nosso menu.
		
		return indexTemaEscolhido;
	}

	// Semelhante a outra imprimeTemas, mas somente imprime os temasSelecionados.
	private static void imprimeTemasSelecionados(String[] temasSelecionados) {
		String[] temas = temas();
		int index = 0;
		for (String tema : temas) {
			if (Utensilios.arrayContem(temasSelecionados, tema) && tema != null) {
				System.out.printf("%2d. %s%n", (index+1), Utensilios.capitalize(tema));
				index++;
			}	
		}
	}	
	
	// Esse m�todo desloca as linhas da array bidimensional, sobrescrevendo o tema indicado por indexTema.
	// Para tal, copiamos os valores da pr�xima linha na linha que ser� sobrescrita.
	private static void deletarTema(int posicaoTema) {
		
		// Ser�o deslocadas as linhas a partir da linha que queremos sobrescrever.
		for (int i = posicaoTema; i < temasEPalavras.length; i++) {
			
			// Somente ser�o deslocadas as linhas que tiverem valores.
			if (temasEPalavras[i][0] != null) {
				for (int j = 0; j < temasEPalavras[i].length; j++) {
					
					// O uso do try and catch � para o caso do programa ter todos os temas poss�veis, assim, para que o �ltimo tema n�o d� erro,
					// fazemos isso, e colocamos null nessa �ltima linha.
					try {
						temasEPalavras[i][j] = temasEPalavras[i+1][j];	
					} catch (ArrayIndexOutOfBoundsException erro){
						temasEPalavras[i][j] = null;
					}
				}
			}	
		}
		
	}

	public static boolean temaSemPalavras(int posicaoTema) {
		boolean temaSemPalavras = false;
		int primeiraPalavra = 1; // � o �ndice da primeira palavra do tema.
		
		if (temasEPalavras[posicaoTema][primeiraPalavra] == null) {
			temaSemPalavras = true;
		}
			
		return temaSemPalavras;
	}

	private static void buscarTema() {
		System.out.print("Escreva o nome do tema que deseja pesquisar: ");
		String temaBuscado = Utensilios.lerString();
		
		if (Utensilios.arrayContem(temas(), temaBuscado)) {
			System.out.println("Tema encontrado!");
			imprimeQuantPalavrasTema(posicaoTema(temaBuscado));
			
		} else
			System.out.println("Tema n�o encontrado!");
	}
	
	// Imprime a quantidade de palavras que tem cadastradas no tema na posicaoTema.
	private static void imprimeQuantPalavrasTema(int indexTema) {
		String[] palavrasTema = temasEPalavras[indexTema]; // palavras no tema de indexTema
		
		int quantPalavrasTema = Utensilios.arrayLengthNotNull(palavrasTema) - 1; // Quantidade de palavras, sem considerar null.
																				 // Diminu�do 1, pois a primeira palavra � o pr�prio tema.
		
		System.out.printf("O tema tem %d palavras cadastradas...%n", quantPalavrasTema);
	}

	// Retorna a posi��o que o tema est� na array bidimensional
	private static int posicaoTema(String tema) {
		int posicaoTema = 0;

		for (int i = 0; i < temasEPalavras.length; i++) {
			// S� faremos a repeti��o enquanto houver valores nos temas.
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
		int opcao;
		do{
			menuPalavras();
			System.out.print("Escolha uma das op��es acima: ");
			opcao = Utensilios.validarVariavel(1, 5, "Op��o inv�lida, digite novamente: ");
			System.out.println();
			
			switch (opcao) {
				case 1:
					cadastrarPalavra();
					break;
				case 2:
					excluirPalavra();
					break;
				case 3:
					buscaPalavra();
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
		imprimeTemas();
		System.out.print("Escolha um dos temas acima para cadastrar a palavra: ");
		int indexTemaEscolhido = escolhaTema();
		String [] palavrasDoTema = temasEPalavras[indexTemaEscolhido];
		
		System.out.print("Digite a palavra: ");
		String novaPalavra = Utensilios.lerString();
		
		if (palavraRepetida(novaPalavra, palavrasDoTema))
			System.out.println("A palavra j� est� cadastrada para esse tema!");
		else {
			inserirPalavra(novaPalavra, palavrasDoTema);
			System.out.println("Palavra cadastrada com sucesso!");
		}
	}
	
	private static boolean palavraRepetida (String novaPalavra, String[] listaPalavras) {
		boolean palavraRepetida = false;
		
		// Iniciamos a partir do 1, pois o primeiro valor da listaPalavras � o nome do tema.
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
	
	private static void excluirPalavra() {
		System.out.print("Digite o nome da palavra que deseja excluir: ");
		String palavra = Utensilios.lerString();
		
		if (palavraEncontrada(palavra)) {
			String[] temasDaPalavra = temasPalavra(palavra); // Guarda o nome de todos os temas que cont�m a palavra.
			int quantTemas = Utensilios.arrayLengthNotNull(temasDaPalavra); // Quantos temas tem essa palavra.
			
			if(quantTemas == 1) {
				deletaPalavra(palavra, posicaoTema(temasDaPalavra[0]));
				System.out.printf("A palavra %S foi deletada do tema %S com sucesso!%n", palavra, temasDaPalavra[0]);
				
			} else
				excluirPalavraComVariosTemas(palavra, temasDaPalavra, quantTemas);
			
		}else
			System.out.println("Palavra n�o encontrada!");
		
	}
	
	// Esse m�todo desloca a coluna da array bidimensional em que est� o tema na posicaoTema, sobrescrevendo o valor de "palavra".
	// Para tal, copiamos o valor da pr�xima posi��o, na posi��o da palavra que queremos sobrescrever.
	private static void deletaPalavra (String palavra, int posicaoTema) {
	
		String [] listaPalavrasTema = temasEPalavras[posicaoTema];
		int posicaoPalavra = posicaoPalavra(palavra, listaPalavrasTema);
		
		for (int i = posicaoPalavra; i < listaPalavrasTema.length; i++) {
			// S� percorre as colunas enquanto houver palavras com valores.
			if (listaPalavrasTema[i] == null)
				break;
			else {
				// // O uso do try and catch � para o caso do tema ter todas as palavras poss�veis, assim, para que a �ltimo palavra n�o d� erro,
				// fazemos isso, e colocamos null no �ltimo item.
				try {
					listaPalavrasTema[i] = listaPalavrasTema[i+1];	
				
				} catch (ArrayIndexOutOfBoundsException erro) {
					listaPalavrasTema[i] = null;	
				}	
			}
		}
	}

	// Retorna a posi��o da palavra da lista de palavras dada.
	private static int posicaoPalavra (String palavra, String[] listaPalavras) {
		int quantPalavras = Utensilios.arrayLengthNotNull(listaPalavras); // Quantidade de palavras com valores.
		
		int posicaoPalavra = 0;
		for (int i = 0; i < quantPalavras; i++)
			if (listaPalavras[i].equals(palavra))
				posicaoPalavra = i;
		
		return posicaoPalavra;
	}
	
	private static void excluirPalavraComVariosTemas(String palavra, String[] temasDaPalavra, int quantTemas) {
		System.out.println("Selecione em que tema a palavra ser� exclu�da:");
		System.out.println(" 0. Todos");
		imprimeTemasSelecionados(temasDaPalavra);
		
		int opcao = Utensilios.validarVariavel(0, quantTemas, "Op��o digitada inv�lida, tente novamente: ");
		switch(opcao) {
			case 0:
				for (String tema : temasDaPalavra) {
					if (tema == null)
						break;
					else
						deletaPalavra(palavra, posicaoTema(tema));
				}	
				System.out.printf("A palavra %S foi deletada de todos os temas!%n", palavra);
				break;
			default:
				// Colocamos opcao - 1, pois o �ndice de temasDaPalavra inicia em 0, diferente do nosso menu que apresenta os temas da palavra. 
				int indexTema = opcao - 1;
				// Usamos posicaoTema() pois o �ndice do tema n�o � necess�riamente o mesmo da nossa array bidimensional.
				deletaPalavra(palavra, posicaoTema(temasDaPalavra[indexTema]));
				System.out.printf("A palavra %S foi deletada do tema %S com sucesso!%n", palavra, temasDaPalavra[indexTema]);
		}
	}
	
	private static void buscaPalavra() {
		System.out.print("Digite a palavra que deseja buscar: ");
		String palavraBuscada = Utensilios.lerString();		
		
		if (palavraEncontrada(palavraBuscada)) {
			String[] temasDaPalavra = temasPalavra(palavraBuscada); // guarda todos os temas que contiverem a palavra.
			
			int quantTemas = Utensilios.arrayLengthNotNull(temasDaPalavra); // quantidade de temas com a palavra.
			
			if (quantTemas == 1) {
				System.out.printf("Palavra encontrada no tema %S%n", temasDaPalavra[0]);
				
			}else {
				System.out.println("Palavra encontrada nos seguintes temas:");
				imprimeTemasSelecionados(temasDaPalavra);
			}
			
	
		}else
			System.out.println("Palavra n�o encontrada!");
	}

	// Busca a array bidimensional pela palavraBuscada, retornando true caso encontre, e false caso contr�rio.
	private static boolean palavraEncontrada(String palavraBuscada) {
		boolean palavraEncontrada = false;
		
		for (int i = 0; i < temasEPalavras.length; i++) {
			// Ir� percorrer a array at� encontrar um valor null, a partir desse momento n�o haver� mais temas armazenados,
			// ent�o interrompe a repeti��o.
			if (temasEPalavras[i][0] == null) {
				break;
			}else {
				// iniciamos a busca na coluna a partir do 1, pois o �ndice 0 � o nome do tema e percorremos somente os valores que n�o
				// forem null com o "arrayLengthNotNull".
				for (int j = 1; j < Utensilios.arrayLengthNotNull(temasEPalavras[i]); j++) {
					if (temasEPalavras[i][j].equals(palavraBuscada)) {
						palavraEncontrada = true;
						break;
					}
				}
			}
		}
		return palavraEncontrada;
	}

	// Retorna os nomes dos temas que tiverem a palavraBuscada.
	private static String[] temasPalavra (String palavraBuscada) {
		int quantTemas = Utensilios.arrayLengthNotNull(temas()); // Quantidade de temas armazenados no programa.
		
		String[] temasDaPalavra = new String[quantTemas];
		
		int indexTemasDaPalavra = 0;
		for (int i = 0; i < temasEPalavras.length; i++) {
			// Ir� percorrer a array at� encontrar um valor null, a partir desse momento n�o haver� mais temas armazenados,
			// ent�o interrompe a repeti��o.
			if (temasEPalavras[i][0] == null) {
				break;
			}else {
				// iniciamos a busca na coluna a partir do 1, pois o �ndice 0 � o nome do tema e percorremos somente os valores que n�o
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
		imprimeTemas();
		System.out.print("Escolha o tema que deseja listar as palavras: ");
		int posicaoTema = escolhaTema();
		
		System.out.println();
		System.out.println("************ Palavras ***********");
		
		String [] listaPalavras = temasEPalavras[posicaoTema]; // Lista de palavras do tema selecionado
		int quantPalavras = Utensilios.arrayLengthNotNull(listaPalavras); // Quantidade de palavras n�o nulas na lista.
		
		// Imprime as palavras de 5 em 5 por linha.
		for (int i = 1; i < quantPalavras; i+=5) {
			for (int j = 0; j < 5; j++)
				if (listaPalavras[i+j] != null)
					System.out.printf("%S    ", listaPalavras[i+j]);
			
			System.out.println();
		}
	}
}
