package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controle.*;

public class TelaLogin implements ActionListener {
	
	private JFrame janela = new JFrame("Login");
	private JLabel titulo = new JLabel("Aluguel de Imoveis para Temporada");
	private JLabel descricao = new JLabel("Escolha uma conta");
	private JComboBox<String> contas;
	
	private JButton entrar = new JButton("Entrar");
	private JButton cadastrarConta = new JButton("Nova conta");
	
	private ControleDados dados;
	private ControleConta conta;
	private String[] nomesContas;
	

	// Criacao do Frame
	public TelaLogin(ControleDados data) {
		
		this.dados = data;
		this.conta = new ControleConta(data.getContas());
		
		janela.setLayout(null);
		
		
		// Alterando design e alinhamento de nossos componentes
		titulo.setFont(new Font("Times New Roman", Font.PLAIN , 24));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		descricao.setFont(new Font("Open Sans", Font.BOLD , 22));
		descricao.setHorizontalAlignment(SwingConstants.CENTER);
		
		entrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		entrar.setFont(new Font("Open Sans", Font.BOLD, 16));
		
		cadastrarConta.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cadastrarConta.setFont(new Font("Open Sans", Font.BOLD, 16));
		
		
		
		// Adiciona os nomes das contas para a ComboBox
		nomesContas = conta.getNomesContasCapitalizado();
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
		
		entrar.addActionListener(this);
		cadastrarConta.addActionListener(this);
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(420, 480);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		ControleDados dados = new ControleDados();
		
		new TelaLogin(dados);
		
		
		
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == entrar) {
			String contaSelecionada = contas.getSelectedItem().toString();
			new TelaMenuPrincipal(dados, contaSelecionada);
		}
			
		if(src == cadastrarConta)
			new TelaConta(dados).cadastrarConta();
		
		janela.dispose();
			
	}

	

}
