package top.zhangeaky.controller;
import org.springframework.web.bind.annotation.RestController;
import top.zhangeaky.consumer.apiRest;


@RestController
public class apiInstance implements apiRest {

    @Override
    public String f1() {
        return "harden";
    }

    @Override
    public String f2() {
        return "durant";
    }

    @Override
    public String f3() {
        return "irving";
    }
}
