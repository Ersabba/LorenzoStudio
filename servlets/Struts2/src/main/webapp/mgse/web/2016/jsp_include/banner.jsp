<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page import="com.ericsson.urm.config.UrmConfig"%>

<%

String pathJS=request.getContextPath()+"/mgse/web/2016/script/";
String pathCSS=request.getContextPath()+"/mgse/web/2016/css/";
String pathImg=request.getContextPath()+"/mgse/web/2016/img/top_banner/";

%>

<link rel="stylesheet" type="text/css" href="<%=pathCSS%>bannerTop.css" media="screen" />
<script type="text/javascript" src="<%=pathJS%>jquery-1.12.3.min.js"></script>
<script type="text/javascript">
<%--
	possibili valori per environnement(definiscono le immagini da caricare e lo stile appropriato):
	empty (produzione)
	acea (produzione)
	empty_test
	acea_test
--%>

var servClockEnabled = true;
var environment = 'acea';
var pathImg = '<%=pathImg%>';
var cssStyle = 'banner_'+environment;
// console.log('Style banner da settare con classe: '+cssStyle);

$(document).ready(function(){

	hideSrvClockIfIsLoginPage();
//	console.log("servClockEnabled= "+servClockEnabled);
	if(servClockEnabled){
		timeoutCallServerClock = window.setTimeout("getServerClock()", 300);	
	}
	// console.log('caso: '+environment);
	
	var imgRight = pathImg+"urm_topbar_right_"+environment+".png";
	$("#logoBannerRightId").attr("src", imgRight);
	
	 $("#topBanner2Id").attr('class', cssStyle);
	 if(environment=='acea_test'){
	 //di usato al momento solo per ambiente di test di acea 
	 	$("#bannerCenterTextId").css('visibility', 'visible');
	 }else{
		 $("#bannerCenterTextId").css('visibility', 'hidden');
	 }	
});	

<%-- Funzione utilizzata per nascondere e non caricare l'orologio del server. Al momento usata solo per la pagina di login, 
	 all'occorrenza inserire il path nell'if case o il tag con id hideServerClock che � sulla login.jsp.
--%>
function hideSrvClockIfIsLoginPage(){

	if($('#hideServerClock').val()){			
		servClockEnabled = false;		
		$('#serverClockTR_id').hide();
	}	
	if(servClockEnabled){
		var scrpt = document.createElement("script");
		scrpt.type = "text/javascript";
		scrpt.src = '<%=pathJS%>ServerDate.min.js';		

	//  senza head appendo al tr su questa pagina
		$("#topBanner2Id").append(scrpt);		
	}
}
</script>

<table border="0" cellpadding="0" cellspacing="0" width="100%" id="bannerTable">
	<tr id="topBanner2Id" class="banner_empty" ><!-- in esercizio si metter� banner_empty per dare uno sfondo in attesa di caricare il tutto -->
		<td align="left">									
			 <br/>
			 <img align="left" height="54px"  id="logoBannerLeftId" alt="Ericsson Logo" src="<%=pathImg%>ERI_UF_white.png"/>			 
	 		 <%-- Div al momento usato solo per ACEA - ambiente di test --%> 
	 		 <div id="bannerCenterTextId" align="center" height="54px"  width="100%">URM-TEST</div>	 					
		  	 <img  height="54px"  id="logoBannerRightId" align="right" alt="URM" src=""/>		
		</td>
	</tr>
	<tr>
		<td> 
		</td>	
	</tr>
	<tr>
		<td align="right" id="serverClockTR_id">
		    Server Time: <input size="8" type="text" id="serverClock"/>
		</td>
	</tr>	
</table>