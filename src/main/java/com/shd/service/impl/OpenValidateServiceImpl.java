/**
 * 
 */
package com.shd.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shd.common.core.HttpServletContext;
import com.shd.dao.mapper.SysCfgMapper;
import com.shd.model.pojo.SysCfg;
import com.shd.model.pojo.SysCfgExample;
import com.shd.service.OpenValidateService;

/**
 * @author S5343
 * @date 2018年3月27日下午4:04:50
 */
@Service
@Transactional
public class OpenValidateServiceImpl implements OpenValidateService {

	@Autowired
	private SysCfgMapper cfgMapper;

	/**
	 * 
	 * 
	 * @param 配置项ID
	 * @return
	 */
	@Override
	public List<SysCfg> getOpenValidate(String cfgCode) {
		SysCfgExample example = new SysCfgExample();
		SysCfgExample.Criteria criteria = example.createCriteria();
		criteria.andCfgCodeEqualTo(cfgCode);
		return cfgMapper.selectByExample(example);
	}

	/**
	 * @param cfgValue
	 * @param cfgCode
	 * @param cfgId
	 * @return
	 */
	@Override
	public Integer editOpenValidate(String cfgValue, String cfgCode, String cfgId) {
		SysCfgExample example = new SysCfgExample();
		SysCfgExample.Criteria criteria = example.createCriteria();
		criteria.andCfgCodeEqualTo(cfgCode);
		SysCfg record = new SysCfg();
		record.setCfgId(cfgId);
		record.setModifyTime(Calendar.getInstance().getTime());
		record.setCfgValue(cfgValue);
		record.setModifyUserId(HttpServletContext.getCurrentUser().getUserId());
		return cfgMapper.updateByPrimaryKeySelective(record);
	}

}
