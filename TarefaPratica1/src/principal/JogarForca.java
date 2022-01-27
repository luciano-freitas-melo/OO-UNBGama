package principal;

import java.security.SecureRandom;

public class JogarForca {
	private static final int LIMITE_ERROS = 5; // N�mero de tentativas que o usu�rio tem para acertar a palavra.
	
	private static int indexTema; // Essa vari�vel � o �ndice do tema que ser� jogado nessa partida.
	private static String palavraSecreta; // Guarda a palavra secreta que ser� usada durante o jogo.
	
	public static void jogar() {
		String jogarNovamente; // Recebe S ou N, dependendo se o usu�rio deseja jogar novamente ou n�o.
		
		do {
			jogarRodada(JogoDaForca.temasEPalavras);
			jogarNovamente = validarJogarNovamente();
			
		}while (jogarNovamente.equals("S") ? true : false);

	}
	
	private static String validarJogarNovamente() {
		String input;
		
		do {
			input = Utensilios.ler.next().toUpperCase();
			
		} while (!JogarNovamenteValido(input));
		
		return input;
	}

	private static boolean JogarNovamenteValido(String input) {
		boolean inputValido = true;
		
		if(!Utensilios.letraValida(input))
			inputValido = false;
		
		else if (!input.equals("S") && !input.equals("N")) {
			inputValido = false;
			System.out.print("S� � permitido digitar S (para SIM) ou N (para N�O): ");
		}
	
		return inputValido;
	}

	private static void jogarRodada(String[][] temas) {
		
		
		imprimeMensagemAbertura();
		selecionaTema(JogoDaForca.somenteTemas);
		escolherPalavraSecreta(temas[indexTema]);
		
		char[] letrasPalavraSecreta = palavraSecreta.toCharArray(); // palavra secreta separada em uma
																    // array com as letras da palavra.
		
		char[] letrasAcertadas = inicializaLetrasAcertadas(letrasPalavraSecreta); // � onde guardaremos as letras j� acertadas pelo
																				  // usu�rio.
		char[] letrasTentadas = new char[26]; // Armazena todas as letras j� tentadas pelo usu�rio.
		
		boolean enforcado = false; // Diz se o jogador errou o limite de vezes, ou seja, foi enforcado.
		boolean ganhou = false; // Diz se o jogador acertou a palavra ou n�o
		int erros = 0; // Conta quantas vezes o usu�rio errou a letra da palavra.
		char chute; // Guarda os chutes do jogador durante as rodadas da forca.
		int index = 0; // Usaremos essa vari�vel para marcar as rodadas e ir colocando as letras j� tentadas na array letrasTentadas.
		
		while (!enforcado && !ganhou) {
			imprimeLetrasAcertadas(letrasAcertadas);
			imprimeLetrasTentadas(letrasTentadas);
			System.out.println();
			
			System.out.print("Digite uma letra: ");
			chute = pedeChute(letrasTentadas);
			letrasTentadas[index++] = chute;
			
			if (Utensilios.arrayContem(letrasPalavraSecreta, chute)) // Ou seja, verifica se o chute � uma letra da palavra secreta.
				marcaChuteCorreto(chute, letrasAcertadas, letrasPalavraSecreta);
				
			else {
				erros ++;
				desenhaForca(erros);
			}
			
			enforcado = erros == LIMITE_ERROS;
			ganhou = acertouPalavra(letrasAcertadas);
		}
		
		System.out.printf("%nA palavra secreta era: %s%n", palavraSecreta);
		if (ganhou)
			imprimeMensagemVencedor();
		else
			imprimeMensagemPerdedor();
		
		
	}

	private static void imprimeMensagemAbertura() {
		System.out.println();
		System.out.println("*********************************");
	    System.out.println("** Bem vindo ao jogo da Forca! **");
	    System.out.println("*********************************");
	    System.out.println();
	}


	// Apresenta os temas para o usu�rio e pede para que ele selecione um deles
	private static void selecionaTema(String[] temas) {
		Gerenciador.imprimeTemas(temas);
		
			System.out.printf("%nDigite o n�mero do tema que deseja jogar: ");
			
			indexTema = Gerenciador.escolhaTema();
			
			while(Gerenciador.temaSemPalavras(JogoDaForca.temasEPalavras, indexTema)) {
				System.out.print("O tema escolhido n�o tem palavras armazenadas, tente outro: ");
				indexTema = Gerenciador.escolhaTema();
				
			}
		
	}


	// Escolhe uma palavra aleatoriamente dentre a lista de palavras dada no par�metro
	private static void escolherPalavraSecreta(String[] palavras) {
		SecureRandom randomNumbers = new SecureRandom();
		
		// randomNumbers ir� gerar um n�mero ale�torio entre 1 e a quantidade de palavras armazenadas.
		// Utilizamos n�meros a partir do 1, pois palavras tem o nome do tema como sendo o �ndice 0.
		int posicaoPalavra = randomNumbers.nextInt(1, Utensilios.arrayLengthNotNull(palavras));
																	 
		palavraSecreta = palavras[posicaoPalavra].toUpperCase(); // Colocamos a palavra em mai�scula para melhor apresenta��o ao usu�rio.
	
	}

	// Cria uma array com o caracter "_" para cada letra da palavra secreta, e tamb�m respeitando os espa�os da palavra.
	// Exemplo: se palavra secreta � teco teco, o m�todo cria a array {'_', '_', '_', '_', ' ', '_', '_', '_', '_'}
	private static char[] inicializaLetrasAcertadas(char[] letrasPalavraSecreta) {
		int tamanhoPalavraSecreta = letrasPalavraSecreta.length;
		char[] letras = new char[tamanhoPalavraSecreta]; // letras � onde guardaremos os "_" de acordo com o tamanho da palavra secreta															 
		
		for (int i = 0; i < tamanhoPalavraSecreta; i++ ) {
			if(Character.isSpaceChar((letrasPalavraSecreta[i])))
				letras[i] = ' ';
			else
				letras[i] = '_';
		}
		
		return letras;
	}
	
	private static void imprimeLetrasAcertadas(char[] letrasAcertadas) {
		System.out.printf("%nPalavra: ");
		
		for (char letra : letrasAcertadas) {
			if (letra == ' ')
				System.out.print("  ");
			else 
				System.out.printf("%c ",letra);
		}
		
		System.out.println();
	}

	private static void imprimeLetrasTentadas(char[] letrasTentadas) {
		System.out.print("Letras j� tentadas: ");
		for (char letra : letrasTentadas) {
			System.out.printf("%c  ", letra);
		}
		System.out.println();
	}

	private static char pedeChute(char[] letrasTentadas) {
		String chuteStr; // Utilizaremos o chute como string, pois o usu�rio pode digitar mais de um caracter na linha de comando e queremos poder
						 // avaliar essa situa��o.
		
		do {
			
			chuteStr = Utensilios.ler.next().toUpperCase();
				
		}while(!chuteValido(chuteStr, letrasTentadas));
		
		return chuteStr.charAt(0); // ao fim transformamos em char o chute para trabalharmos no restante do c�digo.
	}

	private static boolean chuteValido(String chute, char[] letrasTentadas) {
		char chuteChar = chute.charAt(0); // transforma o chute, que � uma string, em char, pois algumas funcionalidades s� s�o poss�veis com um tipo espec�fico.
		
		boolean chuteValido = true;
		boolean chuteRepetido = Utensilios.arrayContem(letrasTentadas, chuteChar); // Verifica se o chute est� na array das letras j� tentadas pelo
																				   // usu�rio.	
		
		if (!Utensilios.letraValida(chute)) // Se a letra n�o for v�lida, o chute tamb�m n�o � v�lido.
			chuteValido = false;
		
		else if (chuteRepetido) {
			System.out.println("Tente outra letra!");
			chuteValido = false;
		}
			
		return chuteValido;
	}

	private static void marcaChuteCorreto(char chute, char[] letrasAcertadas, char[] letrasPalavraSecreta) {
		int index = 0;
		
		for(char letra : letrasPalavraSecreta) {
			if (chute == letra)
				letrasAcertadas[index] = chute;
			
			index++;
		}		
	}

	private static void desenhaForca(int erros) {
		System.out.println("  _______     ");
		System.out.println(" |/      |    ");

	    switch(erros) {
		    case 1:
		    	System.out.println(" |      (_)   ");
		    	System.out.println(" |            ");
		    	System.out.println(" |            ");
		    	System.out.println(" |            ");
		        break;
		    
		    case 2:    
		    	System.out.println(" |      (_)   ");
		        System.out.println(" |       |    ");
		        System.out.println(" |            ");
		        System.out.println(" |            ");
		        break;
		        
		    case 3:
		    	System.out.println(" |      (_)   ");
		    	System.out.println(" |      \\|/   ");
		    	System.out.println(" |            ");
		        System.out.println(" |            ");
		        break;
		    
		    case 4:
		    	System.out.println(" |      (_)   ");
		        System.out.println(" |      \\|/   ");
		        System.out.println(" |       |    ");
		        System.out.println(" |            ");
		        break;
		    
		    case 5:
		    	System.out.println(" |      (_)   ");
		        System.out.println(" |      \\|/   ");
		        System.out.println(" |       |    ");
		        System.out.println(" |      / \\   ");
		        break;
	    }
	    System.out.println(" |            ");
	    System.out.println("_|___         ");
	    System.out.println();
	}

	// Retorna true caso n�o haja mais lacunas ('_') na array de letras acertadas.
	private static boolean acertouPalavra(char[] letrasAcertadas) {
		return !Utensilios.arrayContem(letrasAcertadas, '_');
	}

	private static void imprimeMensagemVencedor() {
		System.out.println("       ___________      ");
	    System.out.println("      '._==_==_=_.'     ");
	    System.out.println("      .-\\:      /-.    ");
	    System.out.println("     | (|:.     |) |    ");
	    System.out.println("      '-|:.     |-'     ");
	    System.out.println("        \\::.    /      ");
	    System.out.println("         '::. .'        ");
	    System.out.println("           ) (          ");
	    System.out.println("         _.' '._        ");
	    System.out.println("        '-------'       ");
	    System.out.println();
	    System.out.println("Parab�ns, voc� acertou a palavra. Deseja jogar novamente? (S/N)");
	}

	private static void imprimeMensagemPerdedor() {
		System.out.println("    _______________         ");
	    System.out.println("   /               \\       ");
	    System.out.println("  /                 \\      ");
	    System.out.println("//                   \\/\\  ");
	    System.out.println("\\|   XXXX     XXXX   | /   ");
	    System.out.println(" |   XXXX     XXXX   |/     ");
	    System.out.println(" |   XXX       XXX   |      ");
	    System.out.println(" |                   |      ");
	    System.out.println(" \\__      XXX      __/     ");
	    System.out.println("   |\\     XXX     /|       ");
	    System.out.println("   | |           | |        ");
	    System.out.println("   | I I I I I I I |        ");
	    System.out.println("   |  I I I I I I  |        ");
	    System.out.println("   \\_             _/       ");
	    System.out.println("     \\_         _/         ");
	    System.out.println("       \\_______/           ");
	    System.out.println();
	    System.out.println("Voc� perdeu! Deseja tentar novamente? (S/N)");
	}
		
}

