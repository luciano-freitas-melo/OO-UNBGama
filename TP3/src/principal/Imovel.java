package principal;

import java.awt.Image;

public class Imovel {
	// Dono do imovel
	protected Locador proprietario;
	
	// E o nome do imovel
	protected String titulo;
	// Descreve o imovel de forma resumida
	protected String descricao;
	// Onde fica esse imovel 
	protected Localizacao localizacao;
	// Todas as caracteristicas do imovel
	protected Especificao especificacao;
	// O valor de uma noite de estadia
	protected double precoNoite;
	// Datas em que o imovel pode ser reservado
	protected CalendarioDisponibilidade calendario;
	// Conjunto de imagens do imovel
	protected Image[] imagens;
	// Armazena todas as reservas feitas nesse imovel
	protected Reserva[] reservas;
	
	//Getters e Setters - inicio
	public Locador getProprietario() {
		return proprietario;
	}
	public void setProprietario(Locador proprietario) {
		this.proprietario = proprietario;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Localizacao getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}
	public Especificao getEspecificacao() {
		return especificacao;
	}
	public void setEspecificacao(Especificao especificacao) {
		this.especificacao = especificacao;
	}
	public double getPrecoNoite() {
		return precoNoite;
	}
	public void setPrecoNoite(double precoNoite) {
		this.precoNoite = precoNoite;
	}
	public CalendarioDisponibilidade getCalendarioDisponibilidade() {
		return calendario;
	}
	public void setCalendario(CalendarioDisponibilidade calendarioDisponibilidade) {
		this.calendario = calendarioDisponibilidade;
	}
	
	public Image[] getImagens() {
		return imagens;
	}
	public void setImagens(Image[] imagens) {
		this.imagens = imagens;
	}
	public Reserva[] getReservas() {
		return reservas;
	}
	public void setReservas(Reserva[] reservas) {
		this.reservas = reservas;
	}
	//Getters e Setters - fim
	
	
	// Pede ao usuario as informacoes sobre os atributos do imovel para cadastro
	public void cadastrarInfoImovel() {
		System.out.print("titulo:");
		setTitulo(Validador.ler.next());
		System.out.print("descricao ");
		setDescricao(Validador.ler.next());
		System.out.print("Preco por Noite: ");
		setPrecoNoite(Validador.ler.nextDouble());
		
		System.out.print("Localizacao");
		setLocalizacao(new Localizacao());
		
		System.out.print("Calendario de Disponibilidade");
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
