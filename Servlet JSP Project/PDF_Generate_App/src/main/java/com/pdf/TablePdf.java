package com.pdf;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.GrooveBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Tab;
import com.itextpdf.layout.element.Table;

public class TablePdf {
	public static void main(String[] args) throws FileNotFoundException, MalformedURLException {

		String path = "C:\\Pdf\\tblpdf.pdf";

		PdfWriter pdfWriter = new PdfWriter(path);

		PdfDocument pdfDocument = new PdfDocument(pdfWriter);

		Document document = new Document(pdfDocument);

		/*
		 * float columWidth[] = { 200f, 50f, 100f }; String[] tblHeader = { "Item",
		 * "Color", "Size" };
		 * 
		 * String[][] itemArray = { { "Box", "RED", "Big" }, { "Box2", "RED2", "Big2" }
		 * }; Table table = new Table(columWidth);
		 */

		/*
		 * table.addCell(new Cell().add("Item")); table.addCell(new
		 * Cell().add("Quantity")); table.addCell(new Cell().add("Avaliable"));
		 * 
		 * table.addCell(new Cell().add("Manago")); table.addCell(new Cell().add("2"));
		 * table.addCell(new Cell().add("Yes"));
		 * 
		 * table.addCell(new Cell().add("Oil")); table.addCell(new Cell().add("3"));
		 * table.addCell(new Cell().add("No"));
		 */

		/*
		 * Border border = new GrooveBorder(new DeviceRgb(200, 7, 4), 3); String imgPath
		 * = "img\\certificate1.png"; ImageData imgData =
		 * ImageDataFactory.create(imgPath); Image image = new Image(imgData);
		 * 
		 * for (int i = 0; i < 3; i++) {
		 * 
		 * table.addCell(new
		 * Cell().add(tblHeader[i]).setBackgroundColor(Color.BLACK).setFontColor(Color.
		 * WHITE) .setBorder(border));
		 * 
		 * }
		 * 
		 * for (int i = 0; i < 2; i++) { for (int j = 0; j < 3; j++) { if (i % 2 == 0) {
		 * table.addCell( new
		 * Cell().add(itemArray[i][j]).setBackgroundColor(Color.BLUE).setFontColor(Color
		 * .WHITE)); } else { table.addCell( new
		 * Cell().add(itemArray[i][j]).setBackgroundColor(Color.YELLOW).setFontColor(
		 * Color.WHITE)); }
		 * 
		 * }
		 * 
		 * }
		 * 
		 * table.addCell(new Cell().add("ok")); table.addCell(new
		 * Cell().add(image.setWidth(30f).setHeight(30f))); table.addCell(new
		 * Cell().add("Ok"));
		 */

		float coulmnWidth[] = { 100f, 100f, 100f };
		Table table = new Table(coulmnWidth);
		table.setBorder(Border.NO_BORDER);
		table.addCell(new Cell().add("One"));
		table.addCell(new Cell().add("Two"));
		table.addCell(new Cell(2, 0).add("Three"));

		table.addCell(new Cell().add("Four"));
		table.addCell(new Cell().add("Five"));

		table.addCell(new Cell(0, 2).add("Six"));
		table.addCell(new Cell().add("Seven"));

		/*
		 * float coulmnWidth[] = { 100f, 100f, 100f, 100f, 100f, 100f }; Table table =
		 * new Table(coulmnWidth); table.setBorder(Border.NO_BORDER); table.addCell(new
		 * Cell().add("One")); table.addCell(new Cell().add("Two")); table.addCell(new
		 * Cell(2, 0).add("Three"));
		 * 
		 * table.addCell(new Cell().add("Four")); table.addCell(new Cell().add("Five"));
		 * 
		 * table.addCell(new Cell(0, 2).add("Six")); table.addCell(new
		 * Cell().add("Seven"));
		 */

		document.add(table);

		document.close();
	}

}
