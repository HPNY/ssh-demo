<%@page import="com.mybank.fundtrans.dao.FundDaoJDBCImpl"%>
<%@page import="com.mybank.fundtrans.dao.FundDao"%>
<%@page import="com.mybank.fundtrans.domain.Fund"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>find fund</title>
<style type="text/css">
	table{
		text-align:center;
		width:100%;
		
	}
	tr{
		height: 50px;
	}
	
</style>
	<script type="text/javascript">
			function $(id){
				return document.getElementById(id) 
			}
			
			function tableStyle(id){
				
				var tableRow=$(id).rows;
				
				for(var i=0;i<tableRow.length;i++){
					if(i%2==0)
						tableRow[i].style.background="RGB(243,243,243)"
					else
						tableRow[i].style.background="RGB(255,255,255)"
				}
				
			}
		</script>

</head>
<body onload="tableStyle('fundTable')">
	<% 
	//List<Fund> funds = (List)request.getAttribute("fundList");
	FundDao fundDao=new FundDaoJDBCImpl();
	List<Fund> fundList=fundDao.findAll();
	%>
	
		<div style="font-weight:900;font-size:30px;text-align:center;">基金产品查询结果</div>
		<table cellspacing="0" cellpadding="0" id="fundTable">
			<tr>
			<th>基金编号</th>
			<th>基金产品名称</th>
			<th>基金产品价格</th>
			<th>基金产品状态</th>
			<th>基金产品创建时间</th>
			<th>操作</th>
			</tr>
		<%
			for(Object obj  : fundList){
			Fund fund=(Fund)obj;
		%>
			<tr>
			<td><%=fund.getId() %></td>
			<td><%=fund.getName() %></td>
			<td><%=fund.getPrice() %></td>
			<td><% 
				if(fund.getStatus().toString().equals("Y"))
					 out.print("可交易");
				else
					out.print("未上市交易");
				%></td>
			<td><%=fund.getCreateTime() %></td>
			<td>
				<a style="text-decoration: none;color:rgb(30, 240, 30);" href="fund/updateshowFund.action?id=<%=fund.getId() %>" >修改</a>&nbsp
				<a style="text-decoration: none;color:rgb(30, 240, 30);" href="fund/deleteFund.action?id=<%=fund.getId() %>">删除</a>
			</td>
			</tr>
		<%
			}	
		%>
		
	</table>
</body>
</html>