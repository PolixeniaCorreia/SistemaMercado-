package MercadoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import MercadoUtils.ConnectionFactory;
import MercadoUtils.Produto;

public class ProdutoDAO {
	
	public void inserir(Produto p) {
		PreparedStatement ps = null;
		String sql = "insert into produto (codigoProduto, nome, descriçao, quantidade) values(?,?,?,?)";
		try(Connection conn = new ConnectionFactory().getConnection()) {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, p.getCodigoProduto());
			ps.setString(2, p.getNome());
			ps.setString(3, p.getDescriçao());
			ps.setInt(4, p.getQuantidade());
			ps.execute();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error ao inserir um produto no banco!");
		}
		
	}

	public void deletar(Produto p) {
		PreparedStatement ps = null;
		String sql = "delete from produto where codigoProduto = ?";
		try(Connection conn = new ConnectionFactory().getConnection()){
			ps = conn.prepareStatement(sql);
			ps.setInt(1, p.getCodigoProduto());
			ps.execute();
			ps.close();
		}catch (SQLException e) {
			System.out.println("Error ao deletar um produtos");
			System.out.println(e.getMessage());
		}
		
	}
	
	public ArrayList<Produto> listar(){
		ArrayList<Produto> produtos = new ArrayList<>();
		String sql = "select * from produto";
		PreparedStatement ps = null;
		try(Connection conn = new ConnectionFactory().getConnection()){
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Produto p = new Produto();
				p.setCodigoProduto(rs.getInt("CodigoProduto"));
				p.setNome(rs.getString("nome"));
				p.setDescriçao(rs.getString("descriçao"));
				p.setQuantidade(rs.getInt("descriçao"));
				produtos.add(p);
			}
			ps.close();
		}catch(SQLException e) {
			System.out.println("Error ao listar produtos");
			System.out.println(e.getMessage());
		}
		return produtos;
	}

	public void alterar(Produto p, int codigoProduto) {
		PreparedStatement ps = null;
		String sql = "update produto set nome=?, cpf=? where codigoProduto=?";
		try(Connection conn = new ConnectionFactory().getConnection()){
			ps = conn.prepareStatement(sql);
			ps.setInt(1, p.getCodigoProduto());
			ps.setString(2, p.getNome());
			ps.setString(3, p.getDescriçao());
			ps.setInt(4, p.getQuantidade());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error ao alterar a tabela produtos!");
			System.out.println(e.getMessage());
		}
	}



}