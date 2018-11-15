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

        function flowChosen(clicked_id)
        {
            var url = document.forms[0].action+'?requestid='+clicked_id;
            document.forms[0].action=url;
            document.forms[0].submit();
        }

        function flowChoseAjax(flowCodeChosen) {

            var button = $("#" + flowCodeChosen);
            button.attr("disabled","disabled");

            var statusFlowJSP=false;

            if(button.attr("class")=="buttonGreen")
                statusFlowJSP=true;

            $.ajax({
                type:"GET",
                url:"AbilitazioneDisabilitazioneFlussiAjax.action",
                data:"flowCodeChosen="+flowCodeChosen.substr(8,flowCodeChosen.length)+"&statusFlowJSP="+statusFlowJSP.toString(),
                cache: false,
                success: function(result){

                    button.removeAttr("disabled");

                    if(result.errorMsgAjax.length==0){

                        $("#errortd").html("");

                        if(result.statusFlow) {
                            button.attr("value", "<s:text name='mgse.labelbutton.flow.disable'/>");
                            button.attr("class", "buttonGreen");
                        }
                        else{
                            button.attr("value", "<s:text name='mgse.labelbutton.flow.enable'/>");
                            button.attr("class", "buttonRed");
                        }
                    }
                    else{
                        $("#errortd").html(result.errorMsgAjax);
                        $("#errortd").attr("class", "errorCode");
                    }
                },
                error: function(result){
                    button.removeAttr("disabled");
                    alert("Errore nella abilitazione disabilitazione flusso");
                }
            });
        }
    </script>
    <body>

        <!-- BEGIN CENTRAL TABLE  ---------->
        <s:form name="abilitazioneflussi" action="AbilitazioneDisabilitazioneFlussi" >
            <table border="0" cellpadding="0" cellspacing="0" width="100%">
                <tr>
                    <!-- BEGIN CENTRAL TD ---------->
                    <td valign="top">
                        <table border="0" cellpadding="0" cellspacing="0" width="100%">
                            <tr>
                                <td bgcolor="#FF9900" background="img/bgtitle_397x23.gif" width="397" height="23" class="task">&nbsp;&nbsp;
                                    <s:text name="mgse.labeltitle.flowsopenclose" />
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
                                                &nbsp;&nbsp;&nbsp;&nbsp;<s:text name="mgse.tableheader.flow.description"/>
                                            </th>
                                            <th>
                                                &nbsp;&nbsp;&nbsp;&nbsp;<s:text name="mgse.tableheader.flow.code"/>
                                            </th>
                                            <th>
                                                &nbsp;&nbsp;&nbsp;&nbsp;<s:text name="mgse.tableheader.flow.poller.name"/>
                                            </th>
                                            <th>
                                                &nbsp;&nbsp;&nbsp;&nbsp;<s:text name="mgse.tableheader.flow.external.system"/>
                                            </th>
                                            <th style="text-align: center">
                                                <s:text name="mgse.tableheader.flow.enabledisable"/>
                                            </th>
                                        </tr>

                                        <%--<tr>
                                            <td colspan="5">&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                        </tr>--%>

                                        <s:iterator value="flowsWithState" status="itStatus">
                                            <tr >
                                                <td>
                                                    &nbsp;&nbsp;&nbsp;&nbsp;<s:property value="description" />
                                                </td>
                                                <td>
                                                    &nbsp;&nbsp;&nbsp;&nbsp;<s:property value="flowCode" />
                                                </td>
                                                <td>
                                                    &nbsp;&nbsp;&nbsp;&nbsp;<s:property value="pollerName" />
                                                </td>
                                                <td>
                                                    &nbsp;&nbsp;&nbsp;&nbsp;<s:property value="subsystem" />
                                                </td>
                                                <td style="text-align: center">
                                                    <s:if test="enabled">
                                                        <input type="button" value="<s:text name="mgse.labelbutton.flow.disable"/>" onclick="flowChoseAjax(this.id)" id="flowCode<s:property value="flowCode" />" class="buttonGreen"/>
                                                    </s:if>
                                                    <s:else>
                                                        <input type="button" value="<s:text name="mgse.labelbutton.flow.enable"/>" onclick="flowChoseAjax(this.id)" id="flowCode<s:property value="flowCode" />" class="buttonRed"/>
                                                    </s:else>
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
        </s:form>
    </body>


</html>
