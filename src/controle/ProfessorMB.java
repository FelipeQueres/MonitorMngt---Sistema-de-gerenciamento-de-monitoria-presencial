package controle;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import dominio.Professor;

@ManagedBean
public class ProfessorMB {
	private Professor professor;
	private ArrayList<Professor> professores;

	@PostConstruct
	public void iniciar() {
		this.professor = new Professor();
		
		this.professores = new ArrayList<Professor>();

		Professor p = new Professor();
		p.setNome("Marco Antônio");
		p.setEscola("Ciência e Tecnologia");
		p.setMatricula(235253);
		p.setEmail("marco.toni@me.com");
		
		this.professores.add(p);
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public ArrayList<Professor> getProfessores() {
		return professores;
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

}
