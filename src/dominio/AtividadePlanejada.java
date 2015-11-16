package dominio;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AtvPLanejada")
public class AtividadePlanejada {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	private String[] alunos;
	private String descricao;
	private Date data;
	private String local;

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getData() {
		SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
		return sdt.format(this.data);
	}

	public Date getDate() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAlunos() {
		return alunos.toString();
	}

	public void setAlunos(String[] alunos) {
		this.alunos = alunos;
	}

	public String getAlunosToString() {
		return this.alunos.toString();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	
	public String toString() {
		if (this.alunos == null || this.alunos.length == 0)
			return "";
		StringBuilder sbAluno = new StringBuilder();
		for (String aluno : this.alunos) {
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
}
