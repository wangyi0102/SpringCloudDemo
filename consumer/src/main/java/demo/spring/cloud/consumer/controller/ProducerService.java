package demo.spring.cloud.consumer.controller;

import demo.spring.cloud.consumer.interceptor.ProducerServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author 核桃(wy)
 * @date 2020/7/28 19:54
 * @description 定义一个feign接口，通过@ FeignClient（“服务名”）
 * value:服务名称
 * fallback:出现错误就回调同名方法进行处理
 **/
@FeignClient(value = "producer",fallback = ProducerServiceHystrix.class)// producer为服务提供者名称
public interface ProducerService {

    @GetMapping("/testByParam")// 接口名称和服务提供的接口要一样
    String testByParam(@RequestParam("userId") Long userId);

    @RequestMapping("/testByMap")
    String testByMap(@RequestParam Map<String,Object> map);

    @PostMapping("/testByBody")
    String testByBody(@RequestBody Object obj);

    @GetMapping("/testError")// 测试报错
    String testError();

}
