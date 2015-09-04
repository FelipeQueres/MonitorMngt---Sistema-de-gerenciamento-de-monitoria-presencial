package controle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class CheckboxView {

	private String[] alunosSelecionados;
	private List<String> alunos;

	@PostConstruct
	public void iniciar() {
		alunos = new ArrayList<String>();

		alunos.add("Rodrigo");
		alunos.add("Cheila");
		alunos.add("Penha");
		alunos.add("Ceasar");
		alunos.add("Ben");
		alunos.add("Mark");
		alunos.add("Julia");
		alunos.add("Samuel");

		Collections.sort(alunos);
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

	public void setAlunos(List<String> alunos) {
		this.alunos = alunos;
	}

}
