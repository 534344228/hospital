/**
 * 
 */
package com.shd.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.WebRequest;

/**
 * @author S5343
 * @date 2018年3月27日下午3:49:42
 */
public class AjaxUtil {
	public static boolean isAjaxRequest(HttpServletRequest request) {
		String requestedWith = request.getHeader("X-Requested-With");
		return requestedWith != null ? "XMLHttpRequest".equals(requestedWith) : false;
	}

	public static boolean isAjaxRequest(WebRequest webRequest) {
		String requestedWith = webRequest.getHeader("X-Requested-With");
		return requestedWith != null ? "XMLHttpRequest".equals(requestedWith) : false;
	}

	public static boolean isAjaxUploadRequest(WebRequest webRequest) {
		return webRequest.getParameter("ajaxUpload") != null;
	}

	private AjaxUtil() {
	}
}
