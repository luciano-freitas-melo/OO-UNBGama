/* 
O intuito dessa classe é criar métodos que serão úteis várias vezes durante o desenvolvimento do programa. 
*/

package principal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utensilios {
	
	static Scanner ler = new Scanner(System.in);

	// Lê uma string do usuário, primeiro limpando o buffer e recebendo qualquer valor que estiver na linha.					
	public static String lerString() {
		ler.nextLine();
		String variavel = ler.nextLine().toLowerCase();
		
		return variavel;
	}
	
	// Formata uma string qualquer em uma string capitalizada, ou seja, com a primeira letra maiúscula e o resto 
	// minúscula
	public static String capitalize(String palavra) {
		palavra = palavra.toLowerCase();
		palavra = palavra.substring(0,1).toUpperCase().concat(palavra.substring(1));
		return palavra;
	}
	
	/*
	 * Validar variável do tipo inteiro
	 * 	Lê um inteiro do usuário, e valida esse valor de duas formas:
	 * 		1. Se o usuário digitou um inteiro, caso contrário retorna uma mensagem de erro padrão e pede novamente a digitação.
	 * 		2. Se o valor digitado está entre os parâmetros aceitos, isso é feito pelas variáveis minimoAceitavel e maximoAceitavel,
	 * 		da seguinte forma:
	 * 							minimoAceitavel < valor recebido < maximoAceitavel
	 * 		Caso o valor recebido não esteja dentro desse intervalo, retorna uma mensagem de erro ao usuário (também
	 * 		definida por um parâmetro) e pede a leitura novamente do valor, até que seja digitado um valor válido.
	 * 
	 * Exemplo de formato de mensagem de erro: "Número digitado inválido, tente novamente: "
	 */
	public static int validarVariavel(int minimoAceitavel, int maximoAceitavel, String mensagemErro) {
		boolean valorInvalido;
		int variavel = 0;
		do {
			valorInvalido = false;
			try {
				variavel = ler.nextInt();
				if (variavel < minimoAceitavel || variavel > maximoAceitavel) {
					valorInvalido = true;
					System.out.print(mensagemErro);
				}
			}
			catch (InputMismatchException erro){
				valorInvalido = true;
				ler.nextLine();
				System.out.print("Valor digitado inválido, por favor insira um NÚMERO: ");
			}
			
		}while(valorInvalido);
		
		return variavel;
	}

	// Verifica se a letra no parâmetro é uma letra e se é um dígito único.
	public static boolean letraValida (String letra) {
		boolean digitoUnico = letra.length() == 1; // Verifica se o usuário digitou apenas um dígito.
		boolean ehLetra = Character.isLetter(letra.charAt(0)); // Verifica se o chute é uma letra do alfabeto.
		
		if (!digitoUnico)
			System.out.print("Digite apenas uma letra por vez, tente novamente: ");
			
		else if (!ehLetra)
			System.out.print("Isso não é uma letra, tente novamente: ");
			
		return (digitoUnico && ehLetra ? true : false);
	}

	// Verifica se a array dada no parâmetro contêm o valor respectivo.
	public static boolean arrayContem(char[] array, char valor) {
        boolean valorEncontrado = false;

        for(int i = 0; i < array.length; i++) {
            if(array[i] == valor) {
                valorEncontrado = true;
            }
        }
        return valorEncontrado; 
    }
	
	public static boolean arrayContem(String[] array, String valor) {
        boolean valorEncontrado = false;

        for(int i = 0; i < array.length; i++) {
            if(array[i] != null && array[i].equals(valor)) {
                valorEncontrado = true;
            }
        }
        return valorEncontrado; 
    }

	// Retorna o tamanho da array, mas ignorando valores do tipo null na contagem.
	public static int arrayLengthNotNull(String[] array) {
		int arrayLength = 0;
	
		for (String value : array)
			if (value != null)
				arrayLength++;
		
		return arrayLength;
	}	
}