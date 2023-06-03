package com.entity;

import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePdf {

	public static boolean getPdf(Student stu, List<Mark> mark) {
		boolean f = false;
		String filename = "C:\\Users\\Pabitra\\Downloads\\" + stu.getName() + "_marksheet.pdf";
		Document d = new Document();

		try {
			PdfWriter.getInstance(d, new FileOutputStream(filename));
			d.open();

			d.add(new Paragraph("                                                                   Result"));

			d.add(new Paragraph(
					"---------------------------------------------------------------------------------------------------------------------------------- "));
			d.add(new Paragraph("Roll: " + stu.getRoll()));
			d.add(new Paragraph("Name: " + stu.getName()));
			d.add(new Paragraph("Gender: " + stu.getGender()));
			d.add(new Paragraph("DOB: " + stu.getGender()));
			d.add(new Paragraph("Course: " + stu.getCourse()));
			d.add(new Paragraph("Sem: " + stu.getSemestar()));
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

			int secmark = 0;
			int tfullMrk = mark.size() * 100;
			for (Mark m : mark) {
				secmark += m.getMark();
				table.addCell(m.getSubject());
				table.addCell("100");
				table.addCell(m.getMark() + "");
			}

			table.addCell("Total Mark ");
			table.addCell(tfullMrk + "");
			table.addCell(secmark + "");

			d.add(table);

			float di = ((float) secmark / (float) tfullMrk) * 100;

			String div = "";
			if ((int) di >= 60)
				div = "1st Division";
			else if ((int) di < 60 && di >= 50)
				div = "2nd Division";
			else if ((int) di < 50 && di >= 30)
				div = "3rd Division";
			else
				div = "Fail";

			d.add(new Paragraph(" "));
			d.add(new Paragraph(
					"                               Division= " + div + "                Percentage= " + (int)di + "% "));
			f = true;
			d.close();

		} catch (Exception e) {
			f = false;
			e.printStackTrace();
		}

		return f;
	}

}
