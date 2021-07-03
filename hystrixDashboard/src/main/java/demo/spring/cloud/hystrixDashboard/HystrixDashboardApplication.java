package demo.spring.cloud.hystrixDashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author 核桃(wy)
 * @date 2021/7/3 14:07
 * @description Hystrix监控面板
 **/
@SpringBootApplication
@EnableHystrixDashboard
@EnableDiscoveryClient
public class HystrixDashboardApplication {

    public static void main(String args[]){
        SpringApplication.run(HystrixDashboardApplication.class, args);
    }
}
