package MercadoUtils;

public class UsuarioDaAplicacao extends Pessoa{
    private String login;
    private int senha;
    private String tipoUsuario;
    
    
    public UsuarioDaAplicacao() {
	super();
 }
    public UsuarioDaAplicacao(String nome, String cpf, int telefone, String email,String login, int senha) {
   	super(nome,cpf,telefone,email);
   	this.login = login;
   	this.senha = senha;
       }
    public UsuarioDaAplicacao(String nome, String cpf, int telefone, String email,String login, int senha, String tipoUsuario) {
	super(nome,cpf,telefone,email);
	this.login = login;
	this.senha = senha;
	this.tipoUsuario = tipoUsuario;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public int getSenha() {
        return senha;
    }
    public void setSenha(int senha) {
        this.senha = senha;
    }
    public String getTipoUsuario() {
        return tipoUsuario;
    }
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    

}
