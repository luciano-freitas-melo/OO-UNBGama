package principal;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Validador {
	public static Scanner ler = new Scanner(System.in);
	
	/*
	 * Metodos lerEntrada()
	 * - Le a entrada do usuario, valida essa entrada baseada em alguns criterios e retorna a entrada digitada.
	 * - Continua pedindo a entrada ate que seja digitada uma valida
	 */
	// Criterio: entrada eh um inteiro
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
			ler.nextLine();
				
		}
		return numero;
	}
	// Criterios
	// 1. E um inteiro
	// 2. Esta no intervalo de entradas validas ditado pelos parametros do metodo
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
				System.out.println("Entrada digitada invalida, digite um NUMERO!");
			}
			ler.nextLine();
		}
		return numero;
	}
	// Criterios:
	// 1. Eh uma string somente com numeros
	// 2. Contem a quantidade de digitos igual ao parametro
	public static String lerEntrada(int quantDigitos) {
		String numero = null;
		boolean entradaValida = false;
		
		// Verifica se a string contem somente digitos
		boolean somenteDigitos;
		//Verifica se o numero tem a quantidade de digitos correta
		boolean digitosCorretos;
		
		do{
		numero = ler.next(); ler.nextLine();
		somenteDigitos = numero.matches("[\\d]+");
		digitosCorretos = numero.length() == quantDigitos;
		
		if(!somenteDigitos)
			System.out.print("Eh permitido somente numeros! Digite novamente: ");
		else if(!digitosCorretos)
			System.out.printf("O numero deve conter %d digitos, tente novamente: ", quantDigitos);
		else
			entradaValida = true;
	
		}while(!entradaValida);
		
		return numero;
	}
	
	// Pede um double ao usuario e valida a entrada, retornando o valor digitado quando for uma entrada valida
	public static double lerDouble() {
		double numero = 0;
		boolean entradaValida = false;
				
		while(!entradaValida) {
			try {
				numero = ler.nextDouble();
					entradaValida = true;
			}
			// Excessao em que a entrada digitada nao eh um numero
			catch (InputMismatchException erro){
				entradaValida = true;
				System.out.println("Entrada digitada invalida, digite um NUMERO!");
			}
			ler.nextLine();
						
		}
		return numero;
	}
	
	// Pede uma string ao usuario e retorna essa string
	public static String lerString() {	
		String string = ler.nextLine();
		
		return string;
	}
	
	// Le e valida um nome do usuario, atendendo ao minimo de letras que deve haver no nome
	public static String lerNome(int minimoLetras) {
		
		String nome;
		
		boolean nomeValido = false;
		// Verifica se so existem letras e espaco no nome
		boolean somenteLetras;
		//Verifica se o nome tem o minimo de letras aceitavel
		boolean temMinimoLetras;
		
		do{
		nome = ler.nextLine().toLowerCase();
		
		somenteLetras = nome.matches("[a-z\s]+");
		temMinimoLetras = nome.length() > minimoLetras;
		
		if(!somenteLetras)
			System.out.print("O nome so deve conter letras e espacos: ");
		else if(!temMinimoLetras)
			System.out.printf("O nome deve ter mais de %d letras: ", minimoLetras);
		else
			nomeValido = true;
	
		}while(!nomeValido);
		
		return nome;
	}
	
	// Pede ao usuario digitar uma data e a valida, retornando a data digitada.
	public static LocalDate lerData() {
		boolean dataInvalida = true;
		LocalDate data = null;
		
		while(dataInvalida) {
			System.out.print("dia: ");
			int dia = lerEntrada();
			System.out.print("mes: ");
			int mes = lerEntrada();
			System.out.println("ano: ");
			int ano = lerEntrada();
			
			try {
				data = LocalDate.of(ano, mes, dia);
				dataInvalida = false;
			} catch(DateTimeException e) {
				System.out.println("Data digitada invalida, tente novamente!");
			}
		}
		return data;
	}
	
	// Le e valida um telefone do usuario
	public static String lerTelefone() {
		System.out.print("DDD: ");
		String ddd = lerEntrada(3);
		System.out.print("Telefone: ");
		String telefone = lerEntrada(9);
		
		return "("+ddd+")"+telefone;
	}
}
