package controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import dominio.Disciplina;
import dominio.Edital;

@ManagedBean(name = "editalMB")
public class EditaisMB {
	private List<Edital> editais;
	private Edital edital;

	@PostConstruct
	public void iniciar() {
		this.editais = new ArrayList<Edital>();
		Edital edital1 = new Edital(), edital2 = new Edital();

		edital1.setNumero(332);
		edital1.setEscola("Sa�de");
		edital1.setCurso("Medicina");
		edital1.setPeriodoLetivo("1� semestre");
		edital1.setDisciplinas("Biologia Marinha", 13);
		edital1.setInicioInscricao(new Date());
		edital1.setFimInscricao(new Date());
		edital1.setInicioAtividade(new Date());
		edital1.setFimAtividade(new Date());
		edital1.setConteudo("blaalksnfrklasfsnanlak");
		edital1.setBibliografia("A lot of books!");
		
		edital2.setNumero(3513);
		edital2.setEscola("Ci�ncia e Tecnologia");
		edital2.setCurso("Engenharia de Petr�leo e G�s");
		edital2.setPeriodoLetivo("2� semestre");

		edital = new Edital();

		this.editais.add(edital1);
		this.editais.add(edital2);
	}

	public List<Edital> getEditais() {
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

	public boolean isNotDisciplinaEmpity(Edital edital) {
		return !edital.getDisciplinas().isEmpty();
	}
	
	public boolean isNotDisciplinaEmpity() {
		return !this.edital.getDisciplinas().isEmpty();
	}

}