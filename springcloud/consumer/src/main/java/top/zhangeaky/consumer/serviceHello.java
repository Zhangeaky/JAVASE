package top.zhangeaky.consumer;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "service1"/*,fallback =*/ )
/* 一般不直接在底层借口上添加Feign注解
* 因为底层interface 一般来自provider的api 由它提供 接口的实现类 由provider实现
* 一般用一个二层借口 继承这个接口
*  */
public interface serviceHello extends apiRest{


    /* 对 service1 主机发起请求 到底是哪一台主机 是由robbin 负载均衡算法决定的 */
    @GetMapping("/hello")
    /* 要加 RequestMapping  */
    public String api(/*@RequestParam Integer a, @RequestParam Integer b*/);

}
