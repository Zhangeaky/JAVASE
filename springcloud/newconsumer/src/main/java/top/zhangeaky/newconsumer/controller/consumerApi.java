package top.zhangeaky.newconsumer.controller;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import top.zhangeaky.newconsumer.config.webErr;


@FeignClient(value = "service1",fallbackFactory = webErr.class)
public interface consumerApi extends userApi {

    @RequestMapping("/giveMeFive")
    @Override
    public String giveMeFive();

    @RequestMapping("/hello")
    @Override
    public String hello();
}