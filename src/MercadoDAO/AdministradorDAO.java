package MercadoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import MercadoUtils.ConnectionFactory;
import MercadoUtils.Usuario;
import MercadoUtils.Administrador;

public class AdministradorDAO {
	

	public void inserir(Administrador a) {
		PreparedStatement ps = null;
		String sql = "insert into administrador (nome, cpf, email, telefone, login, senha) values(?,?,?,?,?,?)";
		try(Connection conn = new ConnectionFactory().getConnection()) {
			ps = conn.prepareStatement(sql);
			ps.setString(1, a.getNome());
			ps.setString(2, a.getCpf());
			ps.setString(3, a.getEmail());
			ps.setInt(4, a.getTelefone());
			ps.setString(5, a.getLogin());
			ps.setInt(6, a.getSenha());
			ps.execute();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error ao inserir um Administrador no banco!");
		}
		
	}

	public void deletar(Administrador a) {
		PreparedStatement ps = null;
		String sql = "delete from administrador where cpf = ?";
		try(Connection conn = new ConnectionFactory().getConnection()){
			ps = conn.prepareStatement(sql);
			ps.setString(1, a.getCpf());
			ps.execute();
			ps.close();
		}catch (SQLException e) {
			System.out.println("Error ao deletar uma Administrador");
			System.out.println(e.getMessage());
		}
		
	}
	
	public ArrayList<Administrador> listar(){
		ArrayList<Administrador> administrador = new ArrayList<>();
		String sql = "select * from administrador";
		PreparedStatement ps = null;
		try(Connection conn = new ConnectionFactory().getConnection()){
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Administrador a = new Administrador();
				a.setNome(rs.getString("nome"));
				a.setCpf(rs.getString("cpf"));
				a.setEmail(rs.getString("email"));
				a.setTelefone(rs.getInt("telefone"));
				a.setLogin(rs.getString("login"));
				a.setSenha(rs.getInt("senha"));
				administrador.add(a);
			}
			ps.close();
		}catch(SQLException e) {
			System.out.println("Error ao listar Administrador");
			System.out.println(e.getMessage());
		}
		return administrador;
	}

	public void alterar(Administrador a, String cpf) {
		PreparedStatement ps = null;
		String sql = "update administrador set nome=?, cpf=?, email=?, telefone=?, login=?, senha=? where cpf=?";
		try(Connection conn = new ConnectionFactory().getConnection()){
			ps = conn.prepareStatement(sql);
			ps.setString(1, a.getNome());
			ps.setString(2, a.getCpf());
			ps.setString(3, a.getEmail());
			ps.setInt(4, a.getTelefone());
			ps.setString(5, a.getLogin());
			ps.setInt(6, a.getSenha());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error ao alterar a tabela Administrador!");
			System.out.println(e.getMessage());
		}

	}
	
	public boolean verificarLogin(String login, int senha) {
		String sql = "select * from administrador";
		PreparedStatement ps = null;
		try(Connection conn = new ConnectionFactory().getConnection()){
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if (rs.getString("login").equals(login)) {
					if(rs.getInt("senha") == senha) {
						return true;
					}
				}
			}
			ps.close();
		}catch(SQLException e) {
			System.out.println("Error ao verificar administrador");
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean verificarCPF(String cpf) {
		String sql = "select * from administrador";
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
			System.out.println("Error ao verificar administrador");
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public Usuario pegarDados(String cpf) {
		String sql = "select * from administrador";
		Usuario us = new Usuario();
		PreparedStatement ps = null;
		try(Connection conn = new ConnectionFactory().getConnection()){
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if (rs.getString("cpf").equals(cpf)) {
					us.setNome(rs.getString("nome"));
					us.setCpf(rs.getString("cpf"));
					us.setEmail(rs.getString("email"));
					us.setTelefone(rs.getInt("telefone"));
					us.setLogin(rs.getString("login"));
					us.setSenha(rs.getInt("senha"));
					
				}
			}
			ps.close();
		}catch(SQLException e) {
			System.out.println("Error ao verificar administrador");
			System.out.println(e.getMessage());
		}
		return us;
	}
}

