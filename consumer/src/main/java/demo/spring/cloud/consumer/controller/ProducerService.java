package demo.spring.cloud.consumer.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 核桃(wy)
 * @date 2020/7/28 19:54
 * @description
 **/
@FeignClient("producer")// producer为服务提供者名称
public interface ProducerService {

    @GetMapping("/user/info")// 接口名称和服务提供的接口要一样
    String getUserInfo(@RequestParam("userId") Long userId);
}
