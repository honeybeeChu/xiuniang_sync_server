/**
 * 
 */
package com.sync.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * <p>
 * Title:PathUtils
 * </p>
 * <p>
 * Description:路径工具类
 * </p>
 * <p>
 * Company:yuboping
 * </p>
 * 
 * @author yuboping
 * @date 2016年7月15日下午2:44:50
 */
public class PathUtils {

    // 地球平均半径
    private static final double EARTH_RADIUS = 6378137;
    
    /**
     * 
     * <p>
     * Description:根据request获取项目路径
     * </p>
     * 
     * @author yuboping
     * @date 2016年7月15日 下午2:46:23
     * @param path
     * @return
     */
    public static String getPath(HttpServletRequest request, String fileName) {
        String path = request.getSession().getServletContext().getRealPath("/");
        if (!path.endsWith(java.io.File.separator)) {
            path = path + java.io.File.separator + fileName;
        } else {
            path = path + fileName;
        }
        if (!new File(path).exists()) {
            new File(path).mkdirs();
        }
        return path;
    }

    /**
     * 
     * <p>
     * Description:根据类获取项目路径
     * </p>
     * 
     * @author yuboping
     * @date 2016年7月19日 下午4:22:59
     * @return
     */
    public static String getClassPath() {
        String path = "";
        URL url = PathUtils.class.getClass().getResource("/");
        if (null == url) {
            path = PathUtils.class.getClassLoader().getResource("/").getPath().substring(1);
            if (path.contains("WEB-INF")) {
                int i = path.indexOf("WEB-INF");
                path = path.substring(0, i);
            }
        } else {
            path = url.getPath().substring(1);
        }
        try {
            path = java.net.URLDecoder.decode(path, "utf-8");
        } catch (UnsupportedEncodingException e) {
        }
        return java.io.File.separator + path;
    }

    // 把经纬度转为度（°）
    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 根据两点间经纬度坐标（double值），计算两点间距离，单位为公里
     * 
     * @param lng1
     * @param lat1
     * @param lng2
     * @param lat2
     * @return
     */
    public static double getDistance(double lng1, double lat1, double lng2, double lat2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1)
                * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        return s;
    }

    public static void main(String[] args) {
        getClassPath();
    }
}
