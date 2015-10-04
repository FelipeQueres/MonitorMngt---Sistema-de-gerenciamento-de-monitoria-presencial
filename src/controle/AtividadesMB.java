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
	private Atividade atividade;

	@PostConstruct
	public void iniciar() {
		this.atividades = new ArrayList<Atividade>();
		this.atividade = new Atividade();
		Date data = new Date();

		Atividade atividade = new Atividade(),
		          atividade1 = new Atividade();
		
		atividade.setNome("Oficina de Programação");
		atividade.setDescricao("Desenvolver softwares");
		atividade.setData(data);
		
		atividade1.setNome("Oficina de UML");
		atividade1.setDescricao("Aprender UML");
		atividade1.setData(data);

		this.atividades.add(atividade);
		this.atividades.add(atividade1);
	}

	public List<Atividade> getAtividades() {
		return this.atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}
	

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
	public String acaoAbrirInfo(Atividade atividade){
		this.atividade = atividade;

		return "atividadesInfo";
	}
	
	public String acaoEditar(Atividade atividade){
		this.atividade=atividade;
		return "atividadeEditar";
	}
}
