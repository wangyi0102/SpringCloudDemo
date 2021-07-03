package demo.spring.cloud.consumer.interceptor;

import demo.spring.cloud.consumer.controller.ProducerService;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author 核桃(wy)
 * @date 2021/7/3 11:14
 * @description
 **/
@Component
public class ProducerServiceHystrix implements ProducerService {
    @Override
    public String testByParam(Long userId) {
        return "系统繁忙";
    }

    @Override
    public String testByMap(Map<String, Object> map) {
        return "系统繁忙";
    }

    @Override
    public String testByBody(Object obj) {
        return "系统繁忙";
    }

    @Override
    public String testError() {
        return "系统繁忙";
    }
}
