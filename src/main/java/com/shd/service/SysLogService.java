package com.shd.service;

import java.util.List;

import com.shd.model.pojo.SysLog;
import com.shd.model.pojoExt.LogUserExt;

/**
 * 
 * @author S5343
 * @date 2018年3月27日下午5:13:51
 */
public interface SysLogService {
	/**
	 * 保存日志信息
	 * 
	 * @param log
	 * @return
	 */
	Integer save(SysLog log);

	/**
	 * 删除日志信息
	 * 
	 * @param logId
	 * @return
	 */
	Integer delete(String logId);

	/**
	 * 查询日志信息
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	List<LogUserExt> queryLogList(String startTime, String endTime);
}
