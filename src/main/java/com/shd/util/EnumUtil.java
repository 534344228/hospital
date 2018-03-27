package com.shd.util;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.shd.common.core.GeneralEnum;

@SuppressWarnings("all")
public class EnumUtil {

	public static List<? extends GeneralEnum> toList(Class<? extends GeneralEnum> enumClass) {
		return Arrays.asList(enumClass.getEnumConstants());
	}

	public static <T extends GeneralEnum> LinkedHashMap toMap(Class<? extends GeneralEnum> enumClass) {
		return toMap(enumClass.getEnumConstants());
	}

	public static <T extends GeneralEnum> LinkedHashMap toMap(T[] values) {
		LinkedHashMap map = new LinkedHashMap();
		for (GeneralEnum item : values) {
			map.put(item.getId(), item.getName());
		}
		return map;
	}

	public static <T extends GeneralEnum<K>, K> K getId(T enumValue) {
		if (enumValue == null)
			return null;
		return enumValue.getId();
	}

	public static <T extends GeneralEnum> String getName(T enumValue) {
		if (enumValue == null)
			return null;
		return enumValue.getName();
	}

	public static <T extends GeneralEnum> T getById(Object id, Class<? extends GeneralEnum> enumClass) {
		return (T) getById(id, enumClass.getEnumConstants());
	}

	public static String getNameById(Object id, Class<? extends GeneralEnum> enumClass) {
		return getById(id, enumClass.getEnumConstants()).getName();
	}

	public static <T extends GeneralEnum> T getById(Object id, T[] values) {
		if (id == null)
			return null;
		if (id instanceof String && StringUtils.isBlank((String) id))
			return null;

		for (T item : values) {
			if (item.getId().equals(id)) {
				return item;
			}
		}
		return null;
	}

	public static <T extends GeneralEnum> T getRequiredById(Object id, Class<? extends GeneralEnum> enumClass) {
		return (T) getRequiredById(id, enumClass.getEnumConstants());
	}

	public static <T extends GeneralEnum> T getRequiredById(Object id, T[] values) throws IllegalArgumentException {
		if (id == null)
			return null;
		if (id instanceof String && StringUtils.isBlank((String) id))
			return null;

		GeneralEnum v = getById(id, values);
		if (v == null) {
			if (values.length > 0) {
				String className = values[0].getClass().getName();
				throw new IllegalArgumentException("not found Enum:" + className + " value by id:" + id);
			} else {
				throw new IllegalArgumentException("not found Enum by id:" + id);
			}
		}
		return (T) v;
	}

}
