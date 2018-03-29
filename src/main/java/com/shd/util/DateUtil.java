/**
 * 
 */
package com.shd.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 日期转换工具类
 * 
 * @author S5343
 * @date 2018年3月28日下午3:17:08
 */
public class DateUtil {
	// 缺省日期格式
	public static final String FORMAT = "yyyy-MM-dd";
	public static final String FORMAT1 = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT2 = "yyyyMMddHHmmss";
	public static final String FORMAT3 = "yyyyMMddHHmmssSSS";
	public static final String FORMAT4 = "yyyy-MM";
	public static final String FORMAT5 = "yyyyMM";
	public static final String FORMAT6 = "yyyy/MM/dd";

	/**
	 * yyyy-MM-dd
	 * 
	 * @param d
	 * @return
	 */
	public static String dateToString(Date d) {
		String s = new SimpleDateFormat(FORMAT).format(d);
		return s;
	}

	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 
	 * @param d
	 * @return
	 */
	public static String dateToString1(Date d) {
		String s = new SimpleDateFormat(FORMAT1).format(d);
		return s;
	}

	/**
	 * yyyyMMddHHmmss
	 * 
	 * @param d
	 * @return
	 */
	public static String dateToString2(Date d) {
		String s = new SimpleDateFormat(FORMAT2).format(d);
		return s;
	}

	/**
	 * yyyyMMddHHmmssSSS
	 * 
	 * @param d
	 * @return
	 */
	public static String dateToString3(Date d) {
		String s = new SimpleDateFormat(FORMAT3).format(d);
		return s;
	}

	/**
	 * yyyy-MM-dd
	 * 
	 * @param s
	 * @return
	 */
	public static Date stringToDate(String s) {
		Date d = null;
		try {
			d = new SimpleDateFormat(FORMAT).parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	/**
	 * yyyy/MM/dd
	 * 
	 * @param s
	 * @return
	 */
	public static Date stringToDate1(String s) {
		Date d = null;
		try {
			d = new SimpleDateFormat(FORMAT6).parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	/**
	 * yyyy-MM
	 * 
	 * @param s
	 * @return
	 */
	public static Date string4ToDate(String s) {
		Date d = null;
		try {
			d = new SimpleDateFormat(FORMAT4).parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	/**
	 * yyyy-MM
	 * 
	 * @param s
	 * @return
	 */
	public static Date string5ToDate(String s) {
		Date d = null;
		try {
			d = new SimpleDateFormat(FORMAT4).parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	public static String timeToString(Date d) {
		String s = new SimpleDateFormat(FORMAT1).format(d);
		return s;
	}

	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 
	 * @param s
	 * @return
	 */
	public static Date stringToTime(String s) {
		Date d = null;
		try {
			d = new SimpleDateFormat(FORMAT1).parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	/**
	 * 获取当前年份
	 * 
	 * @return
	 */
	public static String getYear() {
		return DateFormatUtils.format(System.currentTimeMillis(), "yyyy");
	}

	/**
	 * 取得当前系统时间：具体格式为yyyyMMddHHmmss
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getCurrDateTime() {
		return DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMddHHmmss");
	}

	/**
	 * 取得当前系统时间：具体格式为yyyyMMddHHmmssSSS
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getCurrentTime() {
		return DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMddHHmmssSSS");
	}

	/**
	 * 取得当前系统时间：具体格式为yyyyMMddHHmmss
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getCurrDateTime(String ftm) {
		return DateFormatUtils.format(System.currentTimeMillis(), ftm);
	}

	/**
	 * 取得当前日期 ：具体格式为yyyy-MM-dd
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getCurrDate() {
		return DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd");
	}

	/**
	 * 取得明天日期 ：具体格式为yyyy-MM-dd
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getCurrDate4() {
		return DateFormatUtils.format(System.currentTimeMillis() + 24 * 60 * 60 * 1000, "yyyy-MM-dd");
	}

	/**
	 * 取得当前日期 ：具体格式为yyyy-MM-dd HH:mm:ss
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getCurrDate1() {
		return DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 取得当前日期 ：具体格式为yyyyMMdd
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getCurrDate2() {
		return DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMdd");
	}

	/**
	 * 取得当前时间：具体格式为HHmmss
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getCurrTime() {
		return DateFormatUtils.format(System.currentTimeMillis(), "HHmmss");
	}

	/**
	 * 取得当前时间：具体格式为HH:mm
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getCurrTime2() {
		return DateFormatUtils.format(System.currentTimeMillis(), "HH:mm");
	}

	/**
	 * 取得当前时间：具体格式为HH
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getCurrTime3() {
		return DateFormatUtils.format(System.currentTimeMillis(), "HH");
	}

	/**
	 * Method signDaysBetweenTowDate 两日期间相差天数.
	 * 
	 * @param d1
	 *            日期字符串
	 * @param d2
	 *            日期字符串
	 * @return long 天数
	 */
	public static long getDaysBetweenTwoDate(String d1, String d2) {
		java.sql.Date dd1 = null;
		java.sql.Date dd2 = null;
		long result = -1l;
		try {
			dd1 = java.sql.Date.valueOf(d1);
			dd2 = java.sql.Date.valueOf(d2);
			result = getDaysBetweenTwoDate(dd1, dd2);
		} catch (Exception ex) {
			result = -1;
		}
		return result;
	}

	/**
	 * Method signDaysBetweenTowDate 两日期间相差天数.
	 * 
	 * @param d1
	 *            开始日期 日期型
	 * @param d2
	 *            开始日期 日期型
	 * @return long 天数
	 */
	public static long getDaysBetweenTwoDate(java.sql.Date d1, java.sql.Date d2) {
		return (d1.getTime() - d2.getTime()) / (3600 * 24 * 1000);
	}

	/**
	 * Method signDaysBetweenTowDate 两日期间相差天数.
	 * 
	 * @param d1
	 *            开始日期 日期型
	 * @param d2
	 *            开始日期 日期型
	 * @return long 天数
	 */
	public static long getDaysBetweenTwoDate(Date d1, Date d2) {
		return (d1.getTime() - d2.getTime()) / (3600 * 24 * 1000);
	}

	/**
	 * 获取几天后的日期
	 * 
	 * @param startDate
	 *            String 格式yyyy-mm-dd
	 * @param step
	 *            天数 只能为整数
	 * @return String yyyy-MM-dd
	 */
	public static String addDate(String startDate, int step) {
		Date date;
		try {
			date = new SimpleDateFormat(FORMAT).parse(startDate);
			Calendar calender = Calendar.getInstance();
			calender.setTime(date);
			String endDate = new SimpleDateFormat(FORMAT).format(calender.getTime());
			return endDate;
		} catch (ParseException e) {
			throw new RuntimeException("endDate is not a vaild format " + new SimpleDateFormat(FORMAT));
		}
	}

	/**
	 * 获取今日凌晨时间
	 * 
	 * @param date
	 * @param flag
	 * @return
	 */
	public static Date getTodayO(Date date, int flag) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		// 时分秒（毫秒数）
		long millisecond = hour * 60 * 60 * 1000 + minute * 60 * 1000 + second * 1000;
		// 凌晨00:00:00
		cal.setTimeInMillis(cal.getTimeInMillis() - millisecond);
		if (flag == 0) {
			return cal.getTime();
		} else if (flag == 1) {
			// 凌晨23:59:59
			cal.setTimeInMillis(cal.getTimeInMillis() + 23 * 60 * 60 * 1000 + 59 * 60 * 1000 + 59 * 1000);
		}
		return cal.getTime();
	}

	public static String getSevenDayBefore(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.roll(Calendar.DATE, -7);// 日期回滚7天
		str = sdf.format(lastDate.getTime());
		return str;
	}

	/**
	 * 获取今年的第一天的日期
	 * 
	 * @return
	 */
	public static String getCurrYearFirstDay() {
		Calendar calendar = Calendar.getInstance();
		int currentYear = calendar.get(Calendar.YEAR);
		calendar.clear();
		calendar.set(Calendar.YEAR, currentYear);
		Date currYearFirst = calendar.getTime();
		return dateToString(currYearFirst);
	}

	/**
	 * 获取该日期的一年前的日期
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getOneYearBefore(String dateStr) {
		Calendar calendar = Calendar.getInstance();
		Date date = stringToDate(dateStr);
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, -1);
		Date lastYear = calendar.getTime();
		return dateToString(lastYear);
	}

	/**
	 * 判断2个日期是否为同一天
	 * 
	 * @param preDate
	 * @param date
	 * @return
	 */
	public static boolean jugeCurDay(Date preDate, Date date) {
		return (int) preDate.getTime() - date.getTime() / (1000 * 3600 * 24) == 0;
	}
}
