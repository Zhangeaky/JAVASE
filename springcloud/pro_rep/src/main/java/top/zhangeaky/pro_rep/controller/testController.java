package top.zhangeaky.pro_rep.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @Value("${server.port}")
    String port;/*   */

    @RequestMapping("/hello")
    public String hello(){

        return "hello world service @port: " + port;

    }




}
