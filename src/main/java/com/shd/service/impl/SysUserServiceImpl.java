/**
 * 
 */
package com.shd.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shd.dao.mapper.SysUserMapper;
import com.shd.model.pojo.SysUser;
import com.shd.model.pojo.SysUserExample;
import com.shd.model.pojoExt.SysUserExt;
import com.shd.service.SysUserService;
import com.shd.util.XTConstant;

/**
 * @author S5343
 * @date 2018年3月27日下午4:49:53
 */
@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;

	/**
	 * @param sysUser
	 * @param orderBy
	 * @return
	 */
	@Override
	public List<SysUser> querySysUserList(SysUser sysUser, String orderBy) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param userId
	 * @return
	 */
	@Override
	public SysUser getSysUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param sysUser
	 * @return
	 */
	@Override
	public Integer save(SysUser sysUser) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param userAcc
	 * @return
	 */
	@Override
	public SysUser getSysUserByUserAcc(String userAcc) {
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria criteria = example.createCriteria().andRecordStateEqualTo(XTConstant.Y);
		if (StringUtils.isNotBlank(userAcc)) {
			criteria.andUserAccEqualTo(userAcc);
		}
		List<SysUser> userList = sysUserMapper.selectByExample(example);
		if (userList != null && !userList.isEmpty()) {
			return userList.get(0);
		}
		return null;
	}

	/**
	 * @param userMobile
	 * @return
	 */
	@Override
	public SysUser getSysUserByUseMobile(String userMobile) {
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria criteria = example.createCriteria().andRecordStateEqualTo(XTConstant.Y);
		if (StringUtils.isNotBlank(userMobile)) {
			criteria.andUserAccEqualTo(userMobile);
		}
		List<SysUser> userList = sysUserMapper.selectByExample(example);
		if (userList != null && !userList.isEmpty()) {
			return userList.get(0);
		}
		return null;
	}

	/**
	 * @param userEmail
	 * @return
	 */
	@Override
	public SysUser getSysUserByUserEmail(String userEmail) {
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria criteria = example.createCriteria().andRecordStateEqualTo(XTConstant.Y);
		if (StringUtils.isNotBlank(userEmail)) {
			criteria.andUserAccEqualTo(userEmail);
		}
		List<SysUser> userList = sysUserMapper.selectByExample(example);
		if (userList != null && !userList.isEmpty()) {
			return userList.get(0);
		}
		return null;
	}

	/**
	 * @param currUser
	 * @return
	 */
	@Override
	public Integer firstTimeAddRoot(SysUser currUser) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param userId
	 * @return
	 */
	@Override
	public Integer deleteUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param paramMap
	 * @return
	 */
	@Override
	public List<SysUserExt> queryUserExtList(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param userId
	 * @return
	 */
	@Override
	public SysUserExt getSysUserExt(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param userId
	 * @return
	 */
	@Override
	public SysUserExt getRootUserExt(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param userId
	 * @return
	 */
	@Override
	public Integer batchDel(String[] userId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param paramMap
	 * @return
	 */
	@Override
	public List<SysUser> queryUserListByRoleId(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param sysUser
	 * @return
	 */
	@Override
	public List<SysUser> checkUnique(SysUser sysUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
