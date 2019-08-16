package com.ecommerce.solution;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class iTextTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Document document = new Document(PageSize.A4);
		try {
			PdfWriter.getInstance(document, new FileOutputStream("Receipts/HelloWorld.pdf"));
			document.open();
			Paragraph p1 = new Paragraph("Hello World");
			Paragraph p2 = new Paragraph("Testing 1234");
			
			document.add(p1);
			document.add(p2);
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		document.close();
	}

}
