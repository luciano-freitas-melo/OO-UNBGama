package modelo;


public class Main {
	private static BancoDeDados bancoDeContas = new BancoDeDados();
	
	public static void main(String[] args) {
		
		int escolhaMenu;
		bancoDeContas.DadosPreCadastrados();
		
		System.out.println("Bem vindo ao Programa Gerenciador de Aluguel de Casas e Apartamentos Para Temporada!");
		do {
			System.out.println();
			menu();
			escolhaMenu = Validador.lerEntrada(1, 4);
			
			switch(escolhaMenu) {
				case 1:
					contas();
					break;
				case 2:
					imoveis();
					break;
				case 3:
					System.out.println("Selecione a conta que deseja realizar a reserva:");
					bancoDeContas.listarContasPorNome();
					// Colocamos o -1 pois o index da lista de contas comeca em 0 e nosso menu em 1.
					int escolherConta = Validador.lerEntrada(1, bancoDeContas.getContas().size()) - 1;
					
					Conta conta = bancoDeContas.getContas().get(escolherConta);
					conta.realizarReserva(bancoDeContas.imoveis());
					break;
					
					
					
							
			}
		}while(escolhaMenu != 4);
		
	}
	
	private static void imoveis() {
		menuImoveis();
		int escolha = Validador.lerEntrada(1,5);
		
		switch(escolha) {
			case 1:
				System.out.println("Selecione o proprietario do imovel:");
				bancoDeContas.listarContasPorNome();
				// Colocamos o -1 pois o index da lista de contas comeca em 0 e nosso menu em 1.
				int escolherConta = Validador.lerEntrada(1, bancoDeContas.getContas().size()) - 1;
				
				Conta conta = bancoDeContas.getContas().get(escolherConta);
				conta.cadastrarNovoImovel();
				
				
			
			
			break;
				
		case 2:
		}
		
			
		
	}

	private static void menuImoveis() {
		System.out.println("------ Imoveis ------");
		System.out.println("1. Cadastrar imovel");
		System.out.println("2. Editar imovel");
		System.out.println("3. Excluir imovel");
		System.out.println("4. Listar imoveis");
		System.out.println("5. Voltar");
		
	}

	// Faz a interação do menu relacionado as contas do sistema
	private static void contas() {
		menuConta();
		int escolha = Validador.lerEntrada(1,5);
		
		switch(escolha) {
		case 1:
			new Conta(bancoDeContas);
			break;
				
		case 2:
		}
		
			
		
	}
				

	private static void menuConta() {
		System.out.println("----- Contas ------");
		System.out.println("1. Cadastrar");
		System.out.println("2. Editar");
		System.out.println("3. Listar");
		System.out.println("4. Excluir");
		System.out.println("5. Voltar");	
	}

	private static void menu() {
		System.out.println("------ Menu Principal ------");
		System.out.println("Escolha uma opcao:");
		System.out.println("1. Contas");
		System.out.println("2. Imoveis");
		System.out.println("3. Realizar reserva");
		System.out.println("4. Sair");
	}

}
