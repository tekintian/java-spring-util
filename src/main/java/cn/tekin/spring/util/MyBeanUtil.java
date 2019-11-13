package cn.tekin.spring.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.Set;

/**
 * 自定义的Bean工具类
 *
 * @Author Tekin <tekintian@gmail.com>
 * @Create 2019-10-25 20:25
 */
public class MyBeanUtil {
    /**
     * 获取对象的null字段
     *
     * @param source
     * @return
     */
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    /**
     * Spring 的BeanUtils.copyProperties在拷贝属性时忽略空值
     * 拷贝对象,忽略null字段
     * 使用方法:  MyBeanUtil.copyPropertiesIgnoreNull(Object src, Object target);
     *
     * @param src
     * @param target
     */
    public static void copyPropertiesIgnoreNull(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }
}
