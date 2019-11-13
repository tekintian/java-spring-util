package cn.tekin.spring.util;

import javax.servlet.http.HttpServletRequest;

/**
 * request请求工具类
 * @Author Tekin <tekintian@gmail.com>
 * @Create 2019-11-01 21:02
 */
public class RequestUtil {
    /**
     * 获取基本请求URL
     * http//yourdomainname/yourContextPath/
     * @param request
     * @return
     */
    public static String getBaseUrl(HttpServletRequest request){
        String portStr=":"+request.getServerPort();
        //如果是80或者443端口,则去除端口号显示
        if (request.getServerPort()==80||request.getServerPort()==443){
            portStr="";
        }
        String baseUrl= request.getScheme()+"://"+request.getServerName() + portStr + request.getContextPath()+"/";
        return baseUrl;
    }

    /**
     * 获取客户端请求IP地址
     * @param request
     * @return
     */
    public static String getRequestIP(HttpServletRequest request) {
        String clientIp = request.getHeader("x-forwarded-for");
        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("Proxy-Client-IP");
        }
        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("WL-Proxy-Client-IP");
        }
        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getRemoteAddr();
        }
        return clientIp;
    }

    /**
     * isResponseBody
     * @param request
     * @return
     */
    public static boolean isResponseBody(HttpServletRequest request) {
        if (request.getRequestURI().indexOf("ajax") > -1) {
            return true;
        }
        return false;
    }


    /**
     * 得到请求的根目录
     * @param request
     * @return
     */
    public static String getBasePath(HttpServletRequest request) {
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName()
                + ":" + request.getServerPort() + path;
        return basePath;
    }
    /**
     * 得到结构目录
     *
     * @param request
     * @return
     */
    public static String getContextPath(HttpServletRequest request) {
        String path = request.getContextPath();
        return path;
    }

}
