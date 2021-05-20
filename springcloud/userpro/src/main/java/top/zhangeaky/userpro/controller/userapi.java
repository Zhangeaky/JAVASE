package top.zhangeaky.userpro.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public interface userapi {
    @GetMapping("/isAlived")
    public String isalived();
}
