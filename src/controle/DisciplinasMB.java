package controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import dominio.Disciplina;

@ManagedBean(name = "disciplinaMB")
public class DisciplinasMB {
	private List<Disciplina> disciplinas;

	@PostConstruct
	public void iniciar() {
		this.disciplinas = new ArrayList<Disciplina>();
		Disciplina disciplina = new Disciplina("FDP II", 23);
		this.disciplinas.add(disciplina);
	}

	public List<Disciplina> getDisciplinas() {
		return this.disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

}
