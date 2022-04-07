package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import controle.*;

public class TelaConta implements ActionListener {
	private JFrame janela = new JFrame("Cadastro de Conta");
	private JLabel titulo = new JLabel("Conta");
	private JLabel nome = new JLabel("Nome Completo");
	private JTextField nomeInput = new JTextField("");
	private JLabel cpf = new JLabel("CPF");
	private JFormattedTextField cpfInput;
	private JLabel dataNasc = new JLabel("Data de Nascimento");
	private JLabel data = new JLabel("Dia / Mes / Ano");
	private JFormattedTextField dataInput;
	private JLabel telefone = new JLabel("Telefone");
	private JLabel numero = new JLabel("(DDD) Numero");
	private JFormattedTextField telefoneInput;
	private JButton submit = new JButton("Enviar");
	private JLabel mensagemErro = new JLabel("");
	
	private ControleConta conta;
	
	
	public TelaConta(ControleDados dados) {
		conta = new ControleConta(dados);
		
		
		janela.setLayout(null);
		
		// Estilos que iremos utilizar no formulario
		Font labelForms = new Font("Open Sans", Font.BOLD, 14);
		Font descricaoInputLabel = new Font("Open Sans", Font.ITALIC, 12);
		Font inputForms = new Font("Open Sans", Font.PLAIN, 14);
		
		// Alterando design e alinhamento do titulo
		Utilitario.adicionarLabel(titulo, new Font("Times New Roman", Font.PLAIN , 24), janela, 20, 20, 350, 40);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Filtramos nome para receber somente letras e espacos
		nomeInput.setDocument(new JTextFieldFilter("[\s|a-zA-Z]")); 
		
		// Criamos mascaras no CPF, Data de nascimento e telefone, para recebermos somente numeros e com quantidade limitada
		MaskFormatter mascaraCpf = Utilitario.setMascara("###.###.### - ##");
		cpfInput = new JFormattedTextField(mascaraCpf);
		
		MaskFormatter mascaraData = Utilitario.setMascara("##  / ##  /  ####");
		dataInput = new JFormattedTextField(mascaraData);
		
		MaskFormatter mascaraTelefone = Utilitario.setMascara("(##) #.####-####");
		telefoneInput = new JFormattedTextField(mascaraTelefone);
			
			
		Utilitario.adicionarLabel(nome, labelForms, janela, 20, 80, 300, 40);
		Utilitario.adicionarInput(nomeInput, inputForms, janela, 20, 120, 350, 40, SwingConstants.LEFT);
	
		Utilitario.adicionarLabel(cpf, labelForms, janela, 20, 180, 100, 40);
		Utilitario.adicionarInput(cpfInput, inputForms, janela, 20, 220, 120, 40, SwingConstants.CENTER);
		
		Utilitario.adicionarLabel(dataNasc, labelForms, janela, 20, 280, 300, 40);
		Utilitario.adicionarInput(dataInput, inputForms, janela, 20, 320, 150, 40, SwingConstants.CENTER);
		dataInput.setToolTipText("Idade minima: 18 anos");
		Utilitario.adicionarLabel(data,Color.GRAY, descricaoInputLabel, janela, 20, 362, 150, 10);
		
		Utilitario.adicionarLabel(telefone, labelForms, janela, 20, 392, 300, 40);
		Utilitario.adicionarInput(telefoneInput, inputForms, janela, 20, 432, 150, 40, SwingConstants.CENTER);
		
		Utilitario.adicionarLabel(numero, Color.GRAY, descricaoInputLabel, janela, 20, 474, 150, 10);
	
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setSize(420, 650);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		
	}

	public void cadastrarConta() {
		// Alteramos o titulo para ficar personalizado com o cadastro de uma conta
		titulo.setText("Criar uma conta");
		
		// Botao para enviar o formulario
		
		submit.addActionListener(this);
		submit.setBounds(120, 550, 160, 40);
		janela.add(submit);
		
		mensagemErro.setHorizontalAlignment(SwingConstants.CENTER);
		Utilitario.adicionarLabel(mensagemErro, Color.RED, new Font("Arial", Font.BOLD, 12), janela, -10, 510, 420, 40);
		
		
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == submit) submitAction();	
		
		
	}
	
	private void submitAction() {
		JTextField[] textsFields = {nomeInput, cpfInput, dataInput, telefoneInput};
		
		// Validamos primeiramente se existe algum campo em branco no formulario
		boolean hasBlankField = false;
		for (JTextField textField : textsFields) {
			String texto = textField.getText().replaceAll("[^a-zA-Z0-9\s]", " ");
			if(texto.isBlank()) {
				hasBlankField = true;
				mensagemErro.setText("Preencha todos os campos!");
				textField.setBorder(BorderFactory.createLineBorder(Color.RED));
				break;
			}else {
				hasBlankField = false;
				textField.setBorder(BorderFactory.createEmptyBorder());
				
			}
		}
		// Soh iremos iniciar a validacao dos dados depois que todos os campos estiverem preenchidos
		if (!hasBlankField) {
			// Validar se os valores digitados são validos
			boolean dadosInvalidos = true;
			JTextField field = new JTextField();
			// Valida o nome
			if(conta.nomeRepetido(nomeInput.getText())){
				mensagemErro.setText("Nome ja cadastrado!");
				field = nomeInput;

			// Valida o cpf
			} else if(conta.cpfRepetido(cpfInput.getValue().toString())) {
				mensagemErro.setText("CPF ja pertence a uma conta!");
				field = cpfInput;
				
			// Valida a data	
			} else if(!conta.dataNascValida(dataInput.getValue().toString())) {
				mensagemErro.setText("Data invalida!");
				field = dataInput;
				
			// Valida o telefone		
			} else if(!conta.telefoneValido(telefoneInput.getValue().toString())) {
				mensagemErro.setText("Telefone invalido!");
				field = telefoneInput;
				 
			} else {
				mensagemErro.setText("");
				dadosInvalidos = false;
			}
	
			// Caso haja um erro nos campos, colocamos o TextField em vermelho para sinalizar onde esta o problema
			if(dadosInvalidos) {
				field.setBorder(BorderFactory.createLineBorder(Color.RED));
			}else {
				field.setBorder(BorderFactory.createEmptyBorder());
				// Cadastra a conta
				conta.cadastrarNovaConta(nomeInput.getText(), cpfInput.getValue().toString(), dataInput.getValue().toString(),
										 telefoneInput.getValue().toString());
				JOptionPane.showMessageDialog(null, "Conta Criada com Sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
				janela.dispose();
			}
		}
	}
}

