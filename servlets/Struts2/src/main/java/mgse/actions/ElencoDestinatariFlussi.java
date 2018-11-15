package mgse.actions;

import com.ericsson.mgse.persistence.dto.datatypes.FlowConfigWithState;
import com.ericsson.urm.persistence.dto.mds.FlowMailNotify;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ParentPackage("json-default")
@Action(value = "RecipientsList", results = {@Result(name = "SUCCESS", location = "/mgse/common/ElencoDestinatariFlussi.jsp") })
@Namespaces(value={@Namespace("/mgse")})
public class ElencoDestinatariFlussi extends ActionSupport implements SessionAware {

    public static final String SESSION_RECIPIENT="repientToAddEdit";

    private static final Logger logger = Logger.getLogger(ElencoDestinatariFlussi.class);

    private List<FlowMailNotify> emails;
    static HashMap<String,FlowMailNotify> map = new HashMap<String, FlowMailNotify>();
    String emailToDelete;
    String errorMsgAjax;
    boolean emailDeleted;
    boolean emailModify;
    FlowMailNotify email;

    String addEditEmail;
    String addEditRecipient;
    private Map<String, Object> session;

    public String getAddEditEmail() {
        return addEditEmail;
    }

    public void setAddEditEmail(String addEditEmail) {
        this.addEditEmail = addEditEmail;
    }

    public String getAddEditRecipient() {
        return addEditRecipient;
    }

    public void setAddEditRecipient(String addEditRecipient) {
        this.addEditRecipient = addEditRecipient;
    }

    public boolean isEmailModify() {
        return emailModify;
    }

    public void setEmailModify(boolean emailModify) {
        this.emailModify = emailModify;
    }

    public boolean isEmailDeleted() {
        return emailDeleted;
    }

    public void setEmailDeleted(boolean emailDeleted) {
        this.emailDeleted = emailDeleted;
    }

    public String getErrorMsgAjax() {
        return errorMsgAjax;
    }

    public void setErrorMsgAjax(String errorMsgAjax) {
        this.errorMsgAjax = errorMsgAjax;
    }

    public String getEmailToDelete() {
        return emailToDelete;
    }

    public void setEmailToDelete(String emailToDelete) {
        this.emailToDelete = emailToDelete;
    }

    public List<FlowMailNotify> getEmails() {
        return emails;
    }

    public void setEmails(List<FlowMailNotify> emails) {
        this.emails = emails;
    }

    public String execute(){

        if(map.isEmpty()){
            for (int i = 1; i <= 15; i++) {
                email = new FlowMailNotify();
                email.setDestinatario("Destinatario N." + i);
                email.setEmail("Angelica.Marranzini"+i+"@libero.it");
                map.put("Angelica.Marranzini"+i+"@libero.it",email);
            }
        }

        emails = new ArrayList<FlowMailNotify>(map.values());

        return "SUCCESS";
    }

    @Action(value = "CancellaEmailDestinatarioAjax", results = {@Result(name="SUCCESS",type="json") })
    public String CancellaEmailDestinatarioAjax(){

        errorMsgAjax="";

        logger.info("Email da cancellare:"+emailToDelete);

        FlowMailNotify flowMailNotify;
        flowMailNotify =  map.get(emailToDelete);

        if(flowMailNotify!=null){
            map.remove(emailToDelete);
            emailDeleted=true;
        }
        else{
            String emails[] = {emailToDelete};
            errorMsgAjax=getText("urm.mgse.menu.flows.notifications.recipient.not.deleted",emails);
            emailDeleted=false;
        }

        return "SUCCESS";
    }

    @Action(value = "AddEditRecipient", results = {@Result(name = "SUCCESS", location = "/mgse/common/ModificaAggiungiDestinatario.jsp") })
    public String aggiungiDestinatario(){

        logger.info("Email da modificare inserire:"+addEditEmail);
        logger.info("Destinatario da modificare inserire:"+addEditRecipient);

        // Chimata action per inserimento (menu principale) oppure chiamata action da pagina modifica email
        if(addEditEmail != null ){

            email = new FlowMailNotify();
            email.setDestinatario(addEditRecipient);
            email.setEmail(addEditEmail);

            // Provengo dalla pagina di modifica, metto in session l'utente e visualizzo i parametri da modificare
            if(emailModify){

                if(session.containsKey(SESSION_RECIPIENT))
                    session.remove(SESSION_RECIPIENT);

                // Valore settato dalla pagina di modifica, metto l'email in sessione
                session.put(SESSION_RECIPIENT,email);
            }
            else{ // chiamata action da pagina di inserimento

                // Precedentemente è stata richiesto di modificare l'utente, INSERT oppure EDIT
                if(session.containsKey(SESSION_RECIPIENT)){

                    FlowMailNotify emailToDelete = (FlowMailNotify)session.get(SESSION_RECIPIENT);

                    logger.info("Destinatario in sessione:"+emailToDelete);

                    if(emailToDelete.getEmail().equals(addEditEmail)){

                        if(!emailToDelete.getDestinatario().equals(addEditRecipient)){

                            logger.info("Cambio destinatario");

                            map.get(addEditEmail).setDestinatario(addEditRecipient);
                        }
                    }
                    else{
                        // Cancello da DB il recipiente in sessione
                        map.remove(emailToDelete.getEmail());
                        // Store su DB dell'elemento appena inserito
                        map.put(addEditEmail,email);
                    }

                    session.remove(SESSION_RECIPIENT);
                }
                else { // INSERT nuovo utente
                    if(!map.containsKey(addEditEmail)){

                        logger.info("Nuovo utente da inserire:"+addEditEmail);
                        map.put(addEditEmail,email);
                    }
                    else
                        logger.error("Utente gia presente nella base dati");
                }

                addEditEmail="";
                addEditRecipient="";
            }
        }
        else{ // Chiamata della Action dal menu principale, pulisco la sessione

            if(session.containsKey(SESSION_RECIPIENT))
                session.remove(SESSION_RECIPIENT);
        }

        return "SUCCESS";
    }

    public void setSession(Map<String, Object> map) {
        session = map;
    }
}
