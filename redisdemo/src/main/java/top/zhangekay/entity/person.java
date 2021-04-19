package top.zhangekay.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;
import java.util.Map;

/*
 * 默认是从全局配置文件中获取值
 * 将配置文件中的每一个属性 映射到这个组件中
 * 将配置文件中的属性和这个类的属性进行相关的绑定
 *
 * prefix 对应 yaml
 *
 *
 * */
@ConfigurationProperties(prefix = "person")
/* 只有是spring 会扫描到的组件类 才有资格使用 configurationProperties 注解*/
@Component
@Validated
public class person {
    private String name;
    private int age;

    private Date birth;
    private Map<String, Object> maps;
    private List<String> hobbies;
    private Dog dog;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getBirth() {
        return birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public Dog getDog() {
        return dog;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                ", maps=" + maps +
                ", dog=" + dog +
                '}';
    }
}
