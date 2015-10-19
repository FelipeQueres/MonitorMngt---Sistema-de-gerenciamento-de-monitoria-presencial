package controle;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import dominio.TermoDeCompromisso;

@ManagedBean(name = "termoMB")
public class TermoDeCompromissoMB {
	private ArrayList<TermoDeCompromisso> termos;
	private TermoDeCompromisso termo;

	@PostConstruct
	public void iniciar() {
		this.termos = new ArrayList<TermoDeCompromisso>();
		this.termo = new TermoDeCompromisso("Lucas Laranja", 43546587,
				"Eng. de Produ��o", "C�lculo 2", "Lukinha_k@me.com",
				"Santa Cruz da Serra", 7.6, 4, "SuperVia", 2, "seis meses",
				"Ana Laura", "Umas paradas a�", "N�o h�", new Date());
		this.termos.add(termo);
	}

	public ArrayList<TermoDeCompromisso> getTermos() {
		return termos;
	}

	public void setTermos(ArrayList<TermoDeCompromisso> termos) {
		this.termos = termos;
	}

	public TermoDeCompromisso getTermo() {
		return termo;
	}

	public void setTermo(TermoDeCompromisso termo) {
		this.termo = termo;
	}
}
