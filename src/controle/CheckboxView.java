package controle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="check")
public class CheckboxView {

	private String[] alunosSelecionados;
	private List<String> alunos;
	private ArrayList<String> escolas;

	@PostConstruct
	public void iniciar() {
		this.alunos = new ArrayList<String>();
		this.escolas = new ArrayList<String>();

		this.escolas.add("Ciência e Tecnologia");
		this.escolas.add("Humanas");
		this.escolas.add("Saúde");
		this.escolas.add("Ciência e Tecnologia");
		
		alunos.add("Rodrigo");
		alunos.add("Cheila");
		alunos.add("Penha");
		alunos.add("Ceasar");
		alunos.add("Ben");
		alunos.add("Mark");
		alunos.add("Julia");
		alunos.add("Samuel");

		Collections.sort(this.alunos);
		Collections.sort(this.escolas);
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
