package dominio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TermoDeCompromisso {
	private String nomeAluno;
	private int matricula;
	private String curso;
	private String disciplina;
	private String email;
	private String campus;
	private double cr;
	private int fase;
	private String localMonitoria;
	private int semestre;
	private String per�odoDuracao; // pensar no tipo de dado
	private String responsavel;
	private String atividades;
	private String infoAdicional;
	private Date dataEntrega;

	public TermoDeCompromisso(String nomeAluno, int matricula, String curso,
			String disciplina, String email, String campus, double cr,
			int fase, String localMonitoria, int semestre,
			String per�odoDuracao, String responsavel, String atividades,
			String infoAdicional, Date dataEntrega) {
		super();
		this.nomeAluno = nomeAluno;
		this.matricula = matricula;
		this.curso = curso;
		this.disciplina = disciplina;
		this.email = email;
		this.campus = campus;
		this.cr = cr;
		this.fase = fase;
		this.localMonitoria = localMonitoria;
		this.semestre = semestre;
		this.per�odoDuracao = per�odoDuracao;
		this.responsavel = responsavel;
		this.atividades = atividades;
		this.infoAdicional = infoAdicional;
		this.dataEntrega = dataEntrega;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public double getCr() {
		return cr;
	}

	public void setCr(double cr) {
		this.cr = cr;
	}

	public int getFase() {
		return fase;
	}

	public void setFase(int fase) {
		this.fase = fase;
	}

	public String getLocalMonitoria() {
		return localMonitoria;
	}

	public void setLocalMonitoria(String localMonitoria) {
		this.localMonitoria = localMonitoria;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public String getPer�odoDuracao() {
		return per�odoDuracao;
	}

	public void setPer�odoDuracao(String per�odoDuracao) {
		this.per�odoDuracao = per�odoDuracao;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getAtividades() {
		return atividades;
	}

	public void setAtividades(String atividades) {
		this.atividades = atividades;
	}

	public String getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public Date getDateEntrega() {
		return dataEntrega;
	}
	
	public String getDataEntrega(){
		SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
		return sdt.format(this.dataEntrega);
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
}
