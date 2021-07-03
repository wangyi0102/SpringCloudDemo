package demo.spring.cloud.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 核桃(wy)
 * @date 2021/7/3 11:02
 * @description Hystrix断路器
 **/
@RestController
public class HystrixController {

    @Resource
    private ProducerService producerService;
    @Resource
    private RestTemplate restTemplate;

    // feign方式的断路器
    @GetMapping("/feign/testError")
    public String testFeignError(){
        return producerService.testError();
    }

    // ribbon方式的断路器
    @GetMapping("/ribbon/testError")
    // ribbon方式的断路器，如果服务出错，就会降级调用自定义的ribbonError方法
    @HystrixCommand(fallbackMethod = "ribbonError")
    public String testRibbonError(){
        return restTemplate.getForObject("http://producer/testError", String.class);
    }

    public String ribbonError(){
        return "ribbonError错误处理";
    }
}
