package principal;

public class Casa extends Imovel{
	
	// O tipo de lugar pode ser de 3 maneiras diferentes
	private enum TipoLugar {LUGAR_INTEIRO, QUARTO_INTEIRO, QUARTO_COMPARTILHADO};
	private TipoLugar tipoLugar;
	// A categoria da casa que o imovel pode ser é de 4 tipos diferentes
	private enum TipoCasa {CASA_RESIDENCIAL, CHALE, CABANA, CASA_DE_CAMPO};
	private TipoCasa tipo;
	
	// Getters e Setters - inicio
	public TipoLugar getTipoLugar() {
		return tipoLugar;
	}
	public void setTipoLugar(TipoLugar tipoLugar) {
		this.tipoLugar = tipoLugar;
	}
	public TipoCasa getTipo() {
		return tipo;
	}
	public void setTipo(TipoCasa tipo) {
		this.tipo = tipo;
	}
	// Getters e Setters - fim

}
