package com.hz.cmfz.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * �������ַ�ת���Ĺ�����
 */
public class DateConvertUtils {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	//�ַ�תutilDate
	public static java.util.Date toUtilDate(String source){
		try {
			return sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//utilDateתsqlDate
	public static java.sql.Date toSqlDate(java.util.Date utilDate){
		return new java.sql.Date(utilDate.getTime());
	}
	
	//���κ�һ���������ͽ��и�ʽ��
	public static String toString(java.util.Date date){//java.sql.Date
		return sdf.format(date);
	}
	
}
