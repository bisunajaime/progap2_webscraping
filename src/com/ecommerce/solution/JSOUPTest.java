package com.ecommerce.solution;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class JSOUPTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "https://fami.com.ph/mutual-fund/save-learn-equity-fund/";
		JSOUPTest j = new JSOUPTest();
		try {
			Document document = Jsoup.connect(url).get();
			for(Element data : document.select("table.tablepress.tablepress-id-4")) {
				if (data.select("tbody.row-hover").text().equals("")) {
					continue;
				}else {
					//row 1 col 2
					String inv_amt_row1 = data.select("tr.row-3.odd>td.column-1").text();
					String sales_load_row1 = data.select("tr.row-3.odd>td.column-2").text();
					//row 2 col 2
					String inv_amt_row2 = data.select("tr.row-4.even>td.column-1").text();
					String sales_load_row2 = data.select("tr.row-4.even>td.column-2").text();
					//row 3 col 3
					String inv_amt_row3 = data.select("tr.row-5.odd>td.column-1").text();
					String sales_load_row3 = data.select("tr.row-5.odd>td.column-2").text();
					//row 4 col 4
					String inv_amt_row4 = data.select("tr.row-6.even>td.column-1").text();
					String sales_load_row4 = data.select("tr.row-6.even>td.column-2").text();
					System.out.println(j.ConvertToInt2(inv_amt_row3));
					System.out.println(j.ConvertToDouble3(inv_amt_row4));
					//System.out.println(j.ConvertToInt2(inv_amt_row4));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}		
	public double ConvertToDouble3(String str) {
		String[] a = str.split("and");
		String b = a[0].trim();
		String c = b.replace(",","");
		double d = Double.parseDouble(c);
		return d;
	}
	
	public double ConvertToInt(String str) {
		String[] a = str.split("-");
		String b = a[0].trim();
		String c = b.replace(",","");
		double d = Double.parseDouble(c);
		return d;
	}
	
	public double ConvertToInt2(String str) {
		String[] a = str.split("-");
		String b = a[1].trim();
		String c = b.replace(",","");
		double d = Double.parseDouble(c);
		return d+0.99;
	}
	
	public double ConvertToDouble(String str) {
		String [] a = str.split("%");
		String b = a[0].trim();
		double d = Double.parseDouble(b);
		return d/100;
	}

}
