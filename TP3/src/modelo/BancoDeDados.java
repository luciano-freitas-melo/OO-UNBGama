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
//		beneficiosPadrao.add(new Beneficio("Wi-Fi", "COMODIDADE"));
//		
//		ArrayList<Imovel> imoveisPadrao1 = new ArrayList<Imovel>();
//		imoveisPadrao1.add(new Casa("Chale Suico", new Localizacao("47850000", "Avenida Holanda"), new Especificacao(20.5, 3, beneficiosPadrao), new BigDecimal(157), null, null, null, "INTEIRO", "PADRAO"));
//		imoveisPadrao1.add(new Apartamento("Loft no Confort Taguatinga", new Localizacao("55641715", "Rua Marcionilo Ribeiro de Carvalho"), new Especificacao(15, 1, beneficiosPadrao), new BigDecimal(60), null, null, null, "LOFT"));
//		
//		ArrayList<Reserva> reservasPadrao1 = new ArrayList<Reserva>();
//		ArrayList<CartaoDePagamento> cartoesPadrao1 = new ArrayList<CartaoDePagamento>();
//		
		Conta contaPadrao1 = new Conta("usuario padrao", "75205489602", LocalDate.of(1995, 06, 12), "11944009564");
		this.inserirConta(contaPadrao1);
		
		Conta contaPadrao2 = new Conta("luciano", "09734785307", LocalDate.of(2001, 11, 20), "7799998599");
		this.inserirConta(contaPadrao2);
//		
//		inserirConta(contaPadrao1);
	}
	
	

}
