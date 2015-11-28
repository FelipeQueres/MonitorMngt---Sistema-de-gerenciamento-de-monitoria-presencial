package dominio;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Funcionarios")
public class Funcionario extends Pessoa {

	private String telefone;
	private String cpf;
	private String funcao;
	private String adm;

	public Funcionario() {
		super();
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getAdm() {
		return adm;
	}

	public void setAdm(String adm) {
		this.adm = adm;
	}

}
