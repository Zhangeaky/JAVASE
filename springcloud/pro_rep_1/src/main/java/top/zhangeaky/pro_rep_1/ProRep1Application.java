package top.zhangeaky.pro_rep_1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProRep1Application {

    @Value("${server.port}")
    String port;

    @RequestMapping("hello")
    public String helloService(){

        return "hello world my port is: " + new ProRep1Application().port;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProRep1Application.class, args);
    }

}
