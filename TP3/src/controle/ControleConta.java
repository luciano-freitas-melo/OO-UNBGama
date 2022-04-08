package controle;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import modelo.*;

public class ControleConta {
	
	private Conta conta;
	// Remete ao banco de contas que temos no sistema
	private ArrayList<Conta> bancoContas;
	
	
	public void setBancoContas(ArrayList<Conta> bancoContas) {
		this.bancoContas = bancoContas;
	}

	public String getNome() {
		return Utilitario.capitalize(this.conta.getNome());
	}
	
	public String getCpf() {
		return this.conta.getCpf();
	}
	
	public String getDataNasc() {
		return this.conta.getDataNascimento().format(DateTimeFormatter.ofPattern("ddMMyyyy"));
	}
	
	public String getTelefone() {
		return this.conta.getTelefone();
	}
	
	
	public ControleConta(ArrayList<Conta> bancoContas) {
		this.bancoContas = bancoContas;
	}

	// Associa uma conta a esse Controle a partir do nome da conta que tiver no banco de dados
	public void associarConta(String contaSelecionada) {
		for (Conta conta : bancoContas) {
			if(contaSelecionada.toLowerCase().equals(conta.getNome())) {
				this.conta = conta;
				break;
			}
		}
	}

	public String[] getNomesContasCapitalizado() {
		String[] nomes = new String[bancoContas.size()];

		int i = 0;
		for (Conta conta : bancoContas) {
			nomes[i++] = Utilitario.capitalize(conta.getNome());
		}
		return nomes;
	}
	
	
	
	// Verifica se o nome ja esta em uma conta do sistema
	public boolean nomeRepetido(String nome) {
		
		nome = nome.toLowerCase();
		
		for(Conta conta : bancoContas) {
			if(conta.getNome().equals(nome))
				return true;
		}
		
		return false;
	}
	
	// Verifica se o nome ja esta em uma conta do sistema
	public boolean cpfRepetido(String cpf) {
			
		for(Conta conta : bancoContas) {
			if(conta.getCpf().equals(cpf))
				return true;	
	}
		
		return false;
	}

	public boolean dataNascValida(String data) {

		LocalDate d;
		try {
		d = Utilitario.toLocalDate(data);
		
		// Caso a string não seja uma data mesmo, retorna falso
		} catch(DateTimeException e) {
			return false;
		}
		
		// Valida se a data eh de uma pessoa com mais de 18 anos
		if(d.isAfter(LocalDate.now().minusYears(18))) {
			return false;
		}
		
		return true;
	}

	public boolean telefoneValido(String telefone) {
		
		char digito9 = telefone.charAt(2);
		int ddd = Integer.parseInt(telefone.substring(0, 2));
		
		// O ddd não pode ser menor que 11, pois não existe nenhum ddd desse tipo
		if(ddd < 11)
			return false;
		
		if(digito9 != '9')
			return false;
		
		
		return true;
	}

	public void cadastrarNovaConta(String nome, String cpf, String dataNascimento, String telefone) {
		conta = new Conta(nome, cpf, Utilitario.toLocalDate(dataNascimento), telefone);
		bancoContas.add(conta);
	}

	public void editarConta(String nome, String cpf, String dataNascimento, String telefone) {
		this.conta = new Conta(nome, cpf, Utilitario.toLocalDate(dataNascimento), telefone);
	}

}
