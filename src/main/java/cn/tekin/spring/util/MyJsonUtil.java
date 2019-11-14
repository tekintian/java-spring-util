package cn.tekin.spring.util;

import com.alibaba.fastjson.JSONObject;

/**
 * 对象 JSON相互转换工具
 *
 * @author Tekin   tekintian@gmail.com
 * @version $Id: $Id
 */
public class MyJsonUtil {
    /**
     * 对象转换JSON STRING
     *
     * @param object object
     * @return string
     */
    public static String toJson(Object object){
//        GsonBuilder gsonBuilder=new GsonBuilder();
//        gsonBuilder.setPrettyPrinting();
//        Gson gson=gsonBuilder.create();
//
//         return gson.toJson(object);

        //直接使用阿里的fastJson转换
        return JSONObject.toJSONString(object,true);
    }

    /**
     * json string转换为对象
     *
     * @param jsonString json string
     * @return object
     */
    public static Object fromJson(String jsonString){
        return JSONObject.parse(jsonString);
    }
}
