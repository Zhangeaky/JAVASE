package top.zhangeaky.newconsumer.config;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import top.zhangeaky.newconsumer.controller.consumerApi;

@Component
public class webErr implements FallbackFactory<consumerApi> {


    @Override
    public consumerApi create(Throwable throwable) {
        return new consumerApi() {
            @Override
            public String giveMeFive() {
                return "fallback givemefive";
            }

            @Override
            public String hello() {
                return "fallback hello";
            }
        };
    }
}
