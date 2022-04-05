package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class CalendarioDisponibilidade {
	
	// Temos uma ArrayList que guarda os periodos em que o imovel esta disponivel
	// Cada periodo tem uma data de inicio e uma data de fim, que guardaremos em um vetor
	private ArrayList<LocalDate> datasDisponiveis = new ArrayList<>();

	
	public ArrayList<LocalDate> getDatasDisponiveis() {
		return datasDisponiveis;
	}

	
	public void cadastrarDatas(ArrayList<LocalDate> novasDatas) {
		
		for(LocalDate data : novasDatas) {
			// Verifica se a nova data ja esta em datasDisponiveis, caso contrario, inclui a nova data
			if(!datasDisponiveis.contains(data))
				this.datasDisponiveis.add(data);
		}
	}

	
	
	
}
		
		