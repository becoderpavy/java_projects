import java.awt.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.slf4j.impl.StaticLoggerBinder;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvasConstants;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

public class Main {

	public static final String disco = "font\\disco.otf";

	public static void main(String[] args) throws IOException {
		String path = "C:\\Pdf\\mypdf.pdf";

		String paragraph = "Hello Welcome to becoder";
		try {
			Paragraph p = new Paragraph(paragraph);
			PdfWriter pdfWriter = new PdfWriter(path);
			PdfDocument pdfDocument = new PdfDocument(pdfWriter);

			pdfDocument.addNewPage();

			// add imge
			String imgsrc = "C:\\Pdf\\certificate2.jpg";
			ImageData data = ImageDataFactory.create(imgsrc);
			Image img = new Image(data);

			// add list
			List ls = new List();
			ls.add("Java");
			ls.add("Android");
			ls.add("C");

			// add font

			PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);

			PdfFont boldFont = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);

			Text test1 = new Text("Nice Person ").setFont(font).setBold();
			Text test2 = new Text("\nHello").setFont(boldFont).setBold().setStrokeColor(Color.RED);
			Text test3 = new Text("\nHello").setTextRenderingMode(PdfCanvasConstants.TextRenderingMode.STROKE)
					.setStrokeColor(Color.BLUE).setStrokeWidth(0.3f);

			Paragraph para = new Paragraph().add(test1).add(test2).add(test3);

			// add style
			Style author = new Style();
			author.setFontColor(Color.RED).setFontSize(40f).setItalic();

			// add external font

			PdfFont discofont = PdfFontFactory.createFont(disco);
			Text mytext = new Text("Kaise hi").setFont(discofont);
			Paragraph para2 = new Paragraph().add(mytext).addStyle(author);

			Document document = new Document(pdfDocument);
			document.add(p);
			document.add(img);
			// document.add(ls);

			document.add(para);
			document.add(para2);

			System.out.println("Generate Pdf");

			document.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
