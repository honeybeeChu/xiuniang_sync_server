package com.sync.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	
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
}
