package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import dominio.Professor;
import dominio.dao.ProfessorDAO;

@ManagedBean
public class ProfessorMB {
	private Professor professor = new Professor();
	private List<Professor> professores = null;
	private ProfessorDAO dao = new ProfessorDAO();

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Professor> getProfessores() {
		if (this.professores == null)
			this.professores = this.dao.lerTodos();

		return this.professores;
	}

	public void setProfessores(ArrayList<Professor> professores) {
		this.professores = professores;
	}

	public String acaoInfo(Professor professor) {
		this.professor = professor;
		return "professorInfo";
	}

	public String acaoEditar(Professor professor) {
		this.professor = professor;
		return "professorEditar";
	}

	public String salvar() {
		if ((this.getProfessor().getId() != null) && (this.getProfessor().getId().longValue() == 0))
			this.getProfessor().setId(null);

		this.dao.salvar(this.getProfessor());
		this.setProfessor(new Professor());
		this.professores = null;

		return "professores";
	}

	public String excluir(Professor professor) {
		this.dao.excluir(professor);
		return "professores";
	}
}
