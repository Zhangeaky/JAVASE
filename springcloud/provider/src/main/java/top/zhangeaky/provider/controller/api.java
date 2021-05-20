package top.zhangeaky.provider.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public interface api {
    @GetMapping("/id1")
    String client1();
    @GetMapping("/id2")
    String client2();
    @GetMapping("/id3")
    String client3();
}
