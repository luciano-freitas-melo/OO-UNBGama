package modelo;

import java.time.LocalDate;

public class Avaliacao {
	
	// Um valor de 1 a 5 sobre a qualidade da hospedagem
	private double nota;
	// Eh possivel fazer um comentario a respeito do imovel que se ficou hospedado
	private String comentario;
	
	// Data que foi feita a avaliacao, sempre sera o momento que foi cadastrada a avaliacao
	private LocalDate dataAvaliacao;
	
	// Getters e Setters - inicio
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
	public LocalDate getDataAvaliacao() {
		return dataAvaliacao;
	}
	// Getters e Setters - fim
	
	public Avaliacao(double nota, String comentario) {
		
		this.nota = nota;
		this.comentario = comentario;
		this.dataAvaliacao = LocalDate.now();
	}
	
	

}
