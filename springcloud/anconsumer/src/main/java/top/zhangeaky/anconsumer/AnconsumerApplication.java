package top.zhangeaky.anconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class AnconsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnconsumerApplication.class, args);
    }

}
