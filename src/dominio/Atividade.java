package dominio;

import java.util.Date;

public class Atividade {
	private String nome;
	private String[] alunos;
	private String descricao;
	private Date data;

	public String getData() {
		return data.toString();
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String[] getAlunos() {
		return alunos;
	}

	public void setAlunos(String[] alunos) {
		this.alunos = alunos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
