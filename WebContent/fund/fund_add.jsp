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
	<div class="content-box-header">
		<h3>新增基金信息</h3>
	</div>

	<div class="content-box-content">
		<form name="form1" action="fund/addFund.action" method="post"
		onSubmit="return checkNull()">
			<p>
				基金名字：<input class="text-input large-input" type="text"
					name="fund.name" />
			</p>
			<p>
				基金价格：<input class="text-input large-input" type="text"
					name="fund.price" />
			</p>
			<p>
				基金描述：
				<textarea class="text-input textarea" rows="16" cols="50"
					name="fund.description"></textarea>
			</p>
			<p>
				基金状态： <input type="radio" name="fund.status" value="Y" checked />可交易
				<input type="radio" name="fund.status" value="N" />不可交易
			</p>
			<p>
				<input class="button" type="submit" value="新增" /> <input
					class="button" type="reset" value="取消" />
			</p>
		</form>
	</div>

</body>
</html>