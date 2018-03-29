package com.shd.service;

import java.util.List;

import com.shd.model.pojo.SysMenu;
import com.shd.model.pojo.SysUserMenu;
import com.shd.model.pojoExt.UserMenuExt;

public interface UserMenuService {
	/**
	 * 查询所有一级菜单
	 * 
	 * @return
	 */
	List<SysMenu> querySysMenu();

	/**
	 * 查询一级菜单所拥有的二级菜单
	 * 
	 * @param menuId
	 * @return
	 */
	List<SysMenu> querySecondSysMenu(String menuId);

	/**
	 * 查询当前用户下所有一级菜单
	 * 
	 * @return
	 */
	List<UserMenuExt> querySysMenuList(String userId);

	/**
	 * 查询当前用户下一级菜单所拥有的二级菜单
	 * 
	 * @param menuId
	 * @return
	 */
	List<UserMenuExt> querySecondSysMenuList(String menuId, String userId);

	/**
	 * 查询所有菜单
	 * 
	 * @param menuId
	 * @return
	 */
	List<SysMenu> queryAllMenuList();

	/**
	 * 查询当前用户所有菜单
	 * 
	 * @param menuId
	 * @return
	 */
	List<SysUserMenu> queryAllMenuListByUserId(String userId);

	/**
	 * 给用户配置菜单
	 * 
	 * @param userId
	 * @param treeId
	 * @return
	 */
	Integer savePermission(String userId, String[] treeId);

	/**
	 * 查询当前菜单所拥有的用户
	 * 
	 * @param menuId
	 * @return
	 */
	List<SysUserMenu> queryAllUserListByMenuId(String menuId);

	/**
	 * 给菜单配置用户
	 * 
	 * @param menuId
	 * @param treeId
	 * @return
	 */
	Integer saveUser(String menuId, String[] treeId);
}
