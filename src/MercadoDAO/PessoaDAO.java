package MercadoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import MercadoUtils.ConnectionFactory;
import MercadoUtils.Pessoa;
import MercadoDAO.InterfacePessoaDAO;

public class PessoaDAO implements InterfacePessoaDAO{
	
	@Override
	public void inserir(Pessoa p) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into pessoa (nome, cpf, email, telefone) values(?,?,?,?)";
		try {
			conn = new ConnectionFactory().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setString(2, p.getCpf());
			ps.setString(3, p.getEmail());
			ps.setInt(4, p.getTelefone());
			ps.execute();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error ao inserir uma pessoa no banco!");
		}finally {
			try {
				ps.close();
				conn.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("Error ao fechar o banco para pessoa!");
			}
		}
	}

	public void deletar(Pessoa p) {
		PreparedStatement ps = null;
		String sql = "delete from produto where cpf = ?";
		try(Connection conn = new ConnectionFactory().getConnection()){
			ps = conn.prepareStatement(sql);
			ps.setString(1, p.getCpf());
			ps.execute();
			ps.close();
		}catch (SQLException e) {
			System.out.println("Error ao deletar uma Pessoa");
			System.out.println(e.getMessage());
		}
		
	}
	
	public ArrayList<Pessoa> listar(){
		ArrayList<Pessoa> pessoa = new ArrayList<>();
		String sql = "select * from produto";
		PreparedStatement ps = null;
		try(Connection conn = new ConnectionFactory().getConnection()){
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Pessoa p = new Pessoa();
				p.setNome(rs.getString("nome"));
				p.setCpf(rs.getString("cpf"));
				p.setEmail(rs.getString("email"));
				p.setTelefone(rs.getInt("Telefone"));
				pessoa.add(p);
			}
			ps.close();
		}catch(SQLException e) {
			System.out.println("Error ao listar Pessoas");
			System.out.println(e.getMessage());
		}
		return pessoa;
	}

	public void alterar(Pessoa p, String cpf) {
		PreparedStatement ps = null;
		String sql = "update pessoa set nome=?, cpf=?, email=?, telefone=? where cpf=?";
		try(Connection conn = new ConnectionFactory().getConnection()){
			ps = conn.prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setString(2, p.getCpf());
			ps.setString(3, p.getEmail());
			ps.setInt(4, p.getTelefone());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error ao alterar a tabela Pessoas!");
			System.out.println(e.getMessage());
		}
	}
	public boolean verificarCPF(String cpf) {
		String sql = "select * from pessoa";
		PreparedStatement ps = null;
		try(Connection conn = new ConnectionFactory().getConnection()){
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if (rs.getString("cpf").equals(cpf)) {
					return true;
				}
			}
			ps.close();
		}catch(SQLException e) {
			System.out.println("Error ao verificar usuários");
			System.out.println(e.getMessage());
		}
		return false;
	}

}