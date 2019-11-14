package cn.tekin.spring.util.controller;

import cn.tekin.spring.util.RequestUtil;
import cn.tekin.spring.util.ResultVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Demo controller
 *
 * @Author Tekin <tekintian@gmail.com>
 * @Create 2019 -11-13 21:06
 * @author Tekin
 * @version $Id: $Id
 */
@RestController
public class DemoController {

    /**
     * Index result vo
     *
     * @param req req
     * @return the result vo
     */
    @RequestMapping("/")
    public ResultVO index(HttpServletRequest req){
        HashMap<String, Object> map = new HashMap<>();
        map.put("ip", RequestUtil.getRequestIP(req));
        map.put("ua",req.getHeader("User-Agent"));

        List<Serializable> aaa = Arrays.asList(map);
        return ResultVO.Util.success(aaa);
    }
}
