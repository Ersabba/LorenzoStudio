package com.ericsson.urm.persistence.dto.mgre;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.ericsson.urm.util.ArgumentsCheckerUtil;

public abstract class BlobUtil {

	public static byte[] toByteArray(Object obj) throws IOException {
		if(obj==null)
			return null;
		
		byte[] bytes = null;
		ObjectOutputStream oos = null;
		ByteArrayOutputStream bos = null;
		try {
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			oos.flush();
			bytes = bos.toByteArray();
		} 
		finally {
			if(oos!=null) {
				oos.close();
			}
			if(bos!=null) {
				bos.close();
			}
		}
		return bytes;
	}

	public static Object toObject(byte[] bytes) throws IOException, ClassNotFoundException {
		if(bytes==null)
			return null;
		
		Object obj = null;
		ByteArrayInputStream bis = null;
		try {
			bis = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bis);
			obj = ois.readObject();
		} 
		finally {
			if(bis!=null) {
				bis.close();
			}
		}
		return obj;
	}
	
	public static <T> T toObject(byte[] bytes, Class<T> clsRet) throws IOException, ClassNotFoundException {
		if(bytes==null)
			return null;
		
		ArgumentsCheckerUtil.checkNull(clsRet, "clsRet");
		
		Object obj = toObject(bytes);
		return obj !=null ? clsRet.cast(obj) : null;
	}

	public static Object toObject(Blob data) throws SQLException, IOException, ClassNotFoundException {
		Object obj = null;
		
		if(data!=null) {
			InputStream is = null;
			ObjectInputStream ois = null;

			try {
				is = data.getBinaryStream();
				ois = new ObjectInputStream(is);
				obj = ois.readObject();
			} 
			finally {
				if(ois!=null) {
					ois.close();
				}
				if(is!=null) {
					is.close();
				}
			}
		}
		return obj;
	}

	public static Blob toBlob(Object obj, Session session) throws IOException {
		byte[] data = toByteArray(obj);
		return obj!=null ? Hibernate.getLobCreator(session).createBlob(data) : null;
	}
}
