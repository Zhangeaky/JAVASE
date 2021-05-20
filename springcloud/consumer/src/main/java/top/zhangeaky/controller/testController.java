package top.zhangeaky.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class testController {
    /* 资源事先定义  */

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @RequestMapping("/gethello")
    public String getHello(String id){
        System.out.println(id);

        restTemplate.getForObject("http://provider/{id}",String.class,id);
        return null;
    }

    @RequestMapping("/client")
    public String client(){

        ServiceInstance service1 = loadBalancerClient.choose("service1");
        String url = "http://"+service1.getHost()+":"+ service1.getPort()+"/hello";
        String forObject = restTemplate.getForObject(url, String.class);
        System.out.println(" res:" +forObject);
        return "client test invoke";
    }

    /* 自定义的负载均衡算法 */
    @RequestMapping("/clientlbbyhand")
    public String nihoa(){

        List<ServiceInstance> services = discoveryClient.getInstances("service1");

        System.out.println(services);

        return null;
    }



}
