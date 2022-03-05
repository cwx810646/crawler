package com.chenjie.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class RegexUtils {
	public static String URL_REGEX = "^(https|http)://.*$";
	
	public static boolean isUrl(String text) {
		Boolean result = false;
		if (StringUtils.isNotBlank(text)) {
			result = RegexUtils.match(RegexUtils.URL_REGEX, text);
		}
		return result;
	}
	
	public static boolean isNotUrl(String text) {
		return !isUrl(text); 
	}
	
	private static boolean match(String regex, String text) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		return matcher.matches();
	}
	
	public static void main(String[] args) {
		System.out.println(RegexUtils.isUrl("htt://www.mi.com/?masid=2701.0103"));
	}
}
