/**
 * User: Michele Aiello
 * Date: Nov 26, 2003
 */
package com.ericsson.communication;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

public class UrmCommunicationBus {

    static private Logger logger = Logger.getLogger(UrmCommunicationBus.class);

    /**
     * Each element of the map is an ArrayList of messages for the client.
     */
    private HashMap queueMap;

    private HashMap listenersMap;

    private CommunicationModule communicationModule;

    private static UrmCommunicationBus _instance;

    public synchronized static UrmCommunicationBus getInstance() {
        if (_instance == null) {
            _instance = new UrmCommunicationBus();
        }
        return _instance;
    }

    private UrmCommunicationBus() {
        queueMap = new HashMap();
        listenersMap = new HashMap();
    }

    public void registerCommunicationModule(CommunicationModule communicationModule) {
        logger.info("Registering communication module. Class = '"+communicationModule.getClass().getName()+"'");
        this.communicationModule = communicationModule;
    }

    public void registerClient(String strClientId, UrmMessageListener listener) throws UrmCommunicationException {
        logger.info("Registering client. ID = "+strClientId+" Listener class = "+listener.getClass().getName());
        ArrayList clientQueue = (ArrayList) queueMap.get(strClientId);
        if (clientQueue != null) {
            throw new UrmCommunicationException();
        }
        clientQueue = new ArrayList(10);
        queueMap.put(strClientId, clientQueue);
        listenersMap.put(strClientId, listener);
    }

    public void send(ServiceCommand command) throws UrmCommunicationException {
        logger.info("Sending command...");
        if (command instanceof ServiceCommandRequest) {
            logger.info("The Command is a request. Sending to the communication module.");
            communicationModule.onMessage((ServiceCommandRequest)command);
        }
        else if (command instanceof ServiceCommandResponse) {
            logger.info("The Command is a response. Sending to the client.");
            ServiceCommandResponse response = (ServiceCommandResponse) command;
            String clientId = response.getRecipientId();
            logger.info("Client ID = "+clientId);
            ArrayList queue = (ArrayList) queueMap.get(clientId);
            if (queue == null) {
                logger.error("The client is not registerd (ID = '"+clientId+"'). Raising an exception.");
                throw new UrmCommunicationException();
            }
            queue.add(command);
            UrmMessageListener listener = (UrmMessageListener) listenersMap.get(clientId);
            logger.info("Notifying the listener ('Class = "+listener.getClass().getName()+"').");
            listener.onMessage();
        }
        else {
            logger.info("Unknow Service Command Type.");
            throw new UrmCommunicationException();
        }
    }

    public ServiceCommand receive(String strClientId) {
        logger.info("Receiving first message for client "+strClientId);
        ArrayList queue = (ArrayList) queueMap.get(strClientId);
        if (queue.size() > 0) {
            ServiceCommand sc = (ServiceCommand) queue.remove(0);
            return sc;
        }
        else {
            logger.info("No messages in the queue");
            return null;
        }
    }
}

