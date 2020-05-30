<%--
  Created by IntelliJ IDEA.
  User: 胖虎
  Date: 2020/5/28
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    index 这是主页面--%>
<%--    在主页面随便加一个连接--%>
<%--    <a href="${pageContext.request.contextPath}/test.do">来测试项目环境有没有搞定</a>--%>
<%--    <a href="${APP_PATH}/test.do">来测试项目环境有没有搞定</a>--%>
    <jsp:forward page="${APP_PATH}/index.htm"></jsp:forward>
</body>
</html>
