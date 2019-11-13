package cn.tekin.spring.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * 页面工具类
 * @Author Tekin <tekintian@gmail.com>
 * @Create 2019-11-03 20:54
 */
public class PageUtil {
    /**
     * 获取带排序的分页请求对象 PageRequest
     * @param page 当前页
     * @param limit  每页数量限制
     * @param order  排序字段字符串
     * @param direction  排序方式 0 升序ASC; 1 DESC 降序
     * @return PageRequest 对象
     */
    public static PageRequest getSortPageRequest(Integer page, Integer limit, String order, Integer direction){
        //排序方式
        Sort.Direction direc = Sort.Direction.DESC;
        if (direction==0){
            direc = Sort.Direction.ASC;
        }
        //排序对象创建, order为前端传递的排序字段, 默认 updateTime DESC
        Sort sort =Sort.by(direc,order);
        //  LENGTH(lastName)
        PageRequest pageRequest = PageRequest.of(page,limit,sort);
        return pageRequest;
    }
}
