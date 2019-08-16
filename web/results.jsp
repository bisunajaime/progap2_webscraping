<%@page import="com.ecommerce.exception.InvestmentAmountException"%>
<%@page import="com.ecommerce.exception.NameLengthException"%>
<%@page import="com.ecommerce.exception.FundTypeException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="errorpage.jsp"%>
<jsp:useBean id="bean" class="com.ecommerce.solution.SolutionBean"/>
<jsp:useBean id="j" class="com.ecommerce.solution.JSOUPBean"/>
<jsp:setProperty property="*" name="bean"/>
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
		j.JSOUPFacade();
		if(bean.getInvestor_fund_type().toUpperCase().trim().length() != 0 && bean.getInvestor_fund_type().trim().toUpperCase().matches("(SALEF||SALBF||SALFIF)")){
			if(bean.getInvestor_name().trim().length() != 0 && bean.getInvestor_name().matches("[a-z A-Z]{5,30}")){
				if(bean.getInvestment_amount() >= j.ConvertToDouble1(j.getInv_amt_row1())){
					bean.Compute();
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
		<h1 style="padding: 50px 0px" class="text-center display-4">Results</h1>
		<div class="row">
			<div class="col-sm-12 col-md-6 col-lg-6">
				<h4><span class="fa fa-user"></span>&nbsp;Investor Name</h4>
				<p><i><jsp:getProperty name="bean" property="investor_name"/></i></p>
				<h4>
					<span class="fa fa-money"></span>&nbsp;Investment Fund Type
				</h4>
				<p><i><jsp:getProperty name="bean" property="investor_fund_type"/></i></p>
				<h4>Amount Invested</h4>
				<p><i>Php<jsp:getProperty name="bean" property="investment_amount"/></i></p>
			</div>
			<div class="col-sm-12 col-md-6 col-lg-6">
				<h4>NAVPS</h4>
				<p><i>Php<jsp:getProperty name="bean" property="navps"/></i></p>
				<h4>Sales Load Amount</h4>
				<p><i>Php<jsp:getProperty name="bean" property="sales_load_amt"/></i></p>
				<h4>Net Amount Invested</h4>
				<p><i>Php<jsp:getProperty name="bean" property="net_amt_inv"/></i></p>
			</div>
			<div class="col">
				<h4>Total Shares Bought</h4>
				<p><i><jsp:getProperty name="bean" property="total_shares_bought"/> shares</i></p>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12 col-md-6 col-lg-6">
				<a class="btn btn-outline-danger btn-block" href="index.jsp">Go back</a>	
			</div>
			<div class="col-sm-12 col-md-6 col-lg-6">
				<form action="itext.action" method="post">
				<input type="hidden" value="<%=bean.getInvestor_name() %>" name="investor_name">
				<input type="hidden" value="<%=bean.getInvestor_fund_type() %>" name="mutual_fund_type">
				<input type="hidden" value="<%=bean.getInvestment_amount() %>" name="investment_amount">
				<input type="hidden" value="<%=Math.ceil(bean.getTotal_shares_bought()) %>" name="total_shares_bought">
				<input type="hidden" value="<%=bean.getNavps() %>" name="navps">
				<input type="hidden" value="<%=bean.getSales_load_amt() %>" name="sales_load_amt">
				<input type="hidden" value="<%=bean.getNet_amt_inv() %>" name="net_amt_inv">
				<button type="submit" class='btn btn-outline-info btn-block'>Generate Receipt</button>
				</form>
			</div>
		</div>
	</div>
	<%@include file="style/footer.html" %>
</body>

</html>