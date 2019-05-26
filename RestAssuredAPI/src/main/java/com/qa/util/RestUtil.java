package com.qa.util;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtil {
	
	public static String empname()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return("EmployeeName:" +generatedString);
	}
	public static String empsal()
	{
		String generatedString = RandomStringUtils.randomNumeric(5);
		return(generatedString);
	}
	public static String empage()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(2);
		return(generatedString);
	}

}
