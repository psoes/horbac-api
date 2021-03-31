package com.uds.horbac.core.utils;
 
public class  PropertyUtils {

	private static int loginAttendLimits = 10;
	
	public static int getLoginAttendLimits() {
		return loginAttendLimits;
	}

	public static void setLoginAttendLimits(int loginAttendLimits) {
		PropertyUtils.loginAttendLimits = loginAttendLimits;
	}



}
