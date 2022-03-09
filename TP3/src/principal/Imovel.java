package principal;

import java.awt.Image;
import java.math.BigDecimal;
import java.util.ArrayList;

public abstract class Imovel {
	
	private String nome;
	// Onde fica esse imovel 
	private Localizacao localizacao;
	// Todas as caracteristicas do imovel
	private Especificacao especificacao;
	// O valor de uma noite de estadia
	private BigDecimal precoNoite;
	// Datas em que o imovel pode ser reservado
	private CalendarioDisponibilidade calendario;
	// Conjunto de imagens do imovel
	private ArrayList<Image> imagens = new ArrayList<>();
	// Armazena todas as reservas feitas nesse imovel
	private ArrayList<Reserva> reservas = new ArrayList<>();
	
	//Getters e Setters - inicio
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Localizacao getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}
	public Especificacao getEspecificacao() {
		return especificacao;
	}
	public void setEspecificacao(Especificacao especificacao) {
		this.especificacao = especificacao;
	}
	public BigDecimal getPrecoNoite() {
		return precoNoite;
	}
	public void setPrecoNoite(double d) {
		this.precoNoite = new BigDecimal(d);
	}
	public CalendarioDisponibilidade getCalendario() {
		return calendario;
	}
	public void setCalendario(CalendarioDisponibilidade calendario) {
		this.calendario = calendario;
	}
	
	public ArrayList<Image> getImagens() {
		return imagens;
	}
	public void setImagens(ArrayList<Image> imagens) {
		this.imagens = imagens;
	}
	public ArrayList<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}
	//Getters e Setters - fim
	
	public Imovel(String nome, Localizacao localizacao, Especificacao especificacao,
			BigDecimal precoNoite, CalendarioDisponibilidade calendario, ArrayList<Image> imagens,
			ArrayList<Reserva> reservas) {
		this.nome = nome;
		this.localizacao = localizacao;
		this.especificacao = especificacao;
		this.precoNoite = precoNoite;
		this.calendario = calendario;
		this.imagens = imagens;
		this.reservas = reservas;
	}
	
	public Imovel () {
	}
	// Pede ao usuario as informacoes sobre os atributos do imovel para cadastro
	public void cadastrarInfoImovel() {
		
		System.out.print("Nome:");
		setNome(Validador.lerNome(3));
		System.out.println();
		System.out.println("Localizacao");
		setLocalizacao(new Localizacao());
		System.out.println();
		System.out.println("Especificacoes");
		setEspecificacao(new Especificacao());
		
		System.out.print("Preco por Noite: RS ");
		setPrecoNoite(Validador.lerDouble());
		
		System.out.println("Calendario de Disponibilidade");
		setCalendario(new CalendarioDisponibilidade());
	}
	
	public Boolean editar() {
		return null;
	}
	
	public Boolean excluir() {
		return null;
	}
	
	public int calcularAvaliacaoMedia(Avaliacao[] avaliacoes) {
		return 0;
	}

}
