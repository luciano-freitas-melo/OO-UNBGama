package principal;


public class Main {
	
	public static void main(String[] args) {
		
		
		System.out.println("Bem vindo ao Programa Gerenciador de Aluguel de Casas e Apartamentos Para Temporada!");
		System.out.println();
		menu();
		int escolhaMenu = Validador.lerEntrada(1, 5);
		
		switch(escolhaMenu) {
			case 1:
				contas();
						
				}
		}
	
	// Faz a interação do menu relacionado as contas do sistema
	private static void contas() {
		menuContas();
		int opcao = Validador.lerEntrada(1, 6);
		
		switch(opcao) {
			case 1:
				Locador novaContaLocador = new Locador();
				BancoDados.inserirNoBanco(novaContaLocador);
				novaContaLocador.imprimirInformacoesConta();
				break;
			case 2:
				Locatario novaContaLocatario = new Locatario();
				BancoDados.inserirNoBanco(novaContaLocatario);
				break;
			case 3:
				System.out.printf("Digite o nome do usuario que deseja editar: ");
		}
	}
				

	private static void menuContas() {
		System.out.println();
		System.out.println("--------- Contas ----------");
		System.out.println("1. Cadastrar locador (Quero alugar meus imoveis)");
		System.out.println("2. Cadastrar locatario (Quero fazer uma reserva com minha conta)");
		System.out.println("3. Editar conta");
		System.out.println("4. Listar contas");
		System.out.println("5. Excluir conta");
		System.out.println("6. Voltar");	
	}

	private static void menu() {
		System.out.println("Escolha uma opcao:");
		System.out.println();
		System.out.println("1. Contas");
		System.out.println("2. Imoveis");
		System.out.println("3. Realizar reserva");
		System.out.println("4. Configuracoes");
		System.out.println("5. Sair");
	}

}
