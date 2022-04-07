package controle;

import modelo.*;

public class ControleDados {
	private BancoDeDados banco = new BancoDeDados();
	
	public ControleDados() {
		banco.DadosPreCadastrados();
	}
	
	
	public String[] getNomesContas() {
		String[] nomes = new String[banco.getContas().size()];

		int i = 0;
		for (Conta conta : banco.getContas()) {
			nomes[i++] = conta.getNome();
		}
		return nomes;
	}
	
	public String[] getNomesContasCapitalizado() {
		String[] nomes = new String[banco.getContas().size()];

		int i = 0;
		for (Conta conta : banco.getContas()) {
			nomes[i++] = Utilitario.capitalize(conta.getNome());
		}
		return nomes;
	}


	public String[] getCpfContas() {
		String[] cfps = new String[banco.getContas().size()];

		int i = 0;
		for (Conta conta : banco.getContas()) {
			cfps[i++] = conta.getCpf();
		}
		return cfps;
	}


	public void inserirConta(Conta conta) {
		banco.getContas().add(conta);
	}


}
