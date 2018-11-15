<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC “-//W3C//DTD HTML 4.01 Frameset//IT” “http://www.w3.org/TR/html4/frameset.dtd”>
<%
	String pathJSP = "web/2016/jsp_include/";
	String pathImage = "img/";
%>
</head>
<FRAMESET style="width:100%;" rows="100px,35px,*" cols="100%" framespacing="0" border="0"> 
		<FRAME name="banner" src="<%=pathJSP%>banner.jsp" frameborder="0" style="overflow:hidden; width: 100%;" noresize="noresize" scrolling="no" /> 
		<FRAME name="banner" src="<%=pathImage%>HP_MGSE_2.jpg" noresize="noresize" scrolling="no" frameborder="0" />
		<FRAMESET cols="200px,*" rows="100%" border="0" framespacing="0"> 				
			<FRAME name="menu" style="overflow:hidden;border-right:2px solid black;padding: 0px 0px 0px 0px;" src="<%=request.getContextPath()%>/mgse/GenerateMenu.action" />
			<FRAME name="body" style="overflow-x:hidden;overflow-y:auto;padding: 0px 0px 0px 0px;border: 3px;" frameborder="5" marginwidth="25px" src="<%=request.getContextPath()%>/mgse/common/welcome.jsp"/>
		</FRAMESET> 
</FRAMESET>
</html>	