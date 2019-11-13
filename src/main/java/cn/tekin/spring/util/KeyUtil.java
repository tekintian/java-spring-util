package cn.tekin.spring.util;

import java.util.Random;

/**
 * 主键生成工具
 *
 * @Author Tekin <tekintian@gmail.com>
 * @Create 2019-10-25 18:22
 */
public class KeyUtil {

    /**
     * 生成唯一ID
     * synchronized 解决多线程生成ID重复问题
     * String.valueOf(number) 将数字转换为字符串
     * System.currentTimeMillis() 当前系统毫秒时间
     *
     * @return
     */
    public static synchronized String getUniqueKey() {
        Random random = new Random();

        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
