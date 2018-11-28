package com.ericsson.gestionesw.persistence.dto.datatype;

import java.io.Serializable;



public class TipoUsoRel implements Serializable {
    private static final long serialVersionUID = -1;

    public static final TipoUsoRel TEST = new TipoUsoRel ("TEST");
    public static final TipoUsoRel PROD = new TipoUsoRel ("PROD");

    private String literal;

    private TipoUsoRel (String literal) {
        this.literal = literal;
    }

    public static TipoUsoRel parse(String literal)	{
        if (TEST.literal.equalsIgnoreCase(literal)) return TEST;
        if (PROD.literal.equalsIgnoreCase(literal)) return PROD;

        throw new IllegalArgumentException ("TipoUsoRel.parse: unsupported literal value " + literal);
    }

    public String toString () {
        return literal;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((literal == null) ? 0 : literal.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final TipoUsoRel other = (TipoUsoRel) obj;
        if (literal == null) {
            if (other.literal != null)
                return false;
        } else if (!literal.equals(other.literal))
            return false;
        return true;
    }

}
