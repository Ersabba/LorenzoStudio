package com.ericsson.urm.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
import java.io.OutputStream;
//import java.io.Reader;
//import java.util.Hashtable;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.ericsson.urm.exceptions.ConfigurationException;
import com.ericsson.urm.util.ArgumentsCheckerUtil;

/**
 * This class provides some utilities to create and to handle the XML files used in the Urm Project .
 */
public class XMLUtilities {

	static private final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
	static private final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	static private final String featureNameSchemaSource = "http://apache.org/xml/properties/schema/external-noNamespaceSchemaLocation";
	private static Logger logger = Logger.getLogger(XMLUtilities.class);
	
	// not static
	private final LoggingErrorHandler errorHandler = new LoggingErrorHandler();
	private DocumentBuilder db;
	
	///// BEGIN /////////////////////////////////////////////////////////////////////////////////////////////////////////
	// DA RIMUOVERE CON JDK > 1.4
	//
	/*
	private static Hashtable mapChReplace = null;
	private static String character_replace_map = null;
	
	private static void loadMapChReplace() {
		try {
			String ch_replace_map = UrmConfig.getInstance().getProperty(UrmConfig.GenericKeys.CHARACTER_REPLACE_MAP);
			if(ch_replace_map!=null && ch_replace_map.trim().length()>0 && !ch_replace_map.equals(character_replace_map)) {
				character_replace_map = ch_replace_map.trim();
				String[] aCh = character_replace_map.split("[\n ,;]");
				String[] entries = null;
				String key;
				String value;
				int iCh;
				
				mapChReplace = new Hashtable();
				for(int j=0; j<aCh.length; ++j) {
					value = aCh[j].trim();
					while(value.endsWith("\r")) {
						value = value.substring(0,value.length()-1);
					}
					entries = value.split("[:=]");
					if(entries.length>1) {
						key = entries[0].trim();
						switch(key.length()) {
							case 0: continue;
							case 1: {
								iCh = (int)key.charAt(0);
								if(iCh<126) {
									continue;
								}
							}
							break;
							default: {
								try {
									if(key.toLowerCase().startsWith("x")) {
										key = Character.toString((char)Integer.valueOf(key.substring(2),16).intValue());
									} else {
										key = Character.toString((char)Integer.valueOf(key).intValue());
									}
								} catch (NumberFormatException e2) {
									logger.warn("Ch. code:"+key+" is not a number");
									continue;
								}
							}
						}
						value = entries[1].trim();
						mapChReplace.put(key, value); 
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.toString(),e);
			mapChReplace = new Hashtable();
		}
	}
    
	 
	public synchronized static String replaceChNotAscii(File xmlSource, String encoding) throws IOException {
		InputStream istream = null;
		Reader reader = null;
		StringBuffer sb = new StringBuffer();
		
		loadMapChReplace();
		
		if(xmlSource!=null) {
			istream = new FileInputStream(xmlSource);
			reader = new InputStreamReader(istream,encoding);
			int iCh = 0;	
			String sCh = null;
			String s = null;
			try {
				while((iCh=reader.read())!=-1) {
					sCh = Character.toString((char)iCh);
					if(mapChReplace!=null) {
						s = (String)mapChReplace.get(sCh);
						if(s!=null) {
							sCh = s;
						}
					} 
					sb.append(sCh);
				}
			} finally {
				if(reader!=null) {
					reader.close();
				}
				if(istream!=null) {
					istream.close();
				}
			}
		}
		return sb.toString();
	}
	*/
    ////END ///////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 *  This class is used to handle and log the errors that can occur in the XML documents used in the Urm project
	 */
	private static class LoggingErrorHandler implements ErrorHandler {

		static private Logger logger = Logger.getLogger(LoggingErrorHandler.class);

		/**
		 * This method is used to create a parsing error message in a log file.
		 *
		 * @param e  is a  SAXParseException type variable
		 *
		 *  @throws org.xml.sax.SAXParseException
		 */
		public void error(SAXParseException e) throws SAXParseException {
			logger.fatal("Parsing error." + "\n  Message        = " + e.getMessage() + "\n  LineNumber     = " + e.getLineNumber() + "\n  ColumnNumber   = " + e.getColumnNumber() + "\n  PublicId       = " + e.getPublicId() + "\n  SystemId       = " + e.getSystemId() + "\n  Class          = "
					+ e.getClass() + "\n  Cause          = " + e.getCause() + "\n  initCause(...) = " + e.initCause(e.getCause()) + "\n  Exception      = " + e.getException());
			throw e;
		}

		/**
		 * This method is used to create a parsing warning message in a log file.
		 *
		 * @param e is a SAXParseException type variable.
		 */
		public void warning(SAXParseException e) {
			logger.warn("Parsing warning." + "\n  Message        = " + e.getMessage() + "\n  LineNumber     = " + e.getLineNumber() + "\n  ColumnNumber   = " + e.getColumnNumber() + "\n  PublicId       = " + e.getPublicId() + "\n  SystemId       = " + e.getSystemId() + "\n  Class          = "
					+ e.getClass() + "\n  Cause          = " + e.getCause() + "\n  initCause(...) = " + e.initCause(e.getCause()) + "\n  Exception      = " + e.getException());
		}

		/**
		 * This method is used to create a parsing fatal error message in a log file.
		 *
		 * @param e is a SAXParseException type variable.
		 *
		 * @throws org.xml.sax.SAXParseException
		 */
		public void fatalError(SAXParseException e) throws SAXParseException {
			logger.fatal("Parsing fatalError." + "\n  Message        = " + e.getMessage() + "\n  LineNumber     = " + e.getLineNumber() + "\n  ColumnNumber   = " + e.getColumnNumber() + "\n  PublicId       = " + e.getPublicId() + "\n  SystemId       = " + e.getSystemId() + "\n  Class          = "
					+ e.getClass() + "\n  Cause          = " + e.getCause() + "\n  initCause(...) = " + e.initCause(e.getCause()) + "\n  Exception      = " + e.getException());
			throw e;
		}
	}

	/**
	 * This constructor without any input parameter creates a new DocumentBuilder type variable
	 */
	public XMLUtilities() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		dbf.setValidating(false);
		dbf.setIgnoringComments(true);
		try {
			db = dbf.newDocumentBuilder();

		} catch (ParserConfigurationException e) {
			logger.fatal("Unable to create a DocumentBuilder");
			throw new ConfigurationException("Unable to create a DocumentBuilder",e);
		}

		db.setErrorHandler(errorHandler);
	}

	/**
	 * This constructor creates a new DocumentBuilder type variable setting the attribute schemaFileName
	 *
	 * @param schemaFileName is a String that contains the name of the schema
	 */
	public XMLUtilities(String schemaFileName) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		dbf.setNamespaceAware(true);
		dbf.setIgnoringComments(true);
		
		if(schemaFileName!=null && !schemaFileName.equals("")) {
			dbf.setValidating(true);
			dbf.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
			dbf.setAttribute(featureNameSchemaSource, schemaFileName);
		} 
		else
		{
			dbf.setValidating(false);
		}
		
		try {
			db = dbf.newDocumentBuilder();

		} catch (ParserConfigurationException e) {
			logger.fatal("Unable to create a DocumentBuilder");
			throw new ConfigurationException("Unable to create a DocumentBuilder",e);
		}

		db.setErrorHandler(errorHandler);
	}

	public DocumentBuilder getDocBuilder(String schemaFileName) throws XMLUtilitiesException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbi=null;
		
		dbf.setNamespaceAware(true);
		dbf.setIgnoringComments(true);
		
		
		if(schemaFileName!=null && !schemaFileName.equals("")) {
			dbf.setValidating(true);
			dbf.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
			dbf.setAttribute(featureNameSchemaSource, schemaFileName);
		}
		else
		{
			dbf.setValidating(false);
		}
		
		try {
			dbi = dbf.newDocumentBuilder();

		} catch (ParserConfigurationException e) {
			logger.fatal("Unable to create a DocumentBuilder ", e);
			throw new XMLUtilitiesException("Unable to create a DocumentBuilder ", e);
		}

		dbi.setErrorHandler(errorHandler);
		return dbi;

	}

	/**
	 *  This method is used to create a new XML Document with the name given as input parameter.
	 *
	 * @param fileName a String that contains the name of the XML Document to return.
	 *
	 *  @return   a Document type variable.
	 *
	 * @throws com.ericsson.mgcf.util.xml.XMLUtilitiesException if the document is not correctly parsed.
	 */
	public synchronized final Document getDocument(String fileName) throws XMLUtilitiesException {
		Document document = null;
		FileInputStream in = null;
		InputSource inpSource = null;

		try {
			in = new FileInputStream(fileName);
			inpSource = new InputSource(in);
			
			String encoding = "UTF-8";
			if(encoding!=null && encoding.trim().length()>0) {
				inpSource.setEncoding(encoding);
			}

			document = db.parse(inpSource);

		} catch (IOException e) {
			throw new XMLUtilitiesException(e);
		} catch (FactoryConfigurationError factoryConfigurationError) {
			logger.error(factoryConfigurationError);
			throw new XMLUtilitiesException(factoryConfigurationError);
		} catch (SAXParseException e) {
			logger.error(e.getMessage(),e);
			throw new XMLUtilitiesException(e.getMessage(),e);
		} catch (SAXException e) {
			logger.error(e.getMessage(),e);
			throw new XMLUtilitiesException(e.getMessage(),e);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException ee) {
					logger.error(ee.getMessage());
				}
			}
		}

		return document;
	}

	public synchronized final Document getDocumentFromDocBuilder(String fileName, DocumentBuilder dbi) throws XMLUtilitiesException {
		Document document = null;
		FileInputStream in = null;
		InputSource inSource = null;
		try {
			in = new FileInputStream(fileName);
			inSource = new InputSource(in);
			
			String encoding = "UTF-8";
			if(encoding!=null && encoding.trim().length()>0) {
				inSource.setEncoding(encoding);
			}

			document = dbi.parse(inSource);


		} catch (IOException e) {
			throw new XMLUtilitiesException(e);
		} catch (FactoryConfigurationError factoryConfigurationError) {
			logger.error(factoryConfigurationError);
			throw new XMLUtilitiesException(factoryConfigurationError);
		} catch (SAXParseException e) {
			logger.error(e);
			throw new XMLUtilitiesException(e);
		} catch (SAXException e) {
			logger.error(e);
			throw new XMLUtilitiesException(e);
		} catch (Exception e) {
			logger.error(e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException ee) {
					logger.error(ee);
				}
			}
		}
		return document;
	}
	
	public synchronized final Document getValidateDocument(String fileName, String schemaFileName) throws XMLUtilitiesException {
		DocumentBuilder dbi = getDocBuilder(schemaFileName);
		return getDocumentFromDocBuilder(fileName, dbi);
	}

	/**
	 * This method is used to store a XML Document in a file.
	 *
	 * @param document the XML Document that has to be stored in a file.
	 *
	 * @param fileName the String that contains the name of the file used to store the document.
	 */
	public final void storeDocumentToFile(Document document, String fileName,String outFileDir) {
		
		String encoding = "UTF-8";
		
		try {
			FileOutputStream outFile = new FileOutputStream(fileName);
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			
			if(encoding!=null && encoding.trim().length()>0) {
				transformer.setOutputProperty(OutputKeys.ENCODING, encoding);
			}

			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(outFile);
			transformer.transform(source, result);
			outFile.close();
		} catch (FileNotFoundException e) {
			logger.info("Directory SIU not found, proceed to save in the tmp directory.");
			try {
				FileOutputStream outFile = new FileOutputStream(outFileDir + File.separator + fileName.substring(fileName.lastIndexOf("/") + 1));
				TransformerFactory factory = TransformerFactory.newInstance();				
				Transformer transformer = factory.newTransformer();
				
				if(encoding!=null && encoding.trim().length()>0) {
					transformer.setOutputProperty(OutputKeys.ENCODING, encoding);
				}

				DOMSource source = new DOMSource(document);
				StreamResult result = new StreamResult(outFile);
				transformer.transform(source, result);
				outFile.close();
			} catch (Exception a1) {
				logger.error(a1);
			}
			logger.error(e);
		} catch (Exception e) {
			logger.error(e);
		}
	}

	/**
	 * This method is used to print a XML Document to an output stream.
	 *
	 * @param inputDocument the XML Document to print to the output stream.
	 *
	 * @param stream the output stream.
	 */
	public final void printDocumentToStream(Document inputDocument, OutputStream stream) {
		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			
			String encoding = "UTF-8";
			if(encoding!=null && encoding.trim().length()>0) {
				transformer.setOutputProperty(OutputKeys.ENCODING, encoding);
			}

			DOMSource source = new DOMSource(inputDocument);
			StreamResult result = new StreamResult(stream);
			transformer.transform(source, result);
			stream.flush();
		} catch (Exception e) {
			logger.error(e);
		}
	}

	/**
	 * This method is used return a new XML Document.
	 *
	 * @return  a Document type variable.
	 */
	public final Document getNewDocument() {
		Document document = db.newDocument();
		return document;
	}
	
	
	public static String replaceXmlVar(String value, Properties prop) {
		String tmpValue = null;
		if(value!=null) {
			tmpValue = new String(value);
			Pattern pattern = Pattern.compile("(?<=\\$\\{)([.0-9a-z_A-Z]*)(?=\\})");
			Matcher matcher = pattern.matcher(tmpValue);
			String keyEnv;
			String keyEnvT;
			String replacement = null;
			while (matcher.find()) {
				keyEnv = matcher.group();
				keyEnvT = keyEnv.trim();
				if(keyEnvT.length()>4 && keyEnvT.toLowerCase().startsWith("env.")) {
					replacement = System.getProperty(keyEnvT.substring(4));
				} 
				else {
					replacement = prop.getProperty(keyEnvT);
				}
				if(replacement!=null) {
					tmpValue = tmpValue.replaceAll("\\$\\{"+keyEnv+"\\}", replacement);
				}
				else {
					logger.error("The key:"+keyEnv+" has not been found");
				}
			}
		}
		return tmpValue;
	}
	
	public static String replaceXmlVar(String value, Properties[] props) {
		 String tmpValue = null;
		 if(value!=null) {
			 tmpValue = new String(value);
			 Pattern pattern = Pattern.compile("(?<=\\$\\{)([.0-9a-z_A-Z]*)(?=\\})");
			 Matcher matcher = pattern.matcher(tmpValue);
			 String keyEnv;
			 String keyEnvT;
			 String replacement = null;
			 while (matcher.find()) {
				 keyEnv = matcher.group();
				 keyEnvT = keyEnv.trim();
				 if(keyEnvT.length()>4 && keyEnvT.toLowerCase().startsWith("env.")) {
					 replacement = System.getProperty(keyEnvT.substring(4));
				 } 
				 else {
					 if(props!=null) {
						 for(int j=0;j<props.length;++j) {							 
							 if(props[j]!=null && props[j].containsKey(keyEnvT)) {
								 replacement = props[j].getProperty(keyEnvT);
							 } 
						 }
					 }
				 }
				 if(replacement!=null) {
					 tmpValue = tmpValue.replaceAll("\\$\\{"+keyEnv+"\\}", replacement);
				 }
				 else {
					 logger.error("The key:"+keyEnv+" has not been found");
				 }
			 }
		 }
	     return tmpValue;
	 }
	
	public static NodeList xpathQuery(Element rootElement, String xpathQuery) throws XPathExpressionException {
		ArgumentsCheckerUtil.checkNull(rootElement);
		ArgumentsCheckerUtil.checkString(xpathQuery);
		 
		XPathFactory xpf = XPathFactory.newInstance();
		XPath xpath = xpf.newXPath();
		XPathExpression xpe = xpath.compile(xpathQuery);
		NodeList nodeList = (NodeList)xpe.evaluate(rootElement, XPathConstants.NODESET);
			
    	return nodeList;
	}

}

