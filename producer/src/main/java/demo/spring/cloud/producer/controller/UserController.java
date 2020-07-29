package demo.spring.cloud.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 核桃(wy)
 * @date 2020/7/28 14:44
 * @description 提供服务
 **/
@RestController
public class UserController {

    @GetMapping("/user/info")
    public String getUserInfo(Long userId){
        return "this is 张三，男，18岁，userId is" + userId;
    }
}
