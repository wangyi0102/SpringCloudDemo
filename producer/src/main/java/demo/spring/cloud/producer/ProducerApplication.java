package demo.spring.cloud.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 核桃(wy)
 * @date 2020/7/28 14:42
 * @description
 **/
@EnableEurekaClient
@SpringBootApplication
public class ProducerApplication {

    public static void main(String args[]){
        SpringApplication.run(ProducerApplication.class, args);
    }
}
