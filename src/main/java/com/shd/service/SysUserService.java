/**
 * 
 */
package com.shd.service;

import java.util.List;
import java.util.Map;

import com.shd.model.pojo.SysUser;
import com.shd.model.pojoExt.SysUserExt;

/**
 * @author S5343
 * @date 2018年3月27日下午4:32:09
 */
public interface SysUserService {
	/**
	 * 查找用户列表
	 * 
	 * @param sysUser
	 *            用户对象
	 * @param orderBy
	 *            排序类型
	 * @return
	 */
	List<SysUser> querySysUserList(SysUser sysUser, String orderBy);

	/**
	 * 查找单个用户对象
	 * 
	 * @param userId
	 *            用户Id
	 * @return
	 */
	SysUser getSysUser(String userId);

	/**
	 * 保存用户对象
	 * 
	 * @param sysUser
	 *            用户对象
	 * @return 影响的行数
	 */
	Integer save(SysUser sysUser);

	/**
	 * 根据账号查询用户
	 * 
	 * @param userAcc
	 *            用户账号
	 * @return
	 */
	SysUser getSysUserByUserAcc(String userAcc);

	/**
	 * 根据用户手机号码查询
	 * 
	 * @param userMobile
	 *            手机号码
	 * @return
	 */
	SysUser getSysUserByUseMobile(String userMobile);

	/**
	 * 根据用户邮箱查询
	 * 
	 * @param userEmail
	 *            邮箱
	 * @return
	 */
	SysUser getSysUserByUserEmail(String userEmail);

	/**
	 * 超级管理员首次创建
	 * 
	 * @param currUser
	 *            用户对象
	 */
	Integer firstTimeAddRoot(SysUser currUser);

	/**
	 * 删除用户
	 * 
	 * @param currUser
	 *            用户对象
	 */
	Integer deleteUser(String userId);

	/**
	 * 查询USER列表
	 * 
	 * @param sysUser
	 * @return
	 */
	List<SysUserExt> queryUserExtList(Map<String, Object> paramMap);

	/**
	 * 获取一条用户信息
	 * 
	 * @param userId
	 * @return
	 */
	SysUserExt getSysUserExt(String userId);

	/**
	 * 获root用户信息
	 * 
	 * @param userId
	 * @return
	 */
	SysUserExt getRootUserExt(String userId);

	/**
	 * 批量删除用户
	 * 
	 * @param userId
	 * @return
	 */
	Integer batchDel(String[] userId);

	/**
	 * 查询带角色的用户
	 * 
	 * @param paramMap
	 * @return
	 */
	List<SysUser> queryUserListByRoleId(Map<String, Object> paramMap);

	/**
	 * 验证手机号码的唯一性
	 * 
	 * @param userMobile
	 * @return
	 */
	List<SysUser> checkUnique(SysUser sysUser);
}
