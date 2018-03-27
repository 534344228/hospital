/**
 * 
 */
package com.shd.enums.sys;

import com.shd.common.core.GeneralEnum;
import com.shd.util.EnumUtil;

/**
 * @author S5343
 * @date 2018年3月27日下午5:05:57
 */
public enum LogTypeEnum implements GeneralEnum<String> {
	runLog("runLog", "运行日志"), operLog("operLog", "操作日志"),;
	private final String id;
	private final String name;

	LogTypeEnum(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public static String getNameById(String id) {
		return EnumUtil.getById(id, LogTypeEnum.class).getName();
	}

}
