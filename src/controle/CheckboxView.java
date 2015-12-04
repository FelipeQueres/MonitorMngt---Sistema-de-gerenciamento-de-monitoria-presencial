package controle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "check")
public class CheckboxView {

	private String[] alunosSelecionados;
	private List<String> alunos;
	private ArrayList<String> escolas;

	@PostConstruct
	public void iniciar() {
		this.alunos = new ArrayList<String>();
		this.escolas = new ArrayList<String>();

		this.escolas.add("Ci�ncias da Sa�de");
		this.escolas.add("Ci�ncias Sociais e Aplicadas");
		this.escolas.add("Educa��o");
		this.escolas.add("Ci�ncias");
		this.escolas.add("Letras");
		this.escolas.add("Artes e Humanidades");
		this.escolas.add("Ci�ncias e Tecnologia");

		alunos.add("Rodrigo");
		alunos.add("Cheila");
		alunos.add("Penha");
		alunos.add("Ceasar");
		alunos.add("Ben");
		alunos.add("Mark");
		alunos.add("Julia");
		alunos.add("Samuel");

		Collections.sort(this.alunos);
	}

	public ArrayList<String> getEscolas() {
		return escolas;
	}

	public void setEscolas(ArrayList<String> escolas) {
		this.escolas = escolas;
	}

	public String[] getAlunosSelecionados() {
		return alunosSelecionados;
	}

	public void setAlunosSelecionados(String[] alunosSelecionados) {
		this.alunosSelecionados = alunosSelecionados;
	}

	public List<String> getAlunos() {
		return alunos;
	}

	public String getAlunosToString() {
		return this.alunos.toString();
	}

	public void setAlunos(List<String> alunos) {
		this.alunos = alunos;
	}

}
