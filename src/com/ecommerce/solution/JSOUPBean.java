package com.ecommerce.solution;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import sun.net.www.content.audio.x_aiff;

public class JSOUPBean {
	private String inv_amt_row1 = "";
	private String inv_amt_row2 = "";
	private String inv_amt_row3 = "";
	private String inv_amt_row4 = "";
	private String sales_load_row1 = "";
	private String sales_load_row2 = "";
	private String sales_load_row3 = "";
	private String sales_load_row4 = "";
	private String navps_salef = "";
	private String navps_salbf = "";
	private String navps_salfif = "";
	
	public JSOUPBean() {
		
	}
	//Gets first value of table
	public double ConvertToDouble1(String str) {
		String[] a = str.split("-");
		String b = a[0].trim();
		String c = b.replace(",","");
		double d = Double.parseDouble(c);
		return d;
	}
	//Gets second value of table
	public double ConvertToDouble2(String str) {
		String[] a = str.split("-");
		String b = a[1].trim();
		String c = b.replace(",","");
		double d = Double.parseDouble(c);
		return d+0.99;
	}
	//more than 2 mil 'and' above
	public double ConvertToDouble3(String str) {
		String[] a = str.split("and");
		String b = a[0].trim();
		String c = b.replace(",","");
		double d = Double.parseDouble(c);
		return d;
	}
	
	public double ConvertToDouble(String str) {
		String [] a = str.split("%");
		String b = a[0].trim();
		double d = Double.parseDouble(b);
		return d/100;
	}

	public String getInv_amt_row1() {
		return inv_amt_row1;
	}

	public String getInv_amt_row2() {
		return inv_amt_row2;
	}

	public String getInv_amt_row3() {
		return inv_amt_row3;
	}
	
	public String getInv_amt_row4() {
		return inv_amt_row4;
	}

	public String getSales_load_row1() {
		return sales_load_row1;
	}

	public String getSales_load_row2() {
		return sales_load_row2;
	}

	public String getSales_load_row3() {
		return sales_load_row3;
	}
	
	public String getSales_load_row4() {
		return sales_load_row4;
	}
	
	public String getNavps_salef() {
		return navps_salef;
	}

	public String getNavps_salbf() {
		return navps_salbf;
	}

	public String getNavps_salfif() {
		return navps_salfif;
	}

	public void JSOUPFacade() {
		RetrieveData();
		RetrieveNAVPSData();
	}
	
	private void RetrieveData() {
		String url = "https://fami.com.ph/mutual-fund/save-learn-equity-fund/";
		try {
			// Document document = Jsoup.connect(url).timeout(10*2000).get();
			Connection connection = Jsoup.connect(url);
			connection.userAgent("Mozilla/5.0");
			Document document = connection.get();
			for(Element data : document.select("table.tablepress.tablepress-id-4")) {
				if (data.select("tbody.row-hover").text().equals("")) {
					continue;
				}else {
					//row 1 col 2
					inv_amt_row1 = data.select("tr.row-3.odd>td.column-1").text();
					sales_load_row1 = data.select("tr.row-3.odd>td.column-2").text();
					//row 2 col 2
					inv_amt_row2 = data.select("tr.row-4.even>td.column-1").text();
					sales_load_row2 = data.select("tr.row-4.even>td.column-2").text();
					//row 3 col 3
					inv_amt_row3 = data.select("tr.row-5.odd>td.column-1").text();
					sales_load_row3 = data.select("tr.row-5.odd>td.column-2").text();
					//row 4 col 4
					inv_amt_row4 = data.select("tr.row-6.even>td.column-1").text();
					sales_load_row4 = data.select("tr.row-6.even>td.column-2").text();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private void RetrieveNAVPSData() {
		String url = "https://fami.com.ph/";
		try {
			Document document = Jsoup.connect(url).get();
			for(Element data : document.select("table.navps")) {
				if (data.select("tbody").text().equals("")) {
					continue;
				}else {
					navps_salef = data.select("tbody>tr:nth-of-type(1) > td:nth-of-type(2)").text();
					navps_salbf = data.select("tbody>tr:nth-of-type(2) > td:nth-of-type(2)").text();
					navps_salfif = data.select("tbody>tr:nth-of-type(3) > td:nth-of-type(2)").text();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
