package principal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validador {
	public static Scanner ler = new Scanner(System.in);
	
	
	// Le a entrada do usuario e valida se foi digitado um inteiro, caso sim retorna esse inteiro
	// Continua pedindo a entrada ate que seja digitada uma valida
	public static int lerEntrada() {
		int numero = 0;
		boolean entradaValida = false;
			
		while(!entradaValida) {
			try {
				numero = ler.nextInt();
				entradaValida = true;
			}
			// Excessao em que a entrada digitada nao eh um numero
			catch (InputMismatchException erro){
				entradaValida = true;
				ler.nextLine();
				System.out.println("Entrada digitada invalida, digite um NUMERO!");
			}
				
		}
		return numero;
	}
	
	// Le a entrada do usuario e a  valida com os seguintes criterios:
	// 1. E um inteiro
	// 2. Esta no intervalo de entradas validas ditado pelos parametros do metodo
	// Continua pedindo a entrada ate que seja digitada uma valida
	public static int lerEntrada(int minimoValido, int maximoValido) {
		int numero = 0;
		boolean entradaValida = false;
		
		while(!entradaValida) {
			
			try {
				numero = ler.nextInt();
				if (numero < minimoValido || numero > maximoValido) {
					System.out.printf("Opcao invalida, digite um numero entre %d e %d!%n", minimoValido, maximoValido);
				}else
					entradaValida = true;
			}
			// Excessao em que a entrada digitada nao eh um numero
			catch (InputMismatchException erro){
				entradaValida = true;
				ler.nextLine();
				System.out.println("Entrada digitada invalida, digite um NUMERO!");
			}	
		}
		return numero;
	}
}
