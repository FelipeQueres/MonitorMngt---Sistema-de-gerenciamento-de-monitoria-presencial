package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import dominio.Aluno;
import dominio.dao.AlunoDAO;

@ManagedBean(name = "alunoMB")
public class AlunoMB {
	private Aluno aluno = new Aluno();
	private List<Aluno> alunos = null;
	private AlunoDAO dao = new AlunoDAO();

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		if (this.alunos == null)
			this.alunos = this.dao.lerTodos();

		return this.alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public String acaoEditar(Aluno aluno) {
		this.aluno = aluno;
		return "manterAluno";
	}
	
	public String acaoInfo(Aluno aluno) {
		this.aluno = aluno;
		return "infoAluno";
	}

	@Override
	public String toString() {
		StringBuilder sbAluno = new StringBuilder();
		for (Aluno aluno : this.alunos) {
			sbAluno.append(aluno.getNome() + " - " + aluno.getMatricula()
					+ ". ");
		}
		return sbAluno.toString();
	}

	public String salvar() {
		if ((this.getAluno().getId() != null) && (this.getAluno().getId().longValue() == 0))
			this.getAluno().setId(null);

		this.dao.salvar(this.getAluno());
		this.setAluno(new Aluno());
		this.alunos = null;
		
		return "alunos";
	}

	public String excluir(Aluno aluno) {
		this.dao.excluir(aluno);
		return "alunos";
	}
}
