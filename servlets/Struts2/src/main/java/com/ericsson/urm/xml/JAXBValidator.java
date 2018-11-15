package com.ericsson.urm.xml;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventLocator;
import javax.xml.bind.util.ValidationEventCollector;

public class JAXBValidator extends ValidationEventCollector {
    @Override
    public boolean handleEvent(ValidationEvent event) {
        if (event.getSeverity() == event.ERROR ||
            event.getSeverity() == event.FATAL_ERROR)
        {
            ValidationEventLocator locator = event.getLocator();
            // change RuntimeException to something more appropriate
            throw new RuntimeException("XML Validation Exception:  " +
                event.getMessage() + " at row: " + locator.getLineNumber() +
                " column: " + locator.getColumnNumber());
        }

        return true;
    }
}
