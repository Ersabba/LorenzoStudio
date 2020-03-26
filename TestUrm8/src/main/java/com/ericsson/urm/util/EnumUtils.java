package com.ericsson.urm.util;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;



public abstract class EnumUtils {
	
	public static <E> Set<String> asSetStr(Set<E> tsSet) {
		Set<String> tsSetNew = null;
		if(tsSet!=null) {
			tsSetNew = new LinkedHashSet<String>();
			for(E ts: tsSet) {
				tsSetNew.add(ts.toString());
			}
		}
		return tsSetNew;
	}
	
	public static <E> List<String> asListStr(List<E> tsList) {
		List<String> tsListNew = null;
		if(tsList!=null) {
			tsListNew = new ArrayList<String>();
			for(E ts: tsList) {
				tsListNew.add(ts.toString());
			}
		}
		return tsListNew;
	}
	
	public static <E> String[] asArrayStr(E[] tsArray) {
		String[] tsArrayNew = null;
		if(tsArray!=null) {
			tsArrayNew = new String[tsArray.length];
			for(int j=0; j<tsArray.length; ++j) {
				tsArrayNew[j] = tsArray[j].toString();
			}
		}
		return tsArrayNew;
	}
}
