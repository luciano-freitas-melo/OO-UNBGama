package controle;

import modelo.*;

public class ControleDados {
	private BancoDeDados banco = new BancoDeDados();
	
	public ControleDados() {
		banco.DadosPreCadastrados();
	}
	
	
	public String[] getNomes() {
		String[] nomes = new String[banco.getContas().size()];

		int i = 0;
		for (Conta conta : banco.getContas()) {
			nomes[i++] = conta.getNome();
		}
		return nomes;
	}


}
