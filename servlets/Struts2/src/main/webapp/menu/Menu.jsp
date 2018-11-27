<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
    <title>Struts 2 in Action: Menu</title>
	</head>

	<body style="background-color:powderblue;">
	
	  <!-- The property struts tag reads the value off the value stack.  In our case
	       the Struts 2 framework has automatically made the Java bean properties of
	       our action available to the result.  We just need to match the nomenclature
	       of our value paramater below with the Java Beans attribute name of our 
	       HelloWorld action.  
	  -->      
  <hr>   
  <ul>
      <li><a href="<s:url action='chapterTwo/Name'/>">HelloWorld</a></li>
      <li><a href="<s:url action='chapterTwo/AnnotatedNameCollector'/>">AnnotatedHelloWorld</a></li>
      <li><a href="<s:url action='chapterThree/PortfolioHomePage'/>">Struts 2 Portfolio (Chapter 3)</a></li>

      <li><a href="<s:url action='tiles_example/HelloWorld'/>">Tiles Example Hello World</a></li>
      <li><a href="<s:url action='mgse/MenuGSE'/>">MENU GSE</a></li>
      <li><a href="<s:url action='datatable'/>">DataTable</a></li>
      <li><a href="<s:url action='oldejb/Ejb20Test'/>">Test EJB 2.0 </a></li>

      <!--

     <li><a href="<s:url action='chapterFour/PortfolioHomePage'/>">Struts 2 Portfolio (Chapter 4)</a></li>	
     <li><a href="<s:url action='chapterFive/PortfolioHomePage'/>">Struts 2 Portfolio (Chapter 5)</a></li>	
     <li><a href="<s:url action='chapterSix/PortfolioHomePage'/>">Struts 2 Portfolio (Chapter 6)</a></li>	
     <li><a href="<s:url action='chapterSeven/PortfolioHomePage'/>">Struts 2 Portfolio (Chapter 7)</a></li>	
     <li><a href="<s:url action='chapterEight/PortfolioHomePage'/>">Struts 2 Portfolio (Chapter 8)</a></li>	
     <li><a href="<s:url action='chapterNine/PortfolioHomePage'/>">Struts 2 Portfolio (Chapter 9)</a></li>	
     <li><a href="<s:url action='chapterTen/PortfolioHomePage'/>">Struts 2 Portfolio (Chapter 10)</a></li>	
     <li><a href="<s:url action='chapterEleven/PortfolioHomePage'/>">Struts 2 Portfolio (Chapter 11)</a></li>

      -->

  </ul>
  <hr>

      <img src="mgse/img/EditEmail.png" alt="Smiley face" height="25" width="29">

	</body>
	
</html>
