package top.zhangeaky.newconsumer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class feignController {


    @Autowired
    consumerApi csum;

    @RequestMapping("/fhello")
    public String fhello(){

        csum.hello();
        return "final";
    }
}