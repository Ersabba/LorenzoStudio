package com.ericsson.urm.xml;

/**
 * Created by IntelliJ IDEA.
 * User: miky
 * Date: Oct 1, 2003
 * Time: 12:34:41 PM
 * To change this template use Options | File Templates.
 */

/**
 * This class is used to manage the exceptions that occur durin the creation and handling of XML documents in Urm Project.
 */
public class XMLUtilitiesException extends Exception {

    public XMLUtilitiesException() {
    }

    public XMLUtilitiesException(String message) {
        super(message);
    }

    public XMLUtilitiesException(String message, Throwable cause) {
        super(message, cause);
    }

    public XMLUtilitiesException(Throwable cause) {
        super(cause);
    }

}
