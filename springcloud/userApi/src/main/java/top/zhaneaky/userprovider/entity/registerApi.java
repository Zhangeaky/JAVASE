package top.zhaneaky.userprovider.entity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public interface registerApi {
    @GetMapping("/isAlive")
    public String isAlive();
}
