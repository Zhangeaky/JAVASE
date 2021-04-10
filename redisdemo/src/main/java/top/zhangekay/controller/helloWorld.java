package top.zhangekay.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/* 将这个类的所有方法返回的数据都写给浏览器 （如果是对象就转为json数据） */
//@ResponseBody
//@Controller
/* RestController <==> ResponseBody + conroller */
@RestController
public class helloWorld {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "@@@hello world@@@";
    }
}
