package com.pdf;

import java.io.FileNotFoundException;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

public class Invoice {

	public static void main(String[] args) throws FileNotFoundException {
		String path = "C:\\Pdf\\invoice.pdf";

		PdfWriter pdfWriter = new PdfWriter(path);

		PdfDocument pdfDocument = new PdfDocument(pdfWriter);

		Document document = new Document(pdfDocument);

		pdfDocument.setDefaultPageSize(PageSize.A4);

		float col = 280f;
		float columnWidth[] = { col, col };

		Table table = new Table(columnWidth);
		table.setBorder(Border.NO_BORDER);
		table.setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(Color.WHITE);

		table.addCell(new Cell().add("Invoice")).setTextAlignment(TextAlignment.CENTER)
				.setVerticalAlignment(VerticalAlignment.MIDDLE)
				.setMarginTop(30f).setFontSize(30f)
				.setBorder(Border.NO_BORDER);

		table.addCell(new Cell().add("Be coder Youtube channel \n kaise ho")).setTextAlignment(TextAlignment.RIGHT)
				.setMarginBottom(30f).setMarginRight(10f).setBorder(Border.NO_BORDER).setFontSize(10f);

		
		
		document.add(table);

		System.out.println("Generate Pdf");

		document.close();

	}
}
