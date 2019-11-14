package cn.tekin.spring.util;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * http请求的最外层范型对象
 * ResultVO<T> 范型
 *
 * @param <T> parameter
 * @Author Tekin <tekintian@gmail.com>
 * @Create 2019 -10-25 14:12
 * @author Tekin
 * @version $Id: $Id
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = -7977834203783475484L;

    private Integer code;
    private String msg;
    private T data;

    /**
     * Util
     */
    public static class Util {
        /**
         * 成功方法
         *
         * @param object object
         * @return result vo
         */
        public static ResultVO success(Object object) {
            ResultVO resultVO = new ResultVO();
            resultVO.setCode(0);
            resultVO.setMsg("SUCCESS");
            resultVO.setData(object);
            return resultVO;
        }

        /**
         * Success result vo
         *
         * @return the result vo
         */
        public static ResultVO success() {
            return success(null);
        }

        /**
         * 错误方法
         *
         * @param code code
         * @param msg  msg
         * @return result vo
         */
        public static ResultVO error(Integer code, String msg) {
            ResultVO resultVO = new ResultVO();
            resultVO.setCode(code);
            resultVO.setMsg(msg);
            resultVO.setData(new ArrayList<String>());
            return resultVO;
        }
    }

}
