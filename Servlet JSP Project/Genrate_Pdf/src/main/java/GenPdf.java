import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GenPdf {

	public static void main(String[] args) {
		String filename = "C:\\Users\\Pabitra\\Downloads\\my.pdf";
		Document d = new Document();

		try {
			PdfWriter.getInstance(d, new FileOutputStream(filename));

			PdfWriter.getInstance(d, new FileOutputStream(filename));
			d.open();

			d.add(new Paragraph("                                                                   Result"));

			d.add(new Paragraph(
					"---------------------------------------------------------------------------------------------------------------------------------- "));
			d.add(new Paragraph("Name: Pabitra"));
			d.add(new Paragraph("Gender: Male"));
			d.add(new Paragraph("DOB: 03-Jun-1999"));
			d.add(new Paragraph("Course: BCA"));
			d.add(new Paragraph("Sem: 1st Sem"));
			d.add(new Paragraph("Gender: Male"));
			d.add(new Paragraph(" "));
			// d.add(new Paragraph(
			// "----------------------------------------------------------------------------------------------------------------------------------
			// "));
			d.add(new Paragraph(" "));

			PdfPTable table = new PdfPTable(3);
			PdfPCell c1 = new PdfPCell(new Phrase("Subject"));
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Full Mark"));
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Mark"));
			table.addCell(c1);

			table.setHeaderRows(1);

			table.addCell("DC");
			table.addCell("100");
			table.addCell("94");

			table.addCell("C");
			table.addCell("100");
			table.addCell("83");

			table.addCell(" ");
			table.addCell("Total Mark");
			table.addCell("283");

			d.add(table);

			d.add(new Paragraph(" "));
			d.add(new Paragraph("                               Division=B                Percentage=83%"));

			d.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
