/**
 * 
 */
package com.shd.service;

import java.util.List;

import com.shd.model.pojo.SysCfg;

/**
 * 打开验证码服务
 * 
 * @author S5343
 * @date 2018年3月27日下午4:03:05
 */
public interface OpenValidateService {
	/**
	 * 查询开启验证码
	 * 
	 * @param cfgCode
	 * @return
	 */
	List<SysCfg> getOpenValidate(String cfgCode);

	/**
	 * 修改状态
	 * 
	 * @param cfgCode
	 * @return
	 */
	Integer editOpenValidate(String cfgValue, String cfgCode, String cfgId);
}
