/**
 * User: Michele Aiello
 * Date: Nov 26, 2003
 */
package com.ericsson.communication;

public interface UrmMessageListener {

    /**
     * This method will be called by the CommunicationBus as
     * a new message is received
     **/
    void onMessage();

}
