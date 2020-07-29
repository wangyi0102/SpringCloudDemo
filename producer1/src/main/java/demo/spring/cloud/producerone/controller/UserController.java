package demo.spring.cloud.producerone.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 核桃(wy)
 * @date 2020/7/28 14:44
 * @description 提供服务
 **/
@RestController
public class UserController {

    @GetMapping("/user/info")
    public String getUserInfo(Long userId){
        return "this is 李四，女，20岁，userId is" + userId;
    }
}
