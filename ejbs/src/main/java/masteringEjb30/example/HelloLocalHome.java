package masteringEjb30.example;

public interface HelloLocalHome extends javax.ejb.EJBLocalHome
{
    /*
     * This method creates the EJB Object.
     *
     * @return The newly created EJB Object.
     */
    HelloLocal create() throws javax.ejb.CreateException;
}
