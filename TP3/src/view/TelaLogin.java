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
		janela.setLayout(new BorderLayout(20,20));
		
		
		// Alteramos o design do nosso titulo
		titulo.setFont(new Font("Times New Roman", Font.PLAIN , 20));
		// colocamos o texto to Jlabel no centro do objeto
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		// Adicionamos o titulo a parte superior do layout
		janela.add(titulo, BorderLayout.NORTH);
		
		//Criamos um container proprio do BoxLayout para inserir os componentes no centro da janela
		Box boxVertical = Box.createVerticalBox();
		// Queremos colocar no centro da janela a descricao e contas
		
		
		// Adiciona os nomes das contas para a ComboBox
		nomesContas = dados.getNomes();
		contas = new JComboBox<String>(nomesContas);
		
		boxVertical.add(descricao);
		boxVertical.add(contas);
		
		janela.add(boxVertical, BorderLayout.CENTER);
		
		
		// Um novo container, que tem funcao de dividir a parte de baixo da janela em dois para os botoes
		JSplitPane splitPane = new JSplitPane();
		splitPane.setRightComponent(entrar);
		splitPane.setLeftComponent(cadastrarConta);
		
		janela.add(splitPane, BorderLayout.SOUTH);
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(350, 400);
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
			new TelaConta(dados);
		
	}

	

}
