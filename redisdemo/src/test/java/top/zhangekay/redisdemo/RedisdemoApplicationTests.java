package top.zhangekay.redisdemo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import top.zhangekay.entity.person;
import top.zhangekay.entity.team;

import java.io.IOException;


@RunWith(SpringRunner.class)
@SpringBootTest
class RedisdemoApplicationTests {

    @Autowired
    ApplicationContext ctx;
    //person pp;

    @Test
    void contextLoads() throws IOException {
        team bean = ctx.getBean(team.class);
        System.out.println(bean);
        System.in.read();
    }

    @Test
    void resource(){
        ctx.getBean(team.class);

    }

}
