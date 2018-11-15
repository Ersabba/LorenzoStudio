package com.ericsson.urm.xml.webmenu;

import com.ericsson.urm.util.ArgumentsCheckerUtil;
import com.ericsson.urm.xml.JAXBValidator;
import com.ericsson.urm.xml.XMLObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;


public class WebMenuXMLFactory extends XMLObjectFactory {

	private static String WEBMENU_CTX_NAME = "com.ericsson.urm.xml.webmenu";
	

	public static Menutype createMenu() throws JAXBException{
		ObjectFactory factory= new ObjectFactory();
		return factory.createMenutype();
	}
	
	public static NodeType createNodeType() throws JAXBException{
		ObjectFactory factory= new ObjectFactory();
		return factory.createNodeType();
	}
	
	public static LeafType createLeafType() throws JAXBException{
		ObjectFactory factory= new ObjectFactory();
		return factory.createLeafType();
	}
	
	public static AuthorizationType createAuthorizationType() throws JAXBException{
		ObjectFactory factory= new ObjectFactory();
		return factory.createAuthorizationType();
	}
	
	public static Menutype createMenu(File xmlFile) throws JAXBException {
		ArgumentsCheckerUtil.checkNull(xmlFile);
		
		JAXBContext jc = JAXBContext.newInstance( WEBMENU_CTX_NAME  );
	    Unmarshaller u = jc.createUnmarshaller();
	    u.setEventHandler(new JAXBValidator());
	    JAXBElement<Menutype> o = (JAXBElement<Menutype>)u.unmarshal( xmlFile);
	    Menutype menutype = o.getValue();
	    
	    return menutype;
	}
	
	public static void saveToFile(Menutype xmlObj, File xmlOutputFile) throws IOException, JAXBException {
		saveToFile(xmlObj,WEBMENU_CTX_NAME , xmlOutputFile);
	}
}
