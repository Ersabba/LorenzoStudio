package masteringEjb30.example;

/**
 * This is the home interface for HelloBean. This interface
 * is implemented by the EJB Server’s tools - the
 * implemented object is called the Home Object, and serves
 * as a factory for EJB Objects.
 *
 * One create() method is in this Home Interface, which
 * corresponds to the ejbCreate() method in HelloBean.
 */
public interface HelloHome extends javax.ejb.EJBHome
{
    /*
     * This method creates the EJB Object.
     *
     * @return The newly created EJB Object.
     */
    public Hello create() throws java.rmi.RemoteException,
            javax.ejb.CreateException;
}
