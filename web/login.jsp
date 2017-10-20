<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 17/10/20
  Time: 下午2:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="JQ3.2.1.js"></script>
</head>
<body>
<form action="login.action" method="post">
用户名: <input type="text"> <br>
密码: <input type="password"> <br>

验证码: <input name="code" size="4"><img id="img" src="${pageContext.request.contextPath}/codeImg.action"> <br>

<input type="submit" value="登录">
</form>
<s:fielderror/>
<script>
    $(function () {
        $("#img").click(function () {
            this.src="${pageContext.request.contextPath}/codeImg.action?ss="+ Math.random()
        })
    })

</script>
</body>
</html>
