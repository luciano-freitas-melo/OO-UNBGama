package principal;

public class Apartamento extends Imovel{
	
	// A categoria do apartamento que o imovel pode ser é de 4 tipos diferentes
	private enum TipoApartamento {PADRAO, CONDOMINIO, LOFT, FLAT};
	private TipoApartamento tipo;
	
	// Getters e Setters - inicio
	public TipoApartamento getTipo() {
		return tipo;
	}
	public void setTipo(TipoApartamento tipo) {
		this.tipo = tipo;
	}
	// Getters e Setters - fim
	

}
