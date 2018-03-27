/**
 * 
 */
package com.shd.util;

import java.util.Date;
import java.util.UUID;

/**
 * @author S5343
 * @date 2018年3月27日下午5:28:40
 */
public class UUIDUtil {
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static String getUUIDNum() {

		return String.valueOf(new Date().getTime()) + "" + (int) (Math.random() * 1000000);
	}

}
