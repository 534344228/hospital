package com.shd.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.shd.common.core.HttpServletContext;
import com.shd.model.pojo.SysUser;
import com.shd.util.AjaxUtil;
import com.shd.util.XTConstant;

/**
 * 通用Controller
 * 
 * @author S5343
 * @date 2018年3月27日下午3:36:56
 */
public class CommonController {
	private static Logger logger = LoggerFactory.getLogger(CommonController.class);

	/**
	 * 后台报错跳转页面
	 * 
	 * @param e
	 * @param request
	 * @return
	 */
	@ExceptionHandler(Throwable.class)
	public String exception(Throwable e, HttpServletRequest request) {
		logger.error(this.getClass().getCanonicalName() + " CommonController Exception", e);
		boolean isAjax = AjaxUtil.isAjaxRequest(request);
		if (isAjax) {
			e.printStackTrace();
			return e.getMessage();
		} else {
			e.printStackTrace();
			request.setAttribute("exception", e);
			return "error/500";
		}
	}

	/**
	 * 设置session的属性值
	 * 
	 * @param key
	 * @param obj
	 */
	protected void setSessionAttribute(String key, Object obj) {
		HttpServletContext.getSession().setAttribute(key, obj);
	}

	/**
	 * 获取session的属性值
	 * 
	 * @param key
	 * @return
	 */
	protected Object getSessionAttribute(String key) {
		return HttpServletContext.getSession().getAttribute(key);
	}

	/**
	 * 删除session的属性值
	 * 
	 * @param key
	 */
	protected void removeSessionAttribute(String key) {
		HttpServletContext.getSession().removeAttribute(key);
	}

	/**
	 * 获取PageSize
	 * 
	 * @return
	 */
	protected Integer getPageSize() {
		Integer pageSize = null;
		String getPath = StringUtils.defaultString(HttpServletContext.getRequest().getServletPath().toString());
		SysUser currUser = HttpServletContext.getCurrentUser();
		if (currUser != null) {
			String cfgCode = getPath + "/" + currUser.getUserId() + "/pageSize";
			Integer sessionValue = (Integer) HttpServletContext.getSession().getAttribute(cfgCode);
			if (sessionValue != null) {
				pageSize = sessionValue;
			}
		}
		if (pageSize == null) {
			pageSize = XTConstant.DEFAULT_PAGE_SIZE;
		}
		return pageSize;
	}
}
