<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.ericsson.gestionesw.persistence.dto.Trps" %>

<html>
<head>
<title>Gestione Software di Campo</title>
<link rel="stylesheet" href="./gestionesw/layouts/default/style.css" type="text/css">
	<script type="text/javascript" src="./gestionesw/js/jquery/jquery-3.3.1.js"></script>
<script>

    <% int MaxFiles =5; %>

    function confirmSubmit() {

        var tipoInstallazione,ambiente, codice;
        var indexRow=0,indexColumn=0;
        var files=new Array(maxFiles);
        var control = true;
        var reg = new RegExp('^\\d+$');
        var maxFiles=<%=MaxFiles%>;

        $('input[type=text],input[type=file],select').each(
			function(index){
				var input = $(this);

                var id = input.parent().parent().attr("id");

                console.log("ID del TAG TR:"+id);
                console.log("Index:"+index);

                // Evito le righe nascoste che sono dotate di ID, le righe della tabella sono senza ID
                if(!id) {
                    alert('Type:' + input.attr('type') + '  Name:' + input.attr('name') + '  Value:' + input.val());

                    // Controllo sul null
                    if(!input.val()){
                        alert(input.attr('name')+" non può essere vuoto!");
                        input.css({'background-color': 'red'});
                        control =false;
                        return control;
					}

					// Controllo sul formato dei campi inseritii
					switch(input.attr('name')){
						case "TipoInstallazione":
							tipoInstallazione=input.val();
							break;
						case "Codice":
							codice=input.val();
							break;
						case "Ambiente":
							ambiente=input.val();
							break;
						case "checkSum": // 0
                            if(!reg.test(input.val())) {
                                alert("La checksum deve essere un valore numerico");
                                input.css({'background-color': 'red'});
                                control =false;
                                return control;
							}
							break;
						case "minValue": // 1
                            if(reg.test(input.val())){
                                if(checkOverlap(input,files,indexRow)){
                                    var row = new Array(2);
                                    files[indexRow]=row;
                                    row[indexColumn]=input;
                                    indexColumn++;
                                }
                                else {
                                    alert("L'estremo dell'intervallo ricade in uno degli intervalli precedentemente definiti");
                                    control =false;
                                    return control;
                                }
                            }
                            else {
                                alert("L'estremo inferiore dell'intervallo deve essere un valore numerico");
                                input.css({'background-color': 'red'});
                                control =false;
                                return control;
                            }
							break;

						case "maxValue": // 2
                            if(reg.test(input.val())){

                                var minValueInput = files[indexRow][indexRow];

                                if(input.val()>minValueInput.val()){
                                    if(checkOverlap(input,files,indexRow)) {
                                        files[indexRow][indexColumn] = input;
                                        indexColumn = 0;
                                        indexRow++;
                                    }
                                    else {
                                        alert("L'estremo dell'intervallo ricade in uno degli intervalli precedentemente definiti");
                                        control =false;
                                        return control;
                                    }
								}
                                else{
                                    alert("L'estremo superiore dell'intervallo "+input.val()+" non può essere inferiore o uguale all'estremo inferiore "+minValueInput.val());
                                    input.css({'background-color': 'red'});
                                    control =false;
                                    return control;
                                }
                            }
                            else {
                                alert("L'estremo superiore dell'intervallo deve essere un valore numerico");
                                input.css({'background-color': 'red'});
                                control =false;
                                return control;
                            }
                            break;

                        case "fileUpload": // 3
                            break;

                    }
                }
			}
    	);

        return false;

    }

    function checkOverlap(input, ranges, rangeNum){

        if(ranges.length!=0){
            for(var i = 0; i < rangeNum; i++) {
                var range = ranges[i];
                if(input.val() >=range[0].val()&&input.val() <=range[1].val()){
                    input.css({'background-color': 'red'});
                    return false;
				}
 /*               for(var j = 0; j < range.length; j++) {
                    //display("range[" + i + "][" + j + "] = " + range[j]);

                	input=range[j];
                }*/
            }
		}
		else
		    return true;

        return true;
	}

    /*

         <tr id="hiddenRow1" align="left" style='visibility:collapse'>
            <td  colspan="3">Nome File: &nbsp;</td>
             <td  colspan="3"><label for="checksum">Checksum2 :</label><input type="text" id ="checksum"name="checkSum" size="5" maxlength="10" value=""/></td>
             <td  colspan="1"><label for="min">Min :</label><input id="min" type="text" name="minValue" size="5" maxlength="10" value=""/></td>
             <td  colspan="1"><label for="max">Max :</label><input id="max" type="text" name="MaxValue" size="5" maxlength="10" value=""/></td>
         </tr>
         <tr id="hiddenRow2" align="center" style='visibility:collapse'>
             <td colspan="7"><label for="fileUpload">Carica File2 &nbsp;</label><input id="fileUpload" type="file" name="fileUpload" onchange="changeFileName()"/></td>
             <td align="right" colspan="1"><input type="submit" class="button" id="deleteFile" name="delFile" value="Elimina File" size="50" maxlength="50" /></td>
         </tr>
         <tr id="hiddenRow3" style='visibility:collapse'>
             <td style="border-bottom: 2px solid #003366;" align="right" colspan="8">&nbsp;</td>
         </tr>

         */

    function confirmSubmit2(){

        var control = true;
        var controlType = true;
        var controlCheckSum = true;
        var controlTipoRelease = true;

        if(confirm("You are currently modifying a record. Are you sure?")){

            if(document.forms[0].type.value==null || document.forms[0].type.value==''){
                alert('Field Tipo Installazione cannot be empty.');
                document.forms[0].type.focus();
                controlType = false;
            }

            if(document.forms[0].checkSum.value==null || document.forms[0].checkSum.value==''){
                alert('Field CheckSum cannot be empty.');
                document.forms[0].checkSum.focus();
                controlCheckSum = false;
            }

            if((document.forms[0].fileUpload.value!=null && document.forms[0].fileUpload.value!='')&&(document.forms[0].tipoRelease.value==null || document.forms[0].tipoRelease.value=='')){
                alert('Field Tipo Release cannot be empty if you choose to upload a file.');
                document.forms[0].tipoRelease.focus();
                controlTipoRelease = false;
            }

            document.forms[0].action="ModificaTRPSServlet";

            control = controlType && controlCheckSum && controlTipoRelease;

        } else {

            control = false;
        }

        return control;
    }

    function back(){
        var control = true;
        document.forms[0].action="./accessoTRPS.jsp";
        return control;
    }


  $(document).ready(function() {
        $("input").click(function(e) {

            var buttonType = $(e.target).attr("name");
            console.log("Tipo bottone. "+buttonType);

            if (buttonType=="delFile")  {

                console.log("Elemento padre: "+$(e.target).parent().parent().prop("tagName"));

                var middleTr=$(e.target).parent().parent();

                middleTr.prev().remove();
                middleTr.next('tr').remove();
                middleTr.remove();

            }
            else if (buttonType=="addFile"){

                var maxFiles=<%=MaxFiles%>;

                var rowFiles = ($('#filesTable tr').length-9)/3;

                console.log("Righe tabella: "+rowFiles);

                if(rowFiles<maxFiles){

                    var hiddenRow1 = $("#hiddenRow1");
                    var hiddenRow2 = $("#hiddenRow2");
                    var hiddenRow3 = $("#hiddenRow3");


                    var hiddenRow3Clone = hiddenRow3.clone(true).attr("style", "visibility: visible");
                    hiddenRow3Clone.removeAttr("id");

                    hiddenRow3Clone.insertBefore(hiddenRow1);

                    var hiddenRow2Clone = hiddenRow2.clone(true).attr("style", "visibility: visible");
                    hiddenRow2Clone.removeAttr("id");

                    hiddenRow2Clone.insertBefore(hiddenRow3Clone);

                    var hiddenRow1Clone = hiddenRow1.clone(true).attr("style", "visibility: visible");
                    hiddenRow1Clone.removeAttr("id");

                    hiddenRow1Clone.insertBefore(hiddenRow2Clone);

                }
				else
				    alert("Non si possono aggiungere più di "+maxFiles+" files");

            }
            else{
                if($(e.target).attr("id")!="submit")
                	$(e.target).css({'background-color': 'aliceblue'});
			}

        });

    });

    $(document).ready(function() {
        $("input").on("change", function(e) {

            var buttonType = $(e.target).attr("name");
            console.log("Tipo bottone. "+buttonType);

            if(buttonType=="fileUpload") {

                var originalFileItemName = $(e.target).val();
                var fileName;

                if (originalFileItemName != null) {
                    fileName = originalFileItemName.replace(/^.*[\\\/]/, '');
                }

                console.log("file name:" + fileName);

                var firstTr = $(e.target).parent().parent().prev().find("td:nth-child(1)").html("Nome File: " + fileName);

            }
        });

    });


</script>
</head>
<%

	String typeInstallUff = request.getParameter("typeInstallUff");
    String tipoUsoRelease = request.getParameter("tipoUsoRelease");
    String code = request.getParameter("code");
    String jspTitle="";

    String opType="new";

    if(opType.equals("edit")){
        jspTitle="Modifica TRPS";

    }
    else if (opType.equals("delete")){
        jspTitle="Cancella TRPS";

    }
    else if(opType.equals("duplicate")){
        jspTitle="Duplica TRPS";
    }
    else if(opType.equals("new")){
        jspTitle="Nuovo TRPS";
    }

    Logger logger = Logger.getLogger("modificaTRPS.jsp");

    List<Trps> trpsGroup = new ArrayList<Trps>();


%>

<body>
	<form method="post" enctype="multipart/form-data">
		<br>
		<table border="0" cellpadding="0" cellspacing="0" width="1024">
			<tr>
				<td valign="top"></td>
				<%--<td valign="top"><jsp:include flush="true" page="./leftMenu.jsp"></jsp:include></td>--%>
				<td valign="top">
					<table width="864" border="0" cellpadding="3" cellspacing="0">
						<tr height="16">
							<td style="background-color: #003366;width: 100%" class="white">&nbsp;&nbsp;<%=jspTitle%></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>
							<table width="85%" border="1" cellpadding="2" cellspacing="0" bordercolor="#003366" bgcolor="aliceblue" align="center" id="filesTable">
								<tr align="center" bgcolor="#003366" height="16">
									<td style="font-size: x-small;border: 1px solid #003366;color: white" colspan="8">CONFIGURAZIONE</td>
								</tr>
								<%if(opType.equals("edit")||opType.equals("delete")){%>
								<tr>
									<td align="right" colspan="2">Tipo Installazione : </td>
									<td>&nbsp;<%=typeInstallUff%></td>
									<td align="right" colspan="2">Codice : </td>
									<td>&nbsp;<%=code%></td>
									<td align="right">Ambiente :</td>
									<td>&nbsp;<%=tipoUsoRelease%></td>
								</tr>
								<%} else if (opType.equals("new")){%>
								<tr>
									<td align="right" colspan="2">Tipo Installazione : </td>
									<td>&nbsp;<input type="text" name="TipoInstallazione" size="10" maxlength="10" /></td>
									<td align="right" colspan="2">Codice : </td>
									<td>&nbsp;
										<select name="Codice">
											<option value="SET" selected="selected">SET</option>
											<option value="PAR">PAR</option>
										</select>
									</td>
									<td align="right" >Ambiente :</td>
									<td>&nbsp;
										<select name="Ambiente">
											<option value="TEST" selected="selected">TEST</option>
											<option value="PROD">PRODUZIONE</option>
										</select>
									</td>
								</tr>
								<%} else if (opType.equals("duplicate")){%>
								<tr>
									<td align="right" colspan="2">Tipo Installazione : </td>
									<td>&nbsp;<input type="text" name="TipoInstallazione" size="10" maxlength="10" value="<%=typeInstallUff%>" /></td>
									<td align="right" colspan="2">Codice : </td>
									<td>&nbsp;
										<select name="Codice">
											<option value="SET" <%if(code.equals("SET")){%> selected="selected" <%}%>>SET</option>
											<option value="PAR" <%if(code.equals("PAR")){%> selected="selected" <%}%>>PAR</option>
										</select>
									</td>
									<td align="right" >Ambiente :</td>
									<td>&nbsp;
										<select name="Ambiente">
											<option value="TEST" <%if(code.equals("TEST")){%> selected="selected" <%}%>>TEST</option>
											<option value="PROD" <%if(code.equals("PROD")){%> selected="selected" <%}%>>PROD</option>
										</select>
									</td>
								</tr>
								<% }

								if (!opType.equals("delete")){
                                %>
								<tr>
									<td align="right" colspan="8"><input type="button" class="button" id="addFile" name="addFile" value="Aggiungi File" size="50" maxlength="50" /></td>
								</tr>
                                <%}%>
								<tr align="center" bgcolor="#0066cc" height="16">
									<td style="font-size: x-small;border: 1px solid #003366;color: white" colspan="8">FILE ASSOCIATI ALLA CONFIGURAZIONE</td>
								</tr>

								<%
								for(Trps trps:trpsGroup){
									if(opType.equals("edit")||opType.equals("duplicate")){
										%>
											<tr align="left">
												<td  colspan="3">Nome File: &nbsp;<%=trps.getFileName()%></td>
												<td  colspan="3"><label for="checksum">Checksum :</label><input type="text"  name="checkSum" size="5" maxlength="10" value="<%=trps.getCheckSum()%>"/></td>
												<td  colspan="1"><label for="min">Min :</label><input  type="text" name="minValue" size="5" maxlength="10" value="<%=trps.getTrpsId().getRangeMinValue()%>"/></td>
												<td  colspan="1"><label for="max">Max :</label><input  type="text" name="maxValue" size="5" maxlength="10" value="<%=trps.getRangeMaxValue()%>"/></td>
											</tr>
											<tr align="center">
												<td colspan="7"><label for="fileUpload">Carica File &nbsp;</label><input  type="file" name="fileUpload""/></td>
												<td align="right" colspan="1"><input type="submit" class="button"  name="delFile" value="Elimina File" size="50" maxlength="50"/></td>
											</tr>
											<tr>
												<td style="border-bottom: 2px solid #003366;" align="right" colspan="8">&nbsp;</td>
											</tr>
										<%
									}
									else if (opType.equals("delete")){
										%>
											<tr align="left">
												<td  colspan="3">Nome File: &nbsp;<%=trps.getFileName()%></td>
												<td  colspan="3">Checksum :<%=trps.getCheckSum()%></td>
												<td  colspan="1">Min :<%=trps.getTrpsId().getRangeMinValue()%></td>
												<td  colspan="1">Max :<%=trps.getRangeMaxValue()%></td>
											</tr>
											<tr>
												<td style="border-bottom: 2px solid #003366;" align="right" colspan="8">&nbsp;</td>
											</tr>
										<%
									}
								}
								%>


								<tr id="hiddenRow1" align="left" style='visibility:collapse'>
								   <td  colspan="3">Nome File: &nbsp;</td>
									<td  colspan="3"><label for="checksum">Checksum2 :</label><input type="text" id ="checksum"name="checkSum" size="5" maxlength="10" value=""/></td>
									<td  colspan="1"><label for="min">Min :</label><input id="min" type="text" name="minValue" size="5" maxlength="10" value=""/></td>
									<td  colspan="1"><label for="max">Max :</label><input id="max" type="text" name="maxValue" size="5" maxlength="10" value=""/></td>
								</tr>
								<tr id="hiddenRow2" align="center" style='visibility:collapse'>
									<td colspan="7"><label for="fileUpload">Carica File2 &nbsp;</label><input id="fileUpload" type="file" name="fileUpload"/></td>
									<td align="right" colspan="1"><input type="submit" class="button" id="deleteFile" name="delFile" value="Elimina File" size="50" maxlength="50" /></td>
								</tr>
								<tr id="hiddenRow3" style='visibility:collapse'>
									<td style="border-bottom: 2px solid #003366;" align="right" colspan="8">&nbsp;</td>
								</tr>


								<tr ><td colspan="8"></td></tr>
								<tr>
									<td colspan="8" align="right">
										<%if (opType.equals("delete")){%>
											<input type="submit" class="button" id="submit" value="&nbsp;&nbsp;&nbsp;Cancella&nbsp;&nbsp;&nbsp;" onclick="return confirmSubmit();"/>
										<%} else {%>
											<input type="submit" class="button" id="submit" value="&nbsp;&nbsp;&nbsp;Salva&nbsp;&nbsp;&nbsp;" onclick="return confirmSubmit();"/>
										<%}%>
										<input type="hidden" name="code" value="<%=code%>"/>
										<input type="hidden" name="tipoRelease" value="<%=tipoUsoRelease%>"/>
										<input type="hidden" name="typeInstallUff" value="<%=typeInstallUff%>"/>
										<input type="hidden" name="numFiles" value=""/>
										<input type="submit" class="button" id="annulla" name="annulla" value="Annulla" onclick="return back();"/>
									</td>
								</tr>
							</table>
						</td></tr>
					</table>
				</td>
			</tr>
		</table>
		<br>
		<table border="0" cellpadding="0" cellspacing="0" width="1024">
			<tr>
				<td style="background-color: #003366"></td>
			</tr>
	<%-- 	<tr>
				<td id="clock" align="right"></td>
			</tr>
	--%>		
		</table>
	</form>
</body>
</html>