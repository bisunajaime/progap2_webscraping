package com.ecommerce.solution;

import javax.xml.transform.Source;

import com.ecommerce.solution.JSOUPBean;

public class SolutionBean {
	private String investor_name;
	private String investor_fund_type;
	private double investment_amount;
	private double net_amt_inv;
	private double sales_load_amt;
	private double navps;
	private double total_shares_bought;
	
	public SolutionBean() {
		// TODO Auto-generated constructor stub
	}
	
	public SolutionBean(String name, String type, double amount) {
		setInvestor_name(name);
		setInvestment_amount(amount);
		setInvestor_fund_type(type);
	}
	
	public String getInvestor_name() {
		return investor_name;
	}

	public void setInvestor_name(String investor_name) {
		this.investor_name = investor_name;
	}

	public String getInvestor_fund_type() {
		return investor_fund_type.toUpperCase();
	}

	public void setInvestor_fund_type(String investor_fund_type) {
		this.investor_fund_type = investor_fund_type;
	}

	public double getInvestment_amount() {
		return investment_amount;
	}

	public void setInvestment_amount(double investment_amount) {
		this.investment_amount = investment_amount;
	}
	
	public double getNet_amt_inv() {
		return net_amt_inv;
	}
	
	public double getSales_load_amt() {
		return sales_load_amt;
	}
	
	public double getNavps() {
		return navps;
	}
	
	public double getTotal_shares_bought() {
		return Math.ceil(total_shares_bought);
	}

	//Process Facade
	public void Compute() {
		Calculate();
	}
	
	private void Calculate() {
		JSOUPBean soupBean = new JSOUPBean();
		soupBean.JSOUPFacade();
		//SALES LOAD (values are converted to percentage for computation)
		double d = soupBean.ConvertToDouble(soupBean.getSales_load_row1());
		double c = soupBean.ConvertToDouble(soupBean.getSales_load_row2());
		double b = soupBean.ConvertToDouble(soupBean.getSales_load_row3());
		double a = soupBean.ConvertToDouble(soupBean.getSales_load_row4());
		//NAVPS values
		double salef = Double.parseDouble(soupBean.getNavps_salef());
		double salfif = Double.parseDouble(soupBean.getNavps_salfif());
		double salbf = Double.parseDouble(soupBean.getNavps_salbf());
		//Investment Amt
		double row1_val1 = soupBean.ConvertToDouble1(soupBean.getInv_amt_row1());
		double row1_val2 = soupBean.ConvertToDouble2(soupBean.getInv_amt_row1());
		
		double row2_val1 = soupBean.ConvertToDouble1(soupBean.getInv_amt_row2());
		double row2_val2 = soupBean.ConvertToDouble2(soupBean.getInv_amt_row2());
		
		double row3_val1 = soupBean.ConvertToDouble1(soupBean.getInv_amt_row3());
		double row3_val2 = soupBean.ConvertToDouble2(soupBean.getInv_amt_row3());
		
		double row4_val1 = soupBean.ConvertToDouble3(soupBean.getInv_amt_row4());
		
		if (getInvestor_fund_type().trim().toUpperCase() != null) {
			switch (getInvestor_fund_type().trim().toUpperCase()) {
			case "SALEF":
					investor_fund_type = "Save and Learn Equity Fund";
					navps = salef;
					if (investment_amount >= row1_val1 && investment_amount <= row1_val2) {
						sales_load_amt = (getInvestment_amount() * d);
						net_amt_inv = getInvestment_amount() - sales_load_amt;
						total_shares_bought = net_amt_inv / salef;
					}else if (getInvestment_amount() >= row2_val1 && getInvestment_amount() <= row2_val2) {
						sales_load_amt = (getInvestment_amount() * c);
						net_amt_inv = getInvestment_amount() - sales_load_amt;
						total_shares_bought = net_amt_inv / salef;
					}else if (getInvestment_amount() >= row3_val1 && getInvestment_amount() <= row3_val2) {
						sales_load_amt = (getInvestment_amount() * b);
						net_amt_inv = getInvestment_amount() - sales_load_amt;
						total_shares_bought = net_amt_inv / salef;
					}else if(getInvestment_amount() >= row4_val1){
						sales_load_amt = (getInvestment_amount() * a);
						net_amt_inv = getInvestment_amount() - sales_load_amt;
						total_shares_bought = net_amt_inv / salef;
					}
				break;
			case "SALBF":
					investor_fund_type = "Save and Learn Balanced Fund";
					navps = salbf;
					if (getInvestment_amount() >= row1_val1 && getInvestment_amount() <= row1_val2) {
						sales_load_amt = (getInvestment_amount() * d);
						net_amt_inv = getInvestment_amount() - sales_load_amt;
						total_shares_bought = net_amt_inv / salbf;
					}else if (getInvestment_amount() >= row2_val1 && getInvestment_amount() <= row2_val2) {
						sales_load_amt = (getInvestment_amount() * c);
						net_amt_inv = getInvestment_amount() - sales_load_amt;
						total_shares_bought = net_amt_inv / salbf;
					}else if (getInvestment_amount() >= row3_val1 && getInvestment_amount() <= row3_val2) {
						sales_load_amt = (getInvestment_amount() * b);
						net_amt_inv = getInvestment_amount() - sales_load_amt;
						total_shares_bought = net_amt_inv / salbf;
					}else if(getInvestment_amount() >= row4_val1){
						sales_load_amt = (getInvestment_amount() * a);
						net_amt_inv = getInvestment_amount() - sales_load_amt;
						total_shares_bought = net_amt_inv / salbf;
					}
				break;
			case "SALFIF":
					investor_fund_type = "Save and Learn Fixed Income Fund";
					navps = salfif;
					if (getInvestment_amount() >= row1_val1 && getInvestment_amount() <= row1_val2) {
						sales_load_amt = (getInvestment_amount() * d);
						net_amt_inv = getInvestment_amount() - sales_load_amt;
						total_shares_bought = net_amt_inv / salfif;
					}else if (getInvestment_amount() >= row2_val1 && getInvestment_amount() <= row2_val2) {
						sales_load_amt = (getInvestment_amount() * c);
						net_amt_inv = getInvestment_amount() - sales_load_amt;
						total_shares_bought = net_amt_inv / salfif;
					}else if (getInvestment_amount() >= row3_val1 && getInvestment_amount() <= row3_val2) {
						sales_load_amt = (getInvestment_amount() * b);
						net_amt_inv = getInvestment_amount() - sales_load_amt;
						total_shares_bought = net_amt_inv / salfif;
					}else if(getInvestment_amount() >= row4_val1){
						sales_load_amt = (getInvestment_amount() * a);
						net_amt_inv = getInvestment_amount() - sales_load_amt;
						total_shares_bought = net_amt_inv / salfif;
					}
				break;
			default:
				break;
			}
		}
	}
}
