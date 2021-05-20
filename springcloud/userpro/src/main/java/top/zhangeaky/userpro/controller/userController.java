package top.zhangeaky.userpro.controller;


import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController implements userapi{

    @Override
    public String isalived() {
        return "ok";
    }
}
