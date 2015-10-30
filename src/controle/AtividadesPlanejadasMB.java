package controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import dominio.AtividadePlanejada;

@ManagedBean(name = "AtvPlMB")
public class AtividadesPlanejadasMB {

	private List<AtividadePlanejada> atividades;
	private AtividadePlanejada atividade;

	@PostConstruct
	public void iniciar() {
		this.atividades = new ArrayList<AtividadePlanejada>();
		this.atividade = new AtividadePlanejada();
		Date data = new Date();

		AtividadePlanejada atividade = new AtividadePlanejada(), atividade1 = new AtividadePlanejada();

		atividade.setNome("Oficina de Programação");
		atividade.setDescricao("Desenvolver softwares");
		atividade.setData(data);
		atividade.setLocal("Lab B103");

		atividade1.setNome("Oficina de UML");
		atividade1.setDescricao("Aprender UML");
		atividade1.setData(data);
		atividade1.setLocal("Lab G103");

		this.atividades.add(atividade);
		this.atividades.add(atividade1);
	}

	public List<AtividadePlanejada> getAtividades() {
		return this.atividades;
	}

	public void setAtividades(List<AtividadePlanejada> atividades) {
		this.atividades = atividades;
	}

	public AtividadePlanejada getAtividade() {
		return atividade;
	}

	public void setAtividade(AtividadePlanejada atividade) {
		this.atividade = atividade;
	}

	public String acaoAbrirInfo(AtividadePlanejada atividade) {
		this.atividade = atividade;

		return "atividadesInfo";
	}

	public String acaoEditar(AtividadePlanejada atividade) {
		this.atividade = atividade;
		return "atividadeEditar";
	}

	public String acaoInfAtividade(AtividadePlanejada atividade) {
		this.atividade = atividade;
		return "informarAtividadeRealizada";
	}
}
