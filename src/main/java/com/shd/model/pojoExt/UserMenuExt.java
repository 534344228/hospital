package com.shd.model.pojoExt;

import com.shd.model.pojo.SysMenu;
import com.shd.model.pojo.SysUserMenu;

public class UserMenuExt extends SysUserMenu {
	private SysMenu menu;

	public SysMenu getMenu() {
		return menu;
	}

	public void setMenu(SysMenu menu) {
		this.menu = menu;
	}

}
