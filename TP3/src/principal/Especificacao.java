package principal;

import java.util.ArrayList;

public class Especificacao {
	
	// Tamanho do imovel em metros quadrados
	private double dimensao;
	// Numero maximo de hospedes no imovel
	private int limiteHospedes;
	
	private ArrayList<Beneficio> listaBeneficios = new ArrayList<>();
	
	// Getters e Setters - inicio
	public double getDimensao() {
		return dimensao;
	}
	public void setDimensao(double dimensao) {
		this.dimensao = dimensao;
	}
	public int getLimiteHospedes() {
		return limiteHospedes;
	}
	public void setLimiteHospedes(int limiteHospedes) {
		this.limiteHospedes = limiteHospedes;
	}
	public ArrayList<Beneficio> getListaBeneficios() {
		return listaBeneficios;
	}
	public void setBeneficios(Beneficio beneficio) {
		this.listaBeneficios.add(beneficio);
	}
	// Getters e Setters - fim
	
	public Especificacao(double dimensao, int limiteHospedes, ArrayList<Beneficio> listaBeneficios) {
		this.dimensao = dimensao;
		this.limiteHospedes = limiteHospedes;
		this.listaBeneficios = listaBeneficios;
	}

	
	public Especificacao () {
		System.out.print("Dimensao(em metros quadrados): ");
		setDimensao(Validador.lerDouble());
		System.out.print("Limite de hospedes: ");
		setLimiteHospedes(Validador.lerEntrada());
		System.out.println();
		System.out.println("Beneficios");
	}
	
	public void editar() {
	}

}


