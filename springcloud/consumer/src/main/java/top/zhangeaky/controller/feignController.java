package top.zhangeaky.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import top.zhangeaky.consumer.serviceHello;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class feignController {

    @Autowired
    /* open Feign 注解修饰的接口实例 */
    private serviceHello serviceHello;


    @GetMapping("consumerHello")
    public String client(Integer a,Integer b) throws InterruptedException {

        System.out.println("a: "+a);
        System.out.println("b: "+b);


        return serviceHello.api();
   }
}
