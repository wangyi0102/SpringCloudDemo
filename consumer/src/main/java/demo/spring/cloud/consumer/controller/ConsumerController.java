package demo.spring.cloud.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 核桃(wy)
 * @date 2020/7/28 14:56
 * @description 消费producer的服务
 **/
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private ProducerService producerService;

    // Rest远程调用
    @GetMapping("/rest/producer")
    public String restPro(Long userId){
        return restTemplate.getForObject("http://producer/user/info?userId="+userId, String.class);
    }

    // feign调用
    @GetMapping("/feign/producer")
    public String feignPro(Long userId){
        return producerService.getUserInfo(userId);
    }

}


