package top.zhangekay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import top.zhangekay.redis.demo1;

/* 标志 springboot 这是一个主程序 */
/* 此文件所在的目录位置不同 回影响其功能
 *
 * 主配置 类
 * main 方法启动
 *  */
@SpringBootApplication
/*
 * 一、 @SpringBootConfiguration 类 配置类注解 --》@configuration
 *       从配置文件 ---> 配置类（组件）
 * 二、 @EnableAutoConfiguration 开启自动配置功能--》免去了手动写
 *           AutoConfigurationPackage(扫苗主配置类文件夹下所有的包中的类，加入spring)
 *           @import(导入组件到容器中，全类名的方式返回)
 * */

/* 18集 */
@EnableEurekaClient
public class RedisdemoApplication {

    public static void main(String[] args) {
//        ConfigurableApplicationContext cac =
//                SpringApplication.run(RedisdemoApplication.class, args);
//        demo1 bean = cac.getBean(demo1.class);
//        bean.set("name","zhangeaky");

        SpringApplication.run(RedisdemoApplication.class, args);

    }
}
