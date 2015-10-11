package dominio;

public class Aluno {

	private String nome;
	private int    matricula;
	private String curso;
	private String disciplina;
	private String rg;
	private String email;
//	private Edital edital;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public int getEdital() {
//		return edital.getNumero();
//	}
//
//	public void setEdital(int numero) {
//		this.edital.setNumero(numero);
//	}
}
