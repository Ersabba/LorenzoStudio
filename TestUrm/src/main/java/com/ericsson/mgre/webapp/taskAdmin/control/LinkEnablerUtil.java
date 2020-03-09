package com.ericsson.mgre.webapp.taskAdmin.control;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/*
import com.ericsson.bizlib.prefs.Preferences;
import com.ericsson.bizlib.prefs.PreferencesFactory;
*/


public class LinkEnablerUtil implements Serializable
{
	private static final Map links = new HashMap ();
	
	public static boolean canEnableLink (String activityCode)
	{
		Boolean enableLink = Boolean.FALSE;
		
		/*synchronized (links) {
			enableLink = (Boolean) links.get (activityCode);
			if (enableLink == null) {
				try {
					Preferences prefs = PreferencesFactory.getInstance ()
						.getPreferences (LinkEnablerUtil.class.getName ());
					
					enableLink = new Boolean (prefs.getValue ("activity." + activityCode));
					links.put (activityCode, enableLink);
				}
				catch (Throwable t) {
					return false;
				}
			}
		}*/
		return enableLink.booleanValue ();
	}
}