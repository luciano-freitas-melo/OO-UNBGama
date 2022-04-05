package modelo;

import java.util.Date;

public class CartaoDePagamento {
	//Criado um enum para o tipo de cartao, pois so podemos receber dois tipos de cartao.
	private enum TipoCartao {CREDITO, DEBITO};
	private TipoCartao tipo;
	private String bandeira;
	private String titular;
	private int numero;
	private Date dataValidade;
	private int CVV;
	
	// Getters e Setters - inicio
	public TipoCartao getTipo() {return tipo;}
	
	public void setTipo(TipoCartao tipo) {this.tipo = tipo;}
	
	public String getBandeira() {return bandeira;}
	
	public void setBandeira(String bandeira) {this.bandeira = bandeira;}
	
	public String getTitular() {return titular;}
	
	public void setTitular(String titular) {this.titular = titular;}
	
	public int getNumero() {return numero;}
	
	public void setNumero(int numero) {this.numero = numero;}
	
	public Date getDataValidade() {return dataValidade;}
	
	public void setDataValidade(Date dataValidade) {this.dataValidade = dataValidade;}
	
	public int getCVV() {return CVV;}
	
	public void setCVV(int cVV) {CVV = cVV;}
	// Getters e Setters - fim
	
	public Boolean adicionar() {
		return null;
	}
	
	public Boolean editar() {
		return null;
	}
	
	public Boolean excluir() {
		return null;
	}
}
