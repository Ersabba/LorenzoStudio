package com.ericsson.mgre.biz.networkMgmt.utils;

import java.io.Serializable;
import java.util.Vector;

public class FileTut implements Serializable {

    private Vector removeAlink;
    private Vector addAlink;
    private String ccsMtr;

    public FileTut(String ccs) {
        removeAlink = new Vector();
        addAlink = new Vector();
        ccsMtr = ccs;
    }

    public String[] getRemoveAlink() {
        String[] alink = null;
        if (!removeAlink.isEmpty()) {
            alink = new String[removeAlink.size()];
            for (int i=0; i<removeAlink.size(); i++) {
                alink[i] = (String) removeAlink.elementAt(i);
            }
        }
        return alink;
    }

    public void setRemoveAlink(String removeAlink) {
        this.removeAlink.addElement(removeAlink);
    }

    public String[] getAddAlink() {
        String[] alink = null;
        if (!addAlink.isEmpty()) {
            alink = new String[addAlink.size()];
            for (int i=0; i<addAlink.size(); i++) {
                alink[i] = (String) addAlink.elementAt(i);
            }
        }
        return alink;
    }

    public void setAddAlink(String addLennt) {
        this.addAlink.addElement(addLennt);
    }

    public String getCcsMtr() {
        return ccsMtr;
    }
}
