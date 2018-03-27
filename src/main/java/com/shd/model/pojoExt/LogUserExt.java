/**
 * 
 */
package com.shd.model.pojoExt;

import com.shd.model.pojo.SysLog;
import com.shd.model.pojo.SysUser;

/**
 * @author S5343
 * @date 2018年3月27日下午5:15:40
 */
public class LogUserExt extends SysLog {
	private SysUser user;

	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}
	
}
