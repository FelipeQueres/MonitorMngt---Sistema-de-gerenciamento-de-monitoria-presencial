package dominio;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Professores")
public class Professor extends Pessoa {

	private int matricula;
	private String escola;

	public Professor() {
		super();
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getEscola() {
		return escola;
	}

	public void setEscola(String escola) {
		this.escola = escola;
	}
}