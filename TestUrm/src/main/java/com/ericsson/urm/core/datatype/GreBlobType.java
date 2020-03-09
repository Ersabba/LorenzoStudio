package com.ericsson.urm.core.datatype;

import org.hibernate.HibernateException;
import org.hibernate.lob.SerializableBlob;
import org.hibernate.type.BlobType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GreBlobType extends BlobType {

    public Object get(ResultSet rs, String name) throws HibernateException, SQLException {
        Blob value = rs.getBlob(name);

        if(!rs.wasNull()){
            ObjectInputStream input = null;
            try {
                input = new ObjectInputStream(value.getBinaryStream());
                return (List)input.readObject();
            } catch (IOException e) {
                throw new HibernateException(e);
            } catch (ClassNotFoundException e) {
                throw new HibernateException(e);
            }
        }
        else
            return null;
    }

    public String getName() {
        return "blobList";
    }

    public Class getReturnedClass() {
        return List.class;
    }

    /*public Object get(ResultSet rs, String name) throws HibernateException, SQLException {
        Blob value = rs.getBlob(name);

        if(!rs.wasNull()){
            ObjectInputStream input = null;
            try {
                input = new ObjectInputStream(value.getBinaryStream());
                return (List)input.readObject();
            } catch (IOException e) {
                throw new HibernateException(e);
            } catch (ClassNotFoundException e) {
                throw new HibernateException(e);
            }
        }
        else
            return null;

        //return rs.wasNull() ? null : new SerializableBlob(value);
    }

    public String getName() {
        return "blobList";
    }

    public Class getReturnedClass() {
        return List.class;
    }*/
}
