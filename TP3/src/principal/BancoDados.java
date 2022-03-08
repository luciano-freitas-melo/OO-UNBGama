package principal;

import java.util.ArrayList;

public class BancoDados {
	private static ArrayList<Locador> contasLocador = new ArrayList<Locador>();
	private static ArrayList<Locatario> contasLocatario = new ArrayList<Locatario>();;
	
	
	
	// Coloca no banco de dados o novo objeto do tipo especificado
	public static void inserirNoBanco(Locador novoLocador) {
		contasLocador.add(novoLocador);
	}
	
	public static void inserirNoBanco(Locatario novoLocatario) {
		contasLocatario.add(novoLocatario);
	}
	
}
