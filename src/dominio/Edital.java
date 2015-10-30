package dominio;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Edital {
	private int numero;
	private String escola;
	private String curso;
	private List<Disciplina> disciplinas;
	private String periodoLetivo;
	private Date inicioInscricao;
	private Date fimInscricao;
	private Date inicioAtividade;
	private Date fimAtividade;
	private String conteudo;
	private String bibliografia;

	public Edital() {
		this.disciplinas = new ArrayList<Disciplina>();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getEscola() {
		return escola;
	}

	public void setEscola(String escola) {
		this.escola = escola;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(String nome, int numVagas) {
		this.disciplinas.add(new Disciplina(nome, numVagas));
	}

	public String getPeriodoLetivo() {
		return periodoLetivo;
	}

	public void setPeriodoLetivo(String periodoLetivo) {
		this.periodoLetivo = periodoLetivo;
	}

	public Date getInicioInscricao() {
		return inicioInscricao;
	}

	public void setInicioInscricao(Date inicioInscricao) {
		this.inicioInscricao = inicioInscricao;
	}

	public Date getFimInscricao() {
		return fimInscricao;
	}

	public void setFimInscricao(Date fimInscricao) {
		this.fimInscricao = fimInscricao;
	}

	public Date getInicioAtividade() {
		return inicioAtividade;
	}

	public void setInicioAtividade(Date inicioAtividade) {
		this.inicioAtividade = inicioAtividade;
	}

	public Date getFimAtividade() {
		return fimAtividade;
	}

	public void setFimAtividade(Date fimAtividade) {
		this.fimAtividade = fimAtividade;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getBibliografia() {
		return bibliografia;
	}

	public void setBibliografia(String bibliografia) {
		this.bibliografia = bibliografia;
	}

	public String getPeriodoInscricao() {
		if (this.inicioInscricao == null)
			return "";

		SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");

		return sdt.format(this.inicioInscricao).toString() + " até "
				+ sdt.format(this.fimInscricao).toString();
	}

	public String getPeriodoAtividade() {
		if (this.inicioAtividade == null)
			return "";

		SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");

		return sdt.format(this.inicioAtividade) + " até "
				+ sdt.format(this.fimAtividade);
	}

	public String toString() {
		return this.numero + " - " + this.curso;
	}

	public void gerarPdf() {
		Document doc = new Document(PageSize.A4, 50, 50, 50, 50);
		try {
			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(
					"C:\\Users\\Aluno\\Desktop\\Edital"+this.numero+".pdf"));
			doc.open();

			doc.add(new Paragraph("Edital de Monitoria No" + numero + ".",
					FontFactory.getFont(FontFactory.HELVETICA, 10)));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			doc.close();
		}
	}
}