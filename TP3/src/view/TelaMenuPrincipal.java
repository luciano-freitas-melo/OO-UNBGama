package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controle.*;

public class TelaMenuPrincipal implements ActionListener{
	
	private JFrame janela = new JFrame("Menu Principal");
	private JMenuBar contaMenu = new JMenuBar();
	private JMenuItem editarConta = new JMenuItem("Editar conta");
	private JMenuItem sair = new JMenuItem("Sair");
	
	
	private JTabbedPane  abas = new JTabbedPane();
	private JPanel abaMeusImoveis;
	private JPanel abaMinhasReservas;
	private JPanel abaCartoes;
	
	private ControleConta conta;
	private ControleDados dados;
	
	
	public TelaMenuPrincipal(ControleDados dados, String contaSelecionada) {
		
		this.dados = dados;
		conta = new ControleConta(dados.getContas());
		conta.associarConta(contaSelecionada);
	
		janela.setLayout(null);
		
		JMenu menu = new JMenu(contaSelecionada);
		menu.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		menu.add(editarConta);
		menu.add(sair);
		
		contaMenu.setLayout(new BorderLayout());
		contaMenu.add(menu, BorderLayout.EAST);
		
		contaMenu.setBounds(260, 10, 235, 20);
		
	
		
		abas.add("Meus Imoveis", abaMeusImoveis);
		abas.add("Reservas", abaMinhasReservas);
		abas.add("Cartoes", abaCartoes);
		abas.setBounds(10, 10, 485, 420);
		
		
		janela.add(contaMenu);
		janela.add(abas);
		
		editarConta.addActionListener(this);
		sair.addActionListener(this);
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(520, 480);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == sair) {
			janela.dispose();
			new TelaLogin(dados);
		}
		if(src == editarConta) {
			new TelaConta().editarConta(conta);
		}
			
			
	}

}
