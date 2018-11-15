<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="html" uri="/struts-tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/mgse/css/urm.css">
        <script type="text/javascript" src="<%=request.getContextPath()%>/mgse/js/jquery/jquery-3.2.1.js"></script>
    </head>
    <script language="JavaScript">

        $(document).ready(function() {
            $("input").click(function(e) {
                var buttonType = $(e.target).attr("name");
                console.log("Tipo bottone. "+buttonType);

                console.log("Elemento padre: "+$(e.target).parent().parent().prop("tagName"));
                console.log("Elemento figlio: "+$(e.target).parent().parent().find("td:nth-child(2)").text().trim());

                var email = $(e.target).parent().parent().find("td:nth-child(2)").text().trim();
                var recipient = $(e.target).parent().parent().find("td:nth-child(1)").text().trim();

                var tr = $(e.target).parent().parent();

                $("#errortd").html("");

                if(buttonType=="deleteEmail"){

                    var r = confirm("Vuoi cancellare l'utente " +email +"?");
                    if (r == true) {
                        console.log("Call AJAX action for deleting user");

                        $.ajax({
                            type:"GET",
                            url:"CancellaEmailDestinatarioAjax.action",
                            data:"emailToDelete="+email,
                            cache: false,
                            success: function(result){

                                if(result.errorMsgAjax.length==0){

                                    $("#errortd").html("");

                                    if(result.emailDeleted)
                                        tr.remove();
                                }
                                else{
                                    $("#errortd").html(result.errorMsgAjax);
                                    $("#errortd").attr("class", "errorCode");
                                }
                            },
                            error: function(result){
                                alert("Errore nella cancellazione della mail "+mail);
                            }
                        });

                    } else {
                        console.log("Cancellazione utente annullata");
                    }
                } // deleteEmail
                else {

                    console.log("Email da modificare: "+email);
                    console.log("Detinatario da cancellare: "+recipient);

                    document.editRecipient.addEditRecipient.value = recipient;
                    document.editRecipient.addEditEmail.value = email;
                    document.editRecipient.submit();

                } // editEmail

            });

        });

    </script>
    <body>

        <!-- BEGIN CENTRAL TABLE  ---------->
            <table border="0" cellpadding="0" cellspacing="0" width="100%">
                <tr>
                    <!-- BEGIN CENTRAL TD ---------->
                    <td valign="top">
                        <table border="0" cellpadding="0" cellspacing="0" width="80%">
                            <tr>
                                <td bgcolor="#FF9900" background="img/bgtitle_397x23.gif" width="397" height="23" class="task">&nbsp;&nbsp;
                                    <s:text name="mgse.labeltitle.recipient.list" />
                                </td>
                            </tr>
                            <tr >
                                <td colspan="2" bgcolor="#EEEEEE">&nbsp;</td>
                            </tr>
                            <tr><td class="border_top" colspan="2" align="center" >&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
                            <!-- BEGIN CENTRAL MASK ---------->

                            <tr>
                                <td bgcolor="#EEEEEE">

                                    <table class="flowsTable">

                                        <tr>
                                            <th>
                                                &nbsp;&nbsp;&nbsp;&nbsp;<s:text name="mgse.tableheader.flow.recipient.name"/>
                                            </th>
                                            <th>
                                                &nbsp;&nbsp;&nbsp;&nbsp;<s:text name="mgse.tableheader.flow.recipient.email"/>
                                            </th>
                                            <th width="50px">
                                                &nbsp;&nbsp;&nbsp;&nbsp;
                                            </th>
                                            <th width="50px">
                                                &nbsp;&nbsp;&nbsp;&nbsp;
                                            </th>
                                        </tr>
                                        <s:iterator value="emails" status="itStatus">
                                            <tr>
                                                <td >&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="destinatario"/></td>
                                                <td >&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="email"/></td>
                                                <td width="50px">
                                                    <input type="image" src="img/EditEmail.png"  name="editEmail" id="<s:property value="email"/>"  />
                                                </td>
                                                <td width="50px">
                                                    <input type="image" src="img/DelEmail.png" name="deleteEmail" id="<s:property value="email" />" />
                                                </td>
                                            </tr>
                                        </s:iterator>
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
    </body>

    <s:form name="editRecipient" action="AddEditRecipient">
        <input type="hidden" name="addEditRecipient" value="">
        <input type="hidden" name="addEditEmail" value="">
        <input type="hidden" name="EmailModify" value="true">
    </s:form>

</html>
