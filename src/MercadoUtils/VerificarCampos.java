package MercadoUtils;

public class VerificarCampos {
	
	public boolean verificarCampos(String nome, String cpf, String email, String telefone, String login, String senha) { // M�TODO PARA VERIFICAR OS CAMPOS
		
		if(nome.equals(null) || login.length() == 0) { // VERIFICAR SE O LOGIN EST� EM BRANCO
			return false;
		}
		if(cpf.equals(null) || cpf.length() == 0) { // VERIFICAR SE A SENHA EST� EM BRANCO
			return false;
		}
		if(email.equals(null) || email.length() == 0) {
			return false;
		}
		if(login.equals(null) || login.length() == 0) {
			return false;
		}
		if(telefone.equals(null) || telefone.length() == 0) {
			return false;
		}
		for(int i = 0; i < telefone.length(); i++) { // VERIFICAR SE APENAS TEM N�MEROS NA VARIAVEL
			if(!Character.isDigit(telefone.charAt(i))) {
				return false;
			}
		}
		if(senha.equals(null) || senha.length() == 0) {
			return false;
		}
		for(int i = 0; i < senha.length(); i++) { // VERIFICAR SE APENAS TEM N�MEROS NA VARIAVEL
			if(!Character.isDigit(senha.charAt(i))) {
				return false;
			}
		}
		
		return true; // RETORNA TRUE SE N�O TIVER EM BRANCO E SE TELEFONE E SENHA TIVEREM APENAS N�MEROS
	}
		
	public boolean verificarCamposCliente(String nome, String cpf, String email, String telefone) { // M�TODO PARA VERIFICAR OS CAMPOS
		
		if(nome.equals(null) || nome.length() == 0) { // VERIFICAR SE O LOGIN EST� EM BRANCO
			return false;
		}
		if(cpf.equals(null) || cpf.length() == 0) { // VERIFICAR SE A SENHA EST� EM BRANCO
			return false;
		}
		if(email.equals(null) || email.length() == 0) {
			return false;
		}
		if(telefone.equals(null) || telefone.length() == 0) {
			return false;
		}
		for(int i = 0; i < telefone.length(); i++) { // VERIFICAR SE APENAS TEM N�MEROS NA VARIAVEL
			if(!Character.isDigit(telefone.charAt(i))) {
				return false;
			}
		}
		
		return true; // RETORNA TRUE SE N�O TIVER EM BRANCO E SE TELEFONE E SENHA TIVEREM APENAS N�MEROS
	}
}
