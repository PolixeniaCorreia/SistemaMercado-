package MercadoUtils;

public class Usuario extends UsuarioDaAplicacao {


    public Usuario() {
	super();
    }

    public Usuario(String nome, String cpf, int telefone, String email,String login, int senha, String tipoUsuario) {
	super(nome, cpf, telefone, email,login,senha,tipoUsuario);
    }

}
