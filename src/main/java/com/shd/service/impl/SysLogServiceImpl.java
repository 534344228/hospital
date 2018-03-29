/**
 * 
 */
package com.shd.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shd.dao.extMapper.LogUserExtMapper;
import com.shd.dao.mapper.SysLogMapper;
import com.shd.model.pojo.SysLog;
import com.shd.model.pojoExt.LogUserExt;
import com.shd.service.SysLogService;
import com.shd.util.UUIDUtil;
import com.shd.util.XTConstant;

/**
 * @author S5343
 * @date 2018年3月27日下午5:17:35
 */
@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {
	@Autowired
	private SysLogMapper logMapper;
	@Autowired
	private LogUserExtMapper logExtMapper;

	/**
	 * @param log
	 * @return
	 */
	@Override
	public Integer save(SysLog log) {
		if (StringUtils.isNotBlank(log.getLogId())) {
			log.setUpdateTime(new Date());
			return logMapper.updateByPrimaryKeySelective(log);
		} else {
			log.setLogId(UUIDUtil.getUUID());
			log.setCreateTime(new Date());
			log.setDelState(XTConstant.Y);
			return logMapper.insertSelective(log);
		}
	}

	/**
	 * @param logId
	 * @return
	 */
	@Override
	public Integer delete(String logId) {
		return logMapper.deleteByPrimaryKey(logId);
	}

	/**
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	@Override
	public List<LogUserExt> queryLogList(String startTime, String endTime) {
		Map<String, Object> map = new HashMap<>();
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		return logExtMapper.queryLogList(map);
	}

}
