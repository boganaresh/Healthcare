package com.slokam.healthcare.util;

public class StringUtils {

	public static boolean blankCheck(String str) {
		boolean flag = false;
		if (str != null && str.trim().length() > 0) {
			flag = true;
		}
		return flag;
	}
}
