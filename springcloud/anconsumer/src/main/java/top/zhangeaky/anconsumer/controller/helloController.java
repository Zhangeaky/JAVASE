package top.zhangeaky.anconsumer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class helloController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
    public String hello(){

        restTemplate.getForObject("http://service1",String.class);
        return "final";
    }

    @RequestMapping("/gate")
    public  String gate(){
        return "gate@"+port;
    }



}
