
package principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Conta {
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private String telefone;
	private ArrayList<Imovel> imoveis = new ArrayList<Imovel>();
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	private ArrayList<CartaoDePagamento> cartoes = new ArrayList<CartaoDePagamento>();
	
	// Getters e Setters - inicio
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDataNascimento() {
		// Retorna a string no formato: Dia/Mes/Ano
		return dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	public void setDataNascimento(LocalDate data) {
		this.dataNascimento = data;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public ArrayList<Imovel> getImoveis() {
		return imoveis;
	}
	public void setImovel(Imovel imovel) {
		this.imoveis.add(imovel);
	}
	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(Reserva novaReserva) {
		this.reservas.add(novaReserva);
	}

	public ArrayList<CartaoDePagamento> getCartoes() {
		return cartoes;
	}

	public void setCartoes(ArrayList<CartaoDePagamento> cartoes) {
		this.cartoes = cartoes;
	}
	// Getters e Setters - fim
	
	public Conta(String nome, String cpf, LocalDate dataNascimento, String telefone, ArrayList<Imovel> imoveis,
			ArrayList<Reserva> reservas, ArrayList<CartaoDePagamento> cartoes) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.imoveis = imoveis;
		this.reservas = reservas;
		this.cartoes = cartoes;
	}
	
	public Conta(BancoDeDados banco) {
		System.out.print("Nome: ");
		setNome(Validador.lerNome(3));
		System.out.print("Numero do CPF: ");
		// Le a entrada do CPF, com a restricao de ter 11 digitos na entrada
		setCpf(Validador.lerEntrada(11));
		System.out.println("Data de nascimento");
		setDataNascimento(Validador.lerData());
		System.out.println("Telefone");
		setTelefone(Validador.lerTelefone());
		
		// Insere no banco a conta criada
		banco.inserirConta(this);
		
		System.out.println("Conta cadastrada com sucesso!");
	}
	
	public void alterarConta() {
		
	}
	public void excluirConta() {
		
	}
	public void cadastrarNovoImovel() {
		System.out.println("Escolha o tipo de imovel:");
		System.out.println("1. Casa");
		System.out.println("2. Apartamento");
		int opcao = Validador.lerEntrada(1,2);
		
		// Colocamos o valor inicial como null pois a variavel deve ser inicializada.
		Imovel novoImovel = null;
		switch(opcao) {
			case 1:
				novoImovel = new Casa(this);
				break;
			case 2:
				novoImovel = new Apartamento(this);
				break;
		}
		this.setImovel(novoImovel);
	}
	
	public void realizarReserva(ArrayList<Imovel> imoveis) {
		Reserva novaReserva = new Reserva(this, imoveis);
		setReservas(novaReserva);
	}

}
