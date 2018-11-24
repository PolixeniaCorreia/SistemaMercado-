package MercadoView;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import MercadoDAO.UsuarioDAO;
import MercadoUtils.Usuario;

public class TelaListarUsuario extends JFrame implements WindowListener{

	private JPanel contentPane;
	private JTable tabelaContasUS;
	private TelaUsuario telaUsuario;
	
	

	public TelaListarUsuario(TelaUsuario tUsuario) {
		this.telaUsuario = tUsuario;
		
		setTitle("Usuários");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 130, 524, 349);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 498, 298);
		contentPane.add(scrollPane);
		
		DefaultTableModel modeloTabela = new DefaultTableModel();
		
		tabelaContasUS = new JTable();
	
		tabelaContasUS.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				 "Nome","CPF","E-mail", "Telefone","UsuárioLogin",
			}
		) {
			boolean[] columnEditables = new boolean[] {
			 false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabelaContasUS.getColumnModel().getColumn(0).setPreferredWidth(64);
		tabelaContasUS.getColumnModel().getColumn(1).setPreferredWidth(110);
		tabelaContasUS.getColumnModel().getColumn(2).setPreferredWidth(183);
		tabelaContasUS.getColumnModel().getColumn(3).setPreferredWidth(149);
		tabelaContasUS.getColumnModel().getColumn(4).setPreferredWidth(137);
		scrollPane.setViewportView(tabelaContasUS);
		
//		
		
		
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

}
