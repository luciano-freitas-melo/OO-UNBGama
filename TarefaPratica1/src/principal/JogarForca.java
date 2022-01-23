package principal;

import java.security.SecureRandom;

public class JogarForca {
	
	private static int indexTema; // Essa variável é o índice do tema que será jogado nessa partida.
	private static String palavraSecreta; // Guarda a palavra secreta que será usada durante na forca.
	
	
	public static void jogar(String[][] temas) {
		
		
		imprimeMensagemAbertura();
		selecionaTema(temas);
		escolherPalavraSecreta(temas[indexTema]);
		
		// REMOVER ESSA LINHA DEPOIS
		palavraSecreta = "mamao papaya maduro";
		System.out.println(palavraSecreta);
		
		char[] letrasPalavraSecreta = palavraSecreta.toCharArray(); // palavra secreta separada em uma
																    // array com as letras da palavra.
		
		char[] letrasAcertadas = inicializaLetrasAcertadas(letrasPalavraSecreta); // É onde guardaremos as letras já acertadas pelo
																				  // usuário.
		System.out.printf("%nPalavra: ");
		imprimeLetrasAcertadas(letrasAcertadas);
		
	}

	
	private static void imprimeMensagemAbertura() {
		System.out.println("*********************************");
	    System.out.println("***Bem vindo ao jogo da Forca!***");
	    System.out.println("*********************************");
	    System.out.println();
	}
	
	// Apresenta os temas para o usuário e pede para que ele selecione um deles
	private static void selecionaTema(String[][] temas) {
		int quantTemas = temas.length; // Quantidade de temas que têm armazenados no programa
		
		System.out.println("************* TEMAS *************");
		
		// Vasculha a array temas, apresentando os temas disponíveis ao usuário
		for(int counter = 0; counter < quantTemas; counter++) {
			System.out.printf("%d. %s%n", (counter+1), Utensilios.capitalize(temas[counter][0])); // exemplo de formato: 1. Tema
		}
		System.out.printf("%nDigite o número do tema que deseja jogar: ");
		
		indexTema = Utensilios.validarVariavel(indexTema, 1, quantTemas , 
				"Tema escolhido inválido, digite novamente: ");
		
		indexTema--; // Removemos 1 do index pois arrays iniciam com 0 e não com 1, como apresenta o nosso menu.
	}

	// Escolhe uma palavra aleatoriamente dentre a lista de palavras dada no parâmetro
	private static void escolherPalavraSecreta(String[] palavras) {
		SecureRandom randomNumbers = new SecureRandom();
		
		// randomNumbers irá gerar um número aleátorio entre 0 e a quantidade de palavras armazenadas menos 1.
		// Devemos somar 1 a esse resultado pois palavras tem o nome do tema como sendo o índice 0.
		// No mesmo pensamento, devemos diminuir um da quantidade de palavras armazenadas para que não ocorra um erro
		// na array palavras.
		int posicaoPalavra = 1 + randomNumbers.nextInt(palavras.length-1);
																	 
		palavraSecreta = palavras[posicaoPalavra];
	
	}

	// Cria uma array com o caracter "_" para cada letra da palavra secreta, e também respeitando os espaços da palavra.
	// Exemplo: se palavra secreta é teco teco, o método cria a array {'_', '_', '_', '_', ' ', '_', '_', '_', '_'}
	private static char[] inicializaLetrasAcertadas(char[] letrasPalavraSecreta) {
		int tamanhoPalavraSecreta = letrasPalavraSecreta.length;
		char[] letras = new char[tamanhoPalavraSecreta]; // letras é onde guardaremos os "_" de acordo com o tamanho da palavra secreta															 
		
		for (int i = 0; i < tamanhoPalavraSecreta; i++ ) {
			if(Character.isSpaceChar((letrasPalavraSecreta[i])))
				letras[i] = ' ';
			else
				letras[i] = '_';
		}
		
		return letras;
	}
	
	private static void imprimeLetrasAcertadas(char[] letrasAcertadas) {
		for (char letra : letrasAcertadas) {
			if (letra == ' ')
				System.out.print("  ");
			else 
				System.out.printf("%c ",letra);
		}
		
		System.out.println();
	}

	
	
}

