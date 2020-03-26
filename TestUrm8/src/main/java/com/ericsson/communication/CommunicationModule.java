/**
 * User: Michele Aiello
 * Date: Nov 26, 2003
 */
package com.ericsson.communication;

public interface CommunicationModule {

    void onMessage(ServiceCommandRequest request);

}
