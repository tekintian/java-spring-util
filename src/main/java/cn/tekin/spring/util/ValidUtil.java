package cn.tekin.spring.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * 验证工具类
 * @Author Tekin <tekintian@gmail.com>
 * @Create 2019-11-04 11:15
 */
public class ValidUtil {
    /**
     * 根据验证结果BindingResult 返回各个字段的验证结果字符串
     * @param bindingResult @Valid注解的验证结果对象
     * @return
     */
    public static String getValidErrorsStr(BindingResult bindingResult) {
        //校验结果以集合的形式返回，
        List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
        //StringBuilder组装异常信息
        StringBuilder builder = new StringBuilder();
        //遍历拼装
        fieldErrorList.forEach(error -> {
            builder.append(error.getDefaultMessage() + '\n');
        });
        //在 builder 参数的开头插入字符串
        // builder.insert(0,"参数验证结果:" +'\n');
        return builder.toString();
    }
}
