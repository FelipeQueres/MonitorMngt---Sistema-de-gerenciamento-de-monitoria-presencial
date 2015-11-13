package dominio;

public class Disciplina {
	private String nome;
	private int quantidadeVagas;

	public Disciplina(String nome, int numVagas) {
		this.nome = nome;
		this.quantidadeVagas = numVagas;
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
