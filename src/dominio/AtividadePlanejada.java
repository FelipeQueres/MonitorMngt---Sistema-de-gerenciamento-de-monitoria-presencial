package dominio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AtvPLanejada")
public class AtividadePlanejada {

	@Id
	@GeneratedValue
	private Long id;

	private String nome;
	private String[] alunosString;
	private String descricao;
	private Date data;
	private String local;

	@OneToMany(mappedBy = "AtvPLanejada")
	private List<Aluno> alunos;

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getDataString() {
		SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
		return sdt.format(this.data);
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date date) {
		this.data = date;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Aluno> getAlunos() {
		return this.alunos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String toString() {
		if (this.alunos == null || this.alunosString.length == 0)
			return "";
		StringBuilder sbAluno = new StringBuilder();
		for (String aluno : this.alunosString) {
			sbAluno.append(aluno + ", ");
		}
		sbAluno.reverse();
		sbAluno.replace(0, 2, ".");
		sbAluno.reverse();
		String retorno = sbAluno.toString();
		return retorno;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String[] getAlunosString() {
		return alunosString;
	}

	public void setAlunosString(String[] alunosString) {
		this.alunosString = alunosString;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
}
