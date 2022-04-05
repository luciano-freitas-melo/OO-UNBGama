package modelo;

import java.awt.Image;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Imovel {
	
	private Conta proprietario;
	// Descricao do imovel para identifica-lo
	private String nome;
	// Tamanho do imovel em metros quadrados
	private Double dimensao;
	// Numero maximo de hospedes que o imovel suporta
	private int limiteHospedes;
	// O valor de uma noite de estadia
	private BigDecimal precoNoite;
	// Conjunto de imagens do imovel
	private ArrayList<Image> imagens = new ArrayList<>();
	// Onde fica esse imovel
	private Localizacao localizacao;
	// Datas em que o imovel pode ser reservado
	private CalendarioDisponibilidade calendario;
	// Beneficios que o imovel tem, como: wifi, ar condicionado, estacionamento, etc...
	private ArrayList<Beneficio> listaBeneficios = new ArrayList<>();
	// Armazena todas as reservas feitas nesse imovel
	private ArrayList<Reserva> reservas = new ArrayList<>();
	
	
	//Getters e Setters - inicio
	public Conta getProprietario() {
		return proprietario;
	}
	public void setProprietario(Conta proprietario) {
		this.proprietario = proprietario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	// Localizacao
	public String getCep() {
		return localizacao.getCep();
	}
	public String getLogradouro() {
		return localizacao.getLogradouro();
	}
	public void setCep(String cep) {
		localizacao.setCep(cep);
	}
	public void setLogradouro(String logradouro) {
		localizacao.setLogradouro(logradouro);
	}
	// fim Localizacao
	
	public Double getDimensao() {
		return dimensao;
	}
	public void setDimensao(Double dimensao) {
		this.dimensao = dimensao;
	}
	public int getLimiteHospedes() {
		return limiteHospedes;
	}
	public void setLimiteHospedes(int limiteHospedes) {
		this.limiteHospedes = limiteHospedes;
	}
	
	public BigDecimal getPrecoNoite() {
		return precoNoite.setScale(2);
	}
	public void setPrecoNoite(double d) {
		this.precoNoite = new BigDecimal(d);
	}
	
	// Calendario Disponibilidade
	public ArrayList<LocalDate> getDatasDisponiveis() {
		return this.calendario.getDatasDisponiveis();
	}
	
	public ArrayList<Image> getImagens() {
		return imagens;
	}
	
	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public ArrayList<Beneficio> getListaBeneficios() {
		return listaBeneficios;
	}
	
	public void setListaBeneficios(ArrayList<Beneficio> listaBeneficios) {
		this.listaBeneficios = listaBeneficios;
	}
	//Getters e Setters - fim
	
	public Imovel(Conta proprietario, String nome, Double dimensao, int limiteHospedes, BigDecimal precoNoite,
			String cep, String logradouro, ArrayList<Beneficio> listaBeneficios) {
		
		this.proprietario = proprietario;
		this.nome = nome;
		this.dimensao = dimensao;
		this.limiteHospedes = limiteHospedes;
		this.precoNoite = precoNoite;
		setCep(cep);
		setLogradouro(logradouro);
		this.listaBeneficios = listaBeneficios;
	}
	
	// Cadastra novas datas no calendario de disponibilidade do imovel
	public void cadastrarDatasNoCalendario(ArrayList<LocalDate> novasDatas) {
		this.calendario.cadastrarDatas(novasDatas);
	}
	
	// Adiciona uma nova imagem ao imovel
	public void incluirImagem(Image imagem) {
		this.imagens .add(imagem);
	}
	
	// Cadastra uma nova reserva nesse imovel
	public void novaReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	

}
