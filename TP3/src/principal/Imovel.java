package principal;

import java.awt.Image;
import java.util.Date;

public class Imovel {
	// Dono do imovel {IMPLEMENTAR UMA COMPOSIÇÃO (COMPOSITOR)}
	protected Locador proprietario;
	
	// E o nome do imovel
	protected String titulo;
	// Descreve o imovel de forma resumida
	protected String descricao;
	
	//{IMPLEMENTAR COMPOSICAO (COMPOSTO)}
	// Onde fica esse imovel 
	protected Localizacao localizacao;
	// Todas as caracteristicas do imovel
	protected Especificao especificacao;
	
	// O valor de uma noite de estadia
	protected double precoNoite;
	// Datas em que o imovel pode ser reservado
	protected Date[] calendarioDisponibilidade;
	// Conjunto de imagens do imovel
	protected Image[] imagens;
	// Todas as reservas feitas nesse imovel
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
	public Date[] getCalendarioDisponibilidade() {
		return calendarioDisponibilidade;
	}
	public void setCalendarioDisponibilidade(Date[] calendarioDisponibilidade) {
		this.calendarioDisponibilidade = calendarioDisponibilidade;
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
	
	public Boolean cadastrar() {
		return null;
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
