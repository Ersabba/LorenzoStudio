package com.ericsson.urm.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class ReflectionUtil {
	
	private static final Map<Class<?>, Class<?>> PRIMITIVES_TO_WRAPPERS = new HashMap<Class<?>, Class<?>>() {
		{ 
			put(boolean.class, Boolean.class);
			put(byte.class, Byte.class);
			put(char.class, Character.class);
			put(double.class, Double.class);
			put(float.class, Float.class);
			put(int.class, Integer.class);
			put(long.class, Long.class);
			put(short.class, Short.class);
			put(void.class, Void.class); 
		}
	};
	
	// safe because both Long.class and long.class are of type Class<Long>
	@SuppressWarnings("unchecked")
	private static <T> Class<T> wrap(Class<T> c) {
		return c != null && c.isPrimitive() ? (Class<T>) PRIMITIVES_TO_WRAPPERS.get(c) : c;
	}
		
	
	public static <T> T invoke(Object instance, String methodName, Class<T> clsReturned, Object... args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
		ArgumentsCheckerUtil.checkNull(instance,"instance");
		ArgumentsCheckerUtil.checkNull(methodName,"methodName");
		ArgumentsCheckerUtil.checkNull(clsReturned,"clsReturned");
		
		Class<?>[] parameterTypes = null;
		if(args!=null) {
			parameterTypes = new Class<?>[args.length];
			int j=0;
			for(Object o : args) {
				try {
					parameterTypes[j] = (Class<?>)o.getClass().getField("TYPE").get(null);
				} catch (Exception e) {
					parameterTypes[j] = o.getClass();
				}
				
				++j;
			}
		}
	
		Class<?> cls = instance.getClass();
		if(instance instanceof Class) {
			cls = (Class<?>)instance;
			instance = null;
		}
		System.out.println(cls.getName());
		
		Method m = null;
		try {
			m = cls.getMethod(methodName, parameterTypes);
		} catch (NoSuchMethodException e1) {
			try {
				m = cls.getDeclaredMethod(methodName, parameterTypes);
			} catch (NoSuchMethodException e) {
				Method[] mm = cls.getMethods();
				for(Method cm : mm) {
					
					if(cm.getName().equals(methodName)) {
						parameterTypes = cm.getParameterTypes();
						if(parameterTypes.length==args.length) {
							int j = 0;
							for(Class<?> c: parameterTypes) {
								Class<?> wc1 = wrap(c);
								Class<?> wc2 = wrap(args[j++].getClass());
								if(!wc1.isAssignableFrom(Object.class) && 
								   !wc2.isAssignableFrom(wc2)) {
									   break;
								   }							   
							}
							if(j==args.length) {
								m = cm;
							}
						}
					}				
				}
				if(m == null) {
					throw e;
				}
			}
		}
		
		Class<?> retType = wrap(m.getReturnType());
		clsReturned = wrap(clsReturned);
		if( !clsReturned.isAssignableFrom(retType) ) {
			throw new RuntimeException("Wrong return type declared:"+clsReturned.getClass()+" expected:"+retType);
		}
		
		m.setAccessible(true);
		return clsReturned.cast(m.invoke(instance, args));
	}
	

	public static Method provideGetter(String fieldName, Class clazz, String prefix) throws SecurityException, NoSuchMethodException {
		return clazz.getMethod(prefix + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1), null);
	}

	public static Method provideSetter(String fieldName, Class clazz, Class[] paramTypes) throws SecurityException, NoSuchMethodException {
		return clazz.getMethod("set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1), paramTypes);
	}

	public static Object getField(String fieldName, Object target) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, SecurityException, NoSuchMethodException {
		Method m = null;
		try {
			m = provideGetter(fieldName, target.getClass(), "get");
		}
		catch (Exception e) {
			m = provideGetter(fieldName, target.getClass(), "is");
		}
		return m.invoke(target, null);
	}

	public static Integer getIntField(String fieldName, Object target) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, SecurityException, NoSuchMethodException {
		return (Integer) getField(fieldName, target);
	}

	public static Double getDoubleField(String fieldName, Object target) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, SecurityException, NoSuchMethodException {
		return (Double) getField(fieldName, target);
	}

	public static String getStringField(String fieldName, Object target) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, SecurityException, NoSuchMethodException {
		return (String) getField(fieldName, target);
	}

	public static Byte getByteField(String fieldName, Object target) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, SecurityException, NoSuchMethodException {
		return (Byte) getField(fieldName, target);
	}

	public static Long getLongField(String fieldName, Object target) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, SecurityException, NoSuchMethodException {
		return (Long) getField(fieldName, target);
	}

	public static Short getShortField(String fieldName, Object target) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, SecurityException, NoSuchMethodException {
		return (Short) getField(fieldName, target);
	}



	// in questo metodo paramType può essere sia una classe Wrapper che primitiva
	public static void setField(String fieldName, Object target, Class paramType, Object arg) throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		if (paramType.equals(Double.class) || paramType.equals(double.class)) {
			try {
				setDoubleField(fieldName, target, (Double) arg);
			}
			catch (Exception e) {
				setPrimitiveDoubleField(fieldName, target, ((Double) arg).doubleValue());
			}
		}
		else if (paramType.equals(Integer.class) || paramType.equals(int.class)) {
			try {
				setIntegerField(fieldName, target, (Integer) arg);
			}
			catch (Exception e) {
				setPrimitiveIntField(fieldName, target, ((Integer) arg).intValue());
			}
		}
		else if (paramType.equals(Byte.class) || paramType.equals(byte.class)) {
			try {
				setByteField(fieldName, target, (Byte) arg);
			}
			catch (Exception e) {
				setPrimitiveByteField(fieldName, target, ((Byte) arg).byteValue());
			}
		}
		else if (paramType.equals(Long.class) || paramType.equals(long.class)) {
			try {
				setLongField(fieldName, target, (Long) arg);
			}
			catch (Exception e) {
				setPrimitiveLongField(fieldName, target, ((Long) arg).longValue());
			}
		}
		else if (paramType.equals(Short.class) || paramType.equals(short.class)) {
			try {
				setShortField(fieldName, target, (Short) arg);
			}
			catch (Exception e) {
				setPrimitiveShortField(fieldName, target, ((Short) arg).shortValue());
			}
		}
		else if (paramType.equals(Boolean.class) || paramType.equals(boolean.class)) {
			try {
				setBooleanField(fieldName, target, (Boolean) arg);
			}
			catch (Exception e) {
				setPrimitiveBooleanField(fieldName, target, ((Boolean) arg).booleanValue());
			}
		}
		else if (paramType.equals(String.class)) {
			setStringField(fieldName, target, (String) arg);
		}
		else {
			Method m = provideSetter(fieldName, target.getClass(), new Class[] {paramType});
			m.invoke(target, new Object[] {arg});
		}
	}

	public static void setDoubleField(String fieldName, Object target, Double arg) throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Method m = provideSetter(fieldName, target.getClass(), new Class[] { Double.class });
		m.invoke(target, new Object[] { arg });
	}

	public static void setPrimitiveDoubleField(String fieldName, Object target, double arg) throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Method m = provideSetter(fieldName, target.getClass(), new Class[] { double.class });
		m.invoke(target, new Object[] { new Double(arg) });
	}

	public static void setIntegerField(String fieldName, Object target, Integer arg) throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Method m = provideSetter(fieldName, target.getClass(), new Class[] { Integer.class });
		m.invoke(target, new Object[] { arg });
	}

	public static void setPrimitiveIntField(String fieldName, Object target, int arg) throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Method m = provideSetter(fieldName, target.getClass(), new Class[] { int.class });
		m.invoke(target, new Object[] { new Integer(arg) });
	}

	public static void setStringField(String fieldName, Object target, String arg) throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Method m = provideSetter(fieldName, target.getClass(), new Class[] { String.class });
		m.invoke(target, new Object[] { arg });
	}

	public static void setByteField(String fieldName, Object target, Byte arg) throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Method m = provideSetter(fieldName, target.getClass(), new Class[] { Byte.class });
		m.invoke(target, new Object[] { arg });
	}

	public static void setPrimitiveByteField(String fieldName, Object target, byte arg) throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Method m = provideSetter(fieldName, target.getClass(), new Class[] { byte.class });
		m.invoke(target, new Object[] { new Byte(arg) });
	}

	public static void setLongField(String fieldName, Object target, Long arg) throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Method m = provideSetter(fieldName, target.getClass(), new Class[] { Long.class });
		m.invoke(target, new Object[] { arg });
	}

	public static void setPrimitiveLongField(String fieldName, Object target, long arg) throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Method m = provideSetter(fieldName, target.getClass(), new Class[] { long.class });
		m.invoke(target, new Object[] { new Long(arg) });
	}

	public static void setShortField(String fieldName, Object target, Short arg) throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Method m = provideSetter(fieldName, target.getClass(), new Class[] { Short.class });
		m.invoke(target, new Object[] { arg });
	}

	public static void setPrimitiveShortField(String fieldName, Object target, short arg) throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Method m = provideSetter(fieldName, target.getClass(), new Class[] { short.class });
		m.invoke(target, new Object[] { new Short(arg) });
	}

	public static void setBooleanField(String fieldName, Object target, Boolean arg) throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Method m = provideSetter(fieldName, target.getClass(), new Class[] { Boolean.class });
		m.invoke(target, new Object[] { arg });
	}

	public static void setPrimitiveBooleanField(String fieldName, Object target, boolean arg) throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Method m = provideSetter(fieldName, target.getClass(), new Class[] { boolean.class });
		m.invoke(target, new Object[] { new Boolean(arg) });
	}

}
