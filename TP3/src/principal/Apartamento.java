package principal;

import java.awt.Image;
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
		public static void imprimeTipoApartamento() {
			int i = 1;
			for(TipoApartamento tipo : TipoApartamento.values()) {
				// Imprime: i. nome do tipoCasa
				System.out.printf("%d. %s%n", i, tipo.nome);
				i++;
			}
		}
	};	
	
	// Declaramos uma variavel para guardar nosso Enum
	private TipoApartamento tipoApart;
	
	// Getters e Setters - inicio
	public String getTipoApart() {
		return tipoApart.nome;
	}
	
	public void escolheTipoApart(int escolha) {
		switch(escolha){
		case 1:
			this.tipoApart = TipoApartamento.PADRAO;
			break;
		case 2:
			this.tipoApart = TipoApartamento.CONDOMINIO;
			break;
		case 3:
			this.tipoApart = TipoApartamento.LOFT;
			break;
		case 4:
			this.tipoApart = TipoApartamento.FLAT;
			break;
		}
	}
	// Getters e Setters - fim
	
	public Apartamento(String nome, Localizacao localizacao, Especificacao especificacao,
			BigDecimal precoNoite, CalendarioDisponibilidade calendario, ArrayList<Image> imagens,
			ArrayList<Reserva> reservas, String tipoApart) {
		super(nome, localizacao, especificacao, precoNoite, calendario, imagens, reservas);
		this.tipoApart = TipoApartamento.valueOf(tipoApart);
	}
	
	public Apartamento() {
		System.out.println("------- Novo Apartamento -------");
		// Recebendo o tipo de Apartamento
		System.out.println("Escolha o tipo de apartamento:");
		TipoApartamento.imprimeTipoApartamento();
		int escolhaTipoApart = Validador.lerEntrada(1,4);
		escolheTipoApart(escolhaTipoApart);
		
		// Recebendo os dados gerais do imovel
		super.cadastrarInfoImovel();
	}

	
}
