/* 
O intuito dessa classe � criar m�todos que ser�o �teis v�rias vezes durante o desenvolvimento do programa. 
*/

package principal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utensilios {
	
	static Scanner ler = new Scanner(System.in);

	// L� uma string do usu�rio, primeiro limpando o buffer e recebendo qualquer valor que estiver na linha.					
	public static String lerString() {
		ler.nextLine();
		String variavel = ler.nextLine().toLowerCase();
		
		return variavel;
	}
	
	// Formata uma string qualquer em uma string capitalizada, ou seja, com a primeira letra mai�scula e o resto 
	// min�scula
	public static String capitalize(String palavra) {
		palavra = palavra.toLowerCase();
		palavra = palavra.substring(0,1).toUpperCase().concat(palavra.substring(1));
		return palavra;
	}
	
	/*
	 * Validar vari�vel do tipo inteiro
	 * 	L� um inteiro do usu�rio, e valida esse valor de duas formas:
	 * 		1. Se o usu�rio digitou um inteiro, caso contr�rio retorna uma mensagem de erro padr�o e pede novamente a digita��o.
	 * 		2. Se o valor digitado est� entre os par�metros aceitos, isso � feito pelas vari�veis minimoAceitavel e maximoAceitavel,
	 * 		da seguinte forma:
	 * 							minimoAceitavel < valor recebido < maximoAceitavel
	 * 		Caso o valor recebido n�o esteja dentro desse intervalo, retorna uma mensagem de erro ao usu�rio (tamb�m
	 * 		definida por um par�metro) e pede a leitura novamente do valor, at� que seja digitado um valor v�lido.
	 * 
	 * Exemplo de formato de mensagem de erro: "N�mero digitado inv�lido, tente novamente: "
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
				System.out.print("Valor digitado inv�lido, por favor insira um N�MERO: ");
			}
			
		}while(valorInvalido);
		
		return variavel;
	}

	// Verifica se a letra no par�metro � uma letra e se � um d�gito �nico.
	public static boolean letraValida (String letra) {
		boolean digitoUnico = letra.length() == 1; // Verifica se o usu�rio digitou apenas um d�gito.
		boolean ehLetra = Character.isLetter(letra.charAt(0)); // Verifica se o chute � uma letra do alfabeto.
		
		if (!digitoUnico)
			System.out.print("Digite apenas uma letra por vez, tente novamente: ");
			
		else if (!ehLetra)
			System.out.print("Isso n�o � uma letra, tente novamente: ");
			
		return (digitoUnico && ehLetra ? true : false);
	}

	// Verifica se a array dada no par�metro cont�m o valor respectivo.
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