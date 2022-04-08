package controle;

import java.util.ArrayList;

import modelo.*;

public class ControleDados {
	private BancoDeDados banco = new BancoDeDados();
	
	
	public ArrayList<Conta> getContas() {
		return banco.getContas();
	}


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
	

	public String[] getCpfContas() {
		String[] cfps = new String[banco.getContas().size()];

		int i = 0;
		for (Conta conta : banco.getContas()) {
			cfps[i++] = conta.getCpf();
		}
		return cfps;
	}


	public void inserirConta(Conta conta) {
		banco.inserirConta(conta);
	}



}
