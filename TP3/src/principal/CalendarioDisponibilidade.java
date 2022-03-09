package principal;

import java.time.LocalDate;
import java.util.ArrayList;

public class CalendarioDisponibilidade {
	
	// Temos uma ArrayList que guarda os periodos em que o imovel esta disponivel
	// Cada periodo tem uma data de inicio e uma data de fim, que guardaremos em um vetor
	private ArrayList<LocalDate[]> periodosDisponiveis = new ArrayList<>();

	// Gets e Sets - inicio
	public ArrayList<LocalDate[]> getPeriodosDisponiveis() {
		return periodosDisponiveis;
	}

	public void inserirNovoPeriodo(LocalDate[] periodo) {
		this.periodosDisponiveis.add(periodo);
	}
	// Gets e Sets - fim
	
	CalendarioDisponibilidade (){
		int opcao;
		do {
			System.out.println();
			cadastrarPeriodo();
			System.out.println();
			System.out.println("Deseja cadastrar outro periodo?");
			System.out.println("1. Sim");
			System.out.println("2. Nao");
			opcao = Validador.lerEntrada(1,2);
			
		}while (opcao != 2);
		
		
	}
	public void cadastrarPeriodo() {
		LocalDate[] periodo = new LocalDate[2];
		
		boolean periodoInvalido;
		do {
			System.out.println("Data inicial de disponibilidade");
			periodo[0] = Validador.lerData();
			System.out.println("Data final de disponibilidade");
			periodo[1] = Validador.lerData();
			
			// Se a data final for anterior a data inicial, o periodo eh invalido
			if(periodo[1].isBefore(periodo[0])) {
				periodoInvalido = true;
				System.out.println("Periodo invalido! Data inicial mais recente que data final!");
				System.out.println("Tente novamente");
			}else {
				periodoInvalido = false;
				inserirNovoPeriodo(periodo);
				System.out.println("Periodo Cadastrado com Sucesso!");
			}		
		} while(periodoInvalido);
	}
	
	
	
}
		
		