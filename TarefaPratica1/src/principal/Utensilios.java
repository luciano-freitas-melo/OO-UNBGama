/* 
O intuito dessa classe � criar m�todos que ser�o �teis v�rias vezes durante o desenvolvimento do programa. 
*/

package principal;

import java.util.Scanner;

public class Utensilios {
	
	static Scanner ler = new Scanner(System.in); // Cria��o de um scanner padr�o que ser� utilizado por diversos
												 // m�todos.

	
	// Formata uma string qualquer em uma string capitalizada, ou seja, com a primeira letra mai�scula e o resto 
	// min�scula
	public static String capitalize(String palavra) {
		palavra = palavra.toLowerCase();
		palavra = palavra.substring(0,1).toUpperCase().concat(palavra.substring(1));
		return palavra;
	}
	
	/*
	 * Validar vari�vel do tipo inteiro
	 * 	L� um inteiro do usu�rio, e valida esse valor de acordo com os par�metros dados, da seguinte forma:
	 * 							minimoAceitavel < valor recebido < maximoAceitavel
	 * 	Caso o valor recebido n�o esteja dentro desse intervalo, retorna uma mensagem de erro ao usu�rio (tamb�m
	 * 	definida por um par�metro) e pede a leitura novamente do valor, at� que seja digitado um valor v�lido.
	 * 
	 * Exemplo de formato de mensagem de erro: "N�mero digitado inv�lido, tente novamente: "
	 */
	public static int validarVariavel(int variavel, int minimoAceitavel, int maximoAceitavel, String mensagemErro) {
		boolean valorInvalido;
		
		do {
			variavel = ler.nextInt();
			
			valorInvalido = false;
			if (variavel < minimoAceitavel || variavel > maximoAceitavel) {
				valorInvalido = true;
				System.out.print(mensagemErro);
			}	
		}while(valorInvalido);
		
		return variavel;
	}
}
