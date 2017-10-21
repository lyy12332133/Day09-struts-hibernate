<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 17/10/21
  Time: 下午2:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加员工</title>
    <script src="JQ3.2.1.js"></script>
    <style>
        button {
            font-size: 18px;
            width: 90px;
            height: 25px;
        }
    </style>
</head>
<body>
<h1>添加员工</h1>
<form action="addStaff.action" method="post">
    姓名: <input type="text" name="sname"> <br>
    部门: <select name="departId" id="department">
    <option value="-1">---请选择---</option>
</select><br>
    职务: <select name="postId" id="post">
    <option value="-1">---请选择---</option>
</select><br>
    验证码: <input type="text" name="code"> <img id="img1" src="${pageContext.request.contextPath}/codeImg.action">
    <br>
    <button type="submit">添加员工</button>
</form>
<s:fielderror/>
<script>
    $(function () {
        $("#img1").click(function () {
            this.src = "${pageContext.request.contextPath}/codeImg.action?a="+Math.random();
        })
        $.post("${pageContext.request.contextPath}/findDepart.action",
                null,
                function (data) {
                    var _html = "<option value='-1'>---请选择---</option>";
                    $.each(data, function (index, value) {
                        _html += '<option value="' + value.id + '">' + value.dname + '</option>'
                    });
                    $("#department").html(_html)
                },
                "json");

        $("#department").change(function () {
            $.post("${pageContext.request.contextPath}/findPost.action",
                    {
                        departId: $("#department").val()
                    },
                    function (data) {
                        var _html = "<option value='-1'>---请选择---</option>";
                        $.each(data, function (index, value) {
                            _html += '<option value="' + value.id + '">' + value.pname + '</option>'
                        });
                        $("#post").html(_html)
                    },
                    "json");
        });
    });
</script>
</body>
</html>
