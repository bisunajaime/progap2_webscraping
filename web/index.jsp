<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ecommerce.solution.JSOUPBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Mutual Fund Solution</title>
  <%@ include file="style/style.html" %>
</head>

<body>
<%@ include file="style/header.html" %>
  <div class="container">
    <div class="jumbotron">
      <h1 style="text-align: center; font-size: 2rem;">Mutual Fund Solution</h1>
    </div>
    <%
	JSOUPBean soupBean = new JSOUPBean();
	soupBean.JSOUPFacade();
	%>
    <div class="">
        <div class="row">
            <div class="col-sm-12 col-md-6 col-lg-6">
                <table class="table table-hover">
                    <thead>
                        <th>Fund Name</th>
                        <th>NAVPS</th>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Save & Learn Equity Fund</td>
                            <td><%= soupBean.getNavps_salef()%></td>
                        </tr>
                        <tr>
                            <td>Save & Learn Balanced Fund</td>
                            <td><%= soupBean.getNavps_salbf()%></td>
                        </tr>
                        <tr>
                            <td>Save & Learned Fixed Income Fund</td>
                            <td><%= soupBean.getNavps_salfif()%></td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="col-sm-12 col-md-6 col-lg-6">
                <table class="table table-hover">
                    <thead>
                        <th>Investment Amount</th>
                        <th>Sales Load</th>
                    </thead>
                    <tbody>
                        <tr>
                            <td><%= soupBean.getInv_amt_row1()%></td>
                            <td><%= soupBean.getSales_load_row1()%></td>
                        </tr>
                        <tr>
                            <td><%= soupBean.getInv_amt_row2()%></td>
                            <td><%= soupBean.getSales_load_row2()%></td>
                        </tr>
                        <tr>
                            <td><%= soupBean.getInv_amt_row3()%></td>
                            <td><%= soupBean.getSales_load_row3()%></td>
                        </tr>
                        <tr>
                            <td><%= soupBean.getInv_amt_row4()%></td>
                            <td><%= soupBean.getSales_load_row4()%></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
	
	<button class="btn btn-outline-info btn-block" data-toggle="collapse" data-target="#demo">Check Investment</button><br>

	<div id="demo" class="collapse">
		<form action="results.jsp" method="post">
			<label><span class="fa fa-user"></span>&nbsp;Enter Investor Name:</label>
            <input class="form-control" type="text" name="investor_name" required><br>
            <label><span class="fa fa-money"></span>&nbsp;Enter Mutual Fund Type: </label>
            <input class="form-control" type="text" name="investor_fund_type" required><br>
            <label><span class="fa fa-dollar"></span>&nbsp;Enter Investment Amount:</label>
            <input class="form-control" type='number' step=".01" name="investment_amount" required><br>
            <button class="btn btn-success" type="submit">Submit</button>
		</form>
	</div>
  </div>
  <%@include file="style/footer.html" %>
</body>

</html>