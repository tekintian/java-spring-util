# java-spring-util

project for spring boot project , include date util , json util, ObjectCopy util etc.

## 使用方法
在pom.xml文件中引入
~~~xml
<dependency>
  <groupId>cn.tekin.spring</groupId>
  <artifactId>util</artifactId>
  <version>v0.1.1</version>
</dependency>
~~~

详细用法请参考API文档
[API文档](http://java-spring-util.tekin.cn/docs/apidocs/index.html)

- ResultVO Util工具使用
~~~java
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
~~~

- 对象拷贝,忽略null值, 将 src对象中的非null拷贝到 target对象中
~~~java
MyBeanUtil.copyPropertiesIgnoreNull(Object src, Object target);
~~~


- 对象转JSON示例
~~~java
Object obj=new Object();
String jsonStr= MyJsonUtil.toJson(obj);

//string对象转json
Object obj = MyJsonUtil.fromJson(jsonString);
~~~

- 生成唯一ID,线程安全,解决多线程生成ID重复问题
~~~java
KeyUtil.getUniqueKey();
~~~

- 获取带排序的分页请求对象 PageRequest
~~~java
PageRequest pageRequest=PageUtil.getSortPageRequest(1, 10, "id", 1)
~~~

- 根据验证结果BindingResult 返回各个字段的验证结果字符串
~~~java
ValidUtil.getValidErrorsStr(bindingResult);
~~~

- xml转对象
~~~java
String xmlStr="<map>aaaa</map>";

XmlUtil.toObject(xmlStr, User.class);
~~~

更多用法,请参考 [API文档](http://java-spring-util.tekin.cn/docs/apidocs/index.html)

## javadoc 注释修复插件

~~~shell
# 将 clirr jar安装到本地
mvn install:install-file -Dfile=docs/clirr-maven-plugin-2.8.jar -DgroupId=org.codehaus.mojo -DartifactId=clirr-maven-plugin -Dversion=2.8 -Dpackaging=jar

# 执行修复命令
javadoc:fix -DcomparisonVersion=1.0
~~~