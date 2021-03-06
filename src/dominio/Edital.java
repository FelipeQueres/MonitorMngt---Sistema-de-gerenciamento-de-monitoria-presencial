package dominio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Editais")
public class Edital {

	@Id
	@GeneratedValue
	private Long id;

	private int numero;
	private String escola;
	private String curso;

	@OneToMany(mappedBy = "edital", cascade=CascadeType.ALL)
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();// TODO anota��o

	private String periodoLetivo;
	private Date inicioInscricao;
	private Date fimInscricao;
	private Date inicioAtividade;
	private Date fimAtividade;
	private String conteudo;
	private String bibliografia;

	// public Edital() {
	// this.disciplinas = new ArrayList<Disciplina>();
	// }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getEscola() {
		return escola;
	}

	public void setEscola(String escola) {
		this.escola = escola;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void addDisciplina(String nome, int numVagas) {
		this.disciplinas.add(new Disciplina(nome, numVagas));
	}

	public void addDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}

	public String getPeriodoLetivo() {
		return periodoLetivo;
	}

	public void setPeriodoLetivo(String periodoLetivo) {
		this.periodoLetivo = periodoLetivo;
	}

	public Date getInicioInscricao() {
		return inicioInscricao;
	}

	public void setInicioInscricao(Date inicioInscricao) {
		this.inicioInscricao = inicioInscricao;
	}

	public Date getFimInscricao() {
		return fimInscricao;
	}

	public void setFimInscricao(Date fimInscricao) {
		this.fimInscricao = fimInscricao;
	}

	public Date getInicioAtividade() {
		return inicioAtividade;
	}

	public void setInicioAtividade(Date inicioAtividade) {
		this.inicioAtividade = inicioAtividade;
	}

	public Date getFimAtividade() {
		return fimAtividade;
	}

	public void setFimAtividade(Date fimAtividade) {
		this.fimAtividade = fimAtividade;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getBibliografia() {
		return bibliografia;
	}

	public void setBibliografia(String bibliografia) {
		this.bibliografia = bibliografia;
	}

	public String getPeriodoInscricao() {
		if (this.inicioInscricao == null)
			return "";

		SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");

		return sdt.format(this.inicioInscricao).toString() + " at� "
				+ sdt.format(this.fimInscricao).toString();
	}

	public String getPeriodoAtividade() {
		if (this.inicioAtividade == null)
			return "";

		SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");

		return sdt.format(this.inicioAtividade) + " at� "
				+ sdt.format(this.fimAtividade);
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public String toString() {
		return this.numero + " - " + this.curso;
	}
}