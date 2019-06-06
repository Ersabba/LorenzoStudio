package com.ericsson.urm.persistence;

import org.hibernate.type.*;


public class Hibernate {
	public static StringType STRING = StringType.INSTANCE;
	public static IntegerType INTEGER = IntegerType.INSTANCE;
	public static LongType LONG = LongType.INSTANCE;
	public static DateType DATE = DateType.INSTANCE;
	public static TimestampType TIMESTAMP = TimestampType.INSTANCE;
	public static YesNoType YES_NO = YesNoType.INSTANCE;
	public static BigIntegerType BIG_INTEGER = BigIntegerType.INSTANCE;
	public static DoubleType DOUBLE = DoubleType.INSTANCE;
	public static FloatType FLOAT = FloatType.INSTANCE;
	public static ClobType CLOB = ClobType.INSTANCE;
}
