package principal;

import java.util.Date;

public class Reserva {
	// Toda reserva esta associada a uma conta que esta realizando a reserva
	private Conta conta;
	private Date dataEntrada;
	private Date dataSaida;
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
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public Date getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Date dataSaida) {
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
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	// Getters e Setters - fim
	
	public Boolean cadastrar() {
		return null;
	}
	
	public Boolean editar() {
		return null;
	}
	
	public Boolean excluir() {
		return null;
	}
	
	public void reservarDatas(Date[] diasDisponiveis) {
	}
	

}
