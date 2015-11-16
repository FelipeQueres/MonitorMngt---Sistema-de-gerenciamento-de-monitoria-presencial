package controle;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import dominio.AtividadeRealizada;

@ManagedBean(name = "AtvReMB")
public class AtividadesRealizadasMB {
	private AtividadeRealizada            atividade;
	private ArrayList<AtividadeRealizada> atividades;

	@PostConstruct
	public void iniciar() {
		this.atividades = new ArrayList<AtividadeRealizada>();

		AtividadeRealizada atividade = new AtividadeRealizada();
		atividade.setNome("Coleta de margaridas");
		atividade.setData(new Date());
		atividade.setObjetivo("Colher margaridas");
		atividade.setLocal("Jardins Suspensos da Babilônia");
		atividade
				.setAtividadesRealizadas("Colhemos flores.\nComemos frutas\n e registramos dados.");
		this.atividades.add(atividade);
	}

	public AtividadeRealizada getAtividade() {
		return atividade;
	}

	public void setAtividade(AtividadeRealizada atividade) {
		this.atividade = atividade;
	}

	public ArrayList<AtividadeRealizada> getAtividades() {
		return atividades;
	}

	public void setAtividades(ArrayList<AtividadeRealizada> atividades) {
		this.atividades = atividades;
	}

	public String acaoAbrirInfo(AtividadeRealizada atividade) {
		this.atividade = atividade;
		return "atividadeRealizadaInfo";
	}

	public String acaoEditar(AtividadeRealizada atividade) {
		this.atividade = atividade;
		return "atividadeRealizadaEditar";
	}
}