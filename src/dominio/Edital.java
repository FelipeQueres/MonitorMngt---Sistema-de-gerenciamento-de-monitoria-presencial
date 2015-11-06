package dominio;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.ListItem;
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

		return sdt.format(this.inicioInscricao).toString() + " at� "
				+ sdt.format(this.fimInscricao).toString();
	}

	public String getPeriodoAtividade() {
		if (this.inicioAtividade == null)
			return "";

		SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");

		return sdt.format(this.inicioAtividade) + " at� "
				+ sdt.format(this.fimAtividade);
	}

	public String toString() {
		return this.numero + " - " + this.curso;
	}

	public void gerarPdf() {
		Document doc = new Document(PageSize.A4, 50, 50, 50, 50);
		try {
			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(
					"C:\\Users\\JAVA\\Desktop\\Edital" + this.numero + ".pdf"));

			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse) context
					.getExternalContext().getResponse();

			response.setContentType("application/pdf");

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			writer.getInstance(doc, baos);

			doc.open();
			montarArquivo(doc);
			doc.close();

			response.setContentLength(baos.size());
			ServletOutputStream os = response.getOutputStream();
			baos.writeTo(os);
			os.flush();
			os.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// doc.close();
		}
	}

	// TODO configurar toString da classe Disciplinas
	public void montarArquivo(Document doc) {
		try {

			Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);

			doc.add(new Paragraph("Edital de Monitoria No" + numero + ".\n",
					FontFactory.getFont(FontFactory.HELVETICA, 10)));

			doc.add(new Paragraph(" "));

			doc.add(new Paragraph("O Diretor da Escola de " + this.escola
					+ " da Unigranrio, no uso de suas atribui��es, torna",
					FontFactory.getFont(FontFactory.HELVETICA, 10)));

			doc.add(new Paragraph(
					"p�blica a realiza��o do Concurso Interno de sele��o de monitores das disciplinas ",
					font));

			doc.add(new Paragraph(this.disciplinas.toString() + " o curso de "
					+ this.curso + " para o per�odo letivo de "
					+ this.periodoLetivo + ".", font));

			doc.add(new Paragraph(
					"As inscri��es poder�o ser efetuadas no per�odo de "
							+ this.inicioInscricao + " a " + this.fimInscricao
							+ ", na .", font));// TODO conferir com a Suelen o
												// que entra nesse campo

			doc.add(new Paragraph(
					"Podendo cada estudante se inscrever em apenas uma disciplina.",
					font));
			doc.add(new Paragraph(" "));
			com.itextpdf.text.List list = new com.itextpdf.text.List(true,
					false);
			list.add(new ListItem(
					"Este Edital � regido pela Regulamenta��o de Monitoria Vigente na UNIGRANRIO(Esta regulamenta��o"
							+ " poder� ser retirada no ato da inscri��o).",
					font));

			list.add(new ListItem(
					"A monitoria visa aprimorar os conhecimentos te�ricos e pr�ticos do estudante na disciplina, bem como permitir a viv�ncia de pr�ticas de ensino e produ��o de conhecimento.",
					font));

			list.add(new ListItem("S�o atribui��es do monitor:", font));

			list.add(new ListItem("� vedado ao aluno monitor:", font));
			list.add(new ListItem(
					"O per�odo previsto para as atividades da monitoria ser� de",
					font));
			list.add(new ListItem("Quadro de vagas:", font));
			list.add(new ListItem("S�o requisitos para o processo seletivo:",
					font));
			list.add(new ListItem(
					"A sele��o ser� feita mediante realiza��o de uma prova e entrevista. Ser�o classificados os candidatos que obtiverem, no processo seletivo, m�dia igual ou superior a 7,0 (sete).",
					font));
			list.add(new ListItem("Para sele��o ser�o considerados:", font));
			list.add(new ListItem(
					"O estudante selecionado ter� que cumprir, no m�nimo, 04 (quatro) horas semanais em atividades definidas pelo professor- coordenador.",
					font));
			list.add(new ListItem(
					"A monitoria n�o garante ao aluno qualquer tipo de bolsa ou remunera��o.",
					font));
			list.add(new ListItem(
					"Os alunos selecionados dever�o assinar o termo de monitoria em tr�s vias, tomando ci�ncia das normas em vigor.",
					font));
			list.add(new ListItem("Conte�do Program�tico:", font));
			doc.add(list);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}