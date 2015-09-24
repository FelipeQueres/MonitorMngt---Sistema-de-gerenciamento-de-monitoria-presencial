package controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import dominio.Atividade;

@ManagedBean(name = "AtvMB")
public class AtividadesMB {

	private List<Atividade> atividades;

	@PostConstruct
	public void iniciar() {
		atividades = new ArrayList<Atividade>();

		Atividade atividade = new Atividade();
		atividade.setNome("Oficina de Programação");
		atividade.setDescricao("Desenvolver softwares");

		Date data = new Date();
		
		atividade.setData(data);

		this.atividades.add(atividade);
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public String getNomeAtv() {
		return atividades.get(0).getNome();
	}

	public String getDescAtv() {
		return atividades.get(0).getDescricao();
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	public String getDatacAtv() {
		return atividades.get(0).getData();
	}
}
