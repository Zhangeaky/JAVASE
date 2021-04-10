package top.zhangekay.entity;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
/* 加载指定的配置文件 */
@PropertySource(value = {"classpath:team.yaml"})
public class team {
    private String name;
    private List<person> players;

    @Override
    public String toString() {
        return "team{" +
                "name='" + name + '\'' +
                ", players=" + players +
                '}';
    }
}
