/*
 * Copyright (c) 2005, Bear Bibeault
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  - Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *  - The name of Bear Bibeault may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * This software is provided by the copyright holders and contributors "as is"
 * and any express or implied warranties, including, but not limited to, the
 * implied warranties of merchantability and fitness for a particular purpose
 * are disclaimed. In no event shall the copyright owner or contributors be
 * liable for any direct, indirect, incidental, special, exemplary, or
 * consequential damages (including, but not limited to, procurement of
 * substitute goods or services; loss of use, data, or profits; or business
 * interruption) however caused and on any theory of liability, whether in
 * contract, strict liability, or tort (including negligence or otherwise)
 * arising in any way out of the use of this software, even if advised of the
 * possibility of such damage.
 */
package com.shd.common.tag;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.PageContext;

/**
 * Type-safe enumeration associating the names of the various scoped contexts
 * with their values (as defined by <code>PageContext</code>) and vice versa.
 *
 * @author <a href="mailto:bear@javaranch.com">Bear Bibeault</a>
 */
public class ScopedContext {

	public static final String SCOPE_NAME_PAGE = "page";
	public static final String SCOPE_NAME_REQUEST = "request";
	public static final String SCOPE_NAME_SESSION = "session";
	public static final String SCOPE_NAME_APPLICATION = "application";
	public static final String EVENT_CLICK = "click";// 点击事件
	public static final String EVENT_SLIDE = "slide";// 滑动事件
	public static final String EVENT_TEXT = "text";// 文字填写事件
	private static final Map BY_NAME = new HashMap();
	private static final Map BY_VALUE = new HashMap();

	public static final ScopedContext PAGE = new ScopedContext(SCOPE_NAME_PAGE, PageContext.PAGE_SCOPE);
	public static final ScopedContext REQUEST = new ScopedContext(SCOPE_NAME_REQUEST, PageContext.REQUEST_SCOPE);
	public static final ScopedContext SESSION = new ScopedContext(SCOPE_NAME_SESSION, PageContext.SESSION_SCOPE);
	public static final ScopedContext APPLICATION = new ScopedContext(SCOPE_NAME_APPLICATION,
			PageContext.APPLICATION_SCOPE);

	private String name;
	private int value;

	/**
	 * Private constructor preventing creation of any instances except those
	 * provided by this implementation.
	 *
	 * @param name
	 *            the name of the scoped context
	 * @param value
	 *            the value of the scoped context as provided by PageContext
	 */
	private ScopedContext(String name, int value) {
		this.name = name;
		this.value = value;
		BY_NAME.put(this.name, this);
		BY_VALUE.put(this.value, this);
	}

	public String getName() {
		return this.name;
	}

	public int getValue() {
		return this.value;
	}

	/**
	 * Obtains the scoped context instance defined with the passed name.
	 *
	 * @param name
	 *            the name of the scoped context to return
	 * @return the named scoped context, or null if none exists
	 */
	public static ScopedContext getInstance(String name) {
		return (ScopedContext) BY_NAME.get(name);
	}

	/**
	 * Obtains the scoped context instance defined with the passed value.
	 *
	 * @param value
	 *            the value of the scoped context to return
	 * @return the scoped context with the passed value, or null if none exists
	 */
	public static ScopedContext getInstance(int value) {
		return (ScopedContext) BY_VALUE.get(value);
	}

}
