<%--<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html><body>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %>

--%>

    <link rel="StyleSheet" href="<%=request.getContextPath()%>/mgse/css/urm_dtree.css" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/mgse/js/dtree.js"></script>

	
<script type="text/javascript">
<%
	String menu=(String)pageContext.findAttribute("menu");
	out.print(menu);
%>
</script>
</body></html>
