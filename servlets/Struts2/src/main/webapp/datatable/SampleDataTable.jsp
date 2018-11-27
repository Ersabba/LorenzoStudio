<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 19/11/2018
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <title>Title</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery.dataTables.min.css">
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/datatable/jquery/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/datatable/jquery.dataTables.min.js"></script>
    </head>
</head>
<script language="JavaScript">

    $(document).ready(function() {
        $('#example').DataTable( {
            "processing": true,
            "serverSide": true,
            "ajax": "LoadDataTable.action"
        } );
    } );
</script>
<body>

    <table id="example" class="display" style="width:100%">
        <thead>
        <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Position</th>
            <th>Office</th>
            <th>Start date</th>
            <th>Salary</th>
        </tr>
        </thead>
        <tfoot>
        <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Position</th>
            <th>Office</th>
            <th>Start date</th>
            <th>Salary</th>
        </tr>
        </tfoot>
    </table>

</body>
</html>
