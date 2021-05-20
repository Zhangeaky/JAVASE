package top.zhangeaky.newconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

/* hystix 整合 feign
* hystrix 整合 restTemplate
*  */
@SpringBootApplication
@EnableFeignClients
/* 这两个注解都实现了打开 hystrix 的功能
* EnableHystrix继承EnableCircuitBreaker
*
*  */
@EnableHystrix
//@EnableCircuitBreaker
public class NewconsumerApplication {

    public static void main(String[] args) {

        SpringApplication.run(NewconsumerApplication.class, args);
    }

}
