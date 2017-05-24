package com.sync.util.md5;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	
//	public String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
//		//确定计算方法
//		MessageDigest md5=MessageDigest.getInstance("MD5");
//		BASE64Encoder base64en = new BASE64Encoder();
//		//加密后的字符串
//		String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
//		return newstr;
//		}

	/**
	 * md5签名
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	public static String sign(String soruce) throws NoSuchAlgorithmException{
		 MessageDigest md5;  
	     md5 = MessageDigest.getInstance("MD5"); 
	     md5.update(soruce.getBytes()); //先更新摘要  
//	     byte[] digest = md5.digest();
//	     String hex = toHex(digest);  
//	     return hex;
	     
	     
	     return new BigInteger(1, md5.digest()).toString(16);
	}
	
	/** 
     * md5 摘要转16进制 
     * @param digest 
     * @return 
     */  
    private static String toHex(byte[] digest) {  
        StringBuilder sb = new StringBuilder();  
        int len = digest.length;  
          
        String out = null;  
        for (int i = 0; i < len; i++) {  
//          out = Integer.toHexString(0xFF & digest[i] + 0xABCDEF); //加任意 salt  
            out = Integer.toHexString(0xFF & digest[i]);//原始方法  
            if (out.length() == 1) {  
                sb.append("0");//如果为1位 前面补个0  
            }  
            sb.append(out);  
        }  
        return sb.toString();  
    }  
}
