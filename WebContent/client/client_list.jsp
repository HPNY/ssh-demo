<%@page import="com.mybank.fundtrans.dao.ClientDaoHibImpl"%>
<%@page import="com.mybank.fundtrans.dao.ClientDao"%>
<%@page import="com.mybank.fundtrans.domain.Client"%>
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
<body onload="tableStyle('clientTable')">
	<% 
	ClientDao clientDao=new ClientDaoHibImpl();
	List<Client> clientList=clientDao.findAll();
	%>
	
		<div style="font-weight:900;font-size:30px;text-align:center;">客户查询结果</div>
		<table cellspacing="0" cellpadding="0" id="clientTable">
			<tr>
			<th>客户身份证号</th>
			<th>客户姓名</th>
			<th>客户性别</th>
			<th>客户联系电话</th>
			<th>客户地址</th>
			<th>客户电邮</th>
			<th>客户创建时间</th>
			<th>操作</th>
			</tr>
		<%
			for(Object obj  : clientList){
			Client client=(Client)obj;
		%>
			<tr>
			<td><%=client.getIdCard() %></td>
			<td><%=client.getName() %></td>
			<td><% 
				if(client.getSex().toString().equals("M"))
					 out.print("男");
				else
					out.print("女");
				%></td>
			<td><%=client.getPhone() %></td>
			<td><%=client.getAddress() %></td>
			<td><%=client.getEmail() %></td>
			<td><%=client.getCreateTime() %></td>
			<td>
				<a style="text-decoration: none;color:rgb(30, 240, 30);" href="client/updateshowClient.action?idCard=<%=client.getIdCard() %>" >修改</a>&nbsp
				<a style="text-decoration: none;color:rgb(30, 240, 30);" href="client/deleteClient.action?idCard=<%=client.getIdCard() %>">删除</a>
			</td>
			</tr>
		<%
			}	
		%>
		
	</table>
</body>
</html>