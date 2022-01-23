package principal;

public class TestarProjeto {

	public static void main(String[] args) {
		String[][] temas = {{"animais", "gato", "cachorro", "pato"}, {"frutas", "melancia", "banana", "goiaba"},
				{"friends", "ross", "rachel", "chandler"}};
		principal.JogarForca.jogar(temas);
	}

}
