package oldejb.actions;

import masteringEjb30.example.Hello;
import masteringEjb30.example.HelloHome;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;

import javax.ejb.CreateException;
import javax.ejb.RemoveException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.util.Hashtable;

@Namespaces(value={@Namespace("/oldejb")})
public class ejbTestAction {

    private static final Logger logger = Logger.getLogger(ejbTestAction.class);

    private String beanResult;

    public String getBeanResult() {
        return beanResult;
    }

    public void setBeanResult(String beanResult) {
        this.beanResult = beanResult;
    }

    @Action(value = "Ejb20Test",results = {
            @Result(name = "SUCCESS", location = "/oldejb/Ejb20Test.jsp"),
            @Result(name = "ERROR", location = "/error.jsp") })
    public String viewJsp() {

        return "SUCCESS";
    }

    @Action(value = "ejbCall",results = {
            @Result(name = "SUCCESS", location = "/oldejb/Ejb20Test.jsp"),
            @Result(name = "ERROR", location = "/error.jsp") })
    public String ejbCall() {

        String ejburl = "t3://localhost:7001/";
        /**Setup the environment*/
        Hashtable environment = new Hashtable(6);
        /**Turn JNDI on to Weblogic and use oracle db password verification*/
        environment.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
        environment.put(Context.SECURITY_PRINCIPAL, "weblogic");
        environment.put(Context.SECURITY_CREDENTIALS, "weblogic12!");
        environment.put(Context.PROVIDER_URL, ejburl);

        Context context = null;
        try {
            /*Obtain the JNDI initial context.
             *
             * The initial context is a starting point for connecting to a JNDI tree. We choose our JNDI
             * driver, the network location of the server, etc.by passing in the environment properties.
             */
            context = new InitialContext(environment);

            /*
             * Get a reference to the home object - the factory for Hello EJB Objects
             */
            Object obj = context.lookup("HelloHome");

            /*
             * Home objects are RMI-IIOP objects, and so they must be cast into RMI-IIOP objects
             * using a special RMI-IIOP cast.
             *
             * See Appendix A for more details on this.
             */
            HelloHome home = (HelloHome) javax.rmi.PortableRemoteObject.narrow(obj,HelloHome.class);

            /*
             * Use the factory to create the Hello EJB Object
             */
            Hello hello = home.create();

            /*
             * Call the hello() method on the EJB object. The EJB object will delegate the call to the bean,
             * receive the result, and return it to us.
             *
             * We then print the result to the screen.
             */
            beanResult=hello.hello();
            /*
             * Done with EJB Object, so remove it.
             * The container will destroy the EJB object.
             */
            hello.remove();

        } catch (NamingException|RemoteException|CreateException|RemoveException e) {
             logger.error("Problemi nella creazione e chiamata dell'EJB 2.0",e);
        }


        return "SUCCESS";

    }

}
