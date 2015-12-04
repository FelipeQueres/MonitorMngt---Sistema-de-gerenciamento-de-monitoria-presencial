package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;

import dominio.Disciplina;
import dominio.Edital;
import dominio.dao.EditalDAO;

@ManagedBean(name = "editalMB")
public class EditalMB {
	private List<Edital> editais = null;
	private Edital edital = new Edital();

	private Disciplina disciplina = new Disciplina();

	private EditalDAO dao = new EditalDAO();

	// private Map<Integer, String> listaEdital;

	public List<Edital> getEditais() {
		if (this.editais == null)
			this.editais = dao.lerTodos();

		return this.editais;
	}

	public void setEditais(List<Edital> editais) {
		this.editais = editais;
	}

	public Edital getEdital() {
		return edital;
	}

	public void setEdital(Edital edital) {
		this.edital = edital;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String acaoAbrirInfo(Edital edital) {
		this.edital = edital;
		return "editalInfo";
	}

	public String acaoAbrirAlterar(Edital edital) {
		this.edital = edital;
		return "editalEditar";
	}

	public String acaoAddDisciplina(Edital edital) {
		this.edital = edital;
		return "adicionarDisciplina";
	}

	// public Map<Integer, String> getListaEdital() {
	// for (int i = 0; i < this.listaEdital.size(); i++) {
	// this.listaEdital.put(this.editais.get(i).getNumero(), this.editais
	// .get(i).getCurso());
	// }
	// return this.listaEdital;
	// }

	/**
	 * Usado para mostrar ou não opções de cada edital
	 * 
	 * @param edital
	 * @return sim se não houver nenhuma disciplina cadastrada no edital
	 *         corrente
	 */
	public boolean isNotDisciplinaEmpity(Edital edital) {
		return !(edital.getDisciplinas() == null || edital.getDisciplinas()
				.isEmpty());
	}

	// public boolean isNotDisciplinaEmpity() {
	// return !this.edital.getDisciplinas().isEmpty();
	// }

	public String salvar() {
		if ((this.getEdital().getId() != null)
				&& (this.getEdital().getId().longValue() == 0))
			this.getEdital().setId(null);

		this.dao.salvar(this.getEdital());
		this.setEdital(new Edital());
		this.editais = null;

		return "editais";
	}

	public String addDisciplina() {
		this.getEdital().addDisciplina(this.disciplina);

		this.dao.salvar(this.getEdital());
		this.setDisciplina(new Disciplina());

		return "adicionarDisciplina";
	}

	public String excluir(Edital edital) {
		this.dao.excluir(edital);
		return "editais";
	}
}