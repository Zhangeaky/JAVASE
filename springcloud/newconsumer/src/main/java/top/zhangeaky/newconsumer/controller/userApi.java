package top.zhangeaky.newconsumer.controller;


import org.springframework.web.bind.annotation.RequestMapping;



public interface userApi {
    @RequestMapping("/hello")
    public String hello();


    @RequestMapping("/giveMeFive")
    public String giveMeFive();

}
