package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;

import dominio.AtividadePlanejada;
import dominio.dao.AtividadePlanejadaDAO;

@ManagedBean(name = "AtvPlMB")
public class AtividadesPlanejadasMB {

	private List<AtividadePlanejada> atividades = null;
	private AtividadePlanejada       atividade  = new AtividadePlanejada();
	private AtividadePlanejadaDAO    dao        = new AtividadePlanejadaDAO();

	public List<AtividadePlanejada> getAtividades() {
		if (this.atividades == null)
			this.atividades = dao.lerTodos();

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

	public String salvar() {
		if ((this.getAtividade().getId() != null) && (this.getAtividade().getId().longValue() == 0))
			this.getAtividade().setId(null);

		this.dao.salvar(this.getAtividade());
		this.setAtividade(new AtividadePlanejada());
		this.atividades = null;

		return "atividades";
	}

	public String excluir(AtividadePlanejada atividade) {
		this.dao.excluir(atividade);
		return "atividades";
	}
}
