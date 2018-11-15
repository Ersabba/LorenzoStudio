package mgse.actions;

import com.ericsson.mgse.webapp.menu.WebMenuFile;
import com.ericsson.urm.StringConstants;
import com.ericsson.urm.util.ArgumentsCheckerUtil;
import com.ericsson.urm.xml.webmenu.AuthorizationType;
import com.ericsson.urm.xml.webmenu.LeafType;
import com.ericsson.urm.xml.webmenu.Menutype;
import com.ericsson.urm.xml.webmenu.NodeType;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;

@Action(value = "GenerateMenu", results = {@Result(name = "SUCCESS", location = "/mgse/common/menus/test_menu.jsp") })
@Namespaces(value={@Namespace("/mgse")})
public class GenerateMenu extends ActionSupport implements ServletRequestAware, ServletResponseAware {

    private static Logger logger = Logger.getLogger(mgse.actions.GenerateMenu.class);
    private static String PREFACE = null;
    private static String SUFFIX = null;

    HttpServletRequest request;
    HttpServletResponse response;

    static {
        StringBuffer buf = new StringBuffer();
        buf.append("d = new dTree('d');\n");
        buf.append("d.config.useLines=false;\n");
        buf.append("d.config.useCookies=false;\n");
        buf.append("d.config.useIcons=false;\n");
        buf.append("d.config.folderLinks=false;\n");
        buf.append("d.config.closeSameLevel=true;\n");
        buf.append("d.add(0,-1,'');	\n");

        PREFACE = buf.toString();
        SUFFIX = "document.write(d);\n";

    }

    public String execute() throws Exception {
        try {



            StringBuffer generated = new StringBuffer();

            Menutype menu = WebMenuFile.getMenu();

            generated.append(PREFACE);

            List childs = menu.getNode();
            if (childs != null && childs.size() > 0) {
                Iterator iter = childs.iterator();
                while (iter.hasNext()) {
                    NodeType curr = (NodeType) iter.next();
                    addNode(curr, 0, generated, menu.getDefaultAuthorization(), request, response);
                }
            }

            List leafs = menu.getLeaf();
            if (leafs != null && leafs.size() > 0) {
                Iterator iter = leafs.iterator();
                while (iter.hasNext()) {
                    LeafType curr = (LeafType) iter.next();
                    addLeaf(curr, 0, generated, menu.getDefaultAuthorization(), request, response);
                }
            }

            generated.append(SUFFIX);
            request.setAttribute("menu", generated.toString());

            return "SUCCESS";

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw ex;
        }
    }

    private void addNode(NodeType node, long idParent, StringBuffer buff, AuthorizationType parentAuth, HttpServletRequest request, HttpServletResponse response) {

        AuthorizationType mergedAuth= checkAuth(node.getAuthorization(), parentAuth);


        if (isAuthorized(request, response, mergedAuth )) {
            long id = node.getIdnum();
            String label = node.getLabel();
            String keyLabel=node.getKeyLabel();
            String linktarget=node.getLinkTarget();
            if(label==null || label.trim().equals(StringConstants.EMPTY_STRING)){
                if(keyLabel!=null)
                    label=getText(keyLabel);
                else
                    label=StringConstants.EMPTY_STRING;
            }
            linktarget=linktarget==null?StringConstants.EMPTY_STRING:linktarget;

            buff.append("d.add(" + id + "," + idParent + ",'" + label + "','','','"+linktarget+"','','');");

            List childs = node.getNode();
            if (childs != null && childs.size() > 0) {
                Iterator iter = childs.iterator();
                while (iter.hasNext()) {
                    NodeType curr = (NodeType) iter.next();
                    addNode(curr, id, buff, mergedAuth, request, response);
                }
            }

            List leafs = node.getLeaf();
            if (leafs != null && leafs.size() > 0) {
                Iterator iter = leafs.iterator();
                while (iter.hasNext()) {
                    LeafType curr = (LeafType) iter.next();
                    addLeaf(curr, id, buff, mergedAuth, request, response);
                }
            }
        }
        else {
            logger.warn("Utente non autorizzato ad accedere al nodo " + node.getKeyLabel() + " del menu");
        }

    }

    private void addLeaf(LeafType leaf, long idParent, StringBuffer buff, AuthorizationType parentAuth, HttpServletRequest request, HttpServletResponse response) {

        ArgumentsCheckerUtil.checkNull(request, "request");
        ArgumentsCheckerUtil.checkNull(parentAuth, "parentAuth");
        if (isAuthorized(request, response, checkAuth(leaf.getAuthorization(), parentAuth))) {
            long id = leaf.getIdnum();
            String link = leaf.getLink();
            String label = leaf.getLabel();
            String keyLabel=leaf.getKeyLabel();
            String linktarget=leaf.getLinkTarget();
            if(label==null || label.trim().equals(StringConstants.EMPTY_STRING)){
                if(keyLabel!=null)
                    label=getText(keyLabel);
                else
                    label=StringConstants.EMPTY_STRING;
            }

            linktarget=linktarget==null?StringConstants.EMPTY_STRING:linktarget;

            buff.append("d.add(" + id + "," + idParent + ",'" + label + "','" + link + "','','"+linktarget+"','','');");
        }

    }

    private boolean isAuthorized(HttpServletRequest request, HttpServletResponse response, AuthorizationType nodeAuth) {
        ArgumentsCheckerUtil.checkNull(request, "request");
        ArgumentsCheckerUtil.checkNull(nodeAuth, "nodeAuth");
        boolean ret = false;
//		List admitted = nodeAuth.getAdmittedRole();
//		Iterator iter = admitted.iterator();
//
//
//        if(MdsProperties.getProperty("authentication.data.source").equalsIgnoreCase("LDAP")){
//    		while (ret == false && iter.hasNext()) {
//    			String curr = (String) iter.next();
//    			ret = request.isUserInRole(curr);
//    		}
//        }else if(MdsProperties.getProperty("authentication.data.source").equalsIgnoreCase("DB")){
//        	AuthenticationModule am = new AuthenticationModule();
//        	try {
//        		am.init( request, response );
//        	}
//        	catch ( AuthException e ) {
//        		logger.error("Utente non autorizzato ad accedere all'applicazione.",e);
//        	}
//        	String role = am.getRole();
//     		while (ret == false && iter.hasNext()) {
//     			String curr = (String) iter.next();
//     			if(role.equalsIgnoreCase(curr)){
//     				ret = true;
//     				break;
//     			}
//     		}
//        }
        ret = true;
        return ret;
    }

    private AuthorizationType checkAuth(AuthorizationType nodeAuth, AuthorizationType parentAuth){
        AuthorizationType ret=null;
        if(nodeAuth!=null){
            ret= nodeAuth;
        }else{
            ret=parentAuth;
        }
        return ret;
    }

    public void setServletRequest(HttpServletRequest httpServletRequest) {

        request=httpServletRequest;
    }

    public void setServletResponse(HttpServletResponse httpServletResponse) {

        response=httpServletResponse;
    }
}
