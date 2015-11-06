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
					+ " da Unigranrio, no uso de suas atribuições, torna",
					FontFactory.getFont(FontFactory.HELVETICA, 10)));

			doc.add(new Paragraph(
					"pública a realização do Concurso Interno de seleção de monitores das disciplinas ",
					font));

			doc.add(new Paragraph(this.disciplinas.toString() + " o curso de "
					+ this.curso + " para o período letivo de "
					+ this.periodoLetivo + ".", font));

			doc.add(new Paragraph(
					"As inscrições poderão ser efetuadas no período de "
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
					"Este Edital é regido pela Regulamentação de Monitoria Vigente na UNIGRANRIO(Esta regulamentação"
							+ " poderá ser retirada no ato da inscrição).",
					font));

			list.add(new ListItem(
					"A monitoria visa aprimorar os conhecimentos teóricos e práticos do estudante na disciplina, bem como permitir a vivência de práticas de ensino e produção de conhecimento.",
					font));

			list.add(new ListItem("São atribuições do monitor:", font));

			list.add(new ListItem("É vedado ao aluno monitor:", font));
			list.add(new ListItem(
					"O período previsto para as atividades da monitoria será de",
					font));
			list.add(new ListItem("Quadro de vagas:", font));
			list.add(new ListItem("São requisitos para o processo seletivo:",
					font));
			list.add(new ListItem(
					"A seleção será feita mediante realização de uma prova e entrevista. Serão classificados os candidatos que obtiverem, no processo seletivo, média igual ou superior a 7,0 (sete).",
					font));
			list.add(new ListItem("Para seleção serão considerados:", font));
			list.add(new ListItem(
					"O estudante selecionado terá que cumprir, no mínimo, 04 (quatro) horas semanais em atividades definidas pelo professor- coordenador.",
					font));
			list.add(new ListItem(
					"A monitoria não garante ao aluno qualquer tipo de bolsa ou remuneração.",
					font));
			list.add(new ListItem(
					"Os alunos selecionados deverão assinar o termo de monitoria em três vias, tomando ciência das normas em vigor.",
					font));
			list.add(new ListItem("Conteúdo Programático:", font));
			doc.add(list);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}