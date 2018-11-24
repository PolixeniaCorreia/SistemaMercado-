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
import MercadoDAO.UsuarioDAO;
import MercadoUtils.Administrador;
import MercadoUtils.Usuario;
import MercadoUtils.VerificarCampos;

public class TelaAlterarUsuarios extends JFrame implements WindowListener {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JLabel lbLogin;
	private JLabel lbSenha;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JButton btnDeletar;
	private TelaUsuario telaUsuario;
	private UsuarioDAO usuarioDAO;
	private Usuario us;
	public VerificarCampos verifC;
	
	public TelaAlterarUsuarios(TelaUsuario tUsuario, Usuario usuarioAlt, String cpfAlt, String usuarioDf) {
		this.telaUsuario = tUsuario;
		
		setTitle("Alterar Conta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 130, 603, 275);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usuarioDAO = new UsuarioDAO();
		us = new Usuario();
		verifC = new VerificarCampos();
		
		JLabel lbNome = new JLabel("Nome: ");
		lbNome.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		lbNome.setBounds(10, 30, 53, 18);
		contentPane.add(lbNome);
		
		JLabel lbEmail = new JLabel("E-mail:");
		lbEmail.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		lbEmail.setBounds(10, 108, 53, 18);
		contentPane.add(lbEmail);
		
		JLabel lbCPF = new JLabel("CPF:");
		lbCPF.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		lbCPF.setBounds(10, 59, 53, 18);
		contentPane.add(lbCPF);
		
		JLabel lbTelefone = new JLabel("Telefone:");
		lbTelefone.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		lbTelefone.setBounds(10, 137, 73, 18);
		contentPane.add(lbTelefone);
		
		txtNome = new JTextField(usuarioAlt.getNome());
		txtNome.setBounds(73, 27, 202, 26);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(73, 56, 202, 26);
		contentPane.add(txtCPF);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(73, 105, 202, 26);
		contentPane.add(txtEmail);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(73, 134, 202, 26);
		contentPane.add(txtTelefone);
		
		lbLogin = new JLabel("Login/Usuário:");
		lbLogin.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		lbLogin.setBounds(285, 30, 87, 18);
		contentPane.add(lbLogin);
		
		lbSenha = new JLabel("Senha:");
		lbSenha.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		lbSenha.setBounds(285, 59, 87, 18);
		contentPane.add(lbSenha);
		
		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		txtLogin.setBounds(375, 27, 202, 26);
		contentPane.add(txtLogin);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(375, 59, 202, 26);
		contentPane.add(txtSenha);
	
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean verificarCadastro = verifC.verificarCampos(txtNome.getText(), txtCPF.getText(), txtEmail.getText(), 
						txtTelefone.getText(), txtLogin.getText(), txtSenha.getText());
				if(verificarCadastro == true) {
					
						us.setNome(txtNome.getText());
						us.setCpf(txtCPF.getText());
						us.setEmail(txtEmail.getText());
						us.setTelefone(Integer.valueOf(txtTelefone.getText()));
						us.setLogin(txtLogin.getText());
						us.setSenha(Integer.valueOf(txtSenha.getText()));
						
					usuarioDAO.alterar(us, cpfAlt);
					
					JOptionPane.showMessageDialog(pegarReferencia(), "Conta alterada com sucesso!");
					telaUsuario.setEnabled(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(pegarReferencia(), "Atenção! Algum campo está em branco ou não foi alterada direito."
							+ "O máximo de caracteres na senha e no telefone é 9, só podendo números.");
				}
				
			}
		});
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAlterar.setBounds(297, 175, 135, 28);
		contentPane.add(btnAlterar);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					us.setNome(txtNome.getText());
					us.setCpf(txtCPF.getText());
					us.setEmail(txtEmail.getText());
					us.setTelefone(Integer.valueOf(txtTelefone.getText()));
					us.setLogin(txtLogin.getText());
					us.setSenha(Integer.valueOf(txtSenha.getText()));
					
					usuarioDAO.deletar(us);
				
				JOptionPane.showMessageDialog(pegarReferencia(), "Conta deletada com sucesso!");
				telaUsuario.setEnabled(true);
				dispose();
			}
		});
		btnDeletar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnDeletar.setBounds(442, 175, 135, 28);
		contentPane.add(btnDeletar);
		
		this.addWindowListener(this);
		setLocation(telaUsuario.getX()+50, telaUsuario.getY()+50);
		super.setVisible(true);
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
		// TODO Auto-generated method stub
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
	
	public TelaAlterarUsuarios pegarReferencia() {
		return this;
	}

}
