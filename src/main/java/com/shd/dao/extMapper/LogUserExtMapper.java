/**
 * 
 */
package com.shd.dao.extMapper;

import java.util.List;
import java.util.Map;

import com.shd.model.pojoExt.LogUserExt;

/**
 * @author S5343
 * @date 2018年3月27日下午5:20:06
 */
public interface LogUserExtMapper {
	/**
	 * 查询日志信息
	 * 
	 * @param map
	 * @return
	 */
	List<LogUserExt> queryLogList(Map<String, Object> map);

}
