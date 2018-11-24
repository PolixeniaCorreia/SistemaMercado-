package MercadoDAO;

/*import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import MercadoUtils.ConnectionFactory;
import MercadoUtils.RelatVendas;

public class RelatVendasDAO {
	
	public void inserir(RelatVendas v) {
		PreparedStatement ps = null;
		String sql = "insert into vendedor (codigoVenda,codigoProduto,cpfCliente,cpfVendedor,data) values(?,?,?,?,?)";
		try(Connection conn = new ConnectionFactory().getConnection()) {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, v.getCodigoVenda());
			ps.setInt(2, v.getCodigoProduto());
			ps.setString(3, v.getCpfCliente());
			ps.setString(4, v.getCpfVendedor());
			ps.setDate(5, v.getData());
			ps.execute();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error ao inserir um Vendedor no banco!");
		}
		
	}

	public void deletar(RelatVendas v) {
		PreparedStatement ps = null;
		String sql = "delete from vendedor where codigoVenda = ?";
		try(Connection conn = new ConnectionFactory().getConnection()){
			ps = conn.prepareStatement(sql);
			ps.setInt(1, v.getCodigoVenda());
			ps.execute();
			ps.close();
		}catch (SQLException e) {
			System.out.println("Error ao deletar um Vendedor");
			System.out.println(e.getMessage());
		}
		
	}
	
	public ArrayList<RelatVendas> listar(){
		ArrayList<RelatVendas> vendedor = new ArrayList<>();
		String sql = "select * from vendedor";
		PreparedStatement ps = null;
		try(Connection conn = new ConnectionFactory().getConnection()){
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				RelatVendas v = new RelatVendas();
				v.setCodigoVenda(rs.getInt("Codigo de Vendas"));
				v.setCodigoProduto(rs.getInt("Codigo Produto"));
				v.setCpfCliente(rs.getString("CPF Cliente"));
				v.setCpfVendedor(rs.getString("CPF Vendedor"));
				vendedor.add(v);
			}
			ps.close();
		}catch(SQLException e) {
			System.out.println("Error ao listar Vendedor");
			System.out.println(e.getMessage());
		}
		return vendedor;
	}
	
	public void alterar(RelatVendas v, String cpf) {
		PreparedStatement ps = null;
		String sql = "update vendedor set codigoVenda=?, codigoProduto=?, cpfCliente=?, cpfVendedor=?, data=? where codigoVenda=?";
		try(Connection conn = new ConnectionFactory().getConnection()){
			ps = conn.prepareStatement(sql);
			ps.setInt(1, v.getCodigoVenda());
			ps.setInt(2, v.getCodigoProduto());
			ps.setString(3, v.getCpfCliente());
			ps.setString(4, v.getCpfVendedor());
			ps.setDate(5, v.getData());
		}catch(SQLException e) {
			System.out.println("Error ao alterar a tabela Vendedor!");
			System.out.println(e.getMessage());
		}
	}
	
}*/