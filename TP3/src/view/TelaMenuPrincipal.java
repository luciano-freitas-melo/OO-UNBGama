package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controle.ControleDados;

public class TelaMenuPrincipal {
	private JFrame janela = new JFrame("Menu Principal");
	private JLabel titulo;
	
	
	public TelaMenuPrincipal(ControleDados dados, String contaSelecionada) {
		
		janela.setLayout(new BorderLayout(20,20));
		
		titulo = new JLabel(contaSelecionada);
		
		janela.add(titulo);
		

		janela.setSize(350, 400);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
	}

}
