package demo.spring.cloud.producerone.controller;

import demo.spring.cloud.producerone.dto.UserDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 核桃(wy)
 * @date 2020/7/28 14:44
 * @description 提供服务
 **/
@RestController
public class UserController {

    @Value("${server.port}")
    String serverPort;
    @Value("${app.name}")
    String appName;

    @GetMapping("/testByParam")
    public String test(Long userId){
        return "服务提供者: "+appName+"，serverPort: "+serverPort+",userId: " + userId;
    }

    @GetMapping("/testByMap")
    public String testByMap(@RequestParam Map<String,Object> map){
        return "服务提供者: "+appName+"，serverPort: "+serverPort+",map: " + map.get("name");
    }

    @PostMapping("/testByBody")
    public String testByBody(@RequestBody UserDTO user){
        return "服务提供者: "+appName+"，serverPort: "+serverPort+",user: " + user.getName();
    }

    @GetMapping("/testError")
    public String testError(){
        int a = 10/0;
        return "服务提供者: "+appName+"，serverPort: "+serverPort+"测试error";
    }
}
