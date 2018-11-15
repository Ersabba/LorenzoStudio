package mgse.actions;

import com.ericsson.mgse.persistence.dto.FlowConfig;
import com.ericsson.mgse.persistence.dto.datatypes.FlowConfigWithState;
import com.ericsson.mgse.persistence.dto.datatypes.PollerStatus;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.*;

import java.util.*;

@ParentPackage("json-default")
@Action(value = "GestioneFlussi", results = {@Result(name = "SUCCESS", location = "/mgse/common/AperturaChiusuraFlussi.jsp") })
@Namespaces(value={@Namespace("/mgse")})
public class GestioneFlussi extends ActionSupport {

    private static final Logger logger = Logger.getLogger(GestioneFlussi.class);

    private boolean statusFlow;

    List<FlowConfigWithState> flowsWithState;

    String flowCodeChosen=null;

    static HashMap<String,FlowConfigWithState> map = new HashMap<String, FlowConfigWithState>();

    String errorMsgAjax="";
    private Boolean statusFlowJSP;

    public String getStatusFlowJSP() {
        return Boolean.toString(statusFlowJSP);
    }

    public void setStatusFlowJSP(String statusFlowJSP) {
        this.statusFlowJSP = Boolean.valueOf(statusFlowJSP);
    }

    public String getFlowCodeChosen() {
        return flowCodeChosen;
    }

    public void setFlowCodeChosen(String flowCodeChosen) {
        this.flowCodeChosen = flowCodeChosen;
    }

    public boolean isStatusFlow() {
        return statusFlow;
    }

    public void setStatusFlow(boolean statusFlow) {
        this.statusFlow = statusFlow;
    }

    public String getErrorMsgAjax() {
        return errorMsgAjax;
    }

    public void setErrorMsgAjax(String errorMsgAjax) {
        this.errorMsgAjax = errorMsgAjax;
    }

    public List<FlowConfigWithState> getFlowsWithState() {
        return flowsWithState;
    }

    public void setFlowsWithState(List<FlowConfigWithState> flowsWithState) {
        this.flowsWithState = flowsWithState;
    }

    public String execute(){


        flowsWithState = new ArrayList<FlowConfigWithState>();

        FlowConfig flowConfig;
        FlowConfigWithState flowConfigWithState;

/*        for(int i=1;i<=20;i++){
            flowConfig = new FlowConfig();
            flowConfig.setDescription("Descrizione Flusso Numero "+i);
            flowConfig.setFlowCode("CodiceFlusso"+i);
            flowConfig.setPollerName("Poller "+i);
            flowConfig.setSubsystem("Sistema Esterno "+i);
            flowConfigWithState = new FlowConfigWithState(flowConfig,i%2==0?true:false);
            flowsWithState.add(flowConfigWithState);
        }*/


       for (int i = 1; i <= 15; i++) {
            flowConfig = new FlowConfig();
            flowConfig.setDescription("Descrizione Flusso Numero " + i);
            flowConfig.setFlowCode("CodiceFlusso" + i);
            flowConfig.setPollerName("Poller " + i);
            flowConfig.setSubsystem("Sistema Esterno " + i);
            flowConfigWithState = new FlowConfigWithState(flowConfig, i % 2 == 0 ? true : false);
            map.put("CodiceFlusso" + i,flowConfigWithState);
        }

 /*       for (int i = 1; i <= 1; i++) {
            flowConfig = new FlowConfig();
            flowConfig.setDescription("lettura_misure_mensili_periodica");
            flowConfig.setFlowCode("AAA");
            flowConfig.setPollerName("SFTPRegistriMensiliPoller");
            flowConfig.setSubsystem("SAEL");
            flowConfigWithState = new FlowConfigWithState(flowConfig, i % 2 == 0 ? true : false);
            map.put("AAA",flowConfigWithState);
        }*/

        flowsWithState = new ArrayList<FlowConfigWithState>(map.values());

        return "SUCCESS";
    }

    @Action(value = "AbilitazioneDisabilitazioneFlussi", results = {@Result(name = "SUCCESS", location = "/common/AperturaChiusuraFlussi.jsp") })
    public String enabledisableflows(){

        addActionError("Codice Flusso "+flowCodeChosen+" scelto");

        //flowsWithState.get(Integer.parseInt(requestid.substring(requestid.length() - 1))).changeStatus();

        return "SUCCESS";
    }


    @Action(value = "AbilitazioneDisabilitazioneFlussiAjax", results = {@Result(name="SUCCESS",type="json") })
    public String ajaxenabledisableflows(){

        errorMsgAjax="";

        logger.info("Codice Flusso scelto:"+flowCodeChosen);

        FlowConfigWithState flowConfigWithState;
        flowConfigWithState =  map.get(flowCodeChosen);

        if (flowConfigWithState.isEnabled()!= statusFlowJSP)
            errorMsgAjax=getText("Stato flusso su interfaccia è diverso da stato flusso in memoria");

        flowConfigWithState.changeStatus();
        statusFlow = flowConfigWithState.isEnabled();

        ArrayList<String> lis = new ArrayList<String>();
        lis.add(flowCodeChosen);

        String names[] = {"flowCodeChosen"};

        if(flowCodeChosen.equals("CodiceFlusso2"))
            errorMsgAjax=getText("mgse.flows.setting.partial.success",names);
        else
            errorMsgAjax="";

        return "SUCCESS";
    }
}
