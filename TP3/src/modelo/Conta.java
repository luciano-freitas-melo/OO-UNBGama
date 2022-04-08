
package modelo;

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
		this.nome = nome.toLowerCase();
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
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
	
	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public ArrayList<CartaoDePagamento> getCartoes() {
		return cartoes;
	}
	// Getters e Setters - fim
	
	
	public Conta(String nome, String cpf, LocalDate dataNascimento, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
	}
	
	// Exclui essa conta de um conjunto de contas dados no parâmetro
	public void excluirConta(ArrayList<Conta> contas) {
		int quantContas = contas.size();
		
		for(int i = 0; i < quantContas; i++) {
			// Buscamos essa conta no banco de contas do sistema através do cpf e excluímos caso a conta esteja no banco
			if (this.cpf.equals(contas.get(i).getCpf())) {
				contas.remove(i);
			}
		}		
	}
	
	public void incluirImovel(Imovel imovel) {
		this.imoveis.add(imovel);
	}
	
	public void incluirReserva(Reserva novaReserva) {
		this.reservas.add(novaReserva);
	}
	
	public void incluirCartao(CartaoDePagamento cartao) {
		this.cartoes.add(cartao);
	}
}
