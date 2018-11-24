package MercadoDAO;

import java.sql.SQLException;
import java.util.ArrayList;

import MercadoUtils.Pessoa;

public interface InterfacePessoaDAO {
	
	void inserir(Pessoa p) throws SQLException;
	void deletar(Pessoa p);
	ArrayList<Pessoa> listar();
	void alterar(Pessoa p, String cpf);

}
