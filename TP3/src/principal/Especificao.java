package principal;

public class Especificao {
	// {IMPLEMENTAR COMPOSICAO (COMPOSITOR)}
	
	// Tamanho do imovel em metros quadrados
	private double dimensao;
	// Numero maximo de hospedes no imovel
	private int limiteHospedes;
	// Quantidade de quartos disponiveis
	private int quantQuartos;
	// Numero total de camas disponiveis
	private int quantCamas;
	// Quantidade de banheiros que se tem acesso no imovel
	private int quantBanheiros;
	// Beneficios que podem estar presentes no imovel
	private Beneficio[] listaBeneficios;
	
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
	public int getQuantQuartos() {
		return quantQuartos;
	}
	public void setQuantQuartos(int quantQuartos) {
		this.quantQuartos = quantQuartos;
	}
	public int getQuantCamas() {
		return quantCamas;
	}
	public void setQuantCamas(int quantCamas) {
		this.quantCamas = quantCamas;
	}
	public int getQuantBanheiros() {
		return quantBanheiros;
	}
	public void setQuantBanheiros(int quantBanheiros) {
		this.quantBanheiros = quantBanheiros;
	}
	public Beneficio[] getListaBeneficios() {
		return listaBeneficios;
	}
	public void setListaBeneficios(Beneficio[] listaBeneficios) {
		this.listaBeneficios = listaBeneficios;
	}
	// Getters e Setters - fim

	public void cadastrar() {
	}
	
	public void editar() {
	}

}


