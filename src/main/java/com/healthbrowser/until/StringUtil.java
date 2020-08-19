package com.healthbrowser.until;

import static jdk.nashorn.internal.objects.NativeString.trim;

import java.io.UnsupportedEncodingException;

public class StringUtil {


    public static boolean isNull(Object obj){
       return null == obj || "".equals(obj);
    }
    /**
     * 转换为Integer类型
     */
    public static Integer toInteger(Object val) {
        return toLong(val).intValue();
    }
    /**
     * 转换为Long类型
     */
    public static Long toLong(Object val) {
        return toDouble(val).longValue();
    }
    /**
     * 转换为Double类型
     */
    public static Double toDouble(Object val) {
        if (val == null) {
            return 0.00;
        }
        try {
            return Double.valueOf(trim(val.toString()));
        } catch (Exception e) {
            return 0.00;
        }
    }

    /**
     * 转换为String类型
     */
    public static String toString(Object val) {
        if (val == null) {
            return "";
        }
        return val.toString();
    }
    public static Boolean toBoolean(Object obj) {
        Boolean Bl = new Boolean(toString(obj));
        boolean bl = Bl.booleanValue();
        return bl;
    }
    
    /**
     * 转换为Float类型
     */
    public static Float toFloat(Object val) {
        return toDouble(val).floatValue();
    }

    /**
	 * 	转换为字节数组
	 * 
	 * @param str
	 * @return
	 */
	public static byte[] getBytes(String str) {
		if (str != null) {
			try {
				return str.getBytes("UTF-8");
			} catch (UnsupportedEncodingException e) {
				return null;
			}
		} else {
			return null;
		}
	}
	 /**
	 * 	转换为字符串
	 * @param str
	 * @return
	 */
	public static String toString(byte[] bytes) {
		try {
			return new String(bytes, "utf-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
