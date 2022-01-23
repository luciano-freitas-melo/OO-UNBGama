/* 
O intuito dessa classe é criar métodos que serão úteis várias vezes durante o desenvolvimento do programa. 
*/

package principal;

import java.util.Scanner;

public class Utensilios {
	
	static Scanner ler = new Scanner(System.in); // Criação de um scanner padrão que será utilizado por diversos
												 // métodos.

	
	// Formata uma string qualquer em uma string capitalizada, ou seja, com a primeira letra maiúscula e o resto 
	// minúscula
	public static String capitalize(String palavra) {
		palavra = palavra.toLowerCase();
		palavra = palavra.substring(0,1).toUpperCase().concat(palavra.substring(1));
		return palavra;
	}
	
	/*
	 * Validar variável do tipo inteiro
	 * 	Lê um inteiro do usuário, e valida esse valor de acordo com os parâmetros dados, da seguinte forma:
	 * 							minimoAceitavel < valor recebido < maximoAceitavel
	 * 	Caso o valor recebido não esteja dentro desse intervalo, retorna uma mensagem de erro ao usuário (também
	 * 	definida por um parâmetro) e pede a leitura novamente do valor, até que seja digitado um valor válido.
	 * 
	 * Exemplo de formato de mensagem de erro: "Número digitado inválido, tente novamente: "
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
