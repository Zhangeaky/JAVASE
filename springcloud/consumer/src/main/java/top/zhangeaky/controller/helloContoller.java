package top.zhangeaky.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloContoller {

    @RequestMapping("/hello")
    public String hello(){
        return "final";
    }
}
