package principal;

import java.awt.Image;
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
		public static void imprimeTipoLugar() {
			int i = 1;
			for(TipoLugar tipo : TipoLugar.values()) {
				// Imprime: i. nome do tipoCasa
				System.out.printf("%d. %s%n", i, tipo.nome);
				i++;
			}
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
		public static void imprimeTipoCasa() {
			int i = 1;
			for(TipoCasa tipo : TipoCasa.values()) {
				// Imprime: i. nome do tipoCasa
				System.out.printf("%d. %s%n", i, tipo.nome);
				i++;
			}
		}
	};
	// Declaramos uma variavel para guardar nosso Enum
	private TipoCasa tipoCasa;
	
	// Getters e Setters - inicio
	public String getTipoLugar() {
		return tipoLugar.nome;
	}
	
	public void escolheTipoLugar(int escolha) {
		switch(escolha){
			case 1:
				this.tipoLugar = TipoLugar.INTEIRO;
				break;
			case 2:
				this.tipoLugar = TipoLugar.QUARTO;
				break;
			case 3:
				this.tipoLugar = TipoLugar.QUARTO_COMPART;
				break;
		}
	} 
	
	public String getTipoCasa() {
		return tipoCasa.nome;
	}
	
	public void escolheTipoCasa(int escolha) {
		switch(escolha){
			case 1:
				this.tipoCasa = TipoCasa.PADRAO;
				break;
			case 2:
				this.tipoCasa = TipoCasa.CHALE;
				break;
			case 3:
				this.tipoCasa = TipoCasa.CABANA;
				break;
			case 4:
				this.tipoCasa = TipoCasa.CAMPO;
				break;
		}
	} 
	// Getters e Setters - fim
	
	public Casa(String nome, Localizacao localizacao, Especificacao especificacao,
			BigDecimal precoNoite, CalendarioDisponibilidade calendario, ArrayList<Image> imagens,
			ArrayList<Reserva> reservas, String tipoLugar , String tipoCasa) {
		super(nome, localizacao, especificacao, precoNoite, calendario, imagens, reservas);

		this.tipoLugar = TipoLugar.valueOf(tipoLugar);
		this.tipoCasa = TipoCasa.valueOf(tipoCasa);
	}

	public Casa() {
		//Recebendo o tipo de lugar
		System.out.println("Escolha o tipo de lugar:");
		TipoLugar.imprimeTipoLugar();
		int escolhaTipoLugar = Validador.lerEntrada(1,3);
		escolheTipoLugar(escolhaTipoLugar);
		
		// Recebendo o tipo de Casa
		System.out.println("Escolha o tipo de casa:");
		TipoCasa.imprimeTipoCasa();
		int escolhaTipoCasa = Validador.lerEntrada(1,4);
		escolheTipoCasa(escolhaTipoCasa);
		
		// Recebendo os dados gerais do imovel
		super.cadastrarInfoImovel();
	}

	
}
