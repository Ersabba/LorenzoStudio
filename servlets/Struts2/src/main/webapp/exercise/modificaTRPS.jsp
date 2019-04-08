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

    <%

     // Parametro da impostare su properties
     int maxFiles =5;
     String typeInstallUff = request.getParameter("typeInstallUff");
     String tipoUsoRelease = request.getParameter("tipoUsoRelease");
     String code = request.getParameter("code");
     String opType = request.getParameter("operationType");
     String jspTitle="";

     opType="new";

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

     List<Trps> trpsGroup = new ArrayList<Trps>();


     %>

    function confirmSubmit() {

        var maxFiles=<%=maxFiles%>;
        var opType="<%=opType%>";

        var tipoInstallazione,ambiente, codice;
        var indexRow=0,indexColumn=0;
        var files=new Array(maxFiles);
        var control = true;
        var reg = new RegExp('^\\d+$');



        $('input[type=text],input[type=file],select').each(
            function(index){
                var input = $(this);

                var id = input.parent().parent().attr("id");

                var attributeName=input.attr('name');
                var cleanedAttrName = attributeName;

                // Evito le righe nascoste che sono dotate di ID, le righe della tabella sono senza ID
                if((!id) && input.attr("id")!="serverClock"){
                    alert('Type:' + input.attr('type') + '  Name:' + input.attr('name') + '  Value:' + input.val());

                    // Cambio i nomi degli attributi
                    if(attributeName!="TipoInstallazione"&&attributeName!="Ambiente"&&attributeName!="Codice"){
                        cleanedAttrName = attributeName.replace(/[0-9]/g, '');

                        console.log("cleanedAttrName:"+cleanedAttrName);
                        //var cleanedAttrName = cleanedAttrName +
                        input.attr("name",cleanedAttrName+(indexRow+1));
                        console.log("Valore Attributo:"+input.attr("name"));
                    }

                    // Controllo sul null
                    if(!input.val()&&cleanedAttrName!="nomeFile"){

                        if(cleanedAttrName=="fileUpload"){
                            // File non impostato dalla JSP precedente o dal tasto upload della JSP attuale
                            if(!input.parent().parent().prev().find("td:nth-child(1)").find("input").attr("value")){
                                alert(cleanedAttrName+" Selezionare il file per effettuare l'upload!");
                                input.css({'background-color': 'red'});
                                control =false;
                                return control;
                            }
                        }
                        else{
                            alert(cleanedAttrName+" non può essere vuoto!");
                            input.css({'background-color': 'red'});
                            control =false;
                            return control;
                        }
                    }

                    // Controllo sul formato dei campi inseritii
                    console.log(" switch cleanedAttrName:"+cleanedAttrName);

                    switch(cleanedAttrName){
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
                            if(reg.test(input.val())||(parseInt(input.val(),10)==-1)){
                                if(checkOverlap(input,files,indexRow)){
                                    var row = new Array(2);
                                    files[indexRow]=row;
                                    row[indexColumn]=input;
                                    indexColumn++;
                                }
                                else {
                                    control =false;
                                    return control;
                                }
                            }
                            else {
                                alert("L'estremo inferiore dell'intervallo deve essere un intero positivo oppure -1");
                                input.css({'background-color': 'red'});
                                control =false;
                                return control;
                            }
                            break;

                        case "maxValue": // 2
                            if(reg.test(input.val())||(parseInt(input.val(),10)==-1)){

                                var minValueInput = parseInt(files[indexRow][indexColumn-1].val(),10);
                                var maxValueInput = parseInt(input.val(),10);

                                console.log("Valore minimo:"+minValueInput);
                                console.log("Valore massimo:"+maxValueInput);

                                if(((minValueInput==-1)&&(maxValueInput!=-1))||((minValueInput!=-1)&&(maxValueInput==-1))){
                                    alert("Per definire un intervallo di default entrambi gli estremi devono essere impostati a -1");
                                    input.css({'background-color': 'red'});
                                    files[indexRow][indexColumn-1].css({'background-color': 'red'});
                                    control =false;
                                    return control;
                                }

                                if((maxValueInput>minValueInput)||((minValueInput==-1)&&(maxValueInput==-1))){
                                    if(checkOverlap(input,files,indexRow)) {
                                        files[indexRow][indexColumn] = input;
                                        indexColumn = 0;
                                    }
                                    else {
                                        control =false;
                                        return control;
                                    }
                                }
                                else{
                                    alert("L'estremo superiore dell'intervallo "+maxValueInput+" non può essere inferiore o uguale all'estremo inferiore "+minValueInput);
                                    control =false;
                                    return control;
                                }
                            }
                            else {
                                alert("L'estremo superiore dell'intervallo deve essere un intero positivo oppure -1");
                                input.css({'background-color': 'red'});
                                control =false;
                                return control;
                            }
                            break;

                        case "fileUpload": // 3

                            var originalFileItemName = input.val();
                            var fileName;

                            if ((originalFileItemName != null) && (originalFileItemName.length!=0)){
                                fileName = originalFileItemName.replace(/^.*[\\\/]/, '');

                                var extension = fileName.substring(fileName.lastIndexOf(".")+1);

                                console.log("Controllo estensione file originale:"+originalFileItemName);
                                console.log("Controllo estensione file:"+fileName);
                                console.log("Estensionefile:"+extension);
                                console.log("Codice:"+codice);

                                if(!extension||extension.length==0){
                                    alert("Il file"+fileName+" deve avere una estensione!");
                                    control =false;
                                    input.css({'background-color': 'red'});
                                    return control;
                                }

                                if(extension.toLowerCase() !== codice.toLowerCase()){
                                    alert("Il file"+fileName+" deve avere l'estensione "+codice);
                                    control =false;
                                    input.css({'background-color': 'red'});
                                    return control;
                                }

                            }

                            indexRow++;
                            break;

                    }
                }
            }
        ); // Fine ciclo sugli elementi di INPUT della FORM

        if(indexRow==0 && opType!="delete" && control){
            alert("Alla configurazione bisogna associare almeno un file");
            control=false;
        }

        if(control){
            $('input[type="hidden"][name="numFiles"]').val(indexRow);
            console.log("Numero file associato alla configurazione:"+indexRow);
            alert("Controllo OK!!!");
            control=false;
        }

        document.forms[0].action="ModificaTRPSServlet";

        return control;

    }

    function checkOverlap(input, ranges, rangeNum){

        var intInput, min, max;

        if(ranges.length!=0){
            for(var i = 0; i < rangeNum; i++) {
                var range = ranges[i];

                intInput = parseInt(input.val(),10);
                min = parseInt(range[0].val(),10);
                max = parseInt(range[1].val(),10);

                if(intInput >=min&&intInput <=max){

                    if(intInput==-1)
                        alert("E stato già definito un intervallo di default");
                    else
                        alert("L'estremo dell'intervallo ricade in uno degli intervalli precedentemente definiti");

                    input.css({'background-color': 'red'});
                    return false;
                }
            }
        }
        else
            return true;

        return true;
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

                var maxFiles=<%=maxFiles%>;

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

            var buttonType = $(e.target).attr("name").replace(/[0-9]/g, '');
            console.log("Tipo bottone. "+buttonType);

            if(buttonType=="fileUpload") {

                var originalFileItemName = $(e.target).val();
                var fileName;

                if (originalFileItemName != null) {
                    fileName = originalFileItemName.replace(/^.*[\\\/]/, '');
                }

                console.log("file name:" + fileName);

                var firstTr = $(e.target).parent().parent().prev().find("td:nth-child(1)").find("input").attr("value",fileName);

            }
        });

    });


</script>
</head>

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

							<tr bgcolor="aliceblue">
								<td align="right" colspan="2">Tipo Installazione : </td>
								<td>&nbsp;<input type="text" name="TipoInstallazione" size="10" maxlength="10" value="<%=typeInstallUff%>" readonly="readonly"/></td>
								<td align="right" colspan="2">Codice : </td>
								<td>&nbsp;<input type="text" name="Codice" size="10" maxlength="10" value="<%=code%>" readonly="readonly"/></td>
								<td align="right" colspan="2">Ambiente : </td>
								<td>&nbsp;<input type="text" name="Ambiente" size="10" maxlength="10" value="<%=tipoUsoRelease%>" readonly="readonly"/></td>
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
								<td  colspan="3"><label for="nomeFile">Nome File :</label><input type="text"  name="nomeFile" size="5" maxlength="10" value="<%=trps.getFileName()%>" readonly="readonly"/></td>
								<td  colspan="3"><label for="checkSum">Checksum :</label><input type="text"  name="checkSum" size="5" maxlength="10" value="<%=trps.getCheckSum()%>"/></td>
								<td  colspan="1"><label for="min">Min :</label><input  type="text" name="minValue" size="5" maxlength="10" value="<%=trps.getTrpsId().getRangeMinValue()%>"/></td>
								<td  colspan="1"><label for="max">Max :</label><input  type="text" name="maxValue" size="5" maxlength="10" value="<%=trps.getRangeMaxValue()%>"/></td>
							</tr>
							<tr align="center">
								<td colspan="7"><label for="fileUpload">Carica File &nbsp;</label><input  type="file" name="fileUpload"/></td>
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
								<td  colspan="3"><label for="nomeFile">Nome File :</label><input type="text"  name="nomeFile" size="5" maxlength="10" value="" readonly="readonly"/></td>
								<td  colspan="3"><label for="checksum">Checksum :</label><input type="text" id ="checksum"name="checkSum" size="5" maxlength="10" value=""/></td>
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
									<input type="hidden" name="numFiles" value=""/>
									<input type="hidden" name="operationType" value="<%=opType%>"/>
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