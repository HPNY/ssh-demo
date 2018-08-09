<%@page import="com.mybank.fundtrans.dao.ClientDaoHibImpl"%>
<%@page import="com.mybank.fundtrans.dao.ClientDao"%>
<%@page import="com.mybank.fundtrans.domain.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add fund</title>
<script language="javascript">
	function checkNull() {
		/*判断是否有空内容*/
		for (i = 0; i < form1.length; i++) {
			if (form1.elements[i].value == "") {
				alert(form1.elements[i].title + "不能为空!");
				form1.elements[i].focus();
				return false;
			}
		}
	}
</script>
</head>
<body>
	<%
		String idCard = request.getParameter("idCard");
		ClientDao clientdao = new ClientDaoHibImpl();
		Client client = clientdao.findById(idCard);
	%>
	<div class="content-box-header">
		<h3>修改客户信息</h3>
	</div>

	<div class="content-box-content">
		<form name="form1" action="client/updateClient.action" method="post"
			onSubmit="return checkNull()">
			<p>
				客户身份证号：<input class="text-input large-input" type="text"
					name="client.idCard" value="<%=client.getIdCard()%>" />
			</p>
			<p>
				客户姓名：<input class="text-input large-input" type="text"
					name="client.name" value="<%=client.getName()%>" />
			</p>
			<p>
				<%
					if (client.getSex().contains("M")) {
				%>
				客户性别： <input type="radio" name="client.sex" value="M" checked />男 <input
					type="radio" name="client.sex" value="F" />女
				<%
					} else {
				%>
				客户性别： <input type="radio" name="client.sex" value="M" />男 <input
					type="radio" name="client.sex" value="F" checked />女
				<%
					}
				%>
			</p>
			<p>
				客户联系电话：<input class="text-input large-input" type="text"
					name="client.phone" value="<%=client.getPhone()%>" />
			</p>
			<p>
				客户地址：<input class="text-input large-input" type="text"
					name="client.address" value="<%=client.getAddress()%>" />
			</p>
			<p>
				客户电邮：<input class="text-input large-input" type="text"
					name="client.email" value="<%=client.getEmail()%>" />
			</p>
			<p>
				客户爱好：
				<textarea class="text-input textarea" rows="16" cols="50"
					name="client.hobby"><%=client.getHobby()%></textarea>
			</p>
			<p>
				<input class="button" type="submit" value="新增" /> <input
					class="button" type="reset" value="取消" />
			</p>
		</form>
	</div>

</body>
</html>