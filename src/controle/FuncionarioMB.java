package controle;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import dominio.Funcionario;
import dominio.Professor;

@ManagedBean
public class FuncionarioMB {
	private Funcionario funcionario;
	private ArrayList<Funcionario> funcionarios;

	@PostConstruct
	public void iniciar() {
		this.funcionarios = new ArrayList<Funcionario>();
		this.funcionario = new Funcionario();

		Funcionario f = new Funcionario();
		f.setNome("Suellen");
		f.setCpf("2305972305");
		f.setFuncao("Auxiliar Administrativo");
		f.setTelefone("2676-983");
		f.setEmail("su_elen@gmail.com");

		this.funcionarios.add(f);
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public String acaoInfo(Funcionario funcionario) {
		this.funcionario = funcionario;
		return "funcionarioInfo";
	}

	public String acaoEditar(Funcionario funcionario) {
		this.funcionario = funcionario;
		return "funcionarioEditar";
	}

}
