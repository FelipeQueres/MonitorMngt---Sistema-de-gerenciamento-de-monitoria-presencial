package dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Disciplina")
public class Disciplina {

	@Id
	@GeneratedValue
	private Long id;

	private String nome;
	private int quantidadeVagas;

	public Disciplina(String nome, int numVagas) {
		this.nome = nome;
		this.quantidadeVagas = numVagas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantidadeVagas() {
		return quantidadeVagas;
	}

	public void setQuantidadeVagas(int quantidadeVagas) {
		this.quantidadeVagas = quantidadeVagas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumVagas() {
		return quantidadeVagas;
	}

	public void setNumVagas(int numVagas) {
		this.quantidadeVagas = numVagas;
	}

}
