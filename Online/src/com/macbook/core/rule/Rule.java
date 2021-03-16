package com.macbook.core.rule;

import java.util.regex.Pattern;

/**
 * 
 * @author maweihong
 *
 */
public class Rule {
		//判断是否为数字
		public static boolean isNum(String str){
			Pattern p = Pattern.compile("[0-9]+");
			return p.matcher(str).matches();
		}
		
		//判断是否为中文
		public static boolean isChinese(String str){
			Pattern p = Pattern.compile("[A-Za-z\\u4e00-\\u9fa5]+");
			return p.matcher(str).matches();
		}
}
