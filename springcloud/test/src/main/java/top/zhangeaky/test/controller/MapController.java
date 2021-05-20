package top.zhangeaky.test.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MapController {

    @RequestMapping("/info")
    public String info(@RequestParam/* 不加这个注解 参数无法注入到map */ Map<String, String> map){

        return (map.get("name")+" "+map.get("id"));

    }




}
