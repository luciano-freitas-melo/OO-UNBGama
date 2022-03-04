package principal;

import java.awt.Image;
import java.util.Date;

public abstract class Conta {
	protected String nome;
	protected int docID;
	protected Date dataNascimento;
	protected int telefone;
	protected Image fotoPerfil;
	
	// Getters e Setters - inicio
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getDocID() {
		return docID;
	}
	public void setDocID(int docID) {
		this.docID = docID;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public Image getFotoPerfil() {
		return fotoPerfil;
	}
	public void setFotoPerfil(Image fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}
	// Getters e Setters - fim
	
	public abstract Boolean criarConta();
	public abstract Boolean alterarConta();
	public abstract Boolean excluirConta();

}
