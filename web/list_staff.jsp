<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 17/10/20
  Time: 上午10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工列表</title>
    <script src="JQ3.2.1.js"></script>
    <style>
        table {
            width: 440px;
            text-align: center;
        }

        #in1 {
            font-size: 50px;
            width: 100px;
            height: 60px;
        }
    </style>
</head>
<body>
<h1>员工列表</h1>
<form action="findStaff.action" method="post">
    部门: <select name="departId" id="department">
    <option value="-1">---请选择---</option>
</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    职务: <select name="postId" id="post">
    <option value="-1">---请选择---</option>
</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input id="in1" type="submit" value="查询">
</form>
<table border="1">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>部门</th>
        <th>职务</th>
    </tr>
    <s:iterator value="staffs" var="staff">
        <tr>
            <td>${staff.id}</td>
            <td>${staff.sname}</td>
            <td>${staff.department.dname}</td>
            <td>${staff.post.pname}</td>
        </tr>
    </s:iterator>
</table>
<script>
    $(function () {
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
