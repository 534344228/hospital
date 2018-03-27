/**
 * 
 */
package com.shd.common.core;

/**
 * 用于枚举需要实现的接口
 * 
 * @author S5343
 * @date 2018年3月27日下午5:06:28
 */
public interface GeneralEnum<T> {
	/**
	 * 得到枚举对应的id,一般保存这个id至数据库
	 * 
	 * @return
	 */
	public T getId();

	/**
	 * 得到枚举描述
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * 枚举名称
	 * 
	 * @return
	 */
	public String name();
}
