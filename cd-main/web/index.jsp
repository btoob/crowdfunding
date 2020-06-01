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
    <%--refresh,自动刷新并指向新页面，其中3是指停留3秒后自动刷新到URL网址--%>
    <%--比如网页上经常出现3秒后跳转到什么什么页面--%>
    <meta http-equiv="Refresh" content="0;URL=${APP_PATH }/index.htm"> 
    <title>Title</title>
</head>
<body>
<%--    index 这是主页面--%>
<%--    在主页面随便加一个连接--%>
<%--    <a href="${pageContext.request.contextPath}/test.do">来测试项目环境有没有搞定</a>--%>
<%--    <a href="${APP_PATH}/test.do">来测试项目环境有没有搞定</a>--%>
<%--    <jsp:forward page="${APP_PATH}/index.htm"></jsp:forward>--%>
</body>
</html>
