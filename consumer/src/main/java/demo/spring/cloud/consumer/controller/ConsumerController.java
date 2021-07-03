package demo.spring.cloud.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

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

    /**
     * Rest ribbon方式远程调用
     * Ribbo是一个基于HTTP和TCP的客户端负载均衡器，
     * 当我们将Ribbon和Eureka一起使用时，Ribbon会从Eureka注册中心去获取服务端列表，
     * 然后进行轮询访问以到达负载均衡的作用，客户端负载均衡中也需要心跳机制去维护服务端清单的有效性，
     * 当然这个过程需要配合服务注册中心一起完成
     *
     * 常用的负载均衡策略
     * RandomRule（随机策略）
     * RoundRobinRule（轮询策略-默认策略）
     * RetryRule（重试策略）
     * WeightedResponseTimeRule（权重策略）
     * @param userId
     * @return
     */
    @GetMapping("/ribbon/producer")
    public String restPro(Long userId){
        userId = userId == null ? 0L : userId;
        return restTemplate.getForObject("http://producer/testByParam?userId="+userId, String.class);
    }

    /**
     * Feign方式调用
     * Feign是一套基于Netflix Feign实现的声明式服务调用客户端。
     * 它使得编写Web服务客户端变得更加简单。通过创建接口并用注解来配置
     * 它既可完成对Web服务接口的绑定。它具备可插拔的注解支持，
     * 包括Feign注解、JAX-RS注解。它也支持可插拔的编码器和解码器。
     * 也同时整合了Ribbon和Eureka来提供均衡负载的HTTP客户端实现。
     *
     * 总之，Feign是基于Ribbon实现，使得接口更加规范化，更有阅读性并且更加简单化，
     * 也具有负载均衡的能力
     * @param userId
     * @return
     */
    @GetMapping("/feign/producer")
    public String feignPro(Long userId){
        return producerService.testByParam(userId);
    }

    // 一个参数
    @GetMapping("/feign/testByParam")
    public String testByParam(Long userId){
        return producerService.testByParam(userId);
    }

    // map参数
    @GetMapping("/feign/testByMap")
    public String testByMap(@RequestParam Map<String,Object> map){
        return producerService.testByMap(map);
    }

    // post提交Obj参数
    @PostMapping("/feign/testByBody")
    public String testByBody(@RequestBody Object obj){
        return producerService.testByBody(obj);
    }

}


