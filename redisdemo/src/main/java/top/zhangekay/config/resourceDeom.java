package top.zhangekay.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import top.zhangekay.entity.person;
import top.zhangekay.entity.team;

/* 导入spring 的配置文件 让其生效 */
// @ImportResource(locations = {"classpath:beans.xml"})

//@Configuration
/*
 * 当前类 是一个配置类 代替spring的配置文件
 * spring.xml 文件的方式是采用 <Bean><Bean/> 标签的方式添加组件
 * */

public class resourceDeom {
    /*
     * 然而以上这种通过引入spring 配置文件为容器添加组件的方式
     * 不是springboot所推荐的
     *
     * springboot 所推荐的方式 是采用配置类
     * 使用 @Bean 注解 来 代替 <Bean/> 标签
     * */

    @Bean
        /* @Bean 注解修饰的方法
         *  其返回值返回的对象 装入 容器 对象 id = ‘函数名’
         *  */
    team nets() {
        System.out.println("team 装入容器");
        return new team();
    }


}
