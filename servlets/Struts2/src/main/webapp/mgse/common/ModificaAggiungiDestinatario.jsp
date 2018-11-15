<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="html" uri="/struts-tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/mgse/css/urm.css">
        <script type="text/javascript" src="<%=request.getContextPath()%>/mgse/js/jquery/jquery-3.2.1.js"></script>
    </head>
    <body>
    <s:form name="AddEditRecipient" action="AddEditRecipient" >
        <!-- BEGIN CENTRAL TABLE  ---------->
            <table border="0" cellpadding="0" cellspacing="0" width="700">
                <tr>
                    <!-- BEGIN CENTRAL TD ---------->
                    <td valign="top">
                        <table border="0" cellpadding="0" cellspacing="0" width="596">
                            <tr>
                                <td bgcolor="#FF9900" background="img/bgtitle_397x23.gif" width="397" height="23" class="task">&nbsp;&nbsp;
                                    <s:text name="mgse.labeltitle.recipient.add.edit" />
                                </td>
                            </tr>

                            <tr>
                                <td bgcolor="#EEEEEE">

                                    <table class="flowsTable">
                                        <tr>
                                            <td class="tdToRight">
                                                <s:text name="mgse.tableheader.flow.recipient.name.add.edit" ></s:text>:&nbsp
                                            </td>
                                            <td>
                                                <s:textfield  name="addEditRecipient"  />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="tdToRight">
                                                <s:text name="mgse.tableheader.flow.recipient.email.add.edit" ></s:text>:&nbsp
                                            </td>
                                            <td>
                                                <s:textfield name="addEditEmail" />
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>

                            <!-- END CENTRAL MASK ---------->
                            <tr><td class="border_bottom" colspan="2" align="center" >&nbsp;&nbsp;&nbsp;&nbsp</td></tr>
                            <tr>
                                <td colspan="2" align="center" bgcolor="#EEEEEE">
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                </td>
                            </tr>
                            <tr id="test">
                                <td colspan="2"  bgcolor="#EEEEEE" style="background:#EEEEEE" align="center" >
                                        <s:submit key="mgse.tableheader.flow.recipient.submit" class="submitForm" />
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center" bgcolor="#EEEEEE" id="errortd">
                                    <s:if test="hasActionErrors()">
                                        <s:actionerror class="errorCode"/>
                                    </s:if>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center" bgcolor="#EEEEEE">
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                </td>
                            </tr>
                        </table>
                    </td>
                    <!-- END CENTRAL TD ---------->
                </tr>
            </table>
            <!-- END CENTRAL TABLE ---------->
        </s:form>
    </body>
</html>
