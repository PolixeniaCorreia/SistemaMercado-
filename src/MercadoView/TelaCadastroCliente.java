package MercadoView;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import MercadoDAO.PessoaDAO;
import MercadoUtils.Pessoa;
import MercadoUtils.VerificarCampos;

public class TelaCadastroCliente extends JFrame implements WindowListener {

    private JPanel contentPane;
    private JTextField txtNome;
    private JTextField txtCPF;
    private JTextField txtEmail;
    private JTextField txtTelefone;
    private TelaUsuario telaUsuario;
    private Pessoa p;
    private PessoaDAO pessoaDAO;
    public VerificarCampos verifC = new VerificarCampos();

    public TelaCadastroCliente() {

	setTitle("Cadastro Cliente");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 323, 304);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel lbNome = new JLabel("Nome*: ");
	lbNome.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
	lbNome.setBounds(20, 38, 53, 18);
	contentPane.add(lbNome);

	JLabel lbEmail = new JLabel("E-mail*:");
	lbEmail.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
	lbEmail.setBounds(20, 116, 53, 18);
	contentPane.add(lbEmail);

	JLabel lbCPF = new JLabel("CPF*:");
	lbCPF.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
	lbCPF.setBounds(20, 67, 53, 18);
	contentPane.add(lbCPF);

	JLabel lbTelefone = new JLabel("Telefone:");
	lbTelefone.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
	lbTelefone.setBounds(20, 145, 73, 18);
	contentPane.add(lbTelefone);

	txtNome = new JTextField();
	txtNome.setBounds(83, 35, 202, 26);
	contentPane.add(txtNome);
	txtNome.setColumns(10);

	txtCPF = new JTextField();
	txtCPF.setColumns(10);
	txtCPF.setBounds(83, 64, 202, 26);
	contentPane.add(txtCPF);

	txtEmail = new JTextField();
	txtEmail.setColumns(10);
	txtEmail.setBounds(83, 113, 202, 26);
	contentPane.add(txtEmail);

	txtTelefone = new JTextField();
	txtTelefone.setColumns(10);
	txtTelefone.setBounds(83, 142, 202, 26);
	contentPane.add(txtTelefone);

	JButton btnCadastrar = new JButton("Cadastrar");

	btnCadastrar.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		// 1 verificar se os campos estão NULL

		// String nome = txtNome.getText();
		// String cpf = txtCPF.getText();
		// String email = txtEmail.getText();
		// String telefone = txtTelefone.getText();
//		boolean bandeira = true;

		boolean verificarCadastro = verifC.verificarCamposCliente(txtNome.getText(), txtCPF.getText(), 
			txtEmail.getText(), txtTelefone.getText()); // VERIFICAR CAMPO ESTÁ EM BRANCO

		boolean clienteCPF = pessoaDAO.verificarCPF(txtCPF.getText()); // VERIC=FICAR SE O CPF JÁ EXISTE

		if (verificarCadastro == true) {

		    if (clienteCPF == true) { 		// SE CPF NAO EXISTIR,CADASTRAR.
			p.setNome(txtNome.getText());
			p.setCpf(txtCPF.getText());
			p.setEmail(txtEmail.getText());
			p.setTelefone(Integer.valueOf(txtTelefone.getText()));

			pessoaDAO.inserir(p);

			JOptionPane.showMessageDialog(pegarReferencia(), "Conta alterada com sucesso!");
			telaUsuario.setEnabled(true);
			dispose();
		    }

		    else {
			JOptionPane.showMessageDialog(pegarReferencia(), "O CPF indicado já está cadastrado!");
		    }

		} else {
		    JOptionPane.showMessageDialog(pegarReferencia(),
			    "Atenção! Algum campo está em branco ou não foi alterada direito."
				    + "O máximo de caracteres na senha e no telefone é 9, só podendo números.");
		}

	    }
	});

	// if (nome.equals(null) || nome.length() == 0) { // VERIFICAR SE ESTÁ EM BRANCO
	// bandeira = false;
	// }
	// if (cpf.equals(null) || cpf.length() == 0) {
	// bandeira = false;
	// }
	// if (email.equals(null) || email.length() == 0) {
	// bandeira = false;
	// }
	// if (telefone.equals(null) || telefone.length() == 0) {
	// bandeira = false;
	// }
	//
	// for (int i = 0; i < telefone.length(); i++) { // VERIFICAR SE APENAS TEM
	// NÚMEROS NA VARIAVEL
	// if (!Character.isDigit(telefone.charAt(i))) {
	// bandeira = false;
	// }
	// }
	//
	// 2 verificar se o CPF digitado já existe no banco se nao, inserir
	//
	// boolean vendedorCPF = pessoaDAO.verificarCPF(cpf); // trazerá o retorno da
	// classe pessoadao da funçaõ
	// verificarcpf.

	// if (vendedorCPF == false) {
	// int intTelefone = Integer.parseInt(telefone);
	// Pessoa p = new Pessoa(nome, cpf, intTelefone, email);
	//
	// pessoaDAO.inserir(p);
	//
	// JOptionPane.showMessageDialog(pegarReferencia(), "O usuário foi cadastrado
	// com sucesso!");
	//
	// }
	// if (vendedorCPF == true) { // TRUE SE O CPF ESTIVER EM ALGUMA DAS TABELAS
	// JOptionPane.showMessageDialog(pegarReferencia(), "O CPF indicado já está
	// cadastrado!");
	// }
	//
	// if (bandeira == false) {
	// JOptionPane.showMessageDialog(pegarReferencia(),
	// "Atenção! Algum campo está em branco ou não foi cadastrado direito."
	// + "O máximo de caracteres na senha e no telefone é 9, só podendo números.");
	// }
	// }
	//
	// });

	btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 15));
	btnCadastrar.setBounds(150, 214, 135, 28);
	contentPane.add(btnCadastrar);

    }

    @Override
    public void windowActivated(WindowEvent arg0) {
	// TODO Auto-generated method stub

    }

    @Override
    public void windowClosed(WindowEvent arg0) {
	// TODO Auto-generated method stub

    }

    @Override
    public void windowClosing(WindowEvent arg0) {
	telaUsuario.setEnabled(true);

    }

    @Override
    public void windowDeactivated(WindowEvent arg0) {
	// TODO Auto-generated method stub

    }

    @Override
    public void windowDeiconified(WindowEvent arg0) {
	// TODO Auto-generated method stub

    }

    @Override
    public void windowIconified(WindowEvent arg0) {
	// TODO Auto-generated method stub

    }

    @Override
    public void windowOpened(WindowEvent arg0) {
	// TODO Auto-generated method stub

    }

    public TelaCadastroCliente pegarReferencia() {
	return this;
    }

}
