package principal;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class BancoDeDados {
	private ArrayList<Conta> contas = new ArrayList<Conta>();
	private ArrayList<Beneficio> beneficiosPadrao = new ArrayList<>();
	
	// Gets e Sets - inicio
	public ArrayList<Conta> getContas() {
		return contas;
	}
	// Coloca no banco de dados a novaConta
	public void inserirConta(Conta novaConta) {
		this.contas.add(novaConta);
	}
	public ArrayList<Beneficio> getBeneficiosPadrao() {
		return beneficiosPadrao;
	}
	public void inserirBeneficio(Beneficio beneficio) {
		this.beneficiosPadrao.add(beneficio);
	}
	// Gets e Sets - fim
	
	public void DadosPreCadastrados() {
		beneficiosPadrao.add(new Beneficio("Wi-Fi", "COMODIDADE"));
		
		ArrayList<Imovel> imoveisPadrao1 = new ArrayList<Imovel>();
		imoveisPadrao1.add(new Casa("Chale Suico", new Localizacao("47850000", "Avenida Holanda"), new Especificacao(20.5, 3, beneficiosPadrao), new BigDecimal(157), null, null, null, "INTEIRO", "PADRAO"));
		imoveisPadrao1.add(new Apartamento("Loft no Confort Taguatinga", new Localizacao("55641715", "Rua Marcionilo Ribeiro de Carvalho"), new Especificacao(15, 1, beneficiosPadrao), new BigDecimal(60), null, null, null, "LOFT"));
		
		ArrayList<Reserva> reservasPadrao1 = new ArrayList<Reserva>();
		ArrayList<CartaoDePagamento> cartoesPadrao1 = new ArrayList<CartaoDePagamento>();
		
		Conta contaPadrao1 = new Conta("luciano", "00100200399", LocalDate.of(2002, 11, 15), "077111112222", imoveisPadrao1, reservasPadrao1, cartoesPadrao1);
		
		
		inserirConta(contaPadrao1);
	}

	// Pede que o usuario digite um nome, e retorna uma conta associada a ele.
	// Caso nao seja encontrado uma conta associada, retorna null.
	public Conta buscarContaPorNome(String nome) {
		Conta contaEncontrada = null;
		
		for (Conta c : contas) {
			if (c.getNome().equals(nome)) {
				contaEncontrada = c;
				break;
			}
		}
		return contaEncontrada;
	}
	// Lista as contas cadastradas de forma enumerada, apresentando o nome da conta
	public void listarContasPorNome() {
		int i = 1;
		for(Conta c : contas) {
			// formato: i. nome da conta
			System.out.printf("%d. %s%n", i, c.getNome());
			i++;
		}
	}	
	
}
