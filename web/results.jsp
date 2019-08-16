<%@page import="com.ecommerce.solution.JSOUPBean"%>
<%@page import="com.ecommerce.exception.InvestmentAmountException"%>
<%@page import="com.ecommerce.exception.NameLengthException"%>
<%@page import="com.ecommerce.exception.FundTypeException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="errorpage.jsp"%>
<%@ page import="com.ecommerce.solution.SolutionBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Results</title>
	<%@ include file="style/style.html" %>
</head>

<body>
<%@ include file="style/header.html" %>
	<%
		String investor_name = request.getParameter("investor_name");
		String investor_fund_type = request.getParameter("investor_fund_type");
		double investment_amount = Double.parseDouble(request.getParameter("investment_amount"));
		SolutionBean javaBean = new SolutionBean();
		JSOUPBean j = new JSOUPBean();
		j.JSOUPFacade();
		
		if(investor_fund_type.toUpperCase().trim().length() != 0 && investor_fund_type.trim().toUpperCase().matches("(SALEF||SALBF||SALFIF)")){
			javaBean.setMutual_fund_type(investor_fund_type);
			
			if(investor_name.trim().length() != 0 && investor_name.matches("[a-z A-Z]{5,30}")){
				javaBean.setInvestor_name(investor_name);
				
				if(investment_amount >= j.ConvertToDouble1(j.getInv_amt_row1())){
					javaBean.setInvestment_amount(investment_amount);
					javaBean.Compute();
				}else{
					throw new InvestmentAmountException();
				}
			}else{
				throw new NameLengthException();
			}
		}else{
			throw new FundTypeException();
		}
	%>

	<div class="container">
		<div class="jumbotron">
			<h1 style="text-align: center">Results</h1>
		</div>
		<div class="row">
			<div class="col-sm-12 col-md-6 col-lg-6">
				<h4><span class="fa fa-user"></span>&nbsp;Investor Name</h4>
				<p><i><%=javaBean.getInvestor_name() %></i></p>
				<h4>
					<span class="fa fa-money"></span>&nbsp;Investment Fund Type
				</h4>
				<p><i><%=javaBean.getMutual_fund_type() %></i></p>
				<h4>Amount Invested</h4>
				<p><i>Php<%=javaBean.getInvestment_amount() %></i></p>
			</div>
			<div class="col-sm-12 col-md-6 col-lg-6">
				<h4>NAVPS</h4>
				<p><i>Php<%=javaBean.getNavps() %></i></p>
				<h4>Sales Load Amount</h4>
				<p><i>Php<%=javaBean.getSales_load_amt() %></i></p>
				<h4>Net Amount Invested</h4>
				<p><i>Php<%=javaBean.getNet_amt_inv() %></i></p>
			</div>
			<div class="col">
				<h4>Total Shares Bought</h4>
				<p><i><%=Math.ceil(javaBean.getTotal_shares_bought()) %> shares</i></p>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12 col-md-6 col-lg-6">
				<a class="btn btn-outline-danger btn-block" href="index.jsp">Go back</a>	
			</div>
			<div class="col-sm-12 col-md-6 col-lg-6">
				<form action="itext.action" method="post">
				<input type="hidden" value="<%=javaBean.getInvestor_name() %>" name="investor_name">
				<input type="hidden" value="<%=javaBean.getMutual_fund_type() %>" name="mutual_fund_type">
				<input type="hidden" value="<%=javaBean.getInvestment_amount() %>" name="investment_amount">
				<input type="hidden" value="<%=Math.ceil(javaBean.getTotal_shares_bought()) %>" name="total_shares_bought">
				<input type="hidden" value="<%=javaBean.getNavps() %>" name="navps">
				<input type="hidden" value="<%=javaBean.getSales_load_amt() %>" name="sales_load_amt">
				<input type="hidden" value="<%=javaBean.getNet_amt_inv() %>" name="net_amt_inv">
				<button type="submit" class='btn btn-outline-info btn-block'>Generate Receipt</button>
				</form>
			</div>
		</div>
	</div>
	<%@include file="style/footer.html" %>
</body>

</html>