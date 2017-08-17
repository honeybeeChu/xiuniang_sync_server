package com.sync.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 获取当前时间的前一个小时date
	 * @return
	 */
	public static Date getOneHoursAgoTime() throws ParseException{
		String oneHoursAgoTime = "";
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, -20); // 把时间设置为当前时间-1小时，同理，也可以设置其他时间
		// cal.set(Calendar. MONTH , Calendar. MONTH -1); //当前月前一月
		SimpleDateFormat sft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		oneHoursAgoTime = sft.format(cal.getTime());// 获取到完整的时间
		return sft.parse(oneHoursAgoTime);
	}
	
	/** 
     * @param 返回java.sql.Date格式的 
     * */  
    public static java.sql.Date strToDate(String strDate) {  
        String str = strDate;  
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");  
        java.util.Date d = null;  
        try {  
            d = format.parse(str);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        java.sql.Date date = new java.sql.Date(d.getTime());  
        return date;  
    }  
    
    
    
    public static Date str2Date(String str, String format){
    	  if (null != str && !"".equals(str)) {
    	    SimpleDateFormat sdf = new SimpleDateFormat(format);
    	    Date date = null;
    	    try {
    	     date = sdf.parse(str);
    	     return date;
    	   } catch (ParseException e) {
    	     e.printStackTrace();
    	  }
    	}
    	return null;
    	}

    	public static String date2Str(Date date, String format) {
    	  if (null != date && !"".equals(date)) {
    	    SimpleDateFormat sdf = new SimpleDateFormat(format);
    	    return sdf.format(date);
    	  }
    	  return null;
    	}

    	public static String timestamp2Str(Timestamp time) {
    	  if(null != time && !"".equals(time)){
    	    Date date = new Date(time.getTime());
    	    return date2Str(date, DEFAULT_FORMAT);
    	  }
    	  return null;
    	}

    	public static Timestamp str2Timestamp(String str) {
    	  if(null != str && !"".equals(str)){
    	    Date date = str2Date(str, DEFAULT_FORMAT);
    	    return new Timestamp(date.getTime());
    	  }
    	  return null;
    	}
}
