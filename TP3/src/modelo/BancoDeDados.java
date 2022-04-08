package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class BancoDeDados {
	private ArrayList<Conta> contas = new ArrayList<>();
	private ArrayList<Beneficio> beneficiosPadrao = new ArrayList<>();
	
	// Gets e Sets - inicio
	public ArrayList<Conta> getContas() {
		return contas;
	}
	
	public ArrayList<Beneficio> getBeneficiosPadrao() {
		return beneficiosPadrao;
	}
	// Gets e Sets - fim
	
	// Coloca no banco de dados a novaConta
	public void inserirConta(Conta novaConta) {
		this.contas.add(novaConta);
	}
	
	// Cadastra um novo beneficio no banco de dados
	public void inserirBeneficio(Beneficio beneficio) {
		this.beneficiosPadrao.add(beneficio);
	}
	
	public void DadosPreCadastrados() {	
		Conta contaPadrao1 = new Conta("usuario padrao", "75205489602", LocalDate.of(1995, 06, 12), "11944009564");
		this.inserirConta(contaPadrao1);
		
		Conta contaPadrao2 = new Conta("luciano", "09734785307", LocalDate.of(2001, 11, 20), "7799998599");
		this.inserirConta(contaPadrao2);
	}
	
	

}
