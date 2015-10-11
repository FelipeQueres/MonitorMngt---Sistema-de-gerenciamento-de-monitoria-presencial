package controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import dominio.Aluno;

@ManagedBean(name="alunoMB")
public class AlunoMB {
	private Aluno aluno;
	private ArrayList<Aluno> alunos;

	@PostConstruct
	public void inicia() {
		this.alunos = new ArrayList<Aluno>();

		Aluno a = new Aluno(), b = new Aluno();

		a.setNome("Pablo Gonçalves");
		a.setCurso("Biologia");
		a.setEmail("p.j@hotmail.com");
		a.setMatricula(326545);
		a.setRg("24659457-5");
		a.setDisciplina("Fisiopatia");
		

		b.setNome("Joana Pacheco");
		b.setCurso("Arquitetura e urbanismo");
		b.setEmail("jp_@gmail.com");
		b.setMatricula(64321231);
		b.setRg("1321321-5");
		b.setDisciplina("Projeção de sei lá");

		this.alunos.add(a);
		this.alunos.add(b);
		
		this.aluno = new Aluno();

	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		return this.alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public String acaoEditar(Aluno aluno){
		this.aluno = aluno;
		return "manterAluno";
	}
	
	public String acaoInfo(Aluno aluno){
		this.aluno = aluno;
		return "infoAluno";
	}
	
}
