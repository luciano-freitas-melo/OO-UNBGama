package principal;

import java.util.Date;

public class Avaliacao {
	
	// Toda avaliacao tem uma reserva associada
	private Reserva reserva;
	// Um valor de 1 a 5 sobre a qualidade da hospedagem
	private double nota;
	// E possivel fazer um comentario a respeito do imovel que se ficou hospedado
	private String comentario;
	// Data que foi feita a avaliacao
	private Date dataAvaliacao;
	
	// Getters e Setters - inicio
	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}
	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}
	// Getters e Setters - fim
	
	public Boolean incluir() {
		return null;
	}
	
	public Boolean editar() {
		return null;
	}
	
	public Boolean excluir() {
		return null;
	}


}
