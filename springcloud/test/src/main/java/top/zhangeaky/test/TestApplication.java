package top.zhangeaky.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.zhangeaky.test.justTest.teacher;

@SpringBootApplication
@RestController
public class TestApplication {

    @RequestMapping("hello")
    public String hello(){
        return "hello world";
    }

    public static void main(String[] args) {

         teacher r =  new teacher();
        //SpringApplication.run(TestApplication.class, args);
    }

}
