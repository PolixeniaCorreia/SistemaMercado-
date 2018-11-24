package MercadoDAO; // USUÁRIO == VENDEDOR //

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import MercadoUtils.ConnectionFactory;
import MercadoUtils.TipoUsuario;
import MercadoUtils.Usuario;

public class UsuarioDAO {

    public void inserir(Usuario u) {
	Connection conn = null;
	PreparedStatement ps = null;
	String sql = "insert into usuario (nome, cpf, email, telefone, login, senha) values(?,?,?,?,?,?)";
	try {
	    conn = new ConnectionFactory().getConnection();
	    ps = conn.prepareStatement(sql);
	    ps.setString(1, u.getNome());
	    ps.setString(2, u.getCpf());
	    ps.setString(3, u.getEmail());
	    ps.setInt(4, u.getTelefone());
	    ps.setString(5, u.getLogin());
	    ps.setInt(6, u.getSenha());
	    ps.execute();
	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	    System.out.println("Error ao inserir um usuário no banco!");
	} finally {
	    try {
		ps.close();
		conn.close();
	    } catch (SQLException e) {
		System.out.println(e.getMessage());
		System.out.println("Error ao fechar o banco para usuário!");
	    }
	}
    }

    public ArrayList<Usuario> listar() {
	ArrayList<Usuario> usuarios = new ArrayList<>();
	String sql = "select * from usuario";
	PreparedStatement ps = null;
	try (Connection conn = new ConnectionFactory().getConnection()) {
	    ps = conn.prepareStatement(sql);
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
		Usuario u = new Usuario();
		u.setNome(rs.getString("nome"));
		u.setCpf(rs.getString("cpf"));
		u.setEmail(rs.getString("email"));
		u.setTelefone(rs.getInt("telefone"));
		u.setLogin(rs.getString("login"));
		u.setSenha(rs.getInt("senha"));
		usuarios.add(u);
	    }
	    ps.close();
	} catch (SQLException e) {
	    System.out.println("Error ao listar usuários");
	    System.out.println(e.getMessage());
	}
	return usuarios;
    }

    public boolean verificarLogin(String login, int senha) {
	String sql = "select * from usuario";
	PreparedStatement ps = null;
	try (Connection conn = new ConnectionFactory().getConnection()) {
	    ps = conn.prepareStatement(sql);
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
		if (rs.getString("login").equals(login)) {
		    if (rs.getInt("senha") == senha) {
			return true;
		    }
		}
	    }
	    ps.close();
	} catch (SQLException e) {
	    System.out.println("Error ao verificar usuários");
	    System.out.println(e.getMessage());
	}
	return false;
    }

    public Usuario fazLogin(String login, int senha) {
	Usuario usuario = new Usuario();
	String sql = "select * from usuario";
	PreparedStatement ps = null;
	try (Connection conn = new ConnectionFactory().getConnection()) {
	    ps = conn.prepareStatement(sql);
	    ResultSet rs = ps.executeQuery();
	    // se existe
	    while (rs.next()) {
		// se esta correta
		if (rs.getString("login").equals(login) && (rs.getInt("senha") == senha)) {
		    usuario.setNome(rs.getString("nome"));
		    usuario.setCpf(rs.getString("cpf"));
		    usuario.setEmail(rs.getString("email"));
		    usuario.setTelefone(rs.getInt("telefone"));
		    usuario.setLogin(rs.getString("login"));
		    usuario.setSenha(rs.getInt("senha"));
		    usuario.setTipoUsuario(rs.getString("tipo"));
		}
	    }
	    ps.close();
    }catch(

    SQLException e)
    {
	System.out.println("Error ao verificar usuários");
	System.out.println(e.getMessage());
    }return usuario;
    }

    public boolean verificarCPF(String cpf) {
	String sql = "select * from usuario";
	PreparedStatement ps = null;
	try (Connection conn = new ConnectionFactory().getConnection()) {
	    ps = conn.prepareStatement(sql);
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
		if (rs.getString("cpf").equals(cpf)) {
		    return true;
		}
	    }
	    ps.close();
	} catch (SQLException e) {
	    System.out.println("Error ao verificar usuários");
	    System.out.println(e.getMessage());
	}
	return false;
    }

    public Usuario pegarDados(String cpf) {
	String sql = "select * from usuario";
	Usuario usuario = new Usuario();
	PreparedStatement ps = null;
	try (Connection conn = new ConnectionFactory().getConnection()) {
	    ps = conn.prepareStatement(sql);
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
		if (rs.getString("cpf").equals(cpf)) {
		    usuario.setNome(rs.getString("nome"));
		    usuario.setCpf(rs.getString("cpf"));
		    usuario.setEmail(rs.getString("email"));
		    usuario.setTelefone(rs.getInt("telefone"));
		    usuario.setLogin(rs.getString("login"));
		    usuario.setSenha(rs.getInt("senha"));
		}
	    }
	    ps.close();
	} catch (SQLException e) {
	    System.out.println("Error ao verificar usuarios");
	    System.out.println(e.getMessage());
	}
	return usuario;
    }

    public void alterar(Usuario v, String cpf) {
	PreparedStatement ps = null;
	String sql = "update usuario set nome=?, cpf=?, email=?, telefone=?, login=?, senha=? where cpf=?";
	try (Connection conn = new ConnectionFactory().getConnection()) {
	    ps = conn.prepareStatement(sql);
	    ps.setString(1, v.getNome());
	    ps.setString(2, v.getCpf());
	    ps.setString(3, v.getEmail());
	    ps.setInt(4, v.getTelefone());
	    ps.setString(5, v.getLogin());
	    ps.setInt(6, v.getSenha());
	    ps.setString(7, cpf);
	    ps.execute();
	} catch (SQLException e) {
	    System.out.println("Error ao alterar a tabela usuário!");
	    System.out.println(e.getMessage());
	}
    }

    public void deletar(Usuario v) {
	PreparedStatement ps = null;
	String sql = "delete from usuario where cpf = ?";
	try (Connection conn = new ConnectionFactory().getConnection()) {
	    ps = conn.prepareStatement(sql);
	    ps.setString(1, v.getCpf());
	    ps.execute();
	    ps.close();
	} catch (SQLException e) {
	    System.out.println("Error ao deletar uma usuário");
	    System.out.println(e.getMessage());
	}

    }

}