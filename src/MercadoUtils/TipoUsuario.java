package MercadoUtils;

public enum TipoUsuario {  // NAO ESTAMOS USANDO ENUM E SIM STRING.

    USUARIO("USUARIO"),
    ADMIN("ADMIN"),
    CLIENTE("CLIENTE");
 
    private String descricao;
 
    TipoUsuario(String descricao) {
        this.descricao = descricao;
    }
 
    public String getDescricao() {
        return descricao;
    }    
}
