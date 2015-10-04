package dominio;

public class Disciplina {
	private String nome;
	private int numVagas;

	public Disciplina(String nome, int numVagas) {
		this.nome = nome;
		this.numVagas = numVagas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumVagas() {
		return numVagas;
	}

	public void setNumVagas(int numVagas) {
		this.numVagas = numVagas;
	}

}
