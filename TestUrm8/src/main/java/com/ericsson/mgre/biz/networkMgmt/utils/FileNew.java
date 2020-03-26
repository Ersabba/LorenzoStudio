package com.ericsson.mgre.biz.networkMgmt.utils;

import java.io.Serializable;
import java.util.Vector;

public class FileNew implements Serializable {

    private Vector removeLennt;
    private Vector addLennt;
    private String ccsMtr;

    public FileNew(String ccs) {
        removeLennt = new Vector();
        addLennt = new Vector();
        ccsMtr = ccs;
    }

    public String[] getRemoveLennt() {
        String[] lennt = null;
        if (!removeLennt.isEmpty()) {
            lennt = new String[removeLennt.size()];
            for (int i=0; i<removeLennt.size(); i++) {
                lennt[i] = (String) removeLennt.elementAt(i);
            }
        }
        return lennt;
    }

    public void setRemoveLennt(String removeLennt) {
        this.removeLennt.addElement(removeLennt);
    }

    public String[] getAddLennt() {
        String[] lennt = null;
        if (!addLennt.isEmpty()) {
            lennt = new String[addLennt.size()];
            for (int i=0; i<addLennt.size(); i++) {
                lennt[i] = (String) addLennt.elementAt(i);
            }
        }
        return lennt;
    }

    public void setAddLennt(String addLennt) {
        this.addLennt.addElement(addLennt);
    }

    public String getCcsMtr() {
        return ccsMtr;
    }
}
