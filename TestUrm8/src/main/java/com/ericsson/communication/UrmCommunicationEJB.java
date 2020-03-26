/**
 * User: Michele Aiello
 * Date: Nov 26, 2003
 */
package com.ericsson.communication;

public class UrmCommunicationEJB {

    /**
     * create a new instance of the EJB registering the client
     * as â€œlistenerâ€? of incoming messages (i.e. the callback
     * method onMessage() will be called
     **/
    public UrmCommunicationEJB(String strClientId, UrmMessageListener listener) throws UrmCommunicationException {
        UrmCommunicationBus.getInstance().registerClient(strClientId, listener);
    }


    /**
     * send the service command to the communication layer
     **/
    public void send(ServiceCommand sc) throws UrmCommunicationException {
        UrmCommunicationBus.getInstance().send(sc);
    }

    /**
     * get a service command from the communication
     * layer or null if nothing has been received
     **/
    public ServiceCommand receive(String strClientIt) {
        return UrmCommunicationBus.getInstance().receive(strClientIt);
    }

}
