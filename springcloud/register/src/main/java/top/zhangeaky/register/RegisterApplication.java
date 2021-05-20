package top.zhangeaky.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
/* new 了一个空的Marker 类
*  作为 EurekaServerAutoConfiguration 注入的开关  @conditionOnBean
*
*              - EurekaServerInitializerConfiguration
* */
public class RegisterApplication {

    public static void main(String[] args) {

        SpringApplication.run(RegisterApplication.class, args);
    }

}
