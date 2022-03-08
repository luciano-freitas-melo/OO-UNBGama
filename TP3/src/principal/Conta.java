
package principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Conta {
	protected String nome;
	protected String docCPF;
	protected LocalDate dataNascimento;
	protected String telefone;
	
	// Getters e Setters - inicio
	public String getNome() {
		// Retorna o nome de forma capitalizada
		return nome = nome.substring(0,1).toUpperCase() + nome.substring(1);
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getdocCPF() {
		return docCPF;
	}
	public void setdocCPF(String docID) {
		this.docCPF = docID;
	}
	public String getDataNascimento() {
		// Retorna a string no formato: Dia/Mes/Ano
		return dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	public void setDataNascimento(String string) {
		// o metodo parse faz com que possamos obter um LocalDate a partir de uma string que esteja no formato que colocamos
		// em "ofPattern", sendo dd = dia, MM = mes e yyyy = ano.
		this.dataNascimento = LocalDate.parse(string, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	// Getters e Setters - fim
	
	public Conta() {
		System.out.print("Nome: ");
		setNome(Validador.ler.next());
		System.out.print("Numero do CPF: ");
		setdocCPF(Validador.ler.next());
		System.out.print("Data de nascimento(DIA/MES/ANO{aaaa}): ");
		setDataNascimento(Validador.ler.next());
		System.out.print("Telefone (DDD)9XXXX-XXXX: ");
		setTelefone(Validador.ler.next());
	}
	
	public void imprimirInformacoesConta() {
		System.out.printf("Usuario %s%n"
				+ "CPF = %s     Data de Nascimento = %s     Telefone = %s",getNome(), getdocCPF(), getDataNascimento(), getTelefone());
	}
	
	
	public abstract Boolean alterarConta();
	public abstract Boolean excluirConta();

}
