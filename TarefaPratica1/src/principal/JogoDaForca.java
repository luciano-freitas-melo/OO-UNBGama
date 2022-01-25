package principal;

public class JogoDaForca {

	public static void main(String[] args) {
		String[][] temas = {{"animais", "gato", "cachorro", "pato"}, {"frutas", "melancia", "banana", "goiaba"},
				{"friends", "ross", "rachel", "chandler"}};
		
		String jogarNovamente; // Recebe S ou N, dependendo se o usuário deseja jogar novamente ou não.
		
		do {
			JogarForca.jogar(temas);
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
			System.out.print("Só é permitido digitar S (para SIM) ou N (para NÃO): ");
		}
	
		return inputValido;
	}

}
