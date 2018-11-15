package masteringEjb30.example;

import org.apache.log4j.Logger;

import javax.ejb.SessionContext;

public class HelloBean implements javax.ejb.SessionBean{

    private static final Logger logger = Logger.getLogger(HelloBean.class);

    private SessionContext ctx;

    //
    // EJB-required methods
    //

    public void ejbCreate() {
        logger.info("ejbCreate()");
    }
    public void ejbRemove() {
        logger.info("ejbRemove()");
    }
    public void ejbActivate() {
        logger.info("ejbActivate()");
    }
    public void ejbPassivate() {
        logger.info("ejbPassivate()");
    }

    public void setSessionContext(javax.ejb.SessionContext ctx) {
        this.ctx = ctx;
    }

    //
    // Business methods
    //
    public String hello() {
        logger.info("hello()");
        return "Hello, World!";
    }
}

