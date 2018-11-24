package MercadoView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MercadoDAO.AdministradorDAO;
import MercadoDAO.UsuarioDAO;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;

import MercadoUtils.Administrador;
import MercadoUtils.Usuario;
import MercadoUtils.VerificarCampos;

public class TelaCadastroUsuarios extends JFrame implements WindowListener {

    private JPanel contentPane;
    private JTextField txtNome;
    private JTextField txtCPF;
    private JTextField txtEmail;
    private JTextField txtTelefone;
    private JLabel lbLogin;
    private JLabel lbSenha;
    private JTextField txtLogin;
    private JTextField txtSenha;
    private TelaUsuario telaUsuario;
    public VerificarCampos verifC;

    public TelaCadastroUsuarios(TelaUsuario tUsuario) {
	this.telaUsuario = tUsuario;

	setTitle("Cadastro de Conta");
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(400, 130, 603, 275);

	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	verifC = new VerificarCampos();

	JComboBox<String> cbTipoUsuario = new JComboBox<String>();
	cbTipoUsuario.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
	
	DefaultComboBoxModel<String> cbModel = new DefaultComboBoxModel<>();

	cbModel.addElement("Administrador");
	cbModel.addElement("Vendedor");

	cbTipoUsuario.setModel(cbModel);
	cbTipoUsuario.setBounds(375, 101, 202, 26);
	contentPane.add(cbTipoUsuario);

	JLabel lbNome = new JLabel("Nome: ");
	lbNome.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
	lbNome.setBounds(10, 28, 53, 18);
	contentPane.add(lbNome);

	JLabel lbEmail = new JLabel("E-mail:");
	lbEmail.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
	lbEmail.setBounds(10, 106, 53, 18);
	contentPane.add(lbEmail);

	JLabel lbCPF = new JLabel("CPF:");
	lbCPF.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
	lbCPF.setBounds(10, 57, 53, 18);
	contentPane.add(lbCPF);

	JLabel lbTelefone = new JLabel("Telefone:");
	lbTelefone.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
	lbTelefone.setBounds(10, 135, 73, 18);
	contentPane.add(lbTelefone);

	txtNome = new JTextField();
	txtNome.setBounds(73, 25, 202, 26);
	contentPane.add(txtNome);
	txtNome.setColumns(10);

	txtCPF = new JTextField();
	txtCPF.setColumns(10);
	txtCPF.setBounds(73, 54, 202, 26);
	contentPane.add(txtCPF);

	txtEmail = new JTextField();
	txtEmail.setColumns(10);
	txtEmail.setBounds(73, 103, 202, 26);
	contentPane.add(txtEmail);

	txtTelefone = new JTextField();
	txtTelefone.setColumns(10);
	txtTelefone.setBounds(73, 132, 202, 26);
	contentPane.add(txtTelefone);

	lbLogin = new JLabel("Login/Usuário:");
	lbLogin.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
	lbLogin.setBounds(285, 28, 87, 18);
	contentPane.add(lbLogin);

	lbSenha = new JLabel("Senha:");
	lbSenha.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
	lbSenha.setBounds(285, 57, 87, 18);
	contentPane.add(lbSenha);

	txtLogin = new JTextField();
	txtLogin.setColumns(10);
	txtLogin.setBounds(375, 25, 202, 26);
	contentPane.add(txtLogin);

	txtSenha = new JTextField();
	txtSenha.setColumns(10);
	txtSenha.setBounds(375, 57, 202, 26);
	contentPane.add(txtSenha);

	JButton btnCadastrar = new JButton("Cadastrar");
	btnCadastrar.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		boolean verificarCadastro = verifC.verificarCampos(txtNome.getText(), txtCPF.getText(),
			txtEmail.getText(), txtTelefone.getText(), txtLogin.getText(), txtSenha.getText()); // MÉTODO
													    // PARA
													    // VERIFICAE
													    // SE TEM
													    // ALGO EM
													    // BRANCO OU
													    // N INT

		if (verificarCadastro == true) {

		    UsuarioDAO usuarioDAO = new UsuarioDAO();
		    AdministradorDAO adminDAO = new AdministradorDAO();

		    // VERIFICAR SE O CPF JÁ TÁ CADASTRADO EM ALGUM DAS DUAS TABELAS //

		    boolean vendedorCPF = usuarioDAO.verificarCPF(txtCPF.getText());
		    boolean adminCPF = adminDAO.verificarCPF(txtCPF.getText());
		    //

		    if (vendedorCPF == false && adminCPF == false) { // FALSE SE NÃO O CPF NÃO TIVER CADASTRADO
			if (cbModel.getSelectedItem().equals("Administrador")) { // VERIFICAR SE O FOI SELECIONADO
				String administrador;						 // 'ADMINISTRADOR' NO MODELO
										 // DO COMBO BOX

			    Administrador admin = new Administrador(txtNome.getText(), txtCPF.getText(),
				    txtEmail.getText(), Integer.valueOf(txtTelefone.getText()), txtLogin.getText(),
				    Integer.valueOf(txtSenha.getText()),administrador);
			    adminDAO.inserir(admin);

			} else { // SENÃO IRÁ DIRETO PARA 'VENDEDOR'
			    String usuario;

			    Usuario us = new Usuario(txtNome.getText(), txtCPF.getText(), txtEmail.getText(),
				    Integer.valueOf(txtTelefone.getText()), txtLogin.getText(),
				    Integer.valueOf(txtSenha.getText()),usuario);
			    usuarioDAO.inserir(us);

			}

			JOptionPane.showMessageDialog(pegarReferencia(), "O usuário foi cadastrado com sucesso!");
			telaUsuario.setEnabled(true); // DESTRAVAR TELA PRINCIPAL
			dispose(); // FECHAR TELA DE CADASTRO

		    } else { // TRUE SE O CPF ESTIVER EM ALGUMA DAS TABELAS
			JOptionPane.showMessageDialog(pegarReferencia(), "O CPF indicado já está cadastrado!");
		    }

		} else {
		    JOptionPane.showMessageDialog(pegarReferencia(),
			    "Atenção! Algum campo está em branco ou não foi cadastrado direito."
				    + "O máximo de caracteres na senha e no telefone é 9, só podendo números.");
		}
	    }
	});
	btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 15));
	btnCadastrar.setBounds(442, 171, 135, 28);
	contentPane.add(btnCadastrar);

	JLabel lbTipoDeConta = new JLabel("Tipo de Conta:");
	lbTipoDeConta.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
	lbTipoDeConta.setBounds(285, 106, 87, 18);
	contentPane.add(lbTipoDeConta);

	this.addWindowListener(this);
	setLocation(telaUsuario.getX() + 50, telaUsuario.getY() + 50);
	super.setVisible(true);
    }

    @Override
    public void windowActivated(WindowEvent e) {
	// TODO Auto-generated method stub

    }

    @Override
    public void windowClosed(WindowEvent e) {
	// TODO Auto-generated method stub

    }

    @Override
    public void windowClosing(WindowEvent e) {
	telaUsuario.setEnabled(true);

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
	// TODO Auto-generated method stub

    }

    @Override
    public void windowDeiconified(WindowEvent e) {
	// TODO Auto-generated method stub

    }

    @Override
    public void windowIconified(WindowEvent e) {
	// TODO Auto-generated method stub

    }

    @Override
    public void windowOpened(WindowEvent e) {
	// TODO Auto-generated method stub

    }

    public TelaCadastroUsuarios pegarReferencia() {
	return this;
    }

}
