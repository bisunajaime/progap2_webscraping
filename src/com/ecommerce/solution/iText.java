package com.ecommerce.solution;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class iText
 */
//@WebServlet("/itext.action")
public class iText extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/pdf");
		String investor_name = request.getParameter("investor_name");
		String mutual_fund_type = request.getParameter("mutual_fund_type");
		double investment_amount = Double.parseDouble(request.getParameter("investment_amount"));
		double total_shares_bought = Double.parseDouble(request.getParameter("total_shares_bought"));
		double navps = Double.parseDouble(request.getParameter("navps"));
		double sales_load_amt = Double.parseDouble(request.getParameter("sales_load_amt"));
		double net_amt_inv = Double.parseDouble(request.getParameter("net_amt_inv"));
		
		try {
			Document document = new Document(PageSize.A4);
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();
			
			document.add(new Paragraph("Investor Name: " + investor_name));
			document.add(new Paragraph("Mutual Fund Type: " + mutual_fund_type));
			document.add(new Paragraph("Investment Amount: " + investment_amount));
			document.add(new Paragraph("Total Shares Bought: " + total_shares_bought));
			document.add(new Paragraph("NAVPS: " + navps));
			document.add(new Paragraph("Sales Load Amount: " + sales_load_amt));
			document.add(new Paragraph("Net Amount Inventory: " + net_amt_inv));
			document.close();
			response.sendRedirect("index.jsp");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		response.sendRedirect("results.jsp");
	}

}
