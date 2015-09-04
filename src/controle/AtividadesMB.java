package controle;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;


@ManagedBean
public class AtividadesMB {
	private String nome;
	private String[] alunos;
	private String descricao;
	
	@PostConstruct
	public void iniciar(){
		this.nome = "Atividade 1";
//		this.data = new Date();
//		this.alunos[0] = "Amanda";
		this.descricao = "Aprender a cortar um cadáver";
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
//	public Date getData() {
//		return data;
//	}
//	public void setData(Date data) {
//		this.data = data;
//	}
	public String[] getAlunos() {
		return alunos;
	}
	public void setAlunos(String[] alunos) {
		this.alunos = alunos;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
