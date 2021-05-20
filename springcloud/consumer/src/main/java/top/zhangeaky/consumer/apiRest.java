package top.zhangeaky.consumer;

import org.springframework.web.bind.annotation.RequestMapping;

// 有 bug @RequestMapping("player")
/* 接口中的注解会带到 实现类中 */
public interface apiRest {
    @RequestMapping("/13")
    public String f1();

    @RequestMapping("/7")
    public String f2();

    @RequestMapping("/11")
    public String f3();

}
