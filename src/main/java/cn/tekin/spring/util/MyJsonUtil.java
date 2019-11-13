package cn.tekin.spring.util;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author Tekin <tekintian@gmail.com>
 * @Create 2019-10-26 11:00
 */
public class MyJsonUtil {
    /**
     * 对象转换JSON STRING
     * @param object
     * @return
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
     * @param jsonString
     * @return
     */
    public static Object fromJson(String jsonString){
        return JSONObject.parse(jsonString);
    }
}
