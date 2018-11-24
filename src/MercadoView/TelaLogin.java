package MercadoView;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import MercadoDAO.UsuarioDAO;
import MercadoUtils.TipoUsuario;
import MercadoUtils.Usuario;

public class TelaLogin extends JFrame {

    private JPanel contentPane;
    private JTextField txtLogin;
    private JTextField txtSenha;
    private UsuarioDAO usDAO;

    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    TelaLogin frame = new TelaLogin();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    public boolean verificarCampos(String login, String senha) { // MÉTODO PARA VERIFICAR OS CAMPOS

	if (login.equals(null) || login.length() == 0) { // VERIFICAR SE O LOGIN ESTÁ EM BRANCO
	    return false;
	}
	if (senha.equals(null) || senha.length() == 0) { // VERIFICAR SE A SENHA ESTÁ EM BRANCO
	    return false;
	}
	for (int i = 0; i < senha.length(); i++) { // VERIFICAR SE APENAS TEM NÚMEROS NA VARIAVEL
	    if (!Character.isDigit(senha.charAt(i))) {
		return false;
	    }
	}
	return true; // RETORNA TRUE SE NÃO TIVER EM BRANCO E SE A SENHA TIVER APENAS NÚMEROS
    }

    public TelaLogin() {

	setFont(new Font("Tahoma", Font.PLAIN, 11));
	setBackground(Color.WHITE);
	setResizable(false);
	setTitle("Login");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(400, 130, 390, 260);

	JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);

	JMenu mnAjuda = new JMenu("Mais");
	menuBar.add(mnAjuda);

	JMenuItem mntmAjuda = new JMenuItem("Ajuda");
	mntmAjuda.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(pegarReferencia(),
			"O login pode conter tanto letras como números. \n " + "A senha deve conter apenas números.");
	    }
	});
	mnAjuda.add(mntmAjuda);

	JMenuItem mntmSair = new JMenuItem("Sair");
	mnAjuda.add(mntmSair);
	contentPane = new JPanel();
	contentPane.setBackground(SystemColor.activeCaption);
	contentPane.setForeground(Color.BLACK);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel lbLogin = new JLabel("Usuário:");
	lbLogin.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
	lbLogin.setBounds(68, 54, 57, 28);
	contentPane.add(lbLogin);

	txtLogin = new JTextField();
	txtLogin.setBounds(133, 57, 169, 28);
	contentPane.add(txtLogin);
	txtLogin.setColumns(10);

	JLabel lbSenha = new JLabel("Senha:");
	lbSenha.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
	lbSenha.setBounds(78, 93, 56, 28);
	contentPane.add(lbSenha);

	txtSenha = new JTextField();
	txtSenha.setColumns(10);
	txtSenha.setBounds(133, 96, 169, 28);
	contentPane.add(txtSenha);

	JButton btnEntrar = new JButton("Entrar");
	btnEntrar.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		// VERIFICA PREENCHIMENTO
		boolean loginVerificado = verificarCampos(txtLogin.getText(), txtSenha.getText());

		if (loginVerificado == true) {

		    UsuarioDAO usuarioDAO = new UsuarioDAO();

		    // VERIFICA SE EXISTE E SE A SENHA E USUÁRIO SÃO VÁLIDOS - CONTROLE DE ACESSO
		    Usuario usuarioLogado = usuarioDAO.fazLogin(txtLogin.getText(),
			    Integer.valueOf(txtSenha.getText()));

		    String opVA;

		    // VERIFICO O TIPO DE USUARIO
		    if (usuarioLogado.getTipoUsuario().equals("VENDEDOR")) {
			
			// ACESSO OS RECURSOS DO TIPO - CONTROLE DE RECURSOS
			opVA = "vendedor";
			TelaUsuario telaUsuario = new TelaUsuario(opVA);
			telaUsuario.setVisible(true);
			dispose();

		    } else { // SE O LOGIN E A SENHA NÃO BATER COM NENHUMA DAS TABELAS
			JOptionPane.showMessageDialog(pegarReferencia(), "O login ou a senha está incorreta!");
		    }
		} else {
		    JOptionPane.showMessageDialog(pegarReferencia(),
			    "Atenção! Algum dos campos está em branco ou a senha está incorreta.");
		}

	    }
	});
	btnEntrar.setFont(new Font("Arial", Font.PLAIN, 15));
	btnEntrar.setBounds(213, 139, 89, 28);
	contentPane.add(btnEntrar);
    }

    public TelaLogin pegarReferencia() {
	return this;
    }
}
