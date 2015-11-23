package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import dominio.Funcionario;
import dominio.dao.FuncionarioDAO;

@ManagedBean
public class FuncionarioMB {
	private Funcionario funcionario = new Funcionario();
	private List<Funcionario> funcionarios = null;
	private FuncionarioDAO dao = new FuncionarioDAO();

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		if (this.funcionarios == null)
			this.funcionarios = dao.lerTodos();
		return this.funcionarios;
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

	public String salvar() {
		if ((this.getFuncionario().getId() != null)
				&& (this.getFuncionario().getId().longValue() == 0))
			this.getFuncionario().setId(null);

		this.dao.salvar(this.getFuncionario());
		this.setFuncionario(new Funcionario());
		this.funcionarios = null;

		return "funcionarios";
	}

	public String excluir(Funcionario funcionario) {
		this.dao.excluir(funcionario);
		return "funcionarios";
	}

}
