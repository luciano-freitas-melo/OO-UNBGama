package controle;

import java.time.*;
import modelo.*;

public class ControleConta {
	
	private Conta conta;
	private ControleDados dados;
	
	public ControleConta(ControleDados dados) {
		this.dados = dados;
	}

	// Verifica se o nome ja esta em uma conta do sistema
	public boolean nomeRepetido(String nome) {
		
		nome = nome.toLowerCase();
		
		for(String nomeConta :dados.getNomesContas()) {
			if(nomeConta.equals(nome))
				return true;
		}
		
		return false;
	}
	
	// Verifica se o nome ja esta em uma conta do sistema
	public boolean cpfRepetido(String cpf) {
			
		for(String cpfConta :dados.getCpfContas()) {
			if(cpfConta.equals(cpf))
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
		dados.inserirConta(conta);
	}

}
