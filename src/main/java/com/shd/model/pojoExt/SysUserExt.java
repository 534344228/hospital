/**
 * 
 */
package com.shd.model.pojoExt;

import com.shd.model.pojo.SysUser;
import com.shd.model.pojo.SysUserRole;

/**
 * @author S5343
 * @date 2018年3月27日下午4:38:54
 */
public class SysUserExt extends SysUser {
	private SysUserRole sysUserRole;// 为角色配置用户

	public SysUserRole getSysUserRole() {
		return sysUserRole;
	}

	public void setSysUserRole(SysUserRole sysUserRole) {
		this.sysUserRole = sysUserRole;
	}

}
