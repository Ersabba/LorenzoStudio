package com.ericsson.urm.persistence.dto.mgre;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

public class BinaryBlobObjType implements UserType {

	public BinaryBlobObjType() {}
	
	
	private byte[] toByteArray (Object obj)
	{
		byte[] bytes = null;
		ByteArrayOutputStream bos = null;
		try {
			bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos); 
			oos.writeObject(obj);
			oos.flush(); 
			oos.close(); 
			bos.close();
			bytes = bos.toByteArray ();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		return bytes;
	}
	    
	private Object toObject (byte[] bytes)
	{
	  Object obj = null;
	  ByteArrayInputStream bis = null;
	  try {
	    bis = new ByteArrayInputStream (bytes);
	    ObjectInputStream ois = new ObjectInputStream (bis);
	    obj = ois.readObject();
	  }
	  catch (IOException ex) {
		  ex.printStackTrace();
	  }
	  catch (ClassNotFoundException ex) {
		  ex.printStackTrace();
	  }
	  finally {
		  if(bis!=null) {
			  try {
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		  }
	  }
	  return obj;
	}
	
	public int[] sqlTypes()
	{
		return new int[] { Types.BLOB };
	}

	public Class<Blob> returnedClass()
	{
		return Blob.class;
	}

	public Object replace(Object original, Object target, Object owner)
	{
		return(original);
	}

	public Object assemble(Serializable cached, Object owner)
	{
		return((BinaryBlobObjType)cached);
	}

	public Serializable disassemble(Object value)
	{
		if(value instanceof byte[]) {
			byte[] bytes = (byte[])value;
			return(bytes);
		} else {
			return (Serializable) value;
		}
	}

	public int hashCode(Object x)
	{
		return (x!=null) ? x.hashCode() : (0);
	}

	public boolean equals(Object x, Object y)
	{
		return (x == y)
		|| (x != null
				&& y != null
				&& x.equals(y));
	}
	
	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner)
			throws HibernateException, SQLException {
		
		Blob blob = rs.getBlob(names[0]);
        if(blob != null) {
        	try {
				ObjectInputStream input = new ObjectInputStream(blob.getBinaryStream());
				return input.readObject();
			} catch (Exception e) {
				throw new HibernateException(e.getMessage(),e);
			}
        } 
		
		return blob;
		
//		Blob blob = rs.getBlob(names[0]);
//		return blob.getBytes(1, (int) blob.length()); 
	}


	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session)
			throws HibernateException, SQLException {
		
		byte[] aval = toByteArray(value);
		
		st.setBlob(index, Hibernate.getLobCreator(session).createBlob(aval));
		
//		// Funziona solo per BLOB < 4KB
//		// st.setBytes(index, aval);
//		
//		// Funziona(???) dopo aver inserito nel file cfg di hibernate
//		// <property name="hibernate.jdbc.batch_size">0</property>
//		//
//		//ByteArrayInputStream bis = new ByteArrayInputStream(aval);
//		//st.setBinaryStream(index, bis, aval.length);
//		//////////////////////////////////////////////////////////
//		
//		// Sperem
//		BLOB tmpBlob = BLOB.createTemporary(st.getConnection(), false, oracle.sql.BLOB.DURATION_CALL );
//		tmpBlob.open(BLOB.MODE_READWRITE);
//		tmpBlob.putBytes(index,aval);
//		st.setBlob(index,tmpBlob);
//		tmpBlob.close();
		
		
		
		//st.setBlob(index, Hibernate.createBlob((byte[]) value)); 
	}

	
	public Object deepCopy(Object value)
	{
		if (value == null) return null;
		
		byte[] bytes = toByteArray(value);
		byte[] result = new byte[bytes.length];
		System.arraycopy(bytes, 0, result, 0, bytes.length);
		
		return toObject(result);
	}

	public boolean isMutable()
	{
		return true;
	}

}
