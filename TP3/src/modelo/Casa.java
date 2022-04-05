package modelo;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Casa extends Imovel{
	
	// O tipo de lugar que eh a casa pode ser de 3 tipos diferentes
	private enum TipoLugar {
		INTEIRO("Lugar Inteiro"), QUARTO("Quarto Inteiro"), QUARTO_COMPART("Quarto Compartilhado");
		private String nome;
		TipoLugar(String nome) {
			this.nome = nome;
		}
	};
	// Declaramos uma variavel para guardar nosso Enum
	private TipoLugar tipoLugar;
	
	// A categoria da casa que o imovel pode ser eh de 4 tipos diferentes
	private enum TipoCasa {
		PADRAO("Casa Residencial"), CHALE("Chale"), CABANA("Cabana"), CAMPO("Casa de Campo");
		private String nome;
		TipoCasa(String nome) {
			this.nome = nome;
		}
	};
	// Declaramos uma variavel para guardar nosso Enum
	private TipoCasa tipoCasa;
	
	
	// Getters e Setters - inicio
	public String getTipoLugar() {
		return tipoLugar.nome;
	}
	public void setTipoLugar(TipoLugar tipoLugar) {
		this.tipoLugar = tipoLugar;
	}
	
	public void setTipoCasa(TipoCasa tipoCasa) {
		this.tipoCasa = tipoCasa;
	}
	public String getTipoCasa() {
		return tipoCasa.nome;
	} 
	// Getters e Setters - fim
	
	public Casa(Conta proprietario, String nome, Double dimensao, int limiteHospedes, BigDecimal precoNoite, String cep,
			String logradouro, ArrayList<Beneficio> listaBeneficios, TipoLugar tipoLugar, TipoCasa tipoCasa) {
		
		super(proprietario, nome, dimensao, limiteHospedes, precoNoite, cep, logradouro, listaBeneficios);
		
		this.tipoLugar = tipoLugar;
		this.tipoCasa = tipoCasa;
		
	}
	
	
	
}
