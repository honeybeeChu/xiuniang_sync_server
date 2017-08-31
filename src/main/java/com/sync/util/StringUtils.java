package com.sync.util;

public class StringUtils {
	public static String convert(String utfString){  
	    StringBuilder sb = new StringBuilder();  
	    int i = -1;  
	    int pos = 0;  
	      
	    while((i=utfString.indexOf("\\u", pos)) != -1){
	        sb.append(utfString.substring(pos, i));  
	        if(i+5 < utfString.length()){  
	            pos = i+6;  
	            sb.append((char)Integer.parseInt(utfString.substring(i+2, i+6), 16));  
	        }
	    }  
	    sb.append(utfString.substring(utfString.lastIndexOf("\\u")+6,utfString.length()));
	    return sb.toString();  
	} 
	
}
