package com.ericsson.urm.persistence.dto.mds;

import java.io.Serializable;

public class FlowMailNotify implements Serializable {
    static final long serialVersionUID = -1;

    private String email;
    private String destinatario;


    public FlowMailNotify() {}


    public FlowMailNotify(String email, String destinatario) {
        this.email = email;
        this.destinatario = destinatario;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getDestinatario() {
        return destinatario;
    }


    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }


    @Override
    public String toString() {
        return "FlowMailNotify [email=" + email + ", destinatario=" + destinatario + "]";
    }

}
