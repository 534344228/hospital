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

/**
 * Extension of <code>java.util.HashMap</code> that enforces a "strict" get()
 * method in that it will throw an exception if the specified key has no
 * corresponding Map entry.
 *
 * @author <a href="mailto:bear@javaranch.com">Bear Bibeault</a>
 */
public class ClassConstantsMap extends HashMap {

	private String className;

	public ClassConstantsMap(String className) {
		super();
		this.className = className;
	}

	public Object get(Object key) {
		if (super.get(key) == null)
			throw new IllegalArgumentException(
					"Key " + key + " could not be found in class constant map for " + this.className);
		return super.get(key);
	}

	public Object put(Object key, Object value) {
		if (key == null)
			throw new IllegalArgumentException("null keys are not permitted");
		if (value == null)
			throw new IllegalArgumentException("null values are not permitted");
		return super.put(key, value);
	}

}
