package MercadoView;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import MercadoDAO.UsuarioDAO;
import MercadoUtils.Usuario;

public class TelaListarCliente extends JFrame {

	private JPanel contentPane;
	private JTable tabelaContasCL;
	private UsuarioDAO usuarioDAO;
	
	public TelaListarCliente() {
	    
		setTitle("Contas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 498, 298);
		contentPane.add(scrollPane);
		
		tabelaContasCL = new JTable();
		tabelaContasCL.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nome", "E-mail", "Telefone"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabelaContasCL.getColumnModel().getColumn(0).setPreferredWidth(64);
		tabelaContasCL.getColumnModel().getColumn(1).setPreferredWidth(204);
		tabelaContasCL.getColumnModel().getColumn(2).setPreferredWidth(167);
		tabelaContasCL.getColumnModel().getColumn(3).setPreferredWidth(137);
		scrollPane.setViewportView(tabelaContasCL);
		
		DefaultTableModel modelo = (DefaultTableModel) tabelaContasCL.getModel();
//		modelo.setNumRows(0); // PARA NÃO DUPLICAR
//		
//		UsuarioDAO usuarioDAO = new UsuarioDAO();	
//		for (Usuario us : usuarioDAO.read()) {
//			modelo.addRow (new Object[] {
//					us.getNome(),
//					us.getCpf(),
//					us.getEmail(),
//					us.getTelefone()
//			});
//	}
		
		ArrayList<Usuario> vendedores = usuarioDAO.listar();
		Object[] addvends = new Object [5];
		
//		for(Usuario us : new vendedores) {
//			addVends [0] = us.getNome();
//			addVends [1] = us.getCpf();
//			addVends [2] = us.getEmail();
//			addVends [3] = us.getTelefone();
//			addVends [4] = us.getLogin();
//			
//			modeloTabela.assRow(addVends);
//		}
		
	}
}
