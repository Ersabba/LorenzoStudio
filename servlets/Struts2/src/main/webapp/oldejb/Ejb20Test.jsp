<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12/11/2018
  Time: 09:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EJB 2.0 Test</title>
</head>
<body>
    <hr>
    <h4>Chiamata EJB</h4>
        <s:form action="ejbCall">
            <s:submit key="ChiamataEjb" />
            <s:property value="beanResult" />
        </s:form>
    <hr>
</body>
</html>
