package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;

import dominio.Disciplina;
import dominio.dao.DisciplinaDAO;

@ManagedBean(name = "disciplinaMB")
public class DisciplinasMB {
	private List<Disciplina> disciplinas = null;
	private Disciplina disciplina = new Disciplina();
	private DisciplinaDAO dao = new DisciplinaDAO();

	public List<Disciplina> getDisciplinas() {
		return this.disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String salvar() {
		if ((this.getDisciplina().getId() != null)
				&& (this.getDisciplina().getId().longValue() == 0))
			this.getDisciplina().setId(null);

		this.dao.salvar(this.getDisciplina());
		this.setDisciplina(new Disciplina());
		this.disciplinas = null;

		return "adicionarDisciplina";
	}
}