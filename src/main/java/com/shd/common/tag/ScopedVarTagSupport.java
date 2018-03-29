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

import java.util.List;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.ValidationMessage;

/**
 * Abstract tag support class for implementing SimpleTag custom actions that
 * specify <code>var</code> and <code>scope</code> attributes.
 *
 * @author <a href="mailto:bear@javaranch.com">Bear Bibeault</a>
 */
public abstract class ScopedVarTagSupport extends SimpleTagSupport {

	private String varName;
	private String scopeName;

	public void setVar(String value) {
		this.varName = value;
	}

	public void setScope(String value) {
		this.scopeName = value;
	}

	protected String getVar() {
		return this.varName;
	}

	protected String getScopeName() {
		return this.scopeName;
	}

	protected ScopedContext getScopedContext() {
		return (this.scopeName == null) ? ScopedContext.PAGE : ScopedContext.getInstance(this.scopeName);
	}

	protected void setScopedVariable(Object value) {
		getJspContext().setAttribute(this.varName, value, getScopedContext().getValue());
	}

	/**
	 * Validation method for the scope name; designed to be called from TagExtraInfo
	 * extensions.
	 *
	 * @param scopeName
	 *            the scope name to be tested
	 * @param validationMessages
	 *            the message list to add error messages to
	 *
	 * @return true if the validation failed, false otherwise
	 */
	public static boolean validateScope(String scopeName, List validationMessages) {
		boolean failed = false;
		if (ScopedContext.getInstance(scopeName) == null) {
			validationMessages
					.add(new ValidationMessage(null, "The value " + scopeName + " is not a valid scope name"));
			failed = true;
		}
		return failed;
	}

}
