package com.shd.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shd.dao.extMapper.UserMenuExtMapper;
import com.shd.dao.mapper.SysMenuMapper;
import com.shd.dao.mapper.SysUserMenuMapper;
import com.shd.model.pojo.SysMenu;
import com.shd.model.pojo.SysMenuExample;
import com.shd.model.pojo.SysUserMenu;
import com.shd.model.pojo.SysUserMenuExample;
import com.shd.model.pojoExt.UserMenuExt;
import com.shd.service.UserMenuService;
import com.shd.util.UUIDUtil;
import com.shd.util.XTConstant;

/**
 * 菜单服务类
 * 
 * @author S5343
 * @date 2018年3月29日上午9:54:58
 */
@Service
@Transactional
public class UserMenuServiceImpl implements UserMenuService {
	@Autowired
	private SysUserMenuMapper userMenuMapper;

	@Autowired
	private SysMenuMapper menuMapper;

	@Autowired
	private UserMenuExtMapper userMenuExtMapper;

	@Override
	public List<SysMenu> querySysMenu() {
		SysMenuExample example = new SysMenuExample();
		SysMenuExample.Criteria criteria = example.createCriteria();
		// 一级菜单:顶层菜单 parentID=null
		criteria.andMenuParentIdIsNull();
		return menuMapper.selectByExample(example);
	}

	@Override
	public List<SysMenu> querySecondSysMenu(String menuId) {
		SysMenuExample example = new SysMenuExample();
		SysMenuExample.Criteria criteria = example.createCriteria();
		criteria.andMenuIdEqualTo(menuId);
		return menuMapper.selectByExample(example);
	}

	@Override
	public List<UserMenuExt> querySysMenuList(String userId) {
		return userMenuExtMapper.querySysMenuList(userId);
	}

	@Override
	public List<UserMenuExt> querySecondSysMenuList(String menuId, String userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(menuId)) {
			map.put("menuId", menuId);
		}
		if (StringUtils.isNotBlank(userId)) {
			map.put("userId", userId);
		}
		return userMenuExtMapper.querySecondSysMenuList(map);
	}

	@Override
	public List<SysMenu> queryAllMenuList() {
		return menuMapper.selectByExample(null);
	}

	@Override
	public List<SysUserMenu> queryAllMenuListByUserId(String userId) {
		SysUserMenuExample example = new SysUserMenuExample();
		SysUserMenuExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		return userMenuMapper.selectByExample(example);
	}

	@Override
	public Integer savePermission(String userId, String[] treeId) {
		List<SysUserMenu> userMenuList = queryAllMenuListByUserId(userId);
		int result = 2;
		if (treeId != null) {
			for (String menuId : treeId) {
				int i = 0;
				for (SysUserMenu sysUserMenu : userMenuList) {
					if (sysUserMenu.getMenuId().equals(menuId)) {
						i = 1;
					}
				}
				if (i == 0) {
					SysUserMenu menu = new SysUserMenu();
					menu.setUserMenuId(UUIDUtil.getUUID());
					menu.setUserId(userId);
					menu.setMenuId(menuId);
					menu.setCreateTime(new Date());
					menu.setDelState(XTConstant.Y);

					result = userMenuMapper.insert(menu);
				}
			}
		}
		for (SysUserMenu sysUserMenu : userMenuList) {
			int i = 0;
			if (treeId != null) {
				for (String menuId : treeId) {
					if (sysUserMenu.getMenuId().equals(menuId)) {
						i = 1;
					}
				}
			}
			if (i == 0) {
				result = userMenuMapper.deleteByPrimaryKey(sysUserMenu.getUserMenuId());
			}
		}
		return result;
	}

	@Override
	public List<SysUserMenu> queryAllUserListByMenuId(String menuId) {
		SysUserMenuExample example = new SysUserMenuExample();
		SysUserMenuExample.Criteria criteria = example.createCriteria();
		criteria.andMenuIdEqualTo(menuId);
		return userMenuMapper.selectByExample(example);
	}

	@Override
	public Integer saveUser(String menuId, String[] treeId) {
		List<SysUserMenu> userMenuList = queryAllUserListByMenuId(menuId);
		int result = 0;
		if (treeId != null) {
			for (String userId : treeId) {
				int i = 0;
				for (SysUserMenu sysUserMenu : userMenuList) {
					if (sysUserMenu.getUserId().equals(userId)) {
						i = 1;
					}
				}
				if (i == 0) {
					SysUserMenu menu = new SysUserMenu();
					menu.setUserMenuId(UUIDUtil.getUUID());
					menu.setUserId(userId);
					menu.setMenuId(menuId);
					menu.setCreateTime(new Date());
					menu.setDelState(XTConstant.Y);

					result = userMenuMapper.insert(menu);
				}
			}
		}
		for (SysUserMenu sysUserMenu : userMenuList) {
			int i = 0;
			if (treeId != null) {
				for (String userId : treeId) {
					if (sysUserMenu.getUserId().equals(userId)) {
						i = 1;
					}
				}
			}
			if (i == 0) {
				result = userMenuMapper.deleteByPrimaryKey(sysUserMenu.getUserMenuId());
			}
		}
		return result;
	}

}
