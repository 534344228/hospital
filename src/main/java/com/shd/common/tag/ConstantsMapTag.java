package com.shd.common.tag;

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

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.ValidationMessage;

/**
 * Custom action handler for <code>&lt;ccc:constantsMap&gt;</code> which
 * establishes a scoped variable containing a Map of all class constants found
 * in a named target class.
 *
 * @author <a href="mailto:bear@javaranch.com">Bear Bibeault</a>
 */
public class ConstantsMapTag extends ScopedVarTagSupport {

	private String className;

	public void setClassName(String value) {
		this.className = value;
	}

	public void doTag() throws JspException {
		try {
			Map constantsMap = new ClassConstantsMap(this.className);
			Class declaringClass = Class.forName(this.className);
			Field[] fields = declaringClass.getFields();
			for (int n = 0; n < fields.length; n++) {
				if (Modifier.isPublic(fields[n].getModifiers()) && Modifier.isStatic(fields[n].getModifiers())
						&& Modifier.isFinal(fields[n].getModifiers())) {
					constantsMap.put(fields[n].getName(), fields[n].get(null));
				}
			}
			setScopedVariable(constantsMap);
		} catch (Exception e) {
			throw new JspException("Exception setting constants map for " + this.className, e);
		}
	}

	/**
	 * Extra info class for the <code>&lt;ccc:constantsMap&gt;</code> custom action
	 * that checks to ensure that the scope name, if specified, is a valid one.
	 */
	public static class ExtraInfo extends TagExtraInfo {

		public ValidationMessage[] validate(TagData tagData) {
			List messages = new ArrayList();
			String varName = (String) tagData.getAttribute("var");
			if ((varName == null) || (varName.length() == 0))
				messages.add(new ValidationMessage(null, "The var attribute cannot be missing or blank"));
			String scopeName = (String) tagData.getAttribute("scope");
			if (scopeName != null)
				ScopedVarTagSupport.validateScope(scopeName, messages);
			return (messages.size() == 0) ? null
					: (ValidationMessage[]) messages.toArray(new ValidationMessage[messages.size()]);
		}

	}

}
