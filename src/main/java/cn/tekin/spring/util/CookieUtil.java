package cn.tekin.spring.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * cookie 工具类
 *
 * @author Tekin   tekintian@gmail.com
 * @version $Id: $Id
 */
public class CookieUtil {
    /**
     * cookie设置
     *
     * @param resp   HttpServletResponse 对象
     * @param name   要设置的Cookie名称
     * @param value  设置的cookie值
     * @param maxAge cookie生存时间 单位秒, -1 长期有效
     */
    public static void set(HttpServletResponse resp, String name, String value, int maxAge){
        Cookie cookie=new Cookie(name,value);
        cookie.setPath("/");  //cookie作用域
        cookie.setMaxAge(maxAge);
        resp.addCookie(cookie); //添加到HttpServletResponse中
    }

    /**
     * 根据 key 获取对应的Cookie对象
     *
     * @param req  HttpServletRequest请求对象
     * @param name 要获取的自定义的cookie  key
     * @return Cookie对象或者null cookie
     */
    public static Cookie get(HttpServletRequest req, String name){
        Map<String, Cookie> cookieMap=getCookiesMap(req);
        //如果cookieMap中有名称为name的则返回对应的Cookie
        if (cookieMap.containsKey(name)){
            return cookieMap.get(name);
        }else{
            return null;
        }
    }
    /**
     * 从HttpServletRequest对象中获取 key -> Cookie 对应的Map
     * @param req HttpServletRequest对象
     * @return key -> Cookie 对应的Map
     */
    private static Map<String , Cookie> getCookiesMap(HttpServletRequest req){
        //初始化map
        Map<String, Cookie> cookieMap=new HashMap<>();
        //从req中获取cookie数组
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                //把名称对应的cookie放入到map中
                cookieMap.put(cookie.getName(),cookie);
            }
        }
        return cookieMap;
    }

    /**
     * 删除cookie
     *
     * @param response response对象
     * @param name     cookie名称
     */
    public static void deleteCookie(HttpServletResponse response, String name) {
        Cookie cookie = new Cookie(name, "");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    /**
     * Delete cookie *
     *
     * @param response response
     * @param name     name
     * @param path     path
     */
    public  static void deleteCookie(HttpServletResponse response, String name, String path) {
        Cookie cookie = new Cookie(name, "");
        cookie.setPath(path);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    /**
     * Delete cookie *
     *
     * @param response response
     * @param name     name
     * @param domain   domain
     * @param path     path
     */
    public  static void deleteCookie(HttpServletResponse response, String name, String domain, String path) {
        Cookie cookie = new Cookie(name, "");
        cookie.setPath(path);
        if(domain != null){
            cookie.setDomain(domain) ;
        }
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    /**
     * 读取指定cookie的值
     *
     * @param request request
     * @param name    name
     * @return string string
     */
    public String readCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i] ;
                if (name.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /**
     * Read all cookies from the request's 'cookie' header, and parse it
     * based on Cookie Version 1.
     * This method can resolve tomcat's bug in handling special characters in
     * cookie (The cookie is maybe written by other applications).
     *
     * @param request    HttpServletRequest
     * @param cookieName cookie name
     * @return the string
     */
    public static String readCookieIgnoreSpecialCharacters(HttpServletRequest request, String cookieName) {
        String cs = request.getHeader("cookie") ;
        if(cs == null) return null ;

        int start = cs.indexOf(cookieName) ;
        if(start < 0 ) return null ;

        cs = cs.substring(start + 1 + cookieName.length()) ;

        int end = cs.indexOf(';') ;
        if(end > 0 ){
            cs = cs.substring(0, end) ;
        }

        return cs ;
    }

}
