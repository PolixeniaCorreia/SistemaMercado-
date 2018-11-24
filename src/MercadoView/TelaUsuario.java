package MercadoView;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MercadoDAO.UsuarioDAO;
import MercadoUtils.Usuario;

public class TelaUsuario extends JFrame {

    private JPanel contentPane;
    private UsuarioDAO usuarioDAO;
    // private AdministradorDAO adminDAO;
    private String opcaoVA;

    public TelaUsuario(String opcaoVA) {
	this.opcaoVA = opcaoVA;

	// Fecha a janela anterior
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(400, 130, 405, 292);

	usuarioDAO = new UsuarioDAO();
	// adminDAO = new AdministradorDAO();

	JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);

	JMenu mnContas = new JMenu("Contas");
	menuBar.add(mnContas);

	JMenuItem mntmInserir = new JMenuItem("Inserir Conta");

	mntmInserir.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

	    }
	});
	mnContas.add(mntmInserir);

	JMenuItem mntmAlterar = new JMenuItem("Alterar Conta");

	mntmAlterar.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {

		String cpfTelaAlt = JOptionPane.showInputDialog(pegarReferencia(),
			"Digite o CPF do usuário que você deseja alterar ou deletar:");

		if (!cpfTelaAlt.equals(null)) { // VERIFICAR SE O CPF ESTÁ EM BRANCO

		    boolean vendedorAltVerif = usuarioDAO.verificarCPF(cpfTelaAlt); // PASSANDO O CPF QUE FOI DIGITADO

		    // boolean adminAltVerif = adminDAO.verificarCPF(cpfTelaAlt);

		    if (vendedorAltVerif == true) { // VERIFICAR SE O CPF BATE EM ALGUM DAS
			// if (vendedorAltVerif == true || adminAltVerif == true) { // VERIFICAR SE O
			// CPF BATE EM ALGUM DAS
			// DUAS TABELAS
			String usuarioDf;

			if (vendedorAltVerif == true) { // TRUE SE O CPF FOR VALIDO NO VENDEDOR

			    Usuario usAlterar = usuarioDAO.pegarDados(cpfTelaAlt); // MÉTODO PARA PEGAR OS DADOS DENTRO
										   // DA TABELA P/ SETAR NA TELA
										   // ALTERAR
			    usuarioDf = "vendedor";

			    pegarReferencia().setEnabled(false); // TRAVAR TELA MAIN DO VENDEDOR OU ADMIN
			    new TelaAlterarUsuarios(pegarReferencia(), usAlterar, cpfTelaAlt, usuarioDf); // ABRIR TELA
													  // DE
													  // ALTERAR
													  // (os dados
													  // do user,
													  // cpf p
													  // alterar,vendedor).

			    // Para deixar preenchido nos campos da tela.

			}
			// else {
			//
			// Usuario usAlterar = adminDAO.pegarDados(cpfTelaAlt); // MÉTODO PARA PEGAR OS
			// DADOS DENTRO DA
			// // TABELA P/ NA TELA ALTERAR
			// usuarioDf = "administrador";
			//
			// pegarReferencia().setEnabled(false); // TRAVAR TELA MAIN DO VENDEDOR OU ADMIN
			// new TelaAlterarUsuarios(pegarReferencia(), usAlterar, cpfTelaAlt, usuarioDf);
			// // ABRIR TELA
			// // DE
			// // ALTERAR
			// }
		    } else { // FALSE SE O CPF NÃO FOR VALIDO EM NENHUMA DAS TABELAS
			JOptionPane.showMessageDialog(pegarReferencia(), "O CPF indicado não está cadastrado!");
		    }
		} else {
		    JOptionPane.showMessageDialog(pegarReferencia(), "O campo de CPF está em branco!");
		}
	    }
	});

	mnContas.add(mntmAlterar);

	JMenuItem mntmListarContas = new JMenuItem("Verificar Contas");

	mntmListarContas.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		pegarReferencia().setEnabled(false);
		new TelaListarUsuario(pegarReferencia());
	    }
	});
	mnContas.add(mntmListarContas);

	JMenu mnClientes = new JMenu("Clientes");
	menuBar.add(mnClientes);

	JMenuItem mntmInserirCliente = new JMenuItem("Inserir Cliente");
	mntmInserirCliente.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
		telaCadastroCliente.setVisible(true);
		dispose();

	    }
	});

	mnClientes.add(mntmInserirCliente);

	JMenuItem mntmAlterarCliente = new JMenuItem("Alterar Cliente");
	mntmAlterarCliente.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

	    }
	});
	mnClientes.add(mntmAlterarCliente);

	JMenuItem mntmVerificarClientes = new JMenuItem("Verificar Clientes");
	mntmVerificarClientes.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {

		pegarReferencia().setEnabled(false);
		new TelaListarUsuario(pegarReferencia());

	    }
	});
	mnClientes.add(mntmVerificarClientes);

	JMenu mnNewMenu = new JMenu("Produtos");
	menuBar.add(mnNewMenu);

	JMenuItem mntmInserirProd = new JMenuItem("Inserir Produto");
	mntmInserirProd.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		pegarReferencia().setEnabled(false);
		new TelaCadastroProd(pegarReferencia());
	    }
	});
	mnNewMenu.add(mntmInserirProd);

	JMenuItem mntmAlterarProd = new JMenuItem("Alterar Produto");
	mntmAlterarProd.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		pegarReferencia().setEnabled(false);
		new TelaAlterarProd(pegarReferencia());
	    }
	});
	mnNewMenu.add(mntmAlterarProd);

	JMenuItem mntmListarEstoque = new JMenuItem("Verificar Estoque");
	mntmListarEstoque.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {

		pegarReferencia().setEnabled(false);
		new TelaListarEstoque(pegarReferencia());
	    }
	});
	mnNewMenu.add(mntmListarEstoque);

	JMenu mnVenda = new JMenu("Venda");
	menuBar.add(mnVenda);

	JMenuItem mntmRelatrioDeVendas = new JMenuItem("Relatório de Vendas");
	mntmRelatrioDeVendas.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {

		pegarReferencia().setEnabled(false);
		new TelaRelatVendas(pegarReferencia());
	    }
	});

	JMenuItem mntmCaixa = new JMenuItem("Caixa");
	mnVenda.add(mntmCaixa);
	mnVenda.add(mntmRelatrioDeVendas);

	JMenu mnNewMenu_1 = new JMenu("Mais");
	menuBar.add(mnNewMenu_1);

	JMenuItem mntmAjuda = new JMenuItem("Ajuda");

	mntmAjuda.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {

		if (opcaoVA.equals("admin")) {
		    JOptionPane.showMessageDialog(pegarReferencia(),
			    "O Administrador pode: Gerenciar contas, sendo apenas vendedores"
				    + "e outros administradores; \n Gerenciar produtos, como também ver o estoque e o relatório de vendas.");

		} else {
		    JOptionPane.showMessageDialog(pegarReferencia(), "O Vendedor pode: Gerenciar clientes apenas;"
			    + "\nGerenciar produtos, como também ver o estoque e o relatório de vendas; \nPode também fazer uma venda (menu -"
			    + "Caixa).");
		}

	    }
	});

	mnNewMenu_1.add(mntmAjuda);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel lbDadosDaConta = new JLabel("Dados da Conta:");
	lbDadosDaConta.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
	lbDadosDaConta.setBounds(20, 11, 141, 21);
	contentPane.add(lbDadosDaConta);

	JLabel lbUsuário = new JLabel("Usuário");
	lbUsuário.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
	lbUsuário.setBounds(20, 43, 54, 21);
	contentPane.add(lbUsuário);

	JLabel lbEmail = new JLabel("E-mail");
	lbEmail.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
	lbEmail.setBounds(20, 65, 54, 21);
	contentPane.add(lbEmail);

	JLabel lbDadosPessoas = new JLabel("Dados Pessoas:");
	lbDadosPessoas.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
	lbDadosPessoas.setBounds(20, 106, 141, 21);
	contentPane.add(lbDadosPessoas);

	JLabel lbNome = new JLabel("Nome");
	lbNome.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
	lbNome.setBounds(20, 139, 54, 21);
	contentPane.add(lbNome);

	JLabel lbDocumento = new JLabel("CPF");
	lbDocumento.setToolTipText("");
	lbDocumento.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
	lbDocumento.setBounds(20, 164, 54, 21);
	contentPane.add(lbDocumento);

	JLabel lbTelefone = new JLabel("Telefone");
	lbTelefone.setToolTipText("");
	lbTelefone.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
	lbTelefone.setBounds(20, 187, 54, 21);
	contentPane.add(lbTelefone);

	JLabel lbUsuarioBD = new JLabel("Poli");
	lbUsuarioBD.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
	lbUsuarioBD.setBounds(107, 43, 119, 21);
	contentPane.add(lbUsuarioBD);

	JLabel lbEmailBD = new JLabel("poli@gmail.com");
	lbEmailBD.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
	lbEmailBD.setBounds(107, 65, 212, 21);
	contentPane.add(lbEmailBD);

	JLabel lbNomeBD = new JLabel("Poli");
	lbNomeBD.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
	lbNomeBD.setBounds(107, 139, 174, 21);
	contentPane.add(lbNomeBD);

	JLabel lbDocBD = new JLabel("70014842459");
	lbDocBD.setToolTipText("");
	lbDocBD.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
	lbDocBD.setBounds(107, 164, 111, 21);
	contentPane.add(lbDocBD);

	JLabel lbTelBD = new JLabel("8880-1684");
	lbTelBD.setToolTipText("");
	lbTelBD.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
	lbTelBD.setBounds(107, 187, 111, 21);
	contentPane.add(lbTelBD);

	// LÓGICA SE O USUÁRIO FOR ADMIN OU VENDEDOR //
	if (opcaoVA.equals("admin")) {
	    super.setTitle("Administrador");
	    mnClientes.setVisible(false);
	    mntmCaixa.setVisible(false);

	} else {
	    super.setTitle("Vendedor");
	    mnContas.setVisible(false);
	}
	//
    }

    public TelaUsuario pegarReferencia() {
	return this;
    }
}
