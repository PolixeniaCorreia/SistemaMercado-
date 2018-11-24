package MercadoUtils;

public class Administrador extends UsuarioDaAplicacao {

    public Administrador() {
	super();
    }
    public Administrador(String nome, String cpf, int telefone, String email, String login, int senha) {
	super(nome, cpf, telefone, email, login, senha);

    }


    public Administrador(String nome, String cpf, int telefone, String email, String login, int senha,
	    String tipoUsuario) {
	super(nome, cpf, telefone, email, login, senha, tipoUsuario);

    }

}
