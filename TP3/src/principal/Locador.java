package principal;

import java.util.ArrayList;

public class Locador extends Conta{
	// {COMPOSIÇÃO COM IMOVEL (COMPOSTO)}
	
	private ArrayList<Imovel> imoveis = new ArrayList<Imovel>();
	
	// Getters e Setters - inicio
	public ArrayList<Imovel> getImoveis() {
		return imoveis;
	}

	public void setImovel(Imovel imovel) {
		this.imoveis.add(imovel);
	}
	// Getters e Setters - fim
		
		
	public Locador() {
		super();
		System.out.println("Ja deseja cadastrar imoveis?");
		System.out.println("1. Sim");
		System.out.println("2. Nao");
		int escolha = Validador.lerEntrada(1,2);
		if(escolha == 1) {
			System.out.println("Escolha o tipo de imovel:");
			System.out.println("1. Casa");
			System.out.println("2. Apartamento");
			int opcao = Validador.lerEntrada(1,2);
			
			Imovel novoImovel;
			if(opcao == 1) {
				novoImovel = new Casa();
			}else {
				novoImovel = new Apartamento();
			}
			setImovel(novoImovel);
			
		}else {
			System.out.println("Novo Locador cadastrado com sucesso!");
		}
		
		
		
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
