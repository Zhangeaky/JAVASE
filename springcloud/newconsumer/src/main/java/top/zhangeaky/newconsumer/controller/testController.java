package top.zhangeaky.newconsumer.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class testController {

    @Value("${server.port}")
    String port;

    @Autowired
    RestTemplate restTemplate;


    @RequestMapping("/gate")
    public  String gate(){


        return "gate@"+port;
    }


    //consumerApi ca;

    /* 注解是给springMVC看的,
    *  会把这一段代码变成servelet
    *
    * */
    @RequestMapping("/hello")
    /* 在默认设置情况下, 一秒钟延迟直接进入后备处理方法 */
    /* 以下这种直接在controller 中添加 hystrix 的方法在实际的开发过程中是不推荐的
    *
    * */


    @HystrixCommand(fallbackMethod = "helloHandler" ,
            threadPoolKey = "hello",
            threadPoolProperties = {
                @HystrixProperty(name="coreSize",value = "30"),
                    @HystrixProperty(name="maxQueueSize",value = "10")
            },

            commandProperties = {
          @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),/* 10s内断闸必须到达的请求数量 */
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value= "75"),/* 失败百分比*/
            @HystrixProperty(name= "circuitBreaker.sleepWindowInMilliseconds",value="7000"),
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds",value="15000"),
                @HystrixProperty(name="metrics.rollingStats.numBuckets", value ="5")
            }

    )
    public String hello(){

        restTemplate.getForObject("http://service1:8082/hello",String.class);
        return "final";

    }

    public String helloHandler(){
        return "服务降级";
    }





}
