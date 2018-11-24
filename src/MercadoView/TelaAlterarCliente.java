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
import MercadoUtils.Administrador;
import MercadoUtils.Usuario;
import MercadoUtils.VerificarCampos;

public class TelaAlterarCliente extends JFrame implements WindowListener {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JButton btnDeletar;
	private JButton btnAlterar;
	private TelaUsuario telaUsuario;
	private PessoaDAO pessoaDAO;
	private Usuario us;
	public VerificarCampos verifC = new VerificarCampos();
	

	public TelaAlterarCliente(TelaUsuario tUsuario, Usuario usuarioAlt, String cpfAlt, String usuarioDf) {
		this.telaUsuario = tUsuario;
		
		setTitle("Alterar Conta de Cliente");
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
		
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (usuarioDf == "vendedor") { 	// CONDIÇÃO PARA VER SE VAI DELETAR NA TABELA 
					us.setNome(txtNome.getText());
					us.setCpf(txtCPF.getText());
					us.setEmail(txtEmail.getText());
					us.setTelefone(Integer.valueOf(txtTelefone.getText()));
					
					pessoaDAO.alterar(us, cpfAlt);
				}
				JOptionPane.showMessageDialog(pegarReferencia(), "Conta deletada com sucesso!");
				telaUsuario.setEnabled(true);
				dispose();
				
			}
		});
		
		btnDeletar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnDeletar.setBounds(165, 214, 135, 28);
		contentPane.add(btnDeletar);
		
		btnAlterar = new JButton("Alterar");
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {  
				
				boolean verificarCadastro = verifC.verificarCamposCliente(txtNome.getText(), txtCPF.getText(), txtEmail.getText(), 
						txtTelefone.getText());
				if(verificarCadastro == true) {
					if (usuarioDf == "vendedor") { // CONDIÇÃO PARA VER SE VAI SER ALTERADO NA TABELA 
						us.setNome(txtNome.getText());
						us.setCpf(txtCPF.getText());
						us.setEmail(txtEmail.getText());
						us.setTelefone(Integer.valueOf(txtTelefone.getText()));
						
						pessoaDAO.alterar(us, cpfAlt);
					}
					
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
		btnAlterar.setBounds(20, 214, 135, 28);
		contentPane.add(btnAlterar);
		
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
	
	public TelaAlterarCliente pegarReferencia() {
		return this;
	}

}
