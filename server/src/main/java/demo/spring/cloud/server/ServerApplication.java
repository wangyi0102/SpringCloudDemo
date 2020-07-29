package demo.spring.cloud.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 核桃(wy)
 * @date 2020/7/28 14:34
 * @description 注册中心
 **/
@EnableEurekaServer
@SpringBootApplication
public class ServerApplication {

    public static void main(String args[]){
        SpringApplication.run(ServerApplication.class, args);
    }
}
