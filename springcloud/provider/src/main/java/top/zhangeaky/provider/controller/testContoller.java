package top.zhangeaky.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class testContoller {

    @Value("${server.port}")
    String port;

    private int randomValue(){
        Random random = new Random();
        int randomNum = random.nextInt((3-1)+1)+1;
        if (randomNum == 3 ) sleep();
        return randomNum;
    }
    private void sleep(){
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/hello")
    public String hello() throws InterruptedException {
        //Thread.sleep(5000);
        int i = randomValue();
        return "hello_world"+"My port: " + port+" "+i;
    }


}
