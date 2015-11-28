package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dominio.Usuario;

@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginMB {
	private boolean autenticado = false;
	private Usuario usuario = null;

	private String login;
	private String senha;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isAutenticado() {
		return autenticado;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * 
	 */
	public String acaoAbrirLogin() {
		return "login";
	}

	/**
	 * 
	 */
	public String acaoAutenticar() {
		return "";
	}

	/**
	 * 
	 */
	public String acaoLogout() {
		return "";
	}

}
