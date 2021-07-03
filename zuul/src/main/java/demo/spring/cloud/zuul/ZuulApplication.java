package demo.spring.cloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author 核桃(wy)
 * @date 2021/7/3 14:45
 * @description
 **/
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class ZuulApplication {

    public static void main(String args[]){
        SpringApplication.run(ZuulApplication.class, args);
    }

    @Bean
    public MyFilter getMyfilter(){
        return new MyFilter();
    }
}
