package com.shd.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class BeanUtil {

	private static final String STR_GET = "get";

	private static final String STR_SET = "set";

	/**
	 * bean及其父类所有的属性转化为map，属性必须有set、get方法
	 * 
	 * @param bean
	 * @return
	 */
	public static Map<String, Object> beanToMap(Object bean) {
		Map<String, Object> result = new HashMap<String, Object>();

		Field[] fields = bean.getClass().getDeclaredFields();

		try {
			String getMethodName;
			for (Field field : fields) {
				if (!field.getName().equals("serialVersionUID")) {
					getMethodName = STR_GET + StringUtils.capitalize(field.getName());
					result.put(field.getName(), bean.getClass().getDeclaredMethod(getMethodName).invoke(bean));
				}
			}

			Class<?> superBeanClass = bean.getClass().getSuperclass();
			if (superBeanClass != Object.class) {
				fields = superBeanClass.getDeclaredFields();

				for (Field field : fields) {
					if (!field.getName().equals("serialVersionUID")) {
						getMethodName = STR_GET + StringUtils.capitalize(field.getName());
						result.put(field.getName(), superBeanClass.getDeclaredMethod(getMethodName).invoke(bean));
					}
				}
			}
		} catch (Exception e) {
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	public static Field[] getAllFields(Object bean, Field[] fields) {
		Field[] fs = null;
		Field[] newFs = null;
		if (bean instanceof Class) {
			@SuppressWarnings("rawtypes")
			Class clazz = (Class) bean;
			bean = clazz;
		} else {
			bean = bean.getClass();
		}
		fs = ((Class<? extends Object>) bean).getDeclaredFields();
		if (fields != null) {
			newFs = (Field[]) ArrayUtils.addAll(fs, fields);
		} else {
			newFs = fs;
		}
		if (bean.equals(Object.class)) {
			return newFs;
		}

		return getAllFields(((Class<? extends Object>) bean).getSuperclass(), newFs);

	}

	@SuppressWarnings("unchecked")
	public static Method getMethod(Object bean, String methodName, Method fs, Field field) {
		if (bean == null) {
			return null;
		}
		if (bean instanceof Class) {
			@SuppressWarnings("rawtypes")
			Class clazz = (Class) bean;
			bean = clazz;
		} else {
			bean = bean.getClass();
		}
		try {
			if (methodName.startsWith(STR_GET)) {
				fs = ((Class<? extends Object>) bean).getDeclaredMethod(methodName);
			} else {
				fs = ((Class<? extends Object>) bean).getDeclaredMethod(methodName, field.getType());
			}

		} catch (NoSuchMethodException e) {
			fs = null;
			return getMethod(((Class<? extends Object>) bean).getSuperclass(), methodName, fs, field);
		}
		if (!CommUtils.isEmpty(fs)) {
			return fs;
		}
		return null;

	}

	/**
	 * 
	 * @param destBean
	 * @param origBean
	 */
	public static void newBeanToBean(Object destBean, Object origBean) {
		Field[] fields = getAllFields(destBean, null);
		try {
			for (Field field : fields) {
				String name = field.getName();
				Method origMethod = getMethod(origBean, STR_GET + StringUtils.capitalize(name), null, field);
				if (origMethod == null) {
					continue;
				}
				Object value = origMethod.invoke(origBean);
				Method destMethod = getMethod(destBean, STR_SET + StringUtils.capitalize(name), null, field);
				destMethod.invoke(destBean, value);
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * map转化为bean及其父类所有的属性，属性必须有set、get方法
	 * 
	 * @param map
	 * @param bean
	 * @return
	 */
	public static void mapToBean(Map<String, Object> map, Object bean) {
		Field[] fields = getAllFields(bean, null);
		try {
			String setMethodName;
			for (Field field : fields) {
				String name = field.getName();
				Object tempObj;// 根据查出来的类型set值 oracle寻找big类型的重载set方法
				boolean empty = CommUtils.isEmpty(map.get(name));
				if (map.containsKey(name) && !empty) {
					tempObj = map.get(name);
					setMethodName = STR_SET + StringUtils.capitalize(name);
					Object cache = map.get(name);
					if (field.getType().equals(Date.class) && !(cache instanceof Date)) {
						if (cache instanceof Long) {
							cache = new Date((Long) cache);
						}
						if (cache instanceof String) {
							cache = DateUtil.stringToDate((String) cache);
						}
					}
					if (field.getType().equals(BigDecimal.class) && !(cache instanceof BigDecimal)) {
						if (cache instanceof Integer) {
							cache = new BigDecimal((Integer) cache);
						}
						if (cache instanceof Double) {
							cache = new BigDecimal((Double) cache);
						}
						if (cache instanceof String) {
							cache = new BigDecimal((String) cache);
						}
					}
					if (field.getType() == String.class) {
						cache = String.valueOf(cache);
					}
					Method method = getMethod(bean, setMethodName, null, field);
					method.invoke(bean, cache);
				} else if (map.containsKey(name.toUpperCase()) && map.get(name.toUpperCase()) != null) {
					// oracle 字段为全大写
					tempObj = map.get(name.toUpperCase());
					setMethodName = STR_SET + StringUtils.capitalize(name);
					Method method = bean.getClass().getDeclaredMethod(setMethodName, tempObj.getClass());
					method.invoke(bean, map.get(name.toUpperCase()));

				}
			}
			Class<?> superBeanClass = bean.getClass().getSuperclass();
			if (superBeanClass != null && superBeanClass != Object.class) {
				fields = superBeanClass.getDeclaredFields();

				for (Field field : fields) {
					if (map.containsKey(field.getName()) && map.get(field.getName()) != null) {
						setMethodName = STR_SET + StringUtils.capitalize(field.getName());
						Method method = superBeanClass.getDeclaredMethod(setMethodName, field.getType());
						method.invoke(bean, map.get(field.getName()));
					}
				}
			}
		} catch (Exception e) {
		}
	}

	/**
	 * Bean与Bean之间同属性复制
	 * 
	 * @param destBean
	 *            复制者
	 * @param origBean
	 *            传递者
	 */
	public static void BeanToBean(Object destBean, Object origBean) {
		try {
			BeanUtils.copyProperties(destBean, origBean);
		} catch (Exception e) {
		}
	}

	public static String getValue(Map<String, Object> map, String key) {
		return map.containsKey(key) ? String.valueOf(map.get(key)) : "";
	}

	public static String getValue(Map<String, Object> map, String key, String defaultValue) {
		return map.containsKey(key) ? String.valueOf(map.get(key)) : defaultValue;
	}
}
