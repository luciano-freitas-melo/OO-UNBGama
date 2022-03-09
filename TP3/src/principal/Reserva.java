package principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

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
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	// Getters e Setters - fim
	
	public Reserva(Conta conta, ArrayList<Imovel> imoveis) {
		setConta(conta);
		setImovel(escolherImovel(imoveis));
		System.out.println();
		System.out.println("Data de check-in:");
		setDataEntrada(Validador.lerData());
		System.out.println();
		System.out.println("Data de check-out:");
		setDataSaida(Validador.lerData());
		System.out.print("Quantidade de hospedes: ");
		setQuantHospedes(Validador.lerEntrada());
		
		System.out.println("Reserva realizada com sucesso!");
		
		
	}
	
	// Lista os imoveis para o usuario e retorna o imovel escolhido
	private Imovel escolherImovel(ArrayList<Imovel> imoveis) {
		System.out.println("Selecione o imovel que deseja alugar:");
		for(Imovel imovel : imoveis)
			System.out.printf("%-1d. %s%n",imoveis.indexOf(imovel), imovel.toString());
		
		int escolha = Validador.lerEntrada(0, imoveis.size()-1);
		
		return imoveis.get(escolha);
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
