package principal;

public class Locador extends Conta{
	// {COMPOSIÇÃO COM IMOVEL (COMPOSTO)}
	
	private Imovel[] imoveis;
	
	// Getters e Setters - inicio
	public Imovel[] getImoveis() {
		return imoveis;
	}

	public void setImoveis(Imovel[] imoveis) {
		this.imoveis = imoveis;
	}
	// Getters e Setters - fim
	
	@Override
	public Boolean criarConta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean alterarConta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean excluirConta() {
		// TODO Auto-generated method stub
		return null;
	}

}
