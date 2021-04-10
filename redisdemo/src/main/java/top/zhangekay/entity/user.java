package top.zhangekay.entity;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class user {
    /*
    * 一个参数 对应 一个 value注解
    * */
    /*
    *   @configurationProperties                   @Value
    *   批量注入配置文件中的属性              一个参数对应一个注解
    *   松散语法 -n == N
    *    不支持 spel                               支持spel
    *   jsr303 数据校验@Validated注解           不支持复杂类型注入
    *
    *
    *
    * */
    @Value("123")
    private long id;
    @Value("zhangeaky")
    private String name;
    @Value("#{13*13*13}")
    private long password;
    @Value("true")
    private Boolean sex;
}
