package MercadoView;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAlterarProd extends JFrame implements WindowListener {

	private JPanel contentPane;
	private JTextField txtNomeBD;
	private JTextField txtPreçoBD;
	private JLabel lbCod;
	private JTextField txtCodBD;
	private JTextField txtQntdBD;
	private TelaUsuario telaUsuario;

	/**
	 * Create the frame.
	 */
	public TelaAlterarProd(TelaUsuario tUsuario) {
		this.telaUsuario = tUsuario;
		
		setTitle("Alterar Produto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 603, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cbTipoUsuario = new JComboBox();
		cbTipoUsuario.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		cbTipoUsuario.setModel(new DefaultComboBoxModel(new String[] {"Alimentos B\u00E1sicos", "Frescos e Refrigerados", "A\u00E7ougue e Peixaria", "Bebidas", "Limpeza", "Perfumaria", "Saud\u00E1veis", "Infantil", "Pets"}));
		cbTipoUsuario.setBounds(375, 104, 202, 26);
		contentPane.add(cbTipoUsuario);
		
		JLabel lbNome = new JLabel("Nome: ");
		lbNome.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		lbNome.setBounds(10, 31, 53, 18);
		contentPane.add(lbNome);
		
		JLabel lbQntd = new JLabel("Quantidade:");
		lbQntd.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		lbQntd.setBounds(285, 60, 80, 18);
		contentPane.add(lbQntd);
		
		JLabel lbPreço = new JLabel("Preço:");
		lbPreço.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		lbPreço.setBounds(10, 60, 53, 18);
		contentPane.add(lbPreço);
		
		txtNomeBD = new JTextField();
		txtNomeBD.setBounds(61, 28, 202, 26);
		contentPane.add(txtNomeBD);
		txtNomeBD.setColumns(10);
		
		txtPreçoBD = new JTextField();
		txtPreçoBD.setColumns(10);
		txtPreçoBD.setBounds(61, 57, 202, 26);
		contentPane.add(txtPreçoBD);
		
		lbCod = new JLabel("Código:");
		lbCod.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		lbCod.setBounds(309, 31, 56, 18);
		contentPane.add(lbCod);
		
		txtCodBD = new JTextField();
		txtCodBD.setColumns(10);
		txtCodBD.setBounds(375, 28, 202, 26);
		contentPane.add(txtCodBD);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaUsuario.setEnabled(true);
				dispose();
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCadastrar.setBounds(297, 197, 135, 28);
		contentPane.add(btnCadastrar);
		
		JLabel lbTipoProd = new JLabel("Tipo de Produto:");
		lbTipoProd.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		lbTipoProd.setBounds(265, 109, 100, 18);
		contentPane.add(lbTipoProd);
		
		txtQntdBD = new JTextField();
		txtQntdBD.setColumns(10);
		txtQntdBD.setBounds(375, 60, 202, 26);
		contentPane.add(txtQntdBD);
		
		JLabel lbDesc = new JLabel("Descrição:");
		lbDesc.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		lbDesc.setBounds(10, 109, 72, 18);
		contentPane.add(lbDesc);
		
		JTextArea txtAreaDescBD = new JTextArea();
		txtAreaDescBD.setBounds(10, 135, 253, 90);
		contentPane.add(txtAreaDescBD);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaUsuario.setEnabled(true);
				dispose();
			}
		});
		btnDeletar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnDeletar.setBounds(442, 197, 135, 28);
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
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
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
}
