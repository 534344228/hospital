package com.shd.dao.extMapper;

import java.util.List;
import java.util.Map;

import com.shd.model.pojoExt.UserMenuExt;

public interface UserMenuExtMapper {
	/**
	 * 查询当前用户下所有一级菜单
	 * 
	 * @param userId
	 * @return
	 */
	List<UserMenuExt> querySysMenuList(String userId);

	/**
	 * 查询当前用户下一级菜单下的二级菜单
	 * 
	 * @param menuId
	 * @return
	 */
	List<UserMenuExt> querySecondSysMenuList(Map<String, Object> map);
}
