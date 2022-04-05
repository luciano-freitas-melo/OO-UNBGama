package modelo;

import java.time.LocalDate;

public class Reserva {
	// Toda reserva esta associada a uma conta que esta realizando a reserva
	private Conta conta;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	// O imovel que sera alugado pelo periodo
	private Imovel imovel;
	// Quantidade de hospedes que ficarao no imovel
	private int quantHospedes;
	// Pode ser feita uma avaliacao sobre a hospedagem
	private Avaliacao avaliacao;
	
	// Getters e Setters - inicio
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public LocalDate getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public LocalDate getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}
	public Imovel getImovel() {
		return imovel;
	}
	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	public int getQuantHospedes() {
		return quantHospedes;
	}
	public void setQuantHospedes(int quantHospedes) {
		this.quantHospedes = quantHospedes;
	}
	
	// Avaliacao
	public Double getnotaAvaliacao() {
		return avaliacao.getNota();
	}
	public String getComentarioAvaliacao() {
		return avaliacao.getComentario();
	}
	public LocalDate getDataAvaliacao() {
		return avaliacao.getDataAvaliacao();
	}
	
	// Getters e Setters - fim
	
	public void adicionarAvaliacao(Double nota, String comentario) {
		this.avaliacao = new Avaliacao(nota, comentario);
	}
	
	public Reserva(Conta conta, LocalDate dataEntrada, LocalDate dataSaida, Imovel imovel, int quantHospedes) {
		this.conta = conta;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.imovel = imovel;
		this.quantHospedes = quantHospedes;
	}

}
