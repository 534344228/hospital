package com.shd.util;

import java.util.Collection;
import java.util.Map;

/**
 * 
 * @author S5343
 * @date 2018年3月29日下午5:40:57
 */
public class CommUtils {

	/**
	 * 判断对象或对象数组中每一个对象是否为空: 对象为null，字符序列长度为0，集合类、Map,String为empty bean为null
	 * 
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		}
		if (obj instanceof CharSequence)
			return ((CharSequence) obj).length() == 0;

		if (obj instanceof Collection)
			return ((Collection) obj).isEmpty();

		if (obj instanceof Map)
			return ((Map) obj).isEmpty();

		if (obj instanceof Object[]) {
			Object[] object = (Object[]) obj;
			if (object.length == 0) {
				return true;
			}
			boolean empty = true;
			for (int i = 0; i < object.length; i++) {
				if (!isEmpty(object[i])) {
					empty = false;
					break;
				}
			}
			return empty;
		}
		if (obj instanceof Long) {
			Long l = (Long) obj;
			return l == null || l == 0L;
		}
		if (obj instanceof String) {
			String str = (String) obj;
			return str == null || str.equals("undefined") || str.equals("null") || str.equals("");
		}
		return false;
	}
}
