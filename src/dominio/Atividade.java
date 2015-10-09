package dominio;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Atividade {
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

	public String[] getAlunos() {
		return alunos;
	}

	public void setAlunos(String[] alunos) {
		this.alunos = alunos;
	}
	
	public String getAlunosToString(){
		return this.alunos.toString();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
