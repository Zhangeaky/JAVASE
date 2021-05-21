package top.zhangekay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import top.zhangekay.entity.Book;

/* 标志 springboot 这是一个主程序 */
/* 此文件所在的目录位置不同 会影响其功能
 *
 * 主配置 类 启动引导类
 * 作用:
 * 1. 配置
 * 3. main 方法启动引导
 *
 *  */
@SpringBootApplication /* 开启组件扫描和自动配置 */
/* 该注解集成了3个注解
 * 一、 @SpringBootConfiguration 类 配置类注解 --》@configuration
 *       从配置文件 ---> 配置类（组件）
 * 二、 @EnableAutoConfiguration 开启自动配置功能--》免去了手动写  将项目之外的bean导入到容器中,
 *  要导入进去的类在classpath下META-INF/spring.factories 文件中以kv 对形式存放
 *           AutoConfigurationPackage(扫苗主配置类文件夹下所有的包中的类，加入spring)
 *           @import(导入组件到容器中，全类名的方式返回)
 *
 * 三\
 * */

/* 18集 */
@EnableEurekaClient
public class RedisdemoApplication {

    public static void main(String[] args) {
        Book book =  new Book();
        System.out.println(book.getId());
//        ConfigurableApplicationContext cac =
//                SpringApplication.run(RedisdemoApplication.class, args);
//        demo1 bean = cac.getBean(demo1.class);
//        bean.set("name","zhangeaky");

        SpringApplication.run(RedisdemoApplication.class, args);

    }
}
