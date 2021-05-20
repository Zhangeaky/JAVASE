package top.zhangeaky.provider.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class info implements api{

    @GetMapping("nihao")
    String nihao(){
        return "nihao shijie";
    }

    @Override
    public String client1() {
        return "client1";
    }

    @Override
    public String client2() {
        return "client2";
    }

    @Override
    public String client3() {
        return "client3";
    }
}
