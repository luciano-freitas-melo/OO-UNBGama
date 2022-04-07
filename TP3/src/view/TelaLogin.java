package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controle.*;

public class TelaLogin implements ActionListener {

	private static JFrame janela = new JFrame("Login");
	private static JLabel titulo = new JLabel("Aluguel de Imoveis para Temporada");
	private static JLabel descricao = new JLabel("Escolha uma conta");
	private static JComboBox<String> contas;
	private static JButton entrar = new JButton("Entrar");
	private static JButton cadastrarConta = new JButton("Cadastrar nova conta");
	
	private static ControleDados dados = new ControleDados();
	private String[] nomesContas;
	
	// Criacao do Frame
	public TelaLogin() {
		janela.setLayout(null);
		
		
		// Alterando design e alinhamento de nossos componentes
		titulo.setFont(new Font("Times New Roman", Font.PLAIN , 24));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		descricao.setFont(new Font("Open Sans", Font.BOLD , 22));
		descricao.setHorizontalAlignment(SwingConstants.CENTER);
		
		entrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		entrar.setFont(new Font("Open Sans", Font.BOLD, 16));
		
		cadastrarConta.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		
		
		// Adiciona os nomes das contas para a ComboBox
		nomesContas = dados.getNomesContasCapitalizado();
		contas = new JComboBox<String>(nomesContas);
		
		
		titulo.setBounds(20,20,350,40);
		descricao.setBounds(40, 100, 320, 40);
		contas.setBounds(40, 170, 320, 60);
		entrar.setBounds(120, 280, 160, 40);
		cadastrarConta.setBounds(120, 340, 160, 40);
		
		janela.add(titulo);
		janela.add(descricao);
		janela.add(contas);
		janela.add(entrar);
		janela.add(cadastrarConta);
		
		
		
		janela.setSize(420, 480);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		TelaLogin login = new TelaLogin();
		
		entrar.addActionListener(login);
		cadastrarConta.addActionListener(login);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == entrar) {
			String contaSelecionada = contas.getSelectedItem().toString();
			new TelaMenuPrincipal(dados, contaSelecionada);
			janela.dispose();
		}
			
		if(src == cadastrarConta)
			new TelaConta(dados).cadastrarConta();
		
	}

	

}
