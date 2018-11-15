package com.ericsson.mgse.webapp.menu;

import com.ericsson.urm.exceptions.ConfigurationException;
import com.ericsson.urm.xml.webmenu.Menutype;
import com.ericsson.urm.xml.webmenu.WebMenuXMLFactory;

import java.io.File;

public abstract class WebMenuFile {

	private static long lastModified = -1;

	private static String FILE_PATH = System.getProperty("mgse.home") + File.separator + "xml" + File.separator + "WEB_MENU.xml";

	private static Menutype menu = null;

	public static synchronized Menutype getMenu() {
		checkFile();
		return menu;

	}

	private static void checkFile() {
		try {
			File file = new File(FILE_PATH);
			if (!file.exists() || file.isDirectory())
				throw new ConfigurationException("File " + FILE_PATH + " doesn't exist or is invalid");

			if (file.lastModified() != lastModified) {
				menu = WebMenuXMLFactory.createMenu(file);
				lastModified=file.lastModified();
			}
		} catch (Exception ex) {
			throw new ConfigurationException(ex);
		}

	}

}
