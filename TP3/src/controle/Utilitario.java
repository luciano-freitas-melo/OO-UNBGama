package controle;

import java.awt.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class Utilitario {
	
	public static String capitalize(String str) {
		char[] array = str.toCharArray();
		
		array[0] = Character.toUpperCase(array[0]);
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == '\s')
				array[i+1] = Character.toUpperCase(array[i+1]);
		}
		
		String string = new String(array);
		
		return string;
	}
	
	// Cria um MaskFormatter de acordo com o formato dado, alem de nao inserir os elementos da mascara na saida
	public static MaskFormatter setMascara(String formato) {
		MaskFormatter masc = new MaskFormatter();
		try {
			masc.setMask(formato);
			masc.setValueContainsLiteralCharacters(false);
			masc.setPlaceholderCharacter('\s');
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return masc;
	}
	
	public static void adicionarLabel(JLabel label, Font estilo, JFrame janela, int posX, int posY, int largura, int altura ) {
		
		label.setFont(estilo);
		label.setBounds(posX,posY,largura, altura);
		janela.add(label);
		
	}
	
	public static void adicionarLabel(JLabel label, Color cor, Font estilo, JFrame janela, int posX, int posY, 
								      int largura, int altura ) {
		
		label.setForeground(cor);
		label.setFont(estilo);
		label.setBounds(posX,posY,largura, altura);
		janela.add(label);
		
	}
	
	public static void adicionarInput(JTextField input, Font estilo, JFrame janela, int posX, int posY, 
									  int largura, int altura, int alinhamento) {
		
		input.setFont(estilo);
		input.setBounds(posX,posY,largura, altura);
		janela.add(input);
		input.setHorizontalAlignment(alinhamento);
		
	}
	
	public static void adicionarInput(JFormattedTextField input, Font estilo, JFrame janela, int posX, int posY, 
									  int largura, int altura, int alinhamento) {
		
		input.setFont(estilo);
		input.setBounds(posX,posY,largura, altura);
		janela.add(input);
		input.setHorizontalAlignment(alinhamento);
		
	}
	
	// Pega uma string no formato ddMMuuuu e cria um LocalDate
	public static LocalDate toLocalDate(String data) {
		return LocalDate.parse(data, DateTimeFormatter.ofPattern("ddMMuuuu"));
	}
}
