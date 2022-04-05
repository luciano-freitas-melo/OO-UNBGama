package modelo;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Apartamento extends Imovel{
	
	// A categoria do apartamento que o imovel pode ser é de 4 tipos diferentes
	private enum TipoApartamento {
		PADRAO("Apartamento Convencional"), CONDOMINIO("Condominio"), LOFT("Loft"), FLAT("Flat");
		private String nome;
		
		TipoApartamento(String nome) {
			this.nome = nome;
		}
	};	
	
	// Declaramos uma variavel para guardar nosso Enum
	private TipoApartamento tipoApart;
	
	// Getters e Setters - inicio
	public String getTipoApart() {
		return tipoApart.nome;
	}
	
	public void setTipoApart(TipoApartamento tipo) {
		this.tipoApart = tipo;
	}

	public Apartamento(Conta proprietario, String nome, Double dimensao, int limiteHospedes, BigDecimal precoNoite,
			String cep, String logradouro, ArrayList<Beneficio> listaBeneficios, TipoApartamento tipo) {
		
		super(proprietario, nome, dimensao, limiteHospedes, precoNoite, cep, logradouro, listaBeneficios);
		
		this.tipoApart = tipo;
	}

	// Getters e Setters - fim
	
	


	
}
