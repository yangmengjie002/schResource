package sch.com.utils;


import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * ʱ�������
 * @author yang
 *
 */
public class DateUtils {
	/**
	   * ����ʱ���ʽ�ַ���ת��Ϊʱ�� yyyy-MM-dd HH:mm:ss
	   * 
	   * @param strDate
	   * @return
	   */
	public static Date strToDateLong(String strDate) {
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   ParsePosition pos = new ParsePosition(0);
	   Date strtodate = formatter.parse(strDate, pos);
	   return strtodate;
	}
	
	/**
	   * ����ʱ���ʽʱ��ת��Ϊ�ַ��� yyyy-MM-dd HH:mm:ss
	   * 
	   * @param dateDate
	   * @return
	   */
	public static String dateToStrLong(Date dateDate) {
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   String dateString = formatter.format(dateDate);
	   return dateString;
	}
	
	/**
	   * ����ʱ���ʽʱ��ת��Ϊ�ַ��� yyyy-MM-dd
	   * 
	   * @param dateDate
	   * @param k
	   * @return
	   */
	public static String dateToStr(Date dateDate) {
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	   String dateString = formatter.format(dateDate);
	   return dateString;
	}
	/**
	   * ����ʱ���ʽ�ַ���ת��Ϊʱ�� yyyy-MM-dd 
	   * 
	   * @param strDate
	   * @return
	   */
	public static Date strToDate(String strDate) {
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	   ParsePosition pos = new ParsePosition(0);
	   Date strtodate =  formatter.parse(strDate, pos);
	   return strtodate;
	}
	
	
	/**
	   * �õ�����ʱ�� �ַ��� yyyyMMdd HHmmss
	   * @return 
	   */
	public static String getStringToday() {
	   java.util.Date currentTime = new Date();
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   String dateString = formatter.format(currentTime);
	   return dateString;
	}
	
	
	
	
}
