package MercadoView;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TelaRelatVendas extends JFrame implements WindowListener {

	private JPanel contentPane;
	private JTable tabelaEstoque;
	private TelaUsuario telaUsuario;
	/**
	 * Create the frame.
	 */
	public TelaRelatVendas(TelaUsuario tUsuario) {
		this.telaUsuario = tUsuario;
		
		setTitle("Estoque");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 524, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 498, 298);
		contentPane.add(scrollPane);
		
		tabelaEstoque = new JTable();
		tabelaEstoque.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Id", "C\u00F3digo Produto", "CPF Cliente", "CPF Vendedor", "Data"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabelaEstoque.getColumnModel().getColumn(0).setPreferredWidth(64);
		tabelaEstoque.getColumnModel().getColumn(1).setPreferredWidth(113);
		tabelaEstoque.getColumnModel().getColumn(2).setPreferredWidth(138);
		tabelaEstoque.getColumnModel().getColumn(3).setPreferredWidth(137);
		tabelaEstoque.getColumnModel().getColumn(4).setPreferredWidth(98);
		scrollPane.setViewportView(tabelaEstoque);
		
		this.addWindowListener(this);
		setLocation(telaUsuario.getX()+50, telaUsuario.getY()+50);
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
