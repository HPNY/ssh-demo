<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
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
<style>
        body {
            background-color: blanchedalmond;
        }

        center {
            position: relative;
            top: 100px;
        }
    </style>
</head>
<body>
<form action="UserServlet?flag=1" method="post">
        <center>
            <h1>登录</h1>
                               用户名：
            <input type="text" name="loginUser" />
            <br>
            <br> 密码：&nbsp;&nbsp;&nbsp;
            <input type="password" name="loginPassword" />
            <br>
            <br>
            <input type="submit" name="sign in" value="sign in" />
        </center>
    </form>
</body>
</html>
